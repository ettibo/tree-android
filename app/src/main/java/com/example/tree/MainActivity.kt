package com.example.tree

import com.example.tree.base.BaseActivity
import com.example.tree.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(
    { ActivityMainBinding.inflate(it) },
    R.id.nav_host_container
)