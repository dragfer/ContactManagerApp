package com.example.contactmanager

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert
    suspend fun insert(contact: Contact)

    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    fun getAllContacts(): Flow<List<Contact>>

    @Delete
    suspend fun delete(contact: Contact)
}
