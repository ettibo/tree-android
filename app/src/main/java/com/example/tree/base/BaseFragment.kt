package com.example.tree.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.tree.safeLifecycle
import com.example.tree.viewLifecycle

abstract class BaseFragment<B : ViewBinding>(val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B) :
    Fragment() {
    var binding: B by viewLifecycle()
    var isSafeLifeCycle: Boolean by safeLifecycle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingFactory(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isSafeLifeCycle = true
        initView(view)
    }

    abstract fun initView(view: View)

    protected abstract fun setup()
}