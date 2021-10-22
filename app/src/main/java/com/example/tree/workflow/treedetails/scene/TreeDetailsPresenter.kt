package com.example.tree.workflow.treedetails.scene

import com.example.tree.extension.guard
import java.lang.ref.WeakReference

class TreeDetailsPresenter {
    lateinit var weakFragment: WeakReference<TreeDetailsFragment>

    fun presentData(list: List<String>) {
        val safeFragment = weakFragment.get().guard { return } as TreeDetailsFragment
        if (safeFragment.isSafeLifeCycle) {
            weakFragment.get()?.displayData(list)
        }
    }
}