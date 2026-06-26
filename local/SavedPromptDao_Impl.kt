package com.hezini.assistant.`data`.local

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
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
public class SavedPromptDao_Impl(
  __db: RoomDatabase,
) : SavedPromptDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfSavedPrompt: EntityInsertAdapter<SavedPrompt>

  private val __deleteAdapterOfSavedPrompt: EntityDeleteOrUpdateAdapter<SavedPrompt>

  private val __updateAdapterOfSavedPrompt: EntityDeleteOrUpdateAdapter<SavedPrompt>
  init {
    this.__db = __db
    this.__insertAdapterOfSavedPrompt = object : EntityInsertAdapter<SavedPrompt>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `saved_prompts` (`id`,`title`,`prompt`,`category`,`createdAt`) VALUES (?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: SavedPrompt) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.prompt)
        statement.bindText(4, entity.category)
        statement.bindLong(5, entity.createdAt)
      }
    }
    this.__deleteAdapterOfSavedPrompt = object : EntityDeleteOrUpdateAdapter<SavedPrompt>() {
      protected override fun createQuery(): String = "DELETE FROM `saved_prompts` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedPrompt) {
        statement.bindText(1, entity.id)
      }
    }
    this.__updateAdapterOfSavedPrompt = object : EntityDeleteOrUpdateAdapter<SavedPrompt>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `saved_prompts` SET `id` = ?,`title` = ?,`prompt` = ?,`category` = ?,`createdAt` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedPrompt) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.prompt)
        statement.bindText(4, entity.category)
        statement.bindLong(5, entity.createdAt)
        statement.bindText(6, entity.id)
      }
    }
  }

  public override suspend fun insertPrompt(prompt: SavedPrompt): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfSavedPrompt.insert(_connection, prompt)
  }

  public override suspend fun deletePrompt(prompt: SavedPrompt): Unit = performSuspending(__db,
      false, true) { _connection ->
    __deleteAdapterOfSavedPrompt.handle(_connection, prompt)
  }

  public override suspend fun updatePrompt(prompt: SavedPrompt): Unit = performSuspending(__db,
      false, true) { _connection ->
    __updateAdapterOfSavedPrompt.handle(_connection, prompt)
  }

  public override fun getAllPromptsFlow(): Flow<List<SavedPrompt>> {
    val _sql: String = "SELECT * FROM saved_prompts ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("saved_prompts")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfPrompt: Int = getColumnIndexOrThrow(_stmt, "prompt")
        val _cursorIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _result: MutableList<SavedPrompt> = mutableListOf()
        while (_stmt.step()) {
          val _item: SavedPrompt
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpPrompt: String
          _tmpPrompt = _stmt.getText(_cursorIndexOfPrompt)
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_cursorIndexOfCategory)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          _item = SavedPrompt(_tmpId,_tmpTitle,_tmpPrompt,_tmpCategory,_tmpCreatedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getPromptsByCategory(category: String): Flow<List<SavedPrompt>> {
    val _sql: String = "SELECT * FROM saved_prompts WHERE category = ? ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("saved_prompts")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, category)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfPrompt: Int = getColumnIndexOrThrow(_stmt, "prompt")
        val _cursorIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _result: MutableList<SavedPrompt> = mutableListOf()
        while (_stmt.step()) {
          val _item: SavedPrompt
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpPrompt: String
          _tmpPrompt = _stmt.getText(_cursorIndexOfPrompt)
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_cursorIndexOfCategory)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          _item = SavedPrompt(_tmpId,_tmpTitle,_tmpPrompt,_tmpCategory,_tmpCreatedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
