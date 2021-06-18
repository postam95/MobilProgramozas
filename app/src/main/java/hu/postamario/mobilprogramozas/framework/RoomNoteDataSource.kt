package hu.postamario.mobilprogramozas.framework

import android.content.Context
import hu.postamario.core.data.Note
import hu.postamario.core.repository.NoteDataSource
import hu.postamario.mobilprogramozas.framework.db.DatabaseService
import hu.postamario.mobilprogramozas.framework.db.NoteEntity

class RoomNoteDataSource(context: Context): NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))
    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()
    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }
    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}