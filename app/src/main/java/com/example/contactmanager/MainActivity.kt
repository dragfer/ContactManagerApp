package com.example.contactmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var addButton: Button
    private lateinit var viewButton: Button
    private lateinit var contactsRecyclerView: RecyclerView
    private lateinit var contactsAdapter: ContactsAdapter

    private val contactViewModel: ContactViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        addButton = findViewById(R.id.addButton)
        viewButton = findViewById(R.id.viewButton)
        contactsRecyclerView = findViewById(R.id.contactsRecyclerView)

        // Set up RecyclerView with Adapter
        contactsAdapter = ContactsAdapter(mutableListOf())
        contactsRecyclerView.layoutManager = LinearLayoutManager(this)
        contactsRecyclerView.adapter = contactsAdapter

        // Observe LiveData from the ViewModel to update the UI
        contactViewModel.allContacts.observe(this, Observer { contacts ->
            // Update the RecyclerView with the new list of contacts
            contactsAdapter.updateData(contacts)
        })

        // Add contact button listener
        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phoneNumber = phoneEditText.text.toString()

            if (name.isNotEmpty() && phoneNumber.isNotEmpty()) {
                // Create a contact and insert it into the database
                val contact = Contact(name = name, phoneNumber = phoneNumber)
                contactViewModel.insert(contact)

                nameEditText.text.clear()
                phoneEditText.text.clear()
                Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }

        // View contacts button listener (you can remove this if not necessary)
        viewButton.setOnClickListener {
            // This is no longer needed as the RecyclerView will auto-update when the LiveData changes
            // contactsAdapter.notifyDataSetChanged() // Refresh the RecyclerView
        }
    }
}
