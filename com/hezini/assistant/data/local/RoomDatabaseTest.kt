package com.hezini.assistant.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {

    private lateinit var chatSessionDao: ChatSessionDao
    private lateinit var chatMessageDao: ChatMessageDao
    private lateinit var db: HeziniDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, HeziniDatabase::class.java).build()
        chatSessionDao = db.chatSessionDao()
        chatMessageDao = db.chatMessageDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeSessionAndReadInList() = runBlocking {
        val session = ChatSession("session_1", "Test Title", System.currentTimeMillis(), System.currentTimeMillis())
        chatSessionDao.insertSession(session)
        val allSessions = chatSessionDao.getAllSessionsWithLastMessageFlow().first()
        assertEquals(allSessions[0].session.title, session.title)
    }

    @Test
    @Throws(Exception::class)
    fun writeMessageAndReadInSession() = runBlocking {
        val session = ChatSession("session_1", "Test Title", System.currentTimeMillis(), System.currentTimeMillis())
        chatSessionDao.insertSession(session)
        
        val message = ChatMessage("msg_1", "session_1", "user", "Hello World", null, System.currentTimeMillis())
        chatMessageDao.insertMessage(message)
        
        val messages = chatMessageDao.getMessagesBySessionFlow("session_1").first()
        assertEquals(messages[0].content, message.content)
    }
}
