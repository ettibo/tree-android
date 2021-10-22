package com.example.tree.workflow.treedetails.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tree.R

class TreeDetailsHolder(private val v: View) : RecyclerView.ViewHolder(v) {
    private val treeLabel: TextView = v.findViewById(R.id.tree_label)

    fun bindView(content: String) {
        treeLabel.text = content
    }
}