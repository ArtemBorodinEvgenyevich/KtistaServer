package com.ktinsta.server.model

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
class Image (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    var post_id: Post? = null,

    @Lob
    var data: ByteArray = byteArrayOf(),

    @DateTimeFormat
    var createdAt: Date = Date.from(Instant.now())

)