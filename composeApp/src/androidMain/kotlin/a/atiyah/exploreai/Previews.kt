package a.atiyah.exploreai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import a.atiyah.exploreai.book.domain.Place
import a.atiyah.exploreai.book.presentation.book_list.BookListScreen
import a.atiyah.exploreai.book.presentation.book_list.BookListState
import a.atiyah.exploreai.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
private fun BookSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

private val books = (1..100).map {
    Place(
        id = it.toString(),
        name = "Test$it",
        iconUrl = "",
        categories = listOf(""),
        location = ""
    )
}

@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(
            searchResults = books
        ),
        onAction = {},
        onAiRequested = {}
    )
}