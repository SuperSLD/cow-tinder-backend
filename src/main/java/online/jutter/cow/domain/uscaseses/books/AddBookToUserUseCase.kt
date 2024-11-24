package online.jutter.cow.domain.uscaseses.books

import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.common.ext.toDateString
import online.jutter.cow.data.db.and
import online.jutter.cow.data.db.ent.UserBookEntity
import online.jutter.cow.data.db.eq
import online.jutter.cow.data.db.getQuery
import online.jutter.cow.data.db.repositories.BooksRepository
import java.util.*

class AddBookToUserUseCase {

    operator fun invoke(userId: String, bookId: String) {
        BooksRepository.executeTransaction {
            val userBook = getQuery<UserBookEntity>(
                ("book" eq bookId) and ("user" eq userId)
            ).firstOrNull()
            if (userBook != null) throw error("Книга уже у вас")
            val newBook = UserBookEntity().apply {
                id = getUUID()
                user = userId
                book = bookId
                count = 2
                returnDate = Calendar.getInstance().apply { this.add(Calendar.DAY_OF_WEEK, 45) }.toDateString()
            }
            persist(newBook)
        }
    }
}