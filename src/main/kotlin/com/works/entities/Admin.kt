package com.works.entities

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
data class Admin (

    @Id @GeneratedValue var aid: Long? = null,

    var name: String?,

    @field:NotEmpty var email: String,

    @field:NotEmpty var password: String

)