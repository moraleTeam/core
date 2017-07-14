package team.morale.core.infrastructure.persistence

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableReactiveMongoRepositories
class MongoConfiguration : AbstractReactiveMongoConfiguration() {

    @Value("\${mongo.database.url}")
    lateinit private var database: String

    override fun getDatabaseName() = "reactive"

    @Bean
    fun mongoEventListener(): LoggingEventListener {
        return LoggingEventListener()
    }

    @Bean
    override fun mongoClient(): MongoClient {
        return MongoClients.create(database)
    }
}
