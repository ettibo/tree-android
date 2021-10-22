package com.example.tree.workflow.treelist.scene

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tree.base.BaseFragment
import com.example.tree.databinding.FragmentTreeListBinding
import com.example.tree.models.Tree
import com.example.tree.workflow.treelist.view.TreeListAdapter
import com.example.tree.workflow.treelist.view.TreeListHolder
import java.lang.ref.WeakReference

class TreeListFragment : BaseFragment<FragmentTreeListBinding>({ inflater, container, attach ->
    FragmentTreeListBinding.inflate(
        inflater,
        container,
        attach
    )
}), TreeListHolder.TreeListHolderListener {
    private val interactor = TreeListInteractor()
    var router = TreeListRouter()

    override fun initView(view: View) {
        setup()
        initRecyclerView()
        interactor.fetchTrees(0, 25)
    }

    override fun setup() {
        val weakReference = WeakReference(this)
        interactor.presenter.weakFragment = weakReference
        router.weakFragment = weakReference
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    fun displayLoader() {
        binding.progressBarCyclic.visibility = View.VISIBLE
    }

    fun hideLoader() {
        binding.progressBarCyclic.visibility = View.INVISIBLE
    }

    fun displayTreeList(list: List<Tree>) {
        binding.recyclerView.adapter = TreeListAdapter(list, this)
    }

    override fun onItemClick(tree: Tree) {
        interactor.onTreeSelected(tree)
    }
}