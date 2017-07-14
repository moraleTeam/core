package team.morale.core.domain.user

import team.morale.core.domain.event.Event
import java.util.*

data class UserSignedUpEvent(val id: UUID) : Event()

