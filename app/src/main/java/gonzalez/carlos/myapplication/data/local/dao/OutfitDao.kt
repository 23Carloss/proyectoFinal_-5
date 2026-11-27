package gonzalez.carlos.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import gonzalez.carlos.myapplication.data.local.entity.OutfitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OutfitDao {
    @Query("SELECT * FROM outfit_items")
    fun getAllOutfits(): Flow<List<OutfitEntity>>

    @Query("SELECT * FROM outfit_items WHERE id = :id LIMIT 1")
    suspend fun getOutfitById(id: String): OutfitEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOutfit(item: OutfitEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllOutfits(items: List<OutfitEntity>)

    @Update
    suspend fun updateOutfit(item: OutfitEntity): Int

    @Delete
    suspend fun deleteOutfit(item: OutfitEntity): Int
}