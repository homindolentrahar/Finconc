package com.homindolentrahar.finconc.data.local.db.dao

import androidx.room.*
import com.homindolentrahar.finconc.data.local.db.model.FlowerEntity

@Dao
interface FlowerDao {
    @Query("SELECT * FROM flowerentity")
    suspend fun getAllFlowers(): List<FlowerEntity>

    @Query("SELECT * FROM flowerentity WHERE id = :id")
    suspend fun getSingleFlower(id: Int): FlowerEntity

    @Insert
    suspend fun insertFlower(flower: FlowerEntity)

    @Update
    suspend fun updateFlower(flower: FlowerEntity)

    @Delete
    suspend fun deleteFlower(flower: FlowerEntity)
}