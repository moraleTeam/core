package team.morale.core.infrastructure.persistence

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import team.morale.core.domain.user.User
import team.morale.core.domain.user.UserRepository
import java.util.*

@Repository
interface UserRepository : UserRepository, ReactiveCrudRepository<User, UUID>

