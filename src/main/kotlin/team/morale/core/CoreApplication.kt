package team.morale.core

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.context.annotation.Bean
import team.morale.core.adapter.port.persistence.TeamRepository
import team.morale.core.domain.Team


@SpringBootApplication
@EnableAutoConfiguration(exclude = arrayOf(MongoAutoConfiguration::class, MongoDataAutoConfiguration::class))
class CoreApplication {

    @Bean
    fun initData(teamRepository: TeamRepository) = CommandLineRunner {
        teamRepository.deleteAll().block()
        teamRepository.save(Team("1", "Eric", "a-team@mail.org")).block()
        teamRepository.save(Team("2", "Raymond", "a-team@mail.org")).block()
        teamRepository.save(Team("3", "Paul", "a-team@mail.org")).block()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(CoreApplication::class.java, *args)
}
