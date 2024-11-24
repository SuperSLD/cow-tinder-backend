package online.jutter.cow.domain.uscaseses.documents

import online.jutter.cow.data.db.repositories.DocumentsRepository

class GetAllRequestsUseCase {

    operator fun invoke() = DocumentsRepository.getAll()
}