package com.example.profileapp

import DetailSerie
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.profileapp.ui.theme.ProfileAPPTheme
import kotlinx.serialization.Serializable
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.toRoute


@Serializable class FilmsDestination
@Serializable class SeriesDestination
@Serializable class ActeursDestination
@Serializable class ProfileDestination
@Serializable class DetailFilmDestination(val id:Int)
@Serializable class DetailSerieDestination(val id:Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodel:MainViewModel by viewModels()

        enableEdgeToEdge()
        setContent {

            ProfileAPPTheme {
                val windowSizeClass= currentWindowAdaptiveInfo().windowSizeClass
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold( bottomBar = {


                  if (currentDestination?.hasRoute<ProfileDestination>()==false){

                      NavigationBar {


                          NavigationBarItem(
                              icon = {}, label = { Text("Films") },
                              selected = currentDestination?.hasRoute<FilmsDestination>() == true,
                              onClick = { navController.navigate(FilmsDestination()) })


                          NavigationBarItem(
                              icon = {}, label = { Text("Series") },
                              selected = currentDestination?.hasRoute<SeriesDestination>() == true,
                              onClick = { navController.navigate(SeriesDestination()) })

                          NavigationBarItem(
                              icon = { }, label = { Text("Acteurs") },
                              selected = currentDestination?.hasRoute<ActeursDestination>() == true,
                              onClick = { navController.navigate(ActeursDestination()) })
                      }

                  }



                 } )
                 {

                        innerPadding ->
                    NavHost(modifier= Modifier.padding(innerPadding), navController = navController, startDestination = ProfileDestination()) {
                        composable<FilmsDestination> { Films(viewModel = viewmodel,navController) }
                        composable<SeriesDestination> { Series(viewModel=viewmodel,navController= navController) }
                        composable<ActeursDestination> { Acteurs() }
                        composable<ProfileDestination> {
                            Screen(windowSizeClass,navController) }
                        composable<DetailFilmDestination> {
                                backStackEntry ->
                            val detailFilm= backStackEntry.toRoute<DetailFilmDestination>()
                            DetailFilmView(viewmodel,navController,detailFilm.id) }

                        composable<DetailSerieDestination> {backStackEntry ->
                            val detailSerie= backStackEntry.toRoute<DetailSerieDestination>()
                            DetailSerieView(viewmodel,navController,detailSerie.id) }

                    }
                }



                }

            }
        }
    }







