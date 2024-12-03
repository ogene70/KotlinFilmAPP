package com.example.profileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import kotlinx.serialization.Serializable

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Composable
fun Profile(last:String="JOSEPH",first:String="Ogené"){
    Column (Modifier.padding(25.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

        Image(
            painterResource(R.drawable.logoj),"profile image", modifier = Modifier.clip(
            CircleShape
            ))
        Text(

            text="$last $first") }

}


@Composable
fun Info(){
    Column {
        Text(
            text = "Etudiant developpeur web et mobile"
        )
        Text(
            text = "BUT-MMI IUT PAUL SABATIER"
        ) }

}
@Composable
fun Contact(){
    Column(Modifier.padding(25.dp)) {
        Row {
            Text(
                text =  "ogene.joseph@etu.iut-tlse3.fr"
            )
        }
        Row {
            Text(
                text="www.ojoseph.fr"
            )
        }
    }

}
@Composable
fun MyButton(modifier: Modifier){

    Row(modifier.padding(25.dp)){
        Text(
            text="Continuer dans l'application",
            modifier = Modifier.clip(CircleShape).border(3.dp, Color.Black, CircleShape).background(
                Color.Red).
            padding(10.dp),

        )
    }
}

@Composable
fun Screen(classes: WindowSizeClass,navCotroller:NavHostController){
    when (classes.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {

            Column (modifier=Modifier.background(Color.Black).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){


                Profile("Ogené","JOSEPH")
                Info()
                Contact()
                MyButton(Modifier.clickable { navCotroller.navigate(PlaylistDestination()) })
            }

        }
        else ->{
            Row (modifier=Modifier.background(Color.Cyan).fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){

                Column(modifier = Modifier.padding(5.dp),Arrangement.Center,Alignment.CenterHorizontally){
                    Profile("Ogené","JOSEPH")
                    Info()
                }
                Column(modifier = Modifier.padding(5.dp)){
                    Contact()
                    MyButton(Modifier.clickable { navCotroller.navigate(FilmsDestination()) })
                }


            }}

    }


}