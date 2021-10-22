package com.example.tree.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> B,
    private val navControllerId: Int
) : AppCompatActivity() {
    private var _binding: B? = null
    private val binding
        get() = _binding ?: error("Called before onCreateView or after onDestroyView")

    fun getNavController(): NavController = findNavController(navControllerId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
}