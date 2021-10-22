package com.example.tree.workflow.treedetails.scene

import android.os.Bundle
import com.example.tree.Constants
import com.example.tree.extension.guard
import com.example.tree.models.Tree
import com.google.gson.Gson

class TreeDetailsInteractor {
    val presenter = TreeDetailsPresenter()
    private val worker = TreeDetailsWorker()
    private var tree: Tree? = null

    fun extractArgs(bundle: Bundle?) {
        bundle?.getString(Constants.TREE_DETAILS_KEY)?.let {
            tree = Gson().fromJson(it, Tree::class.java)
        }
    }

    fun processData() {
        val safeTree = tree.guard { return } as Tree
        worker.fetchData(safeTree) { list ->
            presenter.presentData(list)
        }
    }
}