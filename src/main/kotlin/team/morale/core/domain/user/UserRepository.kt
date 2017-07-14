package team.morale.core.domain.user

import reactor.core.publisher.Mono

interface UserRepository {
    fun save(user: User): Mono<User>
}

