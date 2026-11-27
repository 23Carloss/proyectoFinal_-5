package gonzalez.carlos.myapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserEntity(
    @PrimaryKey val id: String = "current_user",
    val name: String,
    val email: String,
    val phone: String,
    val isBiometricsEnabled: Boolean,
    val streakDays: Int
)