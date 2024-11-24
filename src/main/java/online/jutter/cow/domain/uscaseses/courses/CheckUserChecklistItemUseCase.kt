package online.jutter.cow.domain.uscaseses.courses

import online.jutter.cow.data.db.repositories.CoursesRepository
import online.jutter.cow.domain.uscaseses.user.AddUserCoinsUseCase

class CheckUserChecklistItemUseCase {

    private val addUserCoinsUseCase = AddUserCoinsUseCase()

    operator fun invoke(userId: String, checkItemId: String) {
        addUserCoinsUseCase(userId, 25)
        CoursesRepository.check(userId, checkItemId)
    }
}