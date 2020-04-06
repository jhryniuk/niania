package com.example.niania

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choice_contact.*

class ChoiceContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_contact)
        read()
    }

    fun read()
    {
        val cursor: Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)

        val from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID)

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val simple = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to, 2)

        contacts.adapter = simple
    }
}