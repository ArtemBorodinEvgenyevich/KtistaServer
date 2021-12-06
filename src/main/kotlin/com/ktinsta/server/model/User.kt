package com.ktinsta.server.model

import com.ktinsta.server.listeners.UserListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@Entity
@Table(name = "`user`")
@EntityListeners(UserListener::class)
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @get: NotBlank
    var email: String = "",

    @Column(unique = true)
    @get: NotBlank
    var username: String = "",

    @get: NotBlank
    var password: String = "",

    @get: NotBlank
    var firstName: String = "",

    @get: NotBlank
    var lastName: String = "",

    @get: NotBlank
    var followersCounter: Long = 0,

    @get: NotBlank
    var followingsCounter: Long = 0,

    var status: String = "available",

    @DateTimeFormat
    var createdAt: Date = Date.from(Instant.now())
)
{
    @OneToMany(mappedBy = "user_id", targetEntity = Post::class)
    private var posts: Collection<Post>? = null
}
