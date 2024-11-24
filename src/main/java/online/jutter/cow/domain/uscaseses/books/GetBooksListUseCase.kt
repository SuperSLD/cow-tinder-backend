package online.jutter.cow.domain.uscaseses.books

import online.jutter.cow.data.db.repositories.BooksRepository

class GetBooksListUseCase {

    operator fun invoke(userId: String) = BooksRepository.getAllUserBooks(userId)
}