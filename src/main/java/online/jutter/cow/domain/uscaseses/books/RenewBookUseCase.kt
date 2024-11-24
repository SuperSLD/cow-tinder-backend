package online.jutter.cow.domain.uscaseses.books

import online.jutter.cow.common.ext.toCalendar
import online.jutter.cow.common.ext.toDateString
import online.jutter.cow.data.db.and
import online.jutter.cow.data.db.ent.UserBookEntity
import online.jutter.cow.data.db.eq
import online.jutter.cow.data.db.getQuery
import online.jutter.cow.data.db.repositories.BooksRepository
import java.util.Calendar

class RenewBookUseCase {

    operator fun invoke(userId: String, bookId: String) {
        BooksRepository.executeTransaction {
            val userBook = getQuery<UserBookEntity>(
                ("book" eq bookId) and ("user" eq userId)
            ).firstOrNull() ?: throw error("Эта книга не у вас")
            if (userBook.count == 0) throw error("Продлить больше нельзя")
            val cal = userBook.returnDate.toCalendar()
            cal.add(Calendar.DAY_OF_WEEK, 10)
            userBook.returnDate = cal.toDateString()
            userBook.count = userBook.count - 1
            update(userBook)
        }
    }
}