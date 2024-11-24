package online.jutter.cow.data.models

data class CowRequest(
    val id: String,
    val sex: String,
    val breed: String,
    val birthDate: String,
    val papa: String,
    val mama: String,
    val milkVolume: String,
    val meatVolume: String,
    val inbreeding: String,
    val meatIncrement: String,
    val health: String,
    val fertility: String,
    val geneticValue: String,
)