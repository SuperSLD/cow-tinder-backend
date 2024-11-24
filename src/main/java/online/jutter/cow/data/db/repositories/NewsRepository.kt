package online.jutter.cow.data.db.repositories

import online.jutter.cow.data.db.BaseRepository
import online.jutter.cow.data.db.removeAllInstances
import online.jutter.cow.data.db.ent.NewsEntity
import online.jutter.cow.data.db.ent.NotificationEntity


object NewsRepository : BaseRepository<NewsEntity>() {

    fun setAllNews(news: List<NewsEntity>) = executeTransaction {
        removeAllInstances(NotificationEntity::class.java)
        removeAllInstances(NewsEntity::class.java)

        for (item in news) {
            persist(item)
        }
    }

}