package com.hezini.assistant.`data`.local

import androidx.collection.ArrayMap
import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.appendPlaceholders
import androidx.room.util.getColumnIndex
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.room.util.recursiveFetchArrayMap
import androidx.sqlite.SQLiteConnection
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
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlin.text.StringBuilder
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ChatSessionDao_Impl(
  __db: RoomDatabase,
) : ChatSessionDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfChatSession: EntityInsertAdapter<ChatSession>

  private val __deleteAdapterOfChatSession: EntityDeleteOrUpdateAdapter<ChatSession>

  private val __updateAdapterOfChatSession: EntityDeleteOrUpdateAdapter<ChatSession>
  init {
    this.__db = __db
    this.__insertAdapterOfChatSession = object : EntityInsertAdapter<ChatSession>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `chat_sessions` (`id`,`title`,`createdAt`,`updatedAt`,`messageCount`,`isFavorite`,`tags`) VALUES (?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ChatSession) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.title)
        statement.bindLong(3, entity.createdAt)
        statement.bindLong(4, entity.updatedAt)
        statement.bindLong(5, entity.messageCount.toLong())
        val _tmp: Int = if (entity.isFavorite) 1 else 0
        statement.bindLong(6, _tmp.toLong())
        statement.bindText(7, entity.tags)
      }
    }
    this.__deleteAdapterOfChatSession = object : EntityDeleteOrUpdateAdapter<ChatSession>() {
      protected override fun createQuery(): String = "DELETE FROM `chat_sessions` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: ChatSession) {
        statement.bindText(1, entity.id)
      }
    }
    this.__updateAdapterOfChatSession = object : EntityDeleteOrUpdateAdapter<ChatSession>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `chat_sessions` SET `id` = ?,`title` = ?,`createdAt` = ?,`updatedAt` = ?,`messageCount` = ?,`isFavorite` = ?,`tags` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: ChatSession) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.title)
        statement.bindLong(3, entity.createdAt)
        statement.bindLong(4, entity.updatedAt)
        statement.bindLong(5, entity.messageCount.toLong())
        val _tmp: Int = if (entity.isFavorite) 1 else 0
        statement.bindLong(6, _tmp.toLong())
        statement.bindText(7, entity.tags)
        statement.bindText(8, entity.id)
      }
    }
  }

  public override suspend fun insertSession(session: ChatSession): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfChatSession.insert(_connection, session)
  }

  public override suspend fun deleteSession(session: ChatSession): Unit = performSuspending(__db,
      false, true) { _connection ->
    __deleteAdapterOfChatSession.handle(_connection, session)
  }

  public override suspend fun updateSession(session: ChatSession): Unit = performSuspending(__db,
      false, true) { _connection ->
    __updateAdapterOfChatSession.handle(_connection, session)
  }

  public override fun getAllSessionsWithLastMessageFlow(): Flow<List<ChatSessionWithLastMessage>> {
    val _sql: String = "SELECT * FROM chat_sessions ORDER BY updatedAt DESC"
    return createFlow(__db, true, arrayOf("chat_messages", "chat_sessions")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _cursorIndexOfMessageCount: Int = getColumnIndexOrThrow(_stmt, "messageCount")
        val _cursorIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _cursorIndexOfTags: Int = getColumnIndexOrThrow(_stmt, "tags")
        val _collectionMessages: ArrayMap<String, MutableList<ChatMessage>> =
            ArrayMap<String, MutableList<ChatMessage>>()
        while (_stmt.step()) {
          val _tmpKey: String
          _tmpKey = _stmt.getText(_cursorIndexOfId)
          if (!_collectionMessages.containsKey(_tmpKey)) {
            _collectionMessages.put(_tmpKey, mutableListOf())
          }
        }
        _stmt.reset()
        __fetchRelationshipchatMessagesAscomHeziniAssistantDataLocalChatMessage(_connection,
            _collectionMessages)
        val _result: MutableList<ChatSessionWithLastMessage> = mutableListOf()
        while (_stmt.step()) {
          val _item: ChatSessionWithLastMessage
          val _tmpSession: ChatSession
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_cursorIndexOfUpdatedAt)
          val _tmpMessageCount: Int
          _tmpMessageCount = _stmt.getLong(_cursorIndexOfMessageCount).toInt()
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          val _tmpTags: String
          _tmpTags = _stmt.getText(_cursorIndexOfTags)
          _tmpSession =
              ChatSession(_tmpId,_tmpTitle,_tmpCreatedAt,_tmpUpdatedAt,_tmpMessageCount,_tmpIsFavorite,_tmpTags)
          val _tmpMessagesCollection: MutableList<ChatMessage>
          val _tmpKey_1: String
          _tmpKey_1 = _stmt.getText(_cursorIndexOfId)
          _tmpMessagesCollection = _collectionMessages.getValue(_tmpKey_1)
          _item = ChatSessionWithLastMessage(_tmpSession,_tmpMessagesCollection)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getFavoritesFlow(): Flow<List<ChatSessionWithLastMessage>> {
    val _sql: String = "SELECT * FROM chat_sessions WHERE isFavorite = 1 ORDER BY updatedAt DESC"
    return createFlow(__db, true, arrayOf("chat_messages", "chat_sessions")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _cursorIndexOfMessageCount: Int = getColumnIndexOrThrow(_stmt, "messageCount")
        val _cursorIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _cursorIndexOfTags: Int = getColumnIndexOrThrow(_stmt, "tags")
        val _collectionMessages: ArrayMap<String, MutableList<ChatMessage>> =
            ArrayMap<String, MutableList<ChatMessage>>()
        while (_stmt.step()) {
          val _tmpKey: String
          _tmpKey = _stmt.getText(_cursorIndexOfId)
          if (!_collectionMessages.containsKey(_tmpKey)) {
            _collectionMessages.put(_tmpKey, mutableListOf())
          }
        }
        _stmt.reset()
        __fetchRelationshipchatMessagesAscomHeziniAssistantDataLocalChatMessage(_connection,
            _collectionMessages)
        val _result: MutableList<ChatSessionWithLastMessage> = mutableListOf()
        while (_stmt.step()) {
          val _item: ChatSessionWithLastMessage
          val _tmpSession: ChatSession
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_cursorIndexOfUpdatedAt)
          val _tmpMessageCount: Int
          _tmpMessageCount = _stmt.getLong(_cursorIndexOfMessageCount).toInt()
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          val _tmpTags: String
          _tmpTags = _stmt.getText(_cursorIndexOfTags)
          _tmpSession =
              ChatSession(_tmpId,_tmpTitle,_tmpCreatedAt,_tmpUpdatedAt,_tmpMessageCount,_tmpIsFavorite,_tmpTags)
          val _tmpMessagesCollection: MutableList<ChatMessage>
          val _tmpKey_1: String
          _tmpKey_1 = _stmt.getText(_cursorIndexOfId)
          _tmpMessagesCollection = _collectionMessages.getValue(_tmpKey_1)
          _item = ChatSessionWithLastMessage(_tmpSession,_tmpMessagesCollection)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun searchSessions(query: String): Flow<List<ChatSessionWithLastMessage>> {
    val _sql: String =
        "SELECT * FROM chat_sessions WHERE title LIKE '%' || ? || '%' ORDER BY updatedAt DESC"
    return createFlow(__db, true, arrayOf("chat_messages", "chat_sessions")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, query)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _cursorIndexOfMessageCount: Int = getColumnIndexOrThrow(_stmt, "messageCount")
        val _cursorIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _cursorIndexOfTags: Int = getColumnIndexOrThrow(_stmt, "tags")
        val _collectionMessages: ArrayMap<String, MutableList<ChatMessage>> =
            ArrayMap<String, MutableList<ChatMessage>>()
        while (_stmt.step()) {
          val _tmpKey: String
          _tmpKey = _stmt.getText(_cursorIndexOfId)
          if (!_collectionMessages.containsKey(_tmpKey)) {
            _collectionMessages.put(_tmpKey, mutableListOf())
          }
        }
        _stmt.reset()
        __fetchRelationshipchatMessagesAscomHeziniAssistantDataLocalChatMessage(_connection,
            _collectionMessages)
        val _result: MutableList<ChatSessionWithLastMessage> = mutableListOf()
        while (_stmt.step()) {
          val _item: ChatSessionWithLastMessage
          val _tmpSession: ChatSession
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_cursorIndexOfUpdatedAt)
          val _tmpMessageCount: Int
          _tmpMessageCount = _stmt.getLong(_cursorIndexOfMessageCount).toInt()
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          val _tmpTags: String
          _tmpTags = _stmt.getText(_cursorIndexOfTags)
          _tmpSession =
              ChatSession(_tmpId,_tmpTitle,_tmpCreatedAt,_tmpUpdatedAt,_tmpMessageCount,_tmpIsFavorite,_tmpTags)
          val _tmpMessagesCollection: MutableList<ChatMessage>
          val _tmpKey_1: String
          _tmpKey_1 = _stmt.getText(_cursorIndexOfId)
          _tmpMessagesCollection = _collectionMessages.getValue(_tmpKey_1)
          _item = ChatSessionWithLastMessage(_tmpSession,_tmpMessagesCollection)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getSessionById(sessionId: String): ChatSession? {
    val _sql: String = "SELECT * FROM chat_sessions WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, sessionId)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _cursorIndexOfMessageCount: Int = getColumnIndexOrThrow(_stmt, "messageCount")
        val _cursorIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _cursorIndexOfTags: Int = getColumnIndexOrThrow(_stmt, "tags")
        val _result: ChatSession?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_cursorIndexOfUpdatedAt)
          val _tmpMessageCount: Int
          _tmpMessageCount = _stmt.getLong(_cursorIndexOfMessageCount).toInt()
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          val _tmpTags: String
          _tmpTags = _stmt.getText(_cursorIndexOfTags)
          _result =
              ChatSession(_tmpId,_tmpTitle,_tmpCreatedAt,_tmpUpdatedAt,_tmpMessageCount,_tmpIsFavorite,_tmpTags)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteAllSessions() {
    val _sql: String = "DELETE FROM chat_sessions"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  private
      fun __fetchRelationshipchatMessagesAscomHeziniAssistantDataLocalChatMessage(_connection: SQLiteConnection,
      _map: ArrayMap<String, MutableList<ChatMessage>>) {
    val __mapKeySet: Set<String> = _map.keys
    if (__mapKeySet.isEmpty()) {
      return
    }
    if (_map.size > 999) {
      recursiveFetchArrayMap(_map, true) { _tmpMap ->
        __fetchRelationshipchatMessagesAscomHeziniAssistantDataLocalChatMessage(_connection,
            _tmpMap)
      }
      return
    }
    val _stringBuilder: StringBuilder = StringBuilder()
    _stringBuilder.append("SELECT `id`,`sessionId`,`role`,`content`,`imageUrl`,`timestamp`,`tokenCount`,`isStreaming`,`isError` FROM `chat_messages` WHERE `sessionId` IN (")
    val _inputSize: Int = __mapKeySet.size
    appendPlaceholders(_stringBuilder, _inputSize)
    _stringBuilder.append(")")
    val _sql: String = _stringBuilder.toString()
    val _stmt: SQLiteStatement = _connection.prepare(_sql)
    var _argIndex: Int = 1
    for (_item: String in __mapKeySet) {
      _stmt.bindText(_argIndex, _item)
      _argIndex++
    }
    try {
      val _itemKeyIndex: Int = getColumnIndex(_stmt, "sessionId")
      if (_itemKeyIndex == -1) {
        return
      }
      val _cursorIndexOfId: Int = 0
      val _cursorIndexOfSessionId: Int = 1
      val _cursorIndexOfRole: Int = 2
      val _cursorIndexOfContent: Int = 3
      val _cursorIndexOfImageUrl: Int = 4
      val _cursorIndexOfTimestamp: Int = 5
      val _cursorIndexOfTokenCount: Int = 6
      val _cursorIndexOfIsStreaming: Int = 7
      val _cursorIndexOfIsError: Int = 8
      while (_stmt.step()) {
        val _tmpKey: String
        _tmpKey = _stmt.getText(_itemKeyIndex)
        val _tmpRelation: MutableList<ChatMessage>? = _map.get(_tmpKey)
        if (_tmpRelation != null) {
          val _item_1: ChatMessage
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
          _item_1 =
              ChatMessage(_tmpId,_tmpSessionId,_tmpRole,_tmpContent,_tmpImageUrl,_tmpTimestamp,_tmpTokenCount,_tmpIsStreaming,_tmpIsError)
          _tmpRelation.add(_item_1)
        }
      }
    } finally {
      _stmt.close()
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
