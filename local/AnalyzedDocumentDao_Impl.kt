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
public class AnalyzedDocumentDao_Impl(
  __db: RoomDatabase,
) : AnalyzedDocumentDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfAnalyzedDocument: EntityInsertAdapter<AnalyzedDocument>

  private val __deleteAdapterOfAnalyzedDocument: EntityDeleteOrUpdateAdapter<AnalyzedDocument>
  init {
    this.__db = __db
    this.__insertAdapterOfAnalyzedDocument = object : EntityInsertAdapter<AnalyzedDocument>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `analyzed_documents` (`id`,`fileName`,`fileType`,`analysisType`,`resultText`,`createdAt`,`fileSizeKb`) VALUES (?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: AnalyzedDocument) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.fileName)
        statement.bindText(3, entity.fileType)
        statement.bindText(4, entity.analysisType)
        statement.bindText(5, entity.resultText)
        statement.bindLong(6, entity.createdAt)
        statement.bindLong(7, entity.fileSizeKb)
      }
    }
    this.__deleteAdapterOfAnalyzedDocument = object :
        EntityDeleteOrUpdateAdapter<AnalyzedDocument>() {
      protected override fun createQuery(): String =
          "DELETE FROM `analyzed_documents` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: AnalyzedDocument) {
        statement.bindText(1, entity.id)
      }
    }
  }

  public override suspend fun insertAnalyzedDocument(document: AnalyzedDocument): Unit =
      performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfAnalyzedDocument.insert(_connection, document)
  }

  public override suspend fun deleteAnalyzedDocument(document: AnalyzedDocument): Unit =
      performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfAnalyzedDocument.handle(_connection, document)
  }

  public override fun getAllAnalyzedDocuments(): Flow<List<AnalyzedDocument>> {
    val _sql: String = "SELECT * FROM analyzed_documents ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("analyzed_documents")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfFileName: Int = getColumnIndexOrThrow(_stmt, "fileName")
        val _cursorIndexOfFileType: Int = getColumnIndexOrThrow(_stmt, "fileType")
        val _cursorIndexOfAnalysisType: Int = getColumnIndexOrThrow(_stmt, "analysisType")
        val _cursorIndexOfResultText: Int = getColumnIndexOrThrow(_stmt, "resultText")
        val _cursorIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _cursorIndexOfFileSizeKb: Int = getColumnIndexOrThrow(_stmt, "fileSizeKb")
        val _result: MutableList<AnalyzedDocument> = mutableListOf()
        while (_stmt.step()) {
          val _item: AnalyzedDocument
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpFileName: String
          _tmpFileName = _stmt.getText(_cursorIndexOfFileName)
          val _tmpFileType: String
          _tmpFileType = _stmt.getText(_cursorIndexOfFileType)
          val _tmpAnalysisType: String
          _tmpAnalysisType = _stmt.getText(_cursorIndexOfAnalysisType)
          val _tmpResultText: String
          _tmpResultText = _stmt.getText(_cursorIndexOfResultText)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_cursorIndexOfCreatedAt)
          val _tmpFileSizeKb: Long
          _tmpFileSizeKb = _stmt.getLong(_cursorIndexOfFileSizeKb)
          _item =
              AnalyzedDocument(_tmpId,_tmpFileName,_tmpFileType,_tmpAnalysisType,_tmpResultText,_tmpCreatedAt,_tmpFileSizeKb)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteById(id: String) {
    val _sql: String = "DELETE FROM analyzed_documents WHERE id = ?"
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
