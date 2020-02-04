package com.mindyapps.android.kotlinnotes.ui.new_note

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mindyapps.android.kotlinnotes.R
import com.mindyapps.android.kotlinnotes.data.Note
import com.mindyapps.android.kotlinnotes.ui.main.NoteViewModel


class NewNoteFragment : Fragment() {

    private lateinit var editTitle: EditText
    private lateinit var editText: EditText
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_new_note, container, false)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        editTitle = rootView.findViewById(R.id.edit_title)
        editText = rootView.findViewById(R.id.edit_text)

        val button = rootView.findViewById<Button>(R.id.button_save)

        button.setOnClickListener {
            Log.d("qwwe", "clicked")
            if (TextUtils.isEmpty(editTitle.text) && TextUtils.isEmpty(editText.text)) {
                Toast.makeText(context, "Not saved", Toast.LENGTH_LONG).show()
            } else {
                val title = editTitle.text.toString()
                val text = editText.text.toString()

                val note = Note(title, text)
                noteViewModel.insert(note)
            }
            activity!!.onBackPressed()
        }

        return rootView
    }


}