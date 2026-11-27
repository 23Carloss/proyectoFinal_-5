package gonzalez.carlos.myapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothing_items")
data class ClothingEntity(
    @PrimaryKey val id: String,
    val title: String,
    val category: String,
    val brand: String,
    val size: String,
    val tags: List<String>,
    val dotColorHex: String,
    val totalUses: Int,
    val avgUsesPerMonth: String,
    val purchaseLink: String? = null
)