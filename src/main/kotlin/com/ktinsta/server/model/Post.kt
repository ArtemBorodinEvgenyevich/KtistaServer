package com.ktinsta.server.model

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user_id: User? = null,

    var text: String = "",

    @get: NotBlank
    var likes_counter: Long = 0,

    @get: NotBlank
    var dislikes_counter: Long = 0,

    @get: NotBlank
    var comments_counter: Long = 0,

    @DateTimeFormat
    var createdAt: Date = Date.from(Instant.now())
)
{
    @OneToMany(mappedBy = "post_id", targetEntity = Image::class)
    private var images: Collection<Image>? = null
}
