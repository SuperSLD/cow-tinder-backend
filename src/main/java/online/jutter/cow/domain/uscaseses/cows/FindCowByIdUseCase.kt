package online.jutter.cow.domain.uscaseses.cows

import online.jutter.cow.data.db.repositories.CowsRepository

class FindCowByIdUseCase {

    operator fun invoke(id: String) = CowsRepository.getById(id)
}