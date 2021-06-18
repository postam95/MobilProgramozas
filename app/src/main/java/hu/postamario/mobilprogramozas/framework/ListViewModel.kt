package hu.postamario.mobilprogramozas.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import hu.postamario.core.data.Note
import hu.postamario.core.repository.NoteRepository
import hu.postamario.core.usecase.AddNote
import hu.postamario.core.usecase.GetAllNotes
import hu.postamario.core.usecase.GetNote
import hu.postamario.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel (application: Application): AndroidViewModel(application)    {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val saved = MutableLiveData<Boolean>()

    val notes = MutableLiveData<List<Note>>()

    fun getNotes()   {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }
}