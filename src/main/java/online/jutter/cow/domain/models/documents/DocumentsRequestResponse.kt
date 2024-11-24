package online.jutter.cow.domain.models.documents

import online.jutter.cow.data.db.ent.DocumentEntity
import online.jutter.cow.data.db.ent.RequestEntity

data class DocumentsRequestResponse(
    val documents: List<DocumentEntity>,
    val requests: List<RequestEntity>,
)