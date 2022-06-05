package com.moviles.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.moviles.proyectofinal.databinding.FragmentProfileBinding
import org.json.JSONArray
import org.json.JSONObject


class FragmentProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val binding = FragmentProfileBinding.inflate(layoutInflater)
        val database = Firebase.database
        val myRef = database.reference
        val user = "1"

        myRef.child("usuarios").child(user).child("nombre").get().addOnSuccessListener { response ->
           binding.tvUserName.setText(response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
        myRef.child("usuarios").child("1").child("nombre").get().addOnSuccessListener { response ->
            binding.tvUserName.setText(response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
        myRef.child("usuarios").child("1").child("edad").get().addOnSuccessListener { response ->
            binding.tvUserAge.setText(response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
        myRef.child("usuarios").child("1").child("email").get().addOnSuccessListener { response ->
            binding.tvUserMail.setText(response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
        myRef.child("usuarios").child("1").child("direccion").get().addOnSuccessListener { response ->
            binding.tvUserAdress.setText(response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
        myRef.child("usuarios").child("1").child("compras").get().addOnSuccessListener { response ->
            binding.tvUserPassword.setText(response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
        myRef.child("usuarios").child("1").child("compras").get().addOnSuccessListener { response ->
            binding.tvUserBuys.setText(response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }



        return binding.root
    }


}