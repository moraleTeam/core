package team.morale.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Team(@Id val id: String, val name: String, val email: String)
