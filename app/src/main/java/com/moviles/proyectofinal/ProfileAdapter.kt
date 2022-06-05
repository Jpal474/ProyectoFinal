package com.moviles.proyectofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moviles.proyectofinal.databinding.ItemProfileBinding
import org.json.JSONArray
import org.json.JSONObject

class ProfileAdapter (private val user: JSONArray): RecyclerView.Adapter<ProfileAdapter.MainHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemProfileBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        if(user[position].toString()!="null"){
            holder.render(user[position] as JSONObject)
        }
    }

    override fun getItemCount(): Int = user.length()

    class MainHolder(val binding: ItemProfileBinding): RecyclerView.ViewHolder(binding.root){
        fun render(user: JSONObject){
            binding.tvUserName.setText(user.getString("nombre"))
            binding.tvUserMail.setText(user.getString("email"))
            binding.tvUserAdress.setText(user.getString("direccion"))
            binding.tvUserBuys.setText(user.getString("compras"))
            binding.tvUserPassword.setText(user.getString("password"))
            binding.ivUser.setImageResource(R.drawable.person_icon)

        }
    }
}