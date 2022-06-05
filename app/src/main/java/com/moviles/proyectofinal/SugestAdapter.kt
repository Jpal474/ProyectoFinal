package com.moviles.proyectofinal

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.moviles.proyectofinal.databinding.ItemSugestBinding
import com.moviles.proyectofinal.remote.ItemEntry
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Response

class SugestAdapter (private val products: List<ItemEntry>): RecyclerView.Adapter<SugestAdapter.MainHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemSugestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        if(products[position].toString()!="null"){
            holder.render(products[position])
        }
    }

    override fun getItemCount(): Int = products.size

    class MainHolder(val binding: ItemSugestBinding): RecyclerView.ViewHolder(binding.root){
        fun render(item: ItemEntry){
            binding.productName.setText(item.title)
            binding.product.setImageResource(R.drawable.product_icon)
        }
    }}