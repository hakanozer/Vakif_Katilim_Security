package com.works.entities

import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Digits
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

@Entity
data class Product (
    @Id @GeneratedValue var pid: Long? = null,

    @field:NotEmpty
    @field:Length(min = 1, max = 100)
    var title: String?,

    @field:Min(1)
    @field:Max(1000000)
    @Column(nullable = false)
    var price: Int
)