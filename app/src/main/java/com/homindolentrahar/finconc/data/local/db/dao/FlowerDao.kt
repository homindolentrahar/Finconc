package com.homindolentrahar.finconc.data.local.db.dao

import androidx.room.*
import com.homindolentrahar.finconc.data.local.db.model.FlowerEntity

@Dao
interface FlowerDao {
    @Query("SELECT * FROM flowerentity")
    fun getAllFlowers(): List<FlowerEntity>

    @Query("SELECT * FROM flowerentity WHERE id = :id")
    fun getSingleFlower(id: Int): FlowerEntity

    @Insert
    fun insertFlower(flower: FlowerEntity)

    @Update
    fun updateFlower(flower: FlowerEntity)

    @Delete
    fun deleteFlower(flower: FlowerEntity)
}