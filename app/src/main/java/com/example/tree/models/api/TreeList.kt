package com.example.tree.models.api

import com.example.tree.models.Tree
import com.google.gson.annotations.SerializedName

data class Fields(
    @SerializedName("libellefrancais")
    val name: String?,
    @SerializedName("espece")
    val type: String?,
    @SerializedName("adresse")
    val address: String?,
    @SerializedName("hauteurenm")
    val height: Int?,
    @SerializedName("circonferenceencm")
    val radius: Int?
)

data class Records(@SerializedName("fields") val fields: Fields)

fun Records.toTree(): Tree {
    return Tree(
        fields.name,
        fields.type,
        fields.address,
        fields.height,
        fields.radius
    )
}

data class TreeList(@SerializedName("records") val records: List<Records>)