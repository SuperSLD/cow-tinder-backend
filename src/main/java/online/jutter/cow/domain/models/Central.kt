package online.jutter.cow.domain.models

import online.jutter.cow.data.db.ent.NewsEntity

data class Central(
    val coins: Int,
    val listNews: MutableList<NewsEntity>
)
