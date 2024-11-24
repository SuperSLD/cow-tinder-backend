package online.jutter.cow.domain.uscaseses.cows

import online.jutter.cow.data.db.ent.CowEntity
import online.jutter.cow.data.db.repositories.CowsRepository
import online.jutter.cow.data.db.repositories.CowsRepository.getById
import online.jutter.cow.data.models.AddCowRequest

class AddCowUseCase {

    operator fun invoke(
        addCowRequest: AddCowRequest,
    ) = CowsRepository.executeTransaction {

        var cowEnt = getById(addCowRequest.id)
        if (cowEnt == null) cowEnt = CowEntity()

        cowEnt.id = addCowRequest.id
        cowEnt.mama = addCowRequest.mama
        cowEnt.papa = addCowRequest.papa
        cowEnt.health = addCowRequest.health
        cowEnt.sex = addCowRequest.sex
        cowEnt.breed = addCowRequest.breed
        cowEnt.birthDate = addCowRequest.birthDate
        cowEnt.meatVolume = addCowRequest.meatVolume
        cowEnt.geneticValue = addCowRequest.geneticValue
        cowEnt.fertility = addCowRequest.fertility
        cowEnt.meatIncrement = addCowRequest.meatIncrement
        cowEnt.inbreeding = addCowRequest.inbreeding
        cowEnt.milkVolume = addCowRequest.milkVolume

        persist(cowEnt)
    }
}