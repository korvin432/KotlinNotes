package com.mindyapps.android.kotlinnotes.ui.main

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mindyapps.android.kotlinnotes.NotesAdapter

import com.mindyapps.android.kotlinnotes.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_notes.*


class NotesFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_notes, container, false)
        val context: Context = this.context ?: return rootView

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = NotesAdapter(
            context,
            onClickListener = { _, note ->
                val bundle = bundleOf("note" to note)
                navController.navigate(R.id.action_notesFragment_to_newNoteFragment, bundle)
            }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.allNotes.observe(viewLifecycleOwner, Observer { notes ->
            notes?.let { adapter.setNotes(it) }
        })


        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        Log.d("qwwe", navController.currentDestination!!.label.toString())

        fab.setOnClickListener {
            navController.navigate(R.id.action_notesFragment_to_newNoteFragment, null)
        }
    }

}
