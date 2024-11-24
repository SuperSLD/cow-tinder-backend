package online.jutter.cow.domain.uscaseses.news

import online.jutter.cow.data.db.repositories.UsersRepository
import online.jutter.cow.domain.models.Central

class GetCentralUseCase {

    private val getAllNewsUseCase = GetAllNewsUseCase()

    operator fun invoke(id: String): Central {
        val user = UsersRepository.getById(id)!!
        val news = getAllNewsUseCase()
        return Central(
            coins = user.coins,
            listNews = news
        )
    }
}