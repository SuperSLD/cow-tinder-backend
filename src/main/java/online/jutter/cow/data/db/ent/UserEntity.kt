package online.jutter.cow.data.db.ent

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class UserEntity {
    @Id
    var login: String = ""
    var pin: String = ""
    @Column(name = "user_name")
    var name: String = ""
}