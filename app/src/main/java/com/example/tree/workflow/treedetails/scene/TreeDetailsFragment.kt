package com.example.tree.workflow.treedetails.scene

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tree.base.BaseFragment
import com.example.tree.databinding.FragmentTreeDetailsBinding
import com.example.tree.workflow.treedetails.view.TreeDetailsAdapter
import java.lang.ref.WeakReference

class TreeDetailsFragment :
    BaseFragment<FragmentTreeDetailsBinding>({ inflater, container, attach ->
        FragmentTreeDetailsBinding.inflate(
            inflater,
            container,
            attach
        )
    }) {

    private val interactor = TreeDetailsInteractor()

    override fun initView(view: View) {
        setup()
        initRecyclerView()
        interactor.extractArgs(arguments)
        interactor.processData()
    }

    override fun setup() {
        val weakReference = WeakReference(this)
        interactor.presenter.weakFragment = weakReference
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    fun displayData(list: List<String>) {
        binding.recyclerView.adapter = TreeDetailsAdapter(list)
    }
}