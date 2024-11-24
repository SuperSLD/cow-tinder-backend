package online.jutter.cow.domain.uscaseses.books

import online.jutter.cow.data.db.repositories.BooksRepository

class GetAllBooksUseCase {

    operator fun invoke() = BooksRepository.getAll()
}