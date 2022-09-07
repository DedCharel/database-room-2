package ua.cn.stu.room.model.boxes.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ua.cn.stu.room.model.boxes.room.entities.AccountBoxSettingDbEntity
import ua.cn.stu.room.model.boxes.room.entities.BoxAndSettingsTuple
import ua.cn.stu.room.model.boxes.room.entities.BoxDbEntity
import ua.cn.stu.room.model.boxes.room.views.SettingDbView
import ua.cn.stu.room.model.boxes.room.views.SettingsWithEntitiesTuple

@Dao
interface BoxesDao {

    @Transaction
    @Query("SELECT * FROM settings_view WHERE account_id =:accountId")
    fun getBoxesAndSettings(accountId: Long): Flow<List<SettingsWithEntitiesTuple>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setActiveFlagForBox(accountBoxSetting: AccountBoxSettingDbEntity)

}
