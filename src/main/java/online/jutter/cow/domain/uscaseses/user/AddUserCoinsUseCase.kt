package online.jutter.cow.domain.uscaseses.user

import online.jutter.cow.data.db.repositories.UsersRepository

class AddUserCoinsUseCase {

    operator fun invoke(id: String, coins: Int) {
        val user = UsersRepository.getById(id)!!
        user.coins += coins
        UsersRepository.update(user)
    }
}