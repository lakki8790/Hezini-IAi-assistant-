package com.hezini.assistant.ui.chat

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.hezini.assistant.data.ChatRepository
import com.hezini.assistant.data.local.ChatMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any

@ExperimentalCoroutinesApi
class ChatViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Mock
    lateinit var chatRepository: ChatRepository

    private lateinit var viewModel: ChatViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = ChatViewModel(chatRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `sendMessage appends user message and triggers streaming`() = runTest {
        val userContent = "Hello AI"
        `when`(chatRepository.getMessages(any())).thenReturn(flowOf(emptyList()))
        `when`(chatRepository.streamChat(any())).thenReturn(flowOf("Hi", " there"))

        viewModel.sendMessage(userContent)
        advanceUntilIdle()

        val messages = viewModel.messages.value
        assertTrue("User message not found", messages.any { it.role == "user" && it.content == userContent })
        assertTrue("Assistant message not found", messages.any { it.role == "assistant" && it.content.contains("Hi there") })
    }
}
