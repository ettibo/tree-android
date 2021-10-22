package com.example.tree.workflow.treelist.scene

import com.example.tree.extension.guard
import com.example.tree.models.Tree
import java.lang.ref.WeakReference

class TreeListPresenter {
    lateinit var weakFragment: WeakReference<TreeListFragment>

    fun presentLoader() {
        val safeFragment = weakFragment.get().guard { return } as TreeListFragment
        if (safeFragment.isSafeLifeCycle) {
            weakFragment.get()?.displayLoader()
        }
    }

    fun dismissLoader() {
        val safeFragment = weakFragment.get().guard { return } as TreeListFragment
        if (safeFragment.isSafeLifeCycle) {
            weakFragment.get()?.hideLoader()
        }
    }

    fun presentTreeList(list: List<Tree>) {
        val safeFragment = weakFragment.get().guard { return } as TreeListFragment
        if (safeFragment.isSafeLifeCycle) {
            weakFragment.get()?.displayTreeList(list)
        }
    }

    fun presentTreeDetailsFragment(tree: Tree) {
        val safeFragment = weakFragment.get().guard { return } as TreeListFragment
        if (safeFragment.isSafeLifeCycle) {
            weakFragment.get()?.router?.routeToTreeDetailsFragment(tree)
        }
    }
}