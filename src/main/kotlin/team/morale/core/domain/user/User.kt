package team.morale.core.domain.user

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.mongodb.core.mapping.Document
import team.morale.core.domain.event.EventPublisher
import java.util.*

@Document
data class User(@Id private val id: UUID,
                private val email: String,
                @Transient private val eventPublisher: EventPublisher) {
    init {
        eventPublisher.publish(UserSignedUpEvent(id))
    }
}
