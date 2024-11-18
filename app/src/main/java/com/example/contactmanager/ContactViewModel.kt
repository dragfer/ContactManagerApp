package com.example.contactmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val contactDao: ContactDao = ContactDatabase.getDatabase(application).contactDao()
    // Get all contacts as LiveData using Flow's asLiveData extension
    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts().asLiveData()

    // Insert contact method
    fun insert(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDao.insert(contact)
        }
    }

    // Delete contact method
    fun delete(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDao.delete(contact)
        }
    }
}
