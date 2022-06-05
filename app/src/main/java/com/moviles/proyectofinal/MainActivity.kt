package com.moviles.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.moviles.proyectofinal.remote.ItemEntry
import com.moviles.proyectofinal.remote.RetrofitBuilder
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = Firebase.database
        val myRef = database.reference

        //myRef.child("usuarios").child("1").setValue(User("19", "Pedro Ramirez", "Ramos Millan # 22, Colonia Americana, Guadalajara, Jalisco", "ped.rod@gmail.com", "12345", "120"))
        //myRef.child("usuarios").child("2").setValue(User("21", "Monica Serna", "Av. Prolongación Alcalde #1351, Guadalajara, Jalisco", ",mon_serna@gmail.com", "moniser123", "20"))
        //myRef.child("usuarios").child("3").setValue(User("30", "Zoé Pérez", " Av. Patria 1756, Col.Santa Isabel, Zapopan, Jalisco", "z_per_123@gmail.com", "moniser123", "70"))

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navView.setupWithNavController(navController)
        val retrofit = RetrofitBuilder.create().getItemById("1")

        retrofit.enqueue(object: Callback<ItemEntry> {
            override fun onResponse(call: Call<ItemEntry>, response: Response<ItemEntry>) {
                val resBody = response.body()
                if (resBody != null){
                    Log.d("retrofitresponse", "res: ${resBody}")
                    Log.d("retrofitresponse", "price : ${resBody.price}")
                    Log.d("retrofitresponse","imagee : ${resBody.image}" )
                    Log.d("retrofitresponse", "rating : ${resBody.rating.rate}")




                }

            }

            override fun onFailure(call: Call<ItemEntry>, t: Throwable) {
                Log.e("retrofitresponse", "error: ${t.message}")
            }
        })





    }
}