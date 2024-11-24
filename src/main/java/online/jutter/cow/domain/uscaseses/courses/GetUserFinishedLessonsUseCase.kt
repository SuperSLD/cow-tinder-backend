package online.jutter.cow.domain.uscaseses.courses

import online.jutter.cow.data.db.repositories.CoursesRepository
import online.jutter.cow.domain.uscaseses.user.AddUserCoinsUseCase

class GetUserFinishedLessonsUseCase {

    private val addUserCoinsUseCase = AddUserCoinsUseCase()

    operator fun invoke(userId: String, finishedItemId: String) {
        addUserCoinsUseCase(userId, 50)
        CoursesRepository.finished(userId, finishedItemId)
    }
}