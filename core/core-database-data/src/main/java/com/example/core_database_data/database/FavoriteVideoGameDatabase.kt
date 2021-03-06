package com.example.core_database_data.database

import com.example.core_model.database.favoriteVideoGame.FavoriteVideoGame
import com.example.core_model.database.favoriteVideoGame.FavoriteVideoGameDTO
import com.example.core_model.database.favoriteVideoGame.mapToDTO
import io.realm.Realm
import io.realm.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class FavoriteVideoGameDatabase @Inject constructor(
    private val realm: Realm
) {
    suspend fun write(item:FavoriteVideoGame):Unit = realm.write { copyToRealm(item) }

    fun getAll(): Flow<List<FavoriteVideoGameDTO>> = realm
        .query<FavoriteVideoGame>()
        .asFlow()
        .mapNotNull { it.list.map { item ->  item.mapToDTO() } }

    fun getCount(): Flow<Long> = realm.query<FavoriteVideoGame>().count().asFlow()

    fun getCheckVideoGameById(id:Int):Boolean {
        realm.query<FavoriteVideoGame>("id = $0",id).first().find() ?: return false
        return true
    }

    suspend fun delete(id:Int) {
        realm.write {
            val query = this.query<FavoriteVideoGame>("id = $0",id)
            delete(query)
        }
    }
}