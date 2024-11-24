package online.jutter.cow.domain.uscaseses.cows

import com.example.app_domain.models.cow.CowPairResult
import com.example.app_domain.models.cow.WaitedCowData

class FindCowPairByIdUseCase {

    operator fun invoke(cowTag: String, index: Int): List<CowPairResult> {
        val getAllCowsUseCase = GetAllCowsUseCase()
        val randomCows = getAllCowsUseCase().subList(0, 5)
        return randomCows.map {
            CowPairResult(
                otherCow = it,
                waitedCowData = WaitedCowData(
                    3f, 3f, 3f, 30f,
                )
            )
        }
    }
}