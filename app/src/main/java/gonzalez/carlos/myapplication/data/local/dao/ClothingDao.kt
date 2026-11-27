package gonzalez.carlos.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import gonzalez.carlos.myapplication.data.local.entity.ClothingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothingDao {
    @Query("SELECT * FROM clothing_items")
    fun getAllClothing(): Flow<List<ClothingEntity>>

    @Query("SELECT * FROM clothing_items WHERE id = :id LIMIT 1")
    suspend fun getClothingById(id: String): ClothingEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClothing(item: ClothingEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllClothing(items: List<ClothingEntity>)

    @Update
    suspend fun updateClothing(item: ClothingEntity): Int

    @Delete
    suspend fun deleteClothing(item: ClothingEntity): Int
}