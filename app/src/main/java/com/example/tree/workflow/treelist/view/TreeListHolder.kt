package com.example.tree.workflow.treelist.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tree.R
import com.example.tree.models.Tree

class TreeListHolder(private val v: View) : RecyclerView.ViewHolder(v) {

    interface TreeListHolderListener {
        fun onItemClick(tree: Tree)
    }

    private val treeLabel: TextView = v.findViewById(R.id.tree_label)

    fun bindView(tree: Tree, listener: TreeListHolderListener) {
        treeLabel.text = tree.name
        v.setOnClickListener {
            listener.onItemClick(tree)
        }
    }
}