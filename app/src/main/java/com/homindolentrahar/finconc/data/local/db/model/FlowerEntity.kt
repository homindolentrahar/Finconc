package com.homindolentrahar.finconc.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FlowerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val name: String,
    val image: String
)
