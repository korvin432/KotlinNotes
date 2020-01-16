package com.mindyapps.android.kotlinnotes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_new_note_activity.*

class NewNoteActivity : AppCompatActivity() {

    private lateinit var editTitle: EditText
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note_activity)

        editTitle = edit_title
        editText = edit_text

        val button = button_save
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editTitle.text) && TextUtils.isEmpty(editText.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val title = editTitle.text.toString()
                val text = editText.text.toString()
                replyIntent.putExtra(EXTRA_TITLE, title)
                replyIntent.putExtra(EXTRA_TEXT, text)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }

    companion object {
        const val EXTRA_TITLE = "com.mindyapps.android.kotlinnotes.TITLE"
        const val EXTRA_TEXT = "com.mindyapps.android.kotlinnotes.TEXT"
    }
}
