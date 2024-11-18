package com.example.contactmanager

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val phoneNumber: String
)