package com.hezini.assistant.`data`.local

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ChatMessageDao_Impl(
  __db: RoomDatabase,
) : ChatMessageDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfChatMessage: EntityInsertAdapter<ChatMessage>
  init {
    this.__db = __db
    this.__insertAdapterOfChatMessage = object : EntityInsertAdapter<ChatMessage>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `chat_messages` (`id`,`sessionId`,`role`,`content`,`imageUrl`,`timestamp`,`tokenCount`,`isStreaming`,`isError`) VALUES (?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ChatMessage) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.sessionId)
        statement.bindText(3, entity.role)
        statement.bindText(4, entity.content)
        val _tmpImageUrl: String? = entity.imageUrl
        if (_tmpImageUrl == null) {
          statement.bindNull(5)
        } else {
          statement.bindText(5, _tmpImageUrl)
        }
        statement.bindLong(6, entity.timestamp)
        statement.bindLong(7, entity.tokenCount.toLong())
        val _tmp: Int = if (entity.isStreaming) 1 else 0
        statement.bindLong(8, _tmp.toLong())
        val _tmp_1: Int = if (entity.isError) 1 else 0
        statement.bindLong(9, _tmp_1.toLong())
      }
    }
  }

  public override suspend fun insertMessage(message: ChatMessage): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfChatMessage.insert(_connection, message)
  }

  public override fun getMessagesBySessionFlow(sessionId: String): Flow<List<ChatMessage>> {
    val _sql: String = "SELECT * FROM chat_messages WHERE sessionId = ? ORDER BY timestamp ASC"
    return createFlow(__db, false, arrayOf("chat_messages")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, sessionId)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfSessionId: Int = getColumnIndexOrThrow(_stmt, "sessionId")
        val _cursorIndexOfRole: Int = getColumnIndexOrThrow(_stmt, "role")
        val _cursorIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _cursorIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _cursorIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _cursorIndexOfTokenCount: Int = getColumnIndexOrThrow(_stmt, "tokenCount")
        val _cursorIndexOfIsStreaming: Int = getColumnIndexOrThrow(_stmt, "isStreaming")
        val _cursorIndexOfIsError: Int = getColumnIndexOrThrow(_stmt, "isError")
        val _result: MutableList<ChatMessage> = mutableListOf()
        while (_stmt.step()) {
          val _item: ChatMessage
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpSessionId: String
          _tmpSessionId = _stmt.getText(_cursorIndexOfSessionId)
          val _tmpRole: String
          _tmpRole = _stmt.getText(_cursorIndexOfRole)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_cursorIndexOfContent)
          val _tmpImageUrl: String?
          if (_stmt.isNull(_cursorIndexOfImageUrl)) {
            _tmpImageUrl = null
          } else {
            _tmpImageUrl = _stmt.getText(_cursorIndexOfImageUrl)
          }
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_cursorIndexOfTimestamp)
          val _tmpTokenCount: Int
          _tmpTokenCount = _stmt.getLong(_cursorIndexOfTokenCount).toInt()
          val _tmpIsStreaming: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsStreaming).toInt()
          _tmpIsStreaming = _tmp != 0
          val _tmpIsError: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_cursorIndexOfIsError).toInt()
          _tmpIsError = _tmp_1 != 0
          _item =
              ChatMessage(_tmpId,_tmpSessionId,_tmpRole,_tmpContent,_tmpImageUrl,_tmpTimestamp,_tmpTokenCount,_tmpIsStreaming,_tmpIsError)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getLastMessageForSession(sessionId: String): ChatMessage? {
    val _sql: String =
        "SELECT * FROM chat_messages WHERE sessionId = ? ORDER BY timestamp DESC LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, sessionId)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfSessionId: Int = getColumnIndexOrThrow(_stmt, "sessionId")
        val _cursorIndexOfRole: Int = getColumnIndexOrThrow(_stmt, "role")
        val _cursorIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _cursorIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _cursorIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _cursorIndexOfTokenCount: Int = getColumnIndexOrThrow(_stmt, "tokenCount")
        val _cursorIndexOfIsStreaming: Int = getColumnIndexOrThrow(_stmt, "isStreaming")
        val _cursorIndexOfIsError: Int = getColumnIndexOrThrow(_stmt, "isError")
        val _result: ChatMessage?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpSessionId: String
          _tmpSessionId = _stmt.getText(_cursorIndexOfSessionId)
          val _tmpRole: String
          _tmpRole = _stmt.getText(_cursorIndexOfRole)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_cursorIndexOfContent)
          val _tmpImageUrl: String?
          if (_stmt.isNull(_cursorIndexOfImageUrl)) {
            _tmpImageUrl = null
          } else {
            _tmpImageUrl = _stmt.getText(_cursorIndexOfImageUrl)
          }
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_cursorIndexOfTimestamp)
          val _tmpTokenCount: Int
          _tmpTokenCount = _stmt.getLong(_cursorIndexOfTokenCount).toInt()
          val _tmpIsStreaming: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsStreaming).toInt()
          _tmpIsStreaming = _tmp != 0
          val _tmpIsError: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_cursorIndexOfIsError).toInt()
          _tmpIsError = _tmp_1 != 0
          _result =
              ChatMessage(_tmpId,_tmpSessionId,_tmpRole,_tmpContent,_tmpImageUrl,_tmpTimestamp,_tmpTokenCount,_tmpIsStreaming,_tmpIsError)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteMessagesBySession(sessionId: String) {
    val _sql: String = "DELETE FROM chat_messages WHERE sessionId = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, sessionId)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteAllMessages() {
    val _sql: String = "DELETE FROM chat_messages"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
