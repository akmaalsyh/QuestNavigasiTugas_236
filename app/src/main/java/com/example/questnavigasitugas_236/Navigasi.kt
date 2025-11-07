package com.example.questnavigasitugas_236

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_236.view.ListTampilanData
import com.example.questnavigasitugas_236.view.Beranda

enum class Navigasi {
    Home,
    Formulir,
    List
}

@Composable
fun DataApp (
    navController: NavHostController = rememberNavController(),
    modifier: androidx.compose.ui.Modifier
){
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,

            modifier = Modifier.padding(paddingValues = isiRuang)) {
            composable(route = Navigasi.Formulir.name){
                Beranda (
                    // PilihanJK = JenisK.map {id -> konteks.resource.getString(id)},
                    OnSubmitBtnClick = {
                        navController.navigate(route = Navigasi.Formulir.name)
                    }
                )
            }

            composable(route = Navigasi.List.name){
                ListTampilanData (
                    OnBerandaBtnClick = {cancelAndBackToHome(navController)},
                    OnFormulirBtnClick = {
                        navController.navigate(route = Navigasi.Formulir.name)
                    }
                )
            }

        }
    }
}

private fun cancelAndBackToHome(
    navController: NavController
){
    navController.popBackStack(route = Navigasi.Home.name, inclusive = false)
}