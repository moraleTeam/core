package team.morale.core.infrastructure.event

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import team.morale.core.domain.event.Event
import team.morale.core.domain.event.EventPublisher

@Service
class InMemoryEventPublisher : EventPublisher {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    private var events: List<Event> = ArrayList()

    override fun publish(event: Event) {
        this.events = this.events.plus(event)
        this.logger.info("Publishing $event")
    }
}