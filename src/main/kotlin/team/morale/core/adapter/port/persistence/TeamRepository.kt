package team.morale.core.adapter.port.persistence

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import team.morale.core.domain.Team

@Repository
interface TeamRepository : ReactiveCrudRepository<Team, String>

