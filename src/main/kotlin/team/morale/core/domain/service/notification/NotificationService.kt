package team.morale.core.domain.service.notification

interface NotificationService {

    fun sendNotification(notificationRequest: NotificationRequest)

}