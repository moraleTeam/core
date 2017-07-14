package team.morale.core.infrastructure.service.notification

import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.stereotype.Service
import team.morale.core.domain.service.notification.NotificationRequest
import team.morale.core.domain.service.notification.NotificationService


@Service
class SpringNotificationService(val mailSender: MailSender,
                                @Value("\${spring.mail.username}") val teamMoraleEmail: String) : NotificationService {


    override fun sendNotification(notificationRequest: NotificationRequest) {
        val message = SimpleMailMessage();
        message.from = teamMoraleEmail
        message.to = arrayOf(notificationRequest.email)
        message.text = notificationRequest.body
        mailSender.send(message)
    }

}