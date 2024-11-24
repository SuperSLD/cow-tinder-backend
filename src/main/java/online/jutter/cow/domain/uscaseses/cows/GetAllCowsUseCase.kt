package online.jutter.cow.domain.uscaseses.cows

import online.jutter.cow.data.db.repositories.CowsRepository

class GetAllCowsUseCase {

    operator fun invoke() = CowsRepository.getAll().subList(0, 200)
}