package com.example.tree.workflow.treelist.scene

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.tree.Constants
import com.example.tree.R
import com.example.tree.models.Tree
import com.google.gson.Gson
import java.lang.ref.WeakReference

class TreeListRouter {
    lateinit var weakFragment: WeakReference<TreeListFragment>

    fun routeToTreeDetailsFragment(tree: Tree) {
        val bundle = bundleOf(Pair(Constants.TREE_DETAILS_KEY, Gson().toJson(tree)))
        weakFragment.get()?.findNavController()?.navigate(R.id.actionToTreeDetails, bundle)
    }
}