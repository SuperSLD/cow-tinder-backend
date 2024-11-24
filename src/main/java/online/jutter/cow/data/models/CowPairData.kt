package online.jutter.cow.data.models

data class CowPairData(
    val cowTag: String,
    val maximisationParam: Int,
    val milk: List<Float>,
    val weight: List<Float>,
    val health: List<Float>,
)
