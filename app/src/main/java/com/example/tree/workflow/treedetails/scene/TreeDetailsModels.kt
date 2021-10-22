package com.example.tree.workflow.treedetails.scene

class TreeDetailsModels {
    class HeightViewModel(private val height: Int) {
        fun formatData() : String  = "$height  m(s)"
    }

    class RadiusViewModel(private val radius: Int) {
        fun formatData() : String  = "$radius cm(s)"
    }
}