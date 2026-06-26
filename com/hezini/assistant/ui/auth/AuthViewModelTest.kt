package com.hezini.assistant.ui.auth

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.hezini.assistant.data.AuthRepository
import com.hezini.assistant.utils.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class AuthViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var authRepository: AuthRepository
    
    @Mock
    lateinit var preferenceManager: PreferenceManager

    private lateinit var viewModel: AuthViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = AuthViewModel(authRepository, preferenceManager)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loginWithEmail emits Loading then Success states`() = runTest {
        val mockUser: FirebaseUser = mock()
        `when`(mockUser.uid).thenReturn("test_uid")
        `when`(mockUser.displayName).thenReturn("Test User")
        
        val mockResult: AuthResult = mock()
        `when`(mockResult.user).thenReturn(mockUser)
        `when`(authRepository.loginWithEmail(any(), any())).thenReturn(mockResult)

        viewModel.authState.test {
            assertEquals(AuthState.Idle, awaitItem())
            viewModel.loginWithEmail("test@example.com", "password")
            assertEquals(AuthState.Loading, awaitItem())
            val nextState = awaitItem()
            if (nextState is AuthState.Error) {
                throw AssertionError("Expected Success but got Error: ${nextState.message}")
            }
            val successState = nextState as AuthState.Success
            assertEquals(mockUser, successState.user)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `loginWithEmail emits Error state on failure`() = runTest {
        val errorMessage = "Invalid credentials"
        `when`(authRepository.loginWithEmail(any(), any())).thenThrow(RuntimeException(errorMessage))

        viewModel.authState.test {
            assertEquals(AuthState.Idle, awaitItem())
            viewModel.loginWithEmail("test@example.com", "wrong")
            assertEquals(AuthState.Loading, awaitItem())
            val errorState = awaitItem() as AuthState.Error
            assertEquals(errorMessage, errorState.message)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
