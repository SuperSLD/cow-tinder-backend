package online.jutter.cow.data.db.repositories

import online.jutter.cow.data.db.BaseRepository
import online.jutter.cow.data.db.ent.SectionEntity
import online.jutter.cow.data.db.removeAllInstances

object SectionsRepository : BaseRepository<SectionEntity>() {

    fun setAll(list: List<SectionEntity>) = executeTransaction {
        removeAllInstances(SectionEntity::class.java)
        for (item in list) {
            persist(item)
        }
    }
}