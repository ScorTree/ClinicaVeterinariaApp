package com.example.clinicaveterinariaapp

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class VeterinariosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_veterinarios, container, false)

        val btnAgregar: FloatingActionButton = view.findViewById(R.id.btn_agregar_veterinario)
        btnAgregar.setOnClickListener {
            Toast.makeText(requireContext(), "Agregar nuevo veterinario", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
