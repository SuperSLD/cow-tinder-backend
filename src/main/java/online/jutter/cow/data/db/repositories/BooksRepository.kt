package online.jutter.cow.data.db.repositories

import online.jutter.cow.data.db.BaseRepository
import online.jutter.cow.data.db.ent.BookEntity
import online.jutter.cow.data.db.ent.UserBookEntity
import online.jutter.cow.data.db.eq
import online.jutter.cow.data.db.getQuery
import online.jutter.cow.data.db.removeAllInstances
import online.jutter.cow.domain.models.books.BookListResponse
import online.jutter.cow.domain.models.books.BookResponse

object BooksRepository : BaseRepository<BookEntity>() {

    fun setAll(books: List<BookEntity>) = executeTransaction {
        removeAllInstances(UserBookEntity::class.java)
        removeAllInstances(BookEntity::class.java)

        for (item in books) {
            persist(item)
        }
    }

    fun getAllUserBooks(userId: String) = executeTransaction {
        val userBooks = getQuery<UserBookEntity>("user" eq userId).map { userBook ->
            val book = getById(userBook.book)!!
            book.bookToResponse(userBook)
        }
        val allBooks = getAll().map { it.bookToResponse() }
        var rec = listOf<BookResponse>()
        var new = listOf<BookResponse>()
        for (i in 0..5) {
            rec += allBooks.random()
            new += allBooks.random()
        }
        BookListResponse(
            myBook = userBooks,
            rec = rec,
            new = allBooks//new,
        )
    }

    private fun BookEntity.bookToResponse(userBook: UserBookEntity? = null) =
        BookResponse(
            id = id,
            title = title,
            description = description,
            rating = rating,
            cover = cover,
            author = author,
            renewal = renewal,
            date = userBook?.returnDate,
            renewcount = userBook?.count
        )
}