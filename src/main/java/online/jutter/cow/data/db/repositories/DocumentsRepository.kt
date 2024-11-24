package online.jutter.cow.data.db.repositories

import online.jutter.cow.data.db.BaseRepository
import online.jutter.cow.data.db.ent.DocumentEntity
import online.jutter.cow.data.db.ent.RequestEntity
import online.jutter.cow.data.db.ent.RequestPageEntity
import online.jutter.cow.data.db.ent.RequestPageLineEntity
import online.jutter.cow.data.db.eq
import online.jutter.cow.data.db.getQuery
import online.jutter.cow.data.db.removeAllInstances

object DocumentsRepository : BaseRepository<RequestEntity>() {

    fun createDocument(document: DocumentEntity) = executeTransaction {
        persist(document)
    }

    fun getUserDocuments(userId: String) = executeTransaction {
        getQuery<DocumentEntity>("user" eq userId)
    }

    fun setAllRequests(requests: List<RequestEntity>) = executeTransaction {
        removeAllInstances(RequestEntity::class.java)
        removeAllInstances(RequestPageEntity::class.java)
        removeAllInstances(RequestPageLineEntity::class.java)

        for (item in requests) {
            persist(item)
        }
    }
}