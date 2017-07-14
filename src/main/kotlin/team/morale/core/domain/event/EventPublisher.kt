package team.morale.core.domain.event

interface EventPublisher {

    fun publish(event: Event)
}