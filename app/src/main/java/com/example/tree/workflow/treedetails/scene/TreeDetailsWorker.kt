package com.example.tree.workflow.treedetails.scene

import com.example.tree.models.Tree

class TreeDetailsWorker {
    fun fetchData(tree: Tree, callback: (List<String>) -> Unit) {
        val list = mutableListOf<String>()
        tree.name?.let { list.add(it) }
        tree.address?.let { list.add(it) }
        tree.type?.let { list.add(it) }
        tree.height?.let { list.add(TreeDetailsModels.HeightViewModel(it).formatData()) }
        tree.radius?.let { list.add(TreeDetailsModels.RadiusViewModel(it).formatData()) }
        callback(list)
    }
}