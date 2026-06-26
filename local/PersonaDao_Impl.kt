package com.hezini.assistant.`data`.local

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performInTransactionSuspending
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Float
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
public class PersonaDao_Impl(
  __db: RoomDatabase,
) : PersonaDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfPersona: EntityInsertAdapter<Persona>

  private val __deleteAdapterOfPersona: EntityDeleteOrUpdateAdapter<Persona>

  private val __updateAdapterOfPersona: EntityDeleteOrUpdateAdapter<Persona>
  init {
    this.__db = __db
    this.__insertAdapterOfPersona = object : EntityInsertAdapter<Persona>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `personas` (`id`,`name`,`tagline`,`avatarEmoji`,`avatarColor`,`avatarImagePath`,`category`,`systemPrompt`,`creativityLevel`,`formalityLevel`,`detailLevel`,`toneLevel`,`ttsVoicePitch`,`ttsVoiceSpeed`,`greetingMessage`,`isBuiltIn`,`isActive`,`createdAt`,`lastUsedAt`,`totalChats`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Persona) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.tagline)
        statement.bindText(4, entity.avatarEmoji)
        statement.bindText(5, entity.avatarColor)
        val _tmpAvatarImagePath: String? = entity.avatarImagePath
        if (_tmpAvatarImagePath == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpAvatarImagePath)
        }
        statement.bindText(7, entity.category)
        statement.bindText(8, entity.systemPrompt)
        statement.bindLong(9, entity.creativityLevel.toLong())
        statement.bindLong(10, entity.formalityLevel.toLong())
        statement.bindLong(11, entity.detailLevel.toLong())
        statement.bindLong(12, entity.toneLevel.toLong())
        val _tmpTtsVoicePitch: Float? = entity.ttsVoicePitch
        if (_tmpTtsVoicePitch == null) {
          statement.bindNull(13)
        } else {
          statement.bindDouble(13, _tmpTtsVoicePitch.toDouble())
        }
        val _tmpTtsVoiceSpeed: Float? = entity.ttsVoiceSpeed
        if (_tmpTtsVoiceSpeed == null) {
          statement.bindNull(14)
        } else {
          statement.bindDouble(14, _tmpTtsVoiceSpeed.toDouble())
        }
        val _tmpGreetingMessage: String? = entity.greetingMessage
        if (_tmpGreetingMessage == null) {
          statement.bindNull(15)
        } else {
          statement.bindText(15, _tmpGreetingMessage)
        }
        val _tmp: Int = if (entity.isBuiltIn) 1 else 0
        statement.bindLong(16, _tmp.toLong())
        val _tmp_1: Int = if (entity.isActive) 1 else 0
        statement.bindLong(17, _tmp_1.toLong())
        statement.bindLong(18, entity.createdAt)
        statement.bindLong(19, entity.lastUsedAt)
        statement.bindLong(20, entity.totalChats.toLong())
      }
    }
    this.__deleteAdapterOfPersona = object : EntityDeleteOrUpdateAdapter<Persona>() {
      protected override fun createQuery(): String = "DELETE FROM `personas` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Persona) {
        statement.bindText(1, entity.id)
      }
    }
    this.__updateAdapterOfPersona = object : EntityDeleteOrUpdateAdapter<Persona>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `personas` SET `id` = ?,`name` = ?,`tagline` = ?,`avatarEmoji` = ?,`avatarColor` = ?,`avatarImagePath` = ?,`category` = ?,`systemPrompt` = ?,`creativityLevel` = ?,`formalityLevel` = ?,`detailLevel` = ?,`toneLevel` = ?,`ttsVoicePitch` = ?,`ttsVoiceSpeed` = ?,`greetingMessage` = ?,`isBuiltIn` = ?,`isActive` = ?,`createdAt` = ?,`lastUsedAt` = ?,`totalChats` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Persona) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.tagline)
        statement.bindText(4, entity.avatarEmoji)
        statement.bindText(5, entity.avatarColor)
        val _tmpAvatarImagePath: String? = entity.avatarImagePath
        if (_tmpAvatarImagePath == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpAvatarImagePath)
        }
        statement.bindText(7, entity.category)
        statement.bindText(8, entity.systemPrompt)
        statement.bindLong(9, entity.creativityLevel.toLong())
        statement.bindLong(10, entity.formalityLevel.toLong())
        statement.bindLong(11, entity.detailLevel.toLong())
        statement.bindLong(12, entity.toneLevel.toLong())
        val _tmpTtsVoicePitch: Float? = entity.ttsVoicePitch
        if (_tmpTtsVoicePitch == null) {
          statement.bindNull(13)
        } else {
          statement.bindDouble(13, _tmpTtsVoicePitch.toDouble())
        }
        val _tmpTtsVoiceSpeed: Float? = entity.ttsVoiceSpeed
        if (_tmpTtsVoiceSpeed == null) {
          statement.bindNull(14)
        } else {
          statement.bindDouble(14, _tmpTtsVoiceSpeed.toDouble())
        }
        val _tmpGreetingMessage: String? = entity.greetingMessage
        if (_tmpGreetingMessage == null) {
          statement.bindNull(15)
        } else {
          statement.bindText(15, _tmpGreetingMessage)
        }
        val _tmp: Int = if (entity.isBuiltIn) 1 else 0
        statement.bindLong(16, _tmp.toLong())
        val _tmp_1: Int = if (entity.isActive) 1 else 0
        statement.bindLong(17, _tmp_1.toLong())
        statement.bindLong(18, entity.createdAt)
        statement.bindLong(19, entity.lastUsedAt)
        statement.bindLong(20, entity.totalChats.toLong())
        statement.bindText(21, entity.id)
      }
    }
  }

  public override suspend fun insertPersona(persona: Persona): Unit = performSuspending(__db, false,
      true) { _connection ->
    __insertAdapterOfPersona.insert(_connection, persona)
  }

  public override suspend fun deletePersona(persona: Persona): Unit = performSuspending(__db, false,
      true) { _connection ->
    __deleteAdapterOfPersona.handle(_connection, persona)
  }

  public override suspend fun updatePersona(persona: Persona): Unit = performSuspending(__db, false,
      true) { _connection ->
    __updateAdapterOfPersona.handle(_connection, persona)
  }

  public override suspend fun setActivePersona(id: String): Unit =
      performInTransactionSuspending(__db) {
    super@PersonaDao_Impl.setActivePersona(id)
  }

  public override fun getAllPersonas(): Flow<List<Persona>> {
    val _sql: String = "SELECT * FROM personas ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("personas")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _cursorIndexOfTagline: Int = getColumnIndexOrThrow(_stmt, "tagline")
        val _cursorIndexOfAvatarEmoji: Int = getColumnIndexOrThrow(_stmt, "avatarEmoji")
        val _cursorIndexOfAvatarColor: Int = getColumnIndexOrThrow(_stmt, "avatarColor")
        val _cursorIndexOfAvatarImagePath: Int = getColumnIndexOrThrow(_stmt, "avatarImagePath")
        val _cursorIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _cursorIndexOfSystemPrompt: Int = getColumnIndexOrThrow(_stmt, "systemPrompt")
        val _cursorIndexOfCreativityLevel: Int = getColumnIndexOrThrow(_stmt, "creativityLevel")
        val _cursorIndexOfFormalityLevel: Int = getColumnIndexOrThrow(_stmt, "formalityLevel")
        val _cursorIndexOfDetailLevel: Int = getColumnIndexOrThrow(_stmt, "detailLevel")
        val _cursorIndexOfToneLevel: Int = getColumnIndexOrThrow(_stmt, "toneLevel")
        val _cursorIndexOfTtsVoicePitch: Int = getColumnIndexOrThrow(_stmt, "ttsVoicePitch")
        val _cursorIndexOfTtsVoiceSpeed: Int = getColumnIndexOrThrow(_stmt, "ttsVoiceSpeed")
        val _cursorIndexOfGreetingMessage: Int = getColumnIndexOrThrow(_stmt, "greetingMessage")
        val _cursorIndexOfIsBuiltIn: Int = getColumnIndexOrThrow(_stmt, "isBuiltIn")
        val _cursorIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfLastUsedAt: Int = getColumnIndexOrThrow(_stmt, "lastUsedAt")
        val _cursorIndexOfTotalChats: Int = getColumnIndexOrThrow(_stmt, "totalChats")
        val _result: MutableList<Persona> = mutableListOf()
        while (_stmt.step()) {
          val _item: Persona
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_cursorIndexOfName)
          val _tmpTagline: String
          _tmpTagline = _stmt.getText(_cursorIndexOfTagline)
          val _tmpAvatarEmoji: String
          _tmpAvatarEmoji = _stmt.getText(_cursorIndexOfAvatarEmoji)
          val _tmpAvatarColor: String
          _tmpAvatarColor = _stmt.getText(_cursorIndexOfAvatarColor)
          val _tmpAvatarImagePath: String?
          if (_stmt.isNull(_cursorIndexOfAvatarImagePath)) {
            _tmpAvatarImagePath = null
          } else {
            _tmpAvatarImagePath = _stmt.getText(_cursorIndexOfAvatarImagePath)
          }
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_cursorIndexOfCategory)
          val _tmpSystemPrompt: String
          _tmpSystemPrompt = _stmt.getText(_cursorIndexOfSystemPrompt)
          val _tmpCreativityLevel: Int
          _tmpCreativityLevel = _stmt.getLong(_cursorIndexOfCreativityLevel).toInt()
          val _tmpFormalityLevel: Int
          _tmpFormalityLevel = _stmt.getLong(_cursorIndexOfFormalityLevel).toInt()
          val _tmpDetailLevel: Int
          _tmpDetailLevel = _stmt.getLong(_cursorIndexOfDetailLevel).toInt()
          val _tmpToneLevel: Int
          _tmpToneLevel = _stmt.getLong(_cursorIndexOfToneLevel).toInt()
          val _tmpTtsVoicePitch: Float?
          if (_stmt.isNull(_cursorIndexOfTtsVoicePitch)) {
            _tmpTtsVoicePitch = null
          } else {
            _tmpTtsVoicePitch = _stmt.getDouble(_cursorIndexOfTtsVoicePitch).toFloat()
          }
          val _tmpTtsVoiceSpeed: Float?
          if (_stmt.isNull(_cursorIndexOfTtsVoiceSpeed)) {
            _tmpTtsVoiceSpeed = null
          } else {
            _tmpTtsVoiceSpeed = _stmt.getDouble(_cursorIndexOfTtsVoiceSpeed).toFloat()
          }
          val _tmpGreetingMessage: String?
          if (_stmt.isNull(_cursorIndexOfGreetingMessage)) {
            _tmpGreetingMessage = null
          } else {
            _tmpGreetingMessage = _stmt.getText(_cursorIndexOfGreetingMessage)
          }
          val _tmpIsBuiltIn: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsBuiltIn).toInt()
          _tmpIsBuiltIn = _tmp != 0
          val _tmpIsActive: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_cursorIndexOfIsActive).toInt()
          _tmpIsActive = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpLastUsedAt: Long
          _tmpLastUsedAt = _stmt.getLong(_cursorIndexOfLastUsedAt)
          val _tmpTotalChats: Int
          _tmpTotalChats = _stmt.getLong(_cursorIndexOfTotalChats).toInt()
          _item =
              Persona(_tmpId,_tmpName,_tmpTagline,_tmpAvatarEmoji,_tmpAvatarColor,_tmpAvatarImagePath,_tmpCategory,_tmpSystemPrompt,_tmpCreativityLevel,_tmpFormalityLevel,_tmpDetailLevel,_tmpToneLevel,_tmpTtsVoicePitch,_tmpTtsVoiceSpeed,_tmpGreetingMessage,_tmpIsBuiltIn,_tmpIsActive,_tmpCreatedAt,_tmpLastUsedAt,_tmpTotalChats)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getActivePersona(): Flow<Persona?> {
    val _sql: String = "SELECT * FROM personas WHERE isActive = 1 LIMIT 1"
    return createFlow(__db, false, arrayOf("personas")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _cursorIndexOfTagline: Int = getColumnIndexOrThrow(_stmt, "tagline")
        val _cursorIndexOfAvatarEmoji: Int = getColumnIndexOrThrow(_stmt, "avatarEmoji")
        val _cursorIndexOfAvatarColor: Int = getColumnIndexOrThrow(_stmt, "avatarColor")
        val _cursorIndexOfAvatarImagePath: Int = getColumnIndexOrThrow(_stmt, "avatarImagePath")
        val _cursorIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _cursorIndexOfSystemPrompt: Int = getColumnIndexOrThrow(_stmt, "systemPrompt")
        val _cursorIndexOfCreativityLevel: Int = getColumnIndexOrThrow(_stmt, "creativityLevel")
        val _cursorIndexOfFormalityLevel: Int = getColumnIndexOrThrow(_stmt, "formalityLevel")
        val _cursorIndexOfDetailLevel: Int = getColumnIndexOrThrow(_stmt, "detailLevel")
        val _cursorIndexOfToneLevel: Int = getColumnIndexOrThrow(_stmt, "toneLevel")
        val _cursorIndexOfTtsVoicePitch: Int = getColumnIndexOrThrow(_stmt, "ttsVoicePitch")
        val _cursorIndexOfTtsVoiceSpeed: Int = getColumnIndexOrThrow(_stmt, "ttsVoiceSpeed")
        val _cursorIndexOfGreetingMessage: Int = getColumnIndexOrThrow(_stmt, "greetingMessage")
        val _cursorIndexOfIsBuiltIn: Int = getColumnIndexOrThrow(_stmt, "isBuiltIn")
        val _cursorIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfLastUsedAt: Int = getColumnIndexOrThrow(_stmt, "lastUsedAt")
        val _cursorIndexOfTotalChats: Int = getColumnIndexOrThrow(_stmt, "totalChats")
        val _result: Persona?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_cursorIndexOfName)
          val _tmpTagline: String
          _tmpTagline = _stmt.getText(_cursorIndexOfTagline)
          val _tmpAvatarEmoji: String
          _tmpAvatarEmoji = _stmt.getText(_cursorIndexOfAvatarEmoji)
          val _tmpAvatarColor: String
          _tmpAvatarColor = _stmt.getText(_cursorIndexOfAvatarColor)
          val _tmpAvatarImagePath: String?
          if (_stmt.isNull(_cursorIndexOfAvatarImagePath)) {
            _tmpAvatarImagePath = null
          } else {
            _tmpAvatarImagePath = _stmt.getText(_cursorIndexOfAvatarImagePath)
          }
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_cursorIndexOfCategory)
          val _tmpSystemPrompt: String
          _tmpSystemPrompt = _stmt.getText(_cursorIndexOfSystemPrompt)
          val _tmpCreativityLevel: Int
          _tmpCreativityLevel = _stmt.getLong(_cursorIndexOfCreativityLevel).toInt()
          val _tmpFormalityLevel: Int
          _tmpFormalityLevel = _stmt.getLong(_cursorIndexOfFormalityLevel).toInt()
          val _tmpDetailLevel: Int
          _tmpDetailLevel = _stmt.getLong(_cursorIndexOfDetailLevel).toInt()
          val _tmpToneLevel: Int
          _tmpToneLevel = _stmt.getLong(_cursorIndexOfToneLevel).toInt()
          val _tmpTtsVoicePitch: Float?
          if (_stmt.isNull(_cursorIndexOfTtsVoicePitch)) {
            _tmpTtsVoicePitch = null
          } else {
            _tmpTtsVoicePitch = _stmt.getDouble(_cursorIndexOfTtsVoicePitch).toFloat()
          }
          val _tmpTtsVoiceSpeed: Float?
          if (_stmt.isNull(_cursorIndexOfTtsVoiceSpeed)) {
            _tmpTtsVoiceSpeed = null
          } else {
            _tmpTtsVoiceSpeed = _stmt.getDouble(_cursorIndexOfTtsVoiceSpeed).toFloat()
          }
          val _tmpGreetingMessage: String?
          if (_stmt.isNull(_cursorIndexOfGreetingMessage)) {
            _tmpGreetingMessage = null
          } else {
            _tmpGreetingMessage = _stmt.getText(_cursorIndexOfGreetingMessage)
          }
          val _tmpIsBuiltIn: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsBuiltIn).toInt()
          _tmpIsBuiltIn = _tmp != 0
          val _tmpIsActive: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_cursorIndexOfIsActive).toInt()
          _tmpIsActive = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpLastUsedAt: Long
          _tmpLastUsedAt = _stmt.getLong(_cursorIndexOfLastUsedAt)
          val _tmpTotalChats: Int
          _tmpTotalChats = _stmt.getLong(_cursorIndexOfTotalChats).toInt()
          _result =
              Persona(_tmpId,_tmpName,_tmpTagline,_tmpAvatarEmoji,_tmpAvatarColor,_tmpAvatarImagePath,_tmpCategory,_tmpSystemPrompt,_tmpCreativityLevel,_tmpFormalityLevel,_tmpDetailLevel,_tmpToneLevel,_tmpTtsVoicePitch,_tmpTtsVoiceSpeed,_tmpGreetingMessage,_tmpIsBuiltIn,_tmpIsActive,_tmpCreatedAt,_tmpLastUsedAt,_tmpTotalChats)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getPersonaById(id: String): Persona? {
    val _sql: String = "SELECT * FROM personas WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _cursorIndexOfTagline: Int = getColumnIndexOrThrow(_stmt, "tagline")
        val _cursorIndexOfAvatarEmoji: Int = getColumnIndexOrThrow(_stmt, "avatarEmoji")
        val _cursorIndexOfAvatarColor: Int = getColumnIndexOrThrow(_stmt, "avatarColor")
        val _cursorIndexOfAvatarImagePath: Int = getColumnIndexOrThrow(_stmt, "avatarImagePath")
        val _cursorIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _cursorIndexOfSystemPrompt: Int = getColumnIndexOrThrow(_stmt, "systemPrompt")
        val _cursorIndexOfCreativityLevel: Int = getColumnIndexOrThrow(_stmt, "creativityLevel")
        val _cursorIndexOfFormalityLevel: Int = getColumnIndexOrThrow(_stmt, "formalityLevel")
        val _cursorIndexOfDetailLevel: Int = getColumnIndexOrThrow(_stmt, "detailLevel")
        val _cursorIndexOfToneLevel: Int = getColumnIndexOrThrow(_stmt, "toneLevel")
        val _cursorIndexOfTtsVoicePitch: Int = getColumnIndexOrThrow(_stmt, "ttsVoicePitch")
        val _cursorIndexOfTtsVoiceSpeed: Int = getColumnIndexOrThrow(_stmt, "ttsVoiceSpeed")
        val _cursorIndexOfGreetingMessage: Int = getColumnIndexOrThrow(_stmt, "greetingMessage")
        val _cursorIndexOfIsBuiltIn: Int = getColumnIndexOrThrow(_stmt, "isBuiltIn")
        val _cursorIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfLastUsedAt: Int = getColumnIndexOrThrow(_stmt, "lastUsedAt")
        val _cursorIndexOfTotalChats: Int = getColumnIndexOrThrow(_stmt, "totalChats")
        val _result: Persona?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_cursorIndexOfName)
          val _tmpTagline: String
          _tmpTagline = _stmt.getText(_cursorIndexOfTagline)
          val _tmpAvatarEmoji: String
          _tmpAvatarEmoji = _stmt.getText(_cursorIndexOfAvatarEmoji)
          val _tmpAvatarColor: String
          _tmpAvatarColor = _stmt.getText(_cursorIndexOfAvatarColor)
          val _tmpAvatarImagePath: String?
          if (_stmt.isNull(_cursorIndexOfAvatarImagePath)) {
            _tmpAvatarImagePath = null
          } else {
            _tmpAvatarImagePath = _stmt.getText(_cursorIndexOfAvatarImagePath)
          }
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_cursorIndexOfCategory)
          val _tmpSystemPrompt: String
          _tmpSystemPrompt = _stmt.getText(_cursorIndexOfSystemPrompt)
          val _tmpCreativityLevel: Int
          _tmpCreativityLevel = _stmt.getLong(_cursorIndexOfCreativityLevel).toInt()
          val _tmpFormalityLevel: Int
          _tmpFormalityLevel = _stmt.getLong(_cursorIndexOfFormalityLevel).toInt()
          val _tmpDetailLevel: Int
          _tmpDetailLevel = _stmt.getLong(_cursorIndexOfDetailLevel).toInt()
          val _tmpToneLevel: Int
          _tmpToneLevel = _stmt.getLong(_cursorIndexOfToneLevel).toInt()
          val _tmpTtsVoicePitch: Float?
          if (_stmt.isNull(_cursorIndexOfTtsVoicePitch)) {
            _tmpTtsVoicePitch = null
          } else {
            _tmpTtsVoicePitch = _stmt.getDouble(_cursorIndexOfTtsVoicePitch).toFloat()
          }
          val _tmpTtsVoiceSpeed: Float?
          if (_stmt.isNull(_cursorIndexOfTtsVoiceSpeed)) {
            _tmpTtsVoiceSpeed = null
          } else {
            _tmpTtsVoiceSpeed = _stmt.getDouble(_cursorIndexOfTtsVoiceSpeed).toFloat()
          }
          val _tmpGreetingMessage: String?
          if (_stmt.isNull(_cursorIndexOfGreetingMessage)) {
            _tmpGreetingMessage = null
          } else {
            _tmpGreetingMessage = _stmt.getText(_cursorIndexOfGreetingMessage)
          }
          val _tmpIsBuiltIn: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsBuiltIn).toInt()
          _tmpIsBuiltIn = _tmp != 0
          val _tmpIsActive: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_cursorIndexOfIsActive).toInt()
          _tmpIsActive = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpLastUsedAt: Long
          _tmpLastUsedAt = _stmt.getLong(_cursorIndexOfLastUsedAt)
          val _tmpTotalChats: Int
          _tmpTotalChats = _stmt.getLong(_cursorIndexOfTotalChats).toInt()
          _result =
              Persona(_tmpId,_tmpName,_tmpTagline,_tmpAvatarEmoji,_tmpAvatarColor,_tmpAvatarImagePath,_tmpCategory,_tmpSystemPrompt,_tmpCreativityLevel,_tmpFormalityLevel,_tmpDetailLevel,_tmpToneLevel,_tmpTtsVoicePitch,_tmpTtsVoiceSpeed,_tmpGreetingMessage,_tmpIsBuiltIn,_tmpIsActive,_tmpCreatedAt,_tmpLastUsedAt,_tmpTotalChats)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getCount(): Int {
    val _sql: String = "SELECT COUNT(*) FROM personas"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clearActivePersona() {
    val _sql: String = "UPDATE personas SET isActive = 0"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun markPersonaAsActive(id: String) {
    val _sql: String = "UPDATE personas SET isActive = 1 WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
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
