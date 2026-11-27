package gonzalez.carlos.myapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "outfit_items")
data class OutfitEntity(
    @PrimaryKey val id: String,
    val title: String,
    val category: String,
    val itemsCountText: String,
    val tags: List<String>,
    val dotColorHex: String,
    val isFavorite: Boolean,
    val isMine: Boolean,
    val author: String,
    val purchaseLink: String? = null
)