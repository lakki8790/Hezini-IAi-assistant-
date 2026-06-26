package com.hezini.assistant.`data`.local

import androidx.room.EntityDeleteOrUpdateAdapter
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
public class GeneratedImageDao_Impl(
  __db: RoomDatabase,
) : GeneratedImageDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfGeneratedImage: EntityInsertAdapter<GeneratedImage>

  private val __deleteAdapterOfGeneratedImage: EntityDeleteOrUpdateAdapter<GeneratedImage>

  private val __updateAdapterOfGeneratedImage: EntityDeleteOrUpdateAdapter<GeneratedImage>
  init {
    this.__db = __db
    this.__insertAdapterOfGeneratedImage = object : EntityInsertAdapter<GeneratedImage>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `generated_images` (`id`,`prompt`,`revisedPrompt`,`localPath`,`size`,`quality`,`style`,`createdAt`,`isFavorite`) VALUES (?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: GeneratedImage) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.prompt)
        statement.bindText(3, entity.revisedPrompt)
        statement.bindText(4, entity.localPath)
        statement.bindText(5, entity.size)
        statement.bindText(6, entity.quality)
        statement.bindText(7, entity.style)
        statement.bindLong(8, entity.createdAt)
        val _tmp: Int = if (entity.isFavorite) 1 else 0
        statement.bindLong(9, _tmp.toLong())
      }
    }
    this.__deleteAdapterOfGeneratedImage = object : EntityDeleteOrUpdateAdapter<GeneratedImage>() {
      protected override fun createQuery(): String = "DELETE FROM `generated_images` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: GeneratedImage) {
        statement.bindText(1, entity.id)
      }
    }
    this.__updateAdapterOfGeneratedImage = object : EntityDeleteOrUpdateAdapter<GeneratedImage>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `generated_images` SET `id` = ?,`prompt` = ?,`revisedPrompt` = ?,`localPath` = ?,`size` = ?,`quality` = ?,`style` = ?,`createdAt` = ?,`isFavorite` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: GeneratedImage) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.prompt)
        statement.bindText(3, entity.revisedPrompt)
        statement.bindText(4, entity.localPath)
        statement.bindText(5, entity.size)
        statement.bindText(6, entity.quality)
        statement.bindText(7, entity.style)
        statement.bindLong(8, entity.createdAt)
        val _tmp: Int = if (entity.isFavorite) 1 else 0
        statement.bindLong(9, _tmp.toLong())
        statement.bindText(10, entity.id)
      }
    }
  }

  public override suspend fun insertImage(image: GeneratedImage): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfGeneratedImage.insert(_connection, image)
  }

  public override suspend fun deleteImage(image: GeneratedImage): Unit = performSuspending(__db,
      false, true) { _connection ->
    __deleteAdapterOfGeneratedImage.handle(_connection, image)
  }

  public override suspend fun updateImage(image: GeneratedImage): Unit = performSuspending(__db,
      false, true) { _connection ->
    __updateAdapterOfGeneratedImage.handle(_connection, image)
  }

  public override fun getAllImages(): Flow<List<GeneratedImage>> {
    val _sql: String = "SELECT * FROM generated_images ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("generated_images")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfPrompt: Int = getColumnIndexOrThrow(_stmt, "prompt")
        val _cursorIndexOfRevisedPrompt: Int = getColumnIndexOrThrow(_stmt, "revisedPrompt")
        val _cursorIndexOfLocalPath: Int = getColumnIndexOrThrow(_stmt, "localPath")
        val _cursorIndexOfSize: Int = getColumnIndexOrThrow(_stmt, "size")
        val _cursorIndexOfQuality: Int = getColumnIndexOrThrow(_stmt, "quality")
        val _cursorIndexOfStyle: Int = getColumnIndexOrThrow(_stmt, "style")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _result: MutableList<GeneratedImage> = mutableListOf()
        while (_stmt.step()) {
          val _item: GeneratedImage
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpPrompt: String
          _tmpPrompt = _stmt.getText(_cursorIndexOfPrompt)
          val _tmpRevisedPrompt: String
          _tmpRevisedPrompt = _stmt.getText(_cursorIndexOfRevisedPrompt)
          val _tmpLocalPath: String
          _tmpLocalPath = _stmt.getText(_cursorIndexOfLocalPath)
          val _tmpSize: String
          _tmpSize = _stmt.getText(_cursorIndexOfSize)
          val _tmpQuality: String
          _tmpQuality = _stmt.getText(_cursorIndexOfQuality)
          val _tmpStyle: String
          _tmpStyle = _stmt.getText(_cursorIndexOfStyle)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          _item =
              GeneratedImage(_tmpId,_tmpPrompt,_tmpRevisedPrompt,_tmpLocalPath,_tmpSize,_tmpQuality,_tmpStyle,_tmpCreatedAt,_tmpIsFavorite)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getFavoriteImages(): Flow<List<GeneratedImage>> {
    val _sql: String = "SELECT * FROM generated_images WHERE isFavorite = 1 ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("generated_images")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfPrompt: Int = getColumnIndexOrThrow(_stmt, "prompt")
        val _cursorIndexOfRevisedPrompt: Int = getColumnIndexOrThrow(_stmt, "revisedPrompt")
        val _cursorIndexOfLocalPath: Int = getColumnIndexOrThrow(_stmt, "localPath")
        val _cursorIndexOfSize: Int = getColumnIndexOrThrow(_stmt, "size")
        val _cursorIndexOfQuality: Int = getColumnIndexOrThrow(_stmt, "quality")
        val _cursorIndexOfStyle: Int = getColumnIndexOrThrow(_stmt, "style")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _result: MutableList<GeneratedImage> = mutableListOf()
        while (_stmt.step()) {
          val _item: GeneratedImage
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpPrompt: String
          _tmpPrompt = _stmt.getText(_cursorIndexOfPrompt)
          val _tmpRevisedPrompt: String
          _tmpRevisedPrompt = _stmt.getText(_cursorIndexOfRevisedPrompt)
          val _tmpLocalPath: String
          _tmpLocalPath = _stmt.getText(_cursorIndexOfLocalPath)
          val _tmpSize: String
          _tmpSize = _stmt.getText(_cursorIndexOfSize)
          val _tmpQuality: String
          _tmpQuality = _stmt.getText(_cursorIndexOfQuality)
          val _tmpStyle: String
          _tmpStyle = _stmt.getText(_cursorIndexOfStyle)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          _item =
              GeneratedImage(_tmpId,_tmpPrompt,_tmpRevisedPrompt,_tmpLocalPath,_tmpSize,_tmpQuality,_tmpStyle,_tmpCreatedAt,_tmpIsFavorite)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteImageById(id: String) {
    val _sql: String = "DELETE FROM generated_images WHERE id = ?"
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
