package online.jutter.cow.domain.uscaseses.cows

import online.jutter.cow.data.db.ent.CowEntity
import online.jutter.cow.data.db.repositories.CowsRepository

class GetAllCowsUseCase {

    operator fun invoke(): List<CowEntity> {
        val allCows = CowsRepository.getAll()
        val response = mutableListOf<CowEntity>()
        for (i in 0 .. 200) {
            response.add(allCows.random())
        }
        return allCows//response
    }
}