package com.moviles.proyectofinal.remote

import com.google.gson.annotations.SerializedName
data class ItemEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title : String,
    @SerializedName("description")
    val description : String,
    @SerializedName("price")
    val price : Double,
    @SerializedName("image")
    val image : String,
    @SerializedName("rating")
    val rating : RatingEntry

)
data class RatingEntry(
    @SerializedName("rate")
    val rate : Double,
    @SerializedName("count")
    val count : Int,

)