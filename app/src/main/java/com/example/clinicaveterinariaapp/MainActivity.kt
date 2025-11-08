package com.example.clinicaveterinariaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        toolbar = findViewById(R.id.toolbar)

        // Configurar Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Clínica Veterinaria"

        // Crear el toggle (menú hamburguesa)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Forzar ícono hamburguesa negro
        toolbar.navigationIcon = AppCompatResources.getDrawable(this, R.drawable.ic_menu)
        toolbar.navigationIcon?.setTint(getColor(android.R.color.black))

        // Pantalla inicial → Dashboard
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DashboardFragment())
                .commit()
            navigationView.setCheckedItem(R.id.nav_dashboard)
        }

        // Manejo del menú lateral
        navigationView.setNavigationItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_dashboard -> DashboardFragment()
                R.id.nav_propietarios -> PropietariosFragment()
                R.id.nav_pacientes -> PacientesFragment()
                R.id.nav_veterinarios -> VeterinariosFragment()
                R.id.nav_consultas -> ConsultasFragment()
                R.id.nav_estudios -> EstudiosFragment()
                R.id.nav_hospitalizacion -> HospitalizacionFragment()
                R.id.nav_cirugias -> CirugiasFragment()
                R.id.nav_farmacia -> FarmaciaFragment()
                R.id.nav_proveedores -> ProveedoresFragment()
                R.id.nav_pagos -> PagosFragment()
                R.id.nav_emergencias -> EmergenciasFragment()
                R.id.nav_visitas -> VisitasFragment()
                R.id.nav_auditorias -> AuditoriasFragment()
                else -> DashboardFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()

            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }
}
