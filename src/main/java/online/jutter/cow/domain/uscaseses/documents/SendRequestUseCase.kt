package online.jutter.cow.domain.uscaseses.documents

import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.DocumentEntity
import online.jutter.cow.data.db.repositories.DocumentsRepository
import online.jutter.cow.domain.models.documents.SendRequest

class SendRequestUseCase {

    operator fun invoke(sendRequest: SendRequest, userId: String) {
        DocumentsRepository.createDocument(
            DocumentEntity().apply {
                id = getUUID()
                user = userId
                title = "Документы по отправленной заявке \"${sendRequest.title}\""
                deadline = "30.04.2023"
            }
        )
    }
}