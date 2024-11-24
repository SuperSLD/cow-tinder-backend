package online.jutter.cow.domain.uscaseses.notification

import online.jutter.cow.data.db.repositories.NotificationsRepository
import online.jutter.cow.domain.models.notification.Notification

class SendNotificationUseCase {

    operator fun invoke(
        userId: String,
        title: String,
        text: String,
    ) {
        NotificationsRepository.addNotification(
            Notification(
                title = title,
                text = text,
                user = userId,
                type = "default",
            )
        )
    }

    operator fun invoke(
        userId: String,
        title: String,
        text: String,
        eventId: String,
    ) {
        NotificationsRepository.addNotification(
            Notification(
                title = title,
                text = text,
                user = userId,
                type = "event",
                event = eventId,
            )
        )
    }
}