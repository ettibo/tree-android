package com.example.tree.workflow.treelist.scene

import com.example.tree.models.Tree

class TreeListInteractor {
    val presenter = TreeListPresenter()
    private val worker = TreeListWorker()

    fun fetchTrees(start: Int, rows: Int) {
        presenter.presentLoader()
        worker.fetchTrees(start, rows) { list ->
            presenter.dismissLoader()
            list?.let { presenter.presentTreeList(it) }
        }
    }

    fun onTreeSelected(tree: Tree) {
        presenter.presentTreeDetailsFragment(tree)
    }
}