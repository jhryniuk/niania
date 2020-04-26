package com.example.niania

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import android.widget.Toast
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
        val cursor: Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

        val from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID)

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val simple = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to, 2)

        contacts.adapter = simple

        contacts.setOnItemClickListener {parent, view, position: Int, id: Long ->

            val text = getString(R.string.chosen_number_is) + " " + view.findViewById<TextView>(android.R.id.text2).text
            val number = view.findViewById<TextView>(android.R.id.text2).text
            val name = view.findViewById<TextView>(android.R.id.text1).text
            Toast.makeText(this@ChoiceContactActivity, text, Toast.LENGTH_LONG).show()

            val intent = Intent(this@ChoiceContactActivity, WorkActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("number", number)
            startActivity(intent)
            finish()
        }
    }
}