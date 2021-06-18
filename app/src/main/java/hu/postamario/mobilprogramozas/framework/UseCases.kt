package hu.postamario.mobilprogramozas.framework

import hu.postamario.core.usecase.AddNote
import hu.postamario.core.usecase.GetAllNotes
import hu.postamario.core.usecase.GetNote
import hu.postamario.core.usecase.RemoveNote

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)