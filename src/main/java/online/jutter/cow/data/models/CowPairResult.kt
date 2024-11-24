package com.example.app_domain.models.cow

import online.jutter.cow.data.db.ent.CowEntity

data class CowPairResult(
    val otherCow: CowEntity,
    val waitedCowData: WaitedCowData,
)

data class WaitedCowData(
    val milk: Float,
    val weight: Float,
    val health: Float,
    val fertility: Float,
)
