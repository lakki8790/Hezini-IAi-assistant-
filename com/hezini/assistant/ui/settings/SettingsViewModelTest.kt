package com.hezini.assistant.ui.settings

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.hezini.assistant.utils.AppSettings
import com.hezini.assistant.utils.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
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
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class SettingsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var preferenceManager: PreferenceManager

    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        `when`(preferenceManager.settings).thenReturn(flowOf(AppSettings()))
        viewModel = SettingsViewModel(preferenceManager)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `updateTheme persists to DataStore`() = runTest {
        val theme = "dark"
        viewModel.updateTheme(theme)
        advanceUntilIdle()
        verify(preferenceManager).updateSettings(any())
    }

    @Test
    fun `settings flow emits initial value`() = runTest {
        viewModel.settings.test {
            assertEquals("system", awaitItem().theme)
        }
    }
}
