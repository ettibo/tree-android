package com.example.tree.workflow.treelist.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tree.R
import com.example.tree.extension.inflate
import com.example.tree.models.Tree

class TreeListAdapter(
    private val list: List<Tree>,
    private val listener: TreeListHolder.TreeListHolderListener
) : RecyclerView.Adapter<TreeListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreeListHolder {
        val inflatedView = parent.inflate(R.layout.tree_list_item_row, false)
        return TreeListHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: TreeListHolder, position: Int) =
        holder.bindView(list[position], listener)

    override fun getItemCount(): Int = list.size
}