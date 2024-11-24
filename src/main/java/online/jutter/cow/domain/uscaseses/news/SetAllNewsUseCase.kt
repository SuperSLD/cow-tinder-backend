package online.jutter.cow.domain.uscaseses.news

import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.NewsEntity
import online.jutter.cow.data.db.repositories.NewsRepository
import online.jutter.cow.domain.models.News

class SetAllNewsUseCase {

    operator fun invoke(news: List<News>) {
        NewsRepository.setAllNews(news.map { mapToEnt(it) })
    }

    fun mapToEnt(news: News) =
       NewsEntity().apply {
           this.id = getUUID()
           this.title = news.title
           this.description = news.description
           this.image = news.image
           this.type = news.type
           this.date = news.date
       }
}