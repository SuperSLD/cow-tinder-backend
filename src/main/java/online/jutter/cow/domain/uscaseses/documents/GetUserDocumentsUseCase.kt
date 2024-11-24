package online.jutter.cow.domain.uscaseses.documents

import online.jutter.cow.data.db.repositories.DocumentsRepository

class GetUserDocumentsUseCase {

    operator fun invoke(userId: String) = DocumentsRepository.getUserDocuments(userId)
}