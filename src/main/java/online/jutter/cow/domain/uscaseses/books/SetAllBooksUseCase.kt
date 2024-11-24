package online.jutter.cow.domain.uscaseses.books

import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.BookEntity
import online.jutter.cow.data.db.repositories.BooksRepository
import online.jutter.cow.domain.models.books.Book

class SetAllBooksUseCase {

    operator fun invoke(books: List<Book>) {
        BooksRepository.setAll(
            books.map { book ->
                BookEntity().apply {
                    id = getUUID()
                    title = book.title
                    description = book.description
                    rating = book.rating
                    cover = book.cover
                    author = book.author
                }
            }
        )
    }
}