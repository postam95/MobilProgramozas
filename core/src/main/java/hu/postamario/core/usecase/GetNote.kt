package hu.postamario.core.usecase

import hu.postamario.core.repository.NoteRepository

class GetNote (private val noteRepository: NoteRepository){
    suspend operator fun invoke(id : Long) = noteRepository.getNote(id)
}