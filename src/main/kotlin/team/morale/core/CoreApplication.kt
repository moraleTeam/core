package team.morale.core

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.context.annotation.Bean
import team.morale.core.domain.event.EventPublisher
import team.morale.core.domain.user.User
import team.morale.core.infrastructure.persistence.UserRepository
import java.util.*


@SpringBootApplication
@EnableAutoConfiguration(exclude = arrayOf(MongoAutoConfiguration::class, MongoDataAutoConfiguration::class))
class CoreApplication {

    @Bean
    fun initData(userRepository: UserRepository, eventPublisher: EventPublisher) = CommandLineRunner {
        userRepository.deleteAll().block()
        userRepository.save(User(UUID.randomUUID(), "a-team@mail.org", eventPublisher)).block()
        userRepository.save(User(UUID.randomUUID(), "a-team@mail.org", eventPublisher)).block()
        userRepository.save(User(UUID.randomUUID(), "a-team@mail.org", eventPublisher)).block()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(CoreApplication::class.java, *args)
}
