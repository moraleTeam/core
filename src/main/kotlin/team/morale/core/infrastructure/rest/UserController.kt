package team.morale.core.infrastructure.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import team.morale.core.domain.event.EventPublisher
import team.morale.core.domain.service.notification.NotificationRequest
import team.morale.core.domain.service.notification.NotificationService
import team.morale.core.domain.user.User
import team.morale.core.infrastructure.persistence.UserRepository
import java.util.*

@RestController("/users")
@RequestMapping("/users")
class UserController(val userRepository: UserRepository,
                     val notificationService: NotificationService,
                     val eventPublisher: EventPublisher) {

    @GetMapping("/{id}")
    fun getUserWithId(@PathVariable id: UUID): Mono<User> {
        return userRepository
                .findById(id)
                .switchIfEmpty(Mono.error(NoSuchElementException()))
    }

    @PostMapping
    fun singUp(@RequestBody request: RegisterUserRequest): Mono<User> {
        val user = userRepository
                .save(User(UUID.randomUUID(), request.email, eventPublisher))
                .switchIfEmpty(Mono.error(NoSuchElementException()))
        notificationService.sendNotification(NotificationRequest(request.email, "success"))
        return user
    }

    class RegisterUserRequest(val email: String)
}
