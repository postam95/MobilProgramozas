package hu.postamario.core.usecase

import hu.postamario.core.data.Note
import hu.postamario.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)

}