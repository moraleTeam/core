package team.morale.core.adapter.port.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import team.morale.core.adapter.port.persistence.TeamRepository
import team.morale.core.domain.Team

@RestController
@RequestMapping("/team")
class TeamController(val teamRepository: TeamRepository) {

    @GetMapping("/{teamId}")
    fun getTeamWithId(@PathVariable teamId: String): Mono<Team> {
        return teamRepository.findById(teamId)
                .switchIfEmpty(Mono.error(NoSuchElementException()))
    }
}
