package hu.postamario.core.usecase

import hu.postamario.core.data.Note

class GetWordCount {
    operator fun invoke(note: Note) = getCount(note.content)

    private fun getCount(str: String) =
        str.split(" ", "\n")
            .count()
}