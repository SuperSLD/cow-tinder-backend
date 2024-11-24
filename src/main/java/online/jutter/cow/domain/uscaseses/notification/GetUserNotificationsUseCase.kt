package online.jutter.cow.domain.uscaseses.notification

import online.jutter.cow.data.db.repositories.NewsRepository
import online.jutter.cow.data.db.repositories.NotificationsRepository
import online.jutter.cow.domain.models.notification.NotificationResponse

class GetUserNotificationsUseCase {

    operator fun invoke(userId: String): List<NotificationResponse> {
        val notifications = NotificationsRepository.getAllUserNotifications(userId) ?: return emptyList()
        return notifications.map { n ->
            NotificationResponse(
                title = n.title,
                text = n.text,
                type = n.type,
                event = if (n.type == "event") NewsRepository.getById(n.eventId!!) else null,
            )
        }
    }
}