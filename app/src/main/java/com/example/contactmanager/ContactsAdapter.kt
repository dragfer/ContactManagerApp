package com.example.contactmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactmanager.Contact // Ensure correct import

class ContactsAdapter(private var contactList: MutableList<Contact>) : // Mutable list
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.nameTextView.text = contact.name
        holder.phoneTextView.text = contact.phoneNumber
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    // Update the data and notify the adapter
    fun updateData(newContactList: List<Contact>) {
        contactList.clear() // Clear the old list
        contactList.addAll(newContactList) // Add all the new contacts
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.contactNameTextView)
        val phoneTextView: TextView = itemView.findViewById(R.id.contactPhoneTextView)
    }
}
