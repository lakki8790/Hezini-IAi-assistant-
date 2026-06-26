package com.hezini.assistant.`data`.local

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class HeziniDatabase_Impl : HeziniDatabase() {
  private val _chatSessionDao: Lazy<ChatSessionDao> = lazy {
    ChatSessionDao_Impl(this)
  }


  private val _chatMessageDao: Lazy<ChatMessageDao> = lazy {
    ChatMessageDao_Impl(this)
  }


  private val _savedPromptDao: Lazy<SavedPromptDao> = lazy {
    SavedPromptDao_Impl(this)
  }


  private val _generatedImageDao: Lazy<GeneratedImageDao> = lazy {
    GeneratedImageDao_Impl(this)
  }


  private val _analyzedDocumentDao: Lazy<AnalyzedDocumentDao> = lazy {
    AnalyzedDocumentDao_Impl(this)
  }


  private val _personaDao: Lazy<PersonaDao> = lazy {
    PersonaDao_Impl(this)
  }


  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(5,
        "0f377a89b2d1996a05f5a45d7c5409f4", "111a1c00c80c592b539ad7fccb5475dc") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `chat_sessions` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `messageCount` INTEGER NOT NULL, `isFavorite` INTEGER NOT NULL, `tags` TEXT NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `chat_messages` (`id` TEXT NOT NULL, `sessionId` TEXT NOT NULL, `role` TEXT NOT NULL, `content` TEXT NOT NULL, `imageUrl` TEXT, `timestamp` INTEGER NOT NULL, `tokenCount` INTEGER NOT NULL, `isStreaming` INTEGER NOT NULL, `isError` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`sessionId`) REFERENCES `chat_sessions`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )")
        connection.execSQL("CREATE INDEX IF NOT EXISTS `index_chat_messages_sessionId` ON `chat_messages` (`sessionId`)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `saved_prompts` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `prompt` TEXT NOT NULL, `category` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `user_notes` (`id` TEXT NOT NULL, `sessionId` TEXT NOT NULL, `content` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `chats` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `lastMessage` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `isPremium` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `generated_images` (`id` TEXT NOT NULL, `prompt` TEXT NOT NULL, `revisedPrompt` TEXT NOT NULL, `localPath` TEXT NOT NULL, `size` TEXT NOT NULL, `quality` TEXT NOT NULL, `style` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `isFavorite` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `analyzed_documents` (`id` TEXT NOT NULL, `fileName` TEXT NOT NULL, `fileType` TEXT NOT NULL, `analysisType` TEXT NOT NULL, `resultText` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `fileSizeKb` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `personas` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `tagline` TEXT NOT NULL, `avatarEmoji` TEXT NOT NULL, `avatarColor` TEXT NOT NULL, `avatarImagePath` TEXT, `category` TEXT NOT NULL, `systemPrompt` TEXT NOT NULL, `creativityLevel` INTEGER NOT NULL, `formalityLevel` INTEGER NOT NULL, `detailLevel` INTEGER NOT NULL, `toneLevel` INTEGER NOT NULL, `ttsVoicePitch` REAL, `ttsVoiceSpeed` REAL, `greetingMessage` TEXT, `isBuiltIn` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `lastUsedAt` INTEGER NOT NULL, `totalChats` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0f377a89b2d1996a05f5a45d7c5409f4')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `chat_sessions`")
        connection.execSQL("DROP TABLE IF EXISTS `chat_messages`")
        connection.execSQL("DROP TABLE IF EXISTS `saved_prompts`")
        connection.execSQL("DROP TABLE IF EXISTS `user_notes`")
        connection.execSQL("DROP TABLE IF EXISTS `chats`")
        connection.execSQL("DROP TABLE IF EXISTS `generated_images`")
        connection.execSQL("DROP TABLE IF EXISTS `analyzed_documents`")
        connection.execSQL("DROP TABLE IF EXISTS `personas`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        connection.execSQL("PRAGMA foreign_keys = ON")
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsChatSessions: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsChatSessions.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChatSessions.put("title", TableInfo.Column("title", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChatSessions.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatSessions.put("updatedAt", TableInfo.Column("updatedAt", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatSessions.put("messageCount", TableInfo.Column("messageCount", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatSessions.put("isFavorite", TableInfo.Column("isFavorite", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatSessions.put("tags", TableInfo.Column("tags", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysChatSessions: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesChatSessions: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoChatSessions: TableInfo = TableInfo("chat_sessions", _columnsChatSessions,
            _foreignKeysChatSessions, _indicesChatSessions)
        val _existingChatSessions: TableInfo = read(connection, "chat_sessions")
        if (!_infoChatSessions.equals(_existingChatSessions)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |chat_sessions(com.hezini.assistant.data.local.ChatSession).
              | Expected:
              |""".trimMargin() + _infoChatSessions + """
              |
              | Found:
              |""".trimMargin() + _existingChatSessions)
        }
        val _columnsChatMessages: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsChatMessages.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("sessionId", TableInfo.Column("sessionId", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("role", TableInfo.Column("role", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("content", TableInfo.Column("content", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("imageUrl", TableInfo.Column("imageUrl", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("timestamp", TableInfo.Column("timestamp", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("tokenCount", TableInfo.Column("tokenCount", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("isStreaming", TableInfo.Column("isStreaming", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("isError", TableInfo.Column("isError", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysChatMessages: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        _foreignKeysChatMessages.add(TableInfo.ForeignKey("chat_sessions", "CASCADE", "NO ACTION",
            listOf("sessionId"), listOf("id")))
        val _indicesChatMessages: MutableSet<TableInfo.Index> = mutableSetOf()
        _indicesChatMessages.add(TableInfo.Index("index_chat_messages_sessionId", false,
            listOf("sessionId"), listOf("ASC")))
        val _infoChatMessages: TableInfo = TableInfo("chat_messages", _columnsChatMessages,
            _foreignKeysChatMessages, _indicesChatMessages)
        val _existingChatMessages: TableInfo = read(connection, "chat_messages")
        if (!_infoChatMessages.equals(_existingChatMessages)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |chat_messages(com.hezini.assistant.data.local.ChatMessage).
              | Expected:
              |""".trimMargin() + _infoChatMessages + """
              |
              | Found:
              |""".trimMargin() + _existingChatMessages)
        }
        val _columnsSavedPrompts: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsSavedPrompts.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedPrompts.put("title", TableInfo.Column("title", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedPrompts.put("prompt", TableInfo.Column("prompt", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedPrompts.put("category", TableInfo.Column("category", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedPrompts.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysSavedPrompts: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesSavedPrompts: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoSavedPrompts: TableInfo = TableInfo("saved_prompts", _columnsSavedPrompts,
            _foreignKeysSavedPrompts, _indicesSavedPrompts)
        val _existingSavedPrompts: TableInfo = read(connection, "saved_prompts")
        if (!_infoSavedPrompts.equals(_existingSavedPrompts)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |saved_prompts(com.hezini.assistant.data.local.SavedPrompt).
              | Expected:
              |""".trimMargin() + _infoSavedPrompts + """
              |
              | Found:
              |""".trimMargin() + _existingSavedPrompts)
        }
        val _columnsUserNotes: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsUserNotes.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserNotes.put("sessionId", TableInfo.Column("sessionId", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserNotes.put("content", TableInfo.Column("content", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserNotes.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysUserNotes: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesUserNotes: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoUserNotes: TableInfo = TableInfo("user_notes", _columnsUserNotes,
            _foreignKeysUserNotes, _indicesUserNotes)
        val _existingUserNotes: TableInfo = read(connection, "user_notes")
        if (!_infoUserNotes.equals(_existingUserNotes)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |user_notes(com.hezini.assistant.data.local.UserNote).
              | Expected:
              |""".trimMargin() + _infoUserNotes + """
              |
              | Found:
              |""".trimMargin() + _existingUserNotes)
        }
        val _columnsChats: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsChats.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChats.put("title", TableInfo.Column("title", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChats.put("lastMessage", TableInfo.Column("lastMessage", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChats.put("timestamp", TableInfo.Column("timestamp", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsChats.put("isPremium", TableInfo.Column("isPremium", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysChats: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesChats: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoChats: TableInfo = TableInfo("chats", _columnsChats, _foreignKeysChats,
            _indicesChats)
        val _existingChats: TableInfo = read(connection, "chats")
        if (!_infoChats.equals(_existingChats)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |chats(com.hezini.assistant.data.local.ChatEntity).
              | Expected:
              |""".trimMargin() + _infoChats + """
              |
              | Found:
              |""".trimMargin() + _existingChats)
        }
        val _columnsGeneratedImages: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsGeneratedImages.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("prompt", TableInfo.Column("prompt", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("revisedPrompt", TableInfo.Column("revisedPrompt", "TEXT", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("localPath", TableInfo.Column("localPath", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("size", TableInfo.Column("size", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("quality", TableInfo.Column("quality", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("style", TableInfo.Column("style", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsGeneratedImages.put("isFavorite", TableInfo.Column("isFavorite", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysGeneratedImages: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesGeneratedImages: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoGeneratedImages: TableInfo = TableInfo("generated_images", _columnsGeneratedImages,
            _foreignKeysGeneratedImages, _indicesGeneratedImages)
        val _existingGeneratedImages: TableInfo = read(connection, "generated_images")
        if (!_infoGeneratedImages.equals(_existingGeneratedImages)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |generated_images(com.hezini.assistant.data.local.GeneratedImage).
              | Expected:
              |""".trimMargin() + _infoGeneratedImages + """
              |
              | Found:
              |""".trimMargin() + _existingGeneratedImages)
        }
        val _columnsAnalyzedDocuments: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsAnalyzedDocuments.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAnalyzedDocuments.put("fileName", TableInfo.Column("fileName", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAnalyzedDocuments.put("fileType", TableInfo.Column("fileType", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAnalyzedDocuments.put("analysisType", TableInfo.Column("analysisType", "TEXT", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAnalyzedDocuments.put("resultText", TableInfo.Column("resultText", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAnalyzedDocuments.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAnalyzedDocuments.put("fileSizeKb", TableInfo.Column("fileSizeKb", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysAnalyzedDocuments: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesAnalyzedDocuments: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoAnalyzedDocuments: TableInfo = TableInfo("analyzed_documents",
            _columnsAnalyzedDocuments, _foreignKeysAnalyzedDocuments, _indicesAnalyzedDocuments)
        val _existingAnalyzedDocuments: TableInfo = read(connection, "analyzed_documents")
        if (!_infoAnalyzedDocuments.equals(_existingAnalyzedDocuments)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |analyzed_documents(com.hezini.assistant.data.local.AnalyzedDocument).
              | Expected:
              |""".trimMargin() + _infoAnalyzedDocuments + """
              |
              | Found:
              |""".trimMargin() + _existingAnalyzedDocuments)
        }
        val _columnsPersonas: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsPersonas.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("tagline", TableInfo.Column("tagline", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("avatarEmoji", TableInfo.Column("avatarEmoji", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("avatarColor", TableInfo.Column("avatarColor", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("avatarImagePath", TableInfo.Column("avatarImagePath", "TEXT", false,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("category", TableInfo.Column("category", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("systemPrompt", TableInfo.Column("systemPrompt", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("creativityLevel", TableInfo.Column("creativityLevel", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("formalityLevel", TableInfo.Column("formalityLevel", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("detailLevel", TableInfo.Column("detailLevel", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("toneLevel", TableInfo.Column("toneLevel", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("ttsVoicePitch", TableInfo.Column("ttsVoicePitch", "REAL", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("ttsVoiceSpeed", TableInfo.Column("ttsVoiceSpeed", "REAL", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("greetingMessage", TableInfo.Column("greetingMessage", "TEXT", false,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("isBuiltIn", TableInfo.Column("isBuiltIn", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("isActive", TableInfo.Column("isActive", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("lastUsedAt", TableInfo.Column("lastUsedAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPersonas.put("totalChats", TableInfo.Column("totalChats", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysPersonas: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesPersonas: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoPersonas: TableInfo = TableInfo("personas", _columnsPersonas, _foreignKeysPersonas,
            _indicesPersonas)
        val _existingPersonas: TableInfo = read(connection, "personas")
        if (!_infoPersonas.equals(_existingPersonas)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |personas(com.hezini.assistant.data.local.Persona).
              | Expected:
              |""".trimMargin() + _infoPersonas + """
              |
              | Found:
              |""".trimMargin() + _existingPersonas)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "chat_sessions",
        "chat_messages", "saved_prompts", "user_notes", "chats", "generated_images",
        "analyzed_documents", "personas")
  }

  public override fun clearAllTables() {
    super.performClear(true, "chat_sessions", "chat_messages", "saved_prompts", "user_notes",
        "chats", "generated_images", "analyzed_documents", "personas")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(ChatSessionDao::class, ChatSessionDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(ChatMessageDao::class, ChatMessageDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(SavedPromptDao::class, SavedPromptDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(GeneratedImageDao::class, GeneratedImageDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(AnalyzedDocumentDao::class,
        AnalyzedDocumentDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(PersonaDao::class, PersonaDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun chatSessionDao(): ChatSessionDao = _chatSessionDao.value

  public override fun chatMessageDao(): ChatMessageDao = _chatMessageDao.value

  public override fun savedPromptDao(): SavedPromptDao = _savedPromptDao.value

  public override fun generatedImageDao(): GeneratedImageDao = _generatedImageDao.value

  public override fun analyzedDocumentDao(): AnalyzedDocumentDao = _analyzedDocumentDao.value

  public override fun personaDao(): PersonaDao = _personaDao.value
}
