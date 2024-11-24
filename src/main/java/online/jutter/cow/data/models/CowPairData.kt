package com.example.app_domain.models.cow

data class CowPairData(
    val cowTag: String,
    val maximisationParam: Int,
    val milk: List<Float>,
    val weight: List<Float>,
    val health: List<Float>,
)
