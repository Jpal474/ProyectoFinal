package com.moviles.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moviles.proyectofinal.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

        private lateinit var binding: FragmentHomeBinding
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            //binding = FragmentHomeBinding.inflate(inflater, container, false )
            binding= FragmentHomeBinding.inflate(layoutInflater)
            //action_homeFragment_to_insideHome
            val navController=findNavController()
            binding.buttonHomeToInside.setOnClickListener{

                //navController.navigate(R.id.action_homeFragment_to_insideHome)
                val destination=FragmentHomeDirections.actionFragmentHomeToFragmentInsideHome()

                navController.navigate(destination)
            }
            return binding.root
        }

    }