package hu.postamario.mobilprogramozas.framework

import hu.postamario.core.usecase.*

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount
)