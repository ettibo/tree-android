package com.example.tree.workflow.treedetails.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tree.R
import com.example.tree.extension.inflate

class TreeDetailsAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<TreeDetailsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreeDetailsHolder {
        val inflatedView = parent.inflate(R.layout.tree_list_item_row, false)
        return TreeDetailsHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: TreeDetailsHolder, position: Int) =
        holder.bindView(list[position])

    override fun getItemCount(): Int = list.size
}