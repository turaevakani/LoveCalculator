package com.geektech.lovecalculator.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.lovecalculator.remote.LoveModel

@Dao
interface LoveDao {

    @Query("SELECT * FROM love_model")
    fun getAll(): List<LoveModel>

    @Insert
    fun insert(LoveModel: LoveModel)

    @Query("SELECT * FROM love_model ORDER BY firstName")
    fun sortByFirstName(): List<LoveModel>
}