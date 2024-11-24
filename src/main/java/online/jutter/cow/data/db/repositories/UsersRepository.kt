package online.jutter.cow.data.db.repositories

import online.jutter.cow.data.db.BaseRepository
import online.jutter.cow.data.db.ent.UserEntity
import online.jutter.cow.data.db.eq
import online.jutter.cow.data.db.getQuery

object UsersRepository : BaseRepository<UserEntity>() {

    fun getByLogin(login: String) = executeTransaction {
        getQuery<UserEntity>("login" eq login).firstOrNull()
    }
}