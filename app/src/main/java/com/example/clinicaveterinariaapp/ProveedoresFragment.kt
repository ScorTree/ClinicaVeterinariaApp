package com.example.clinicaveterinariaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProveedoresFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_proveedores, container, false)

        val btnAgregarProveedor: FloatingActionButton = view.findViewById(R.id.btn_agregar_proveedor)
        btnAgregarProveedor.setOnClickListener {
            Toast.makeText(requireContext(), "Agregar nuevo proveedor", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
