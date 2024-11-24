package online.jutter.cow.domain.models.notification

import online.jutter.cow.data.db.ent.NewsEntity

data class NotificationResponse(
    val title: String,
    val text: String,
    val type: String,
    val event: NewsEntity? = null,
)
