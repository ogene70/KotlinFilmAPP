package com.example.profileapp

fun main(){
    println("coucou tu as eval")
    abstract class Piece(){
        abstract val nom:String
        abstract val longueur:Float
        abstract val  largeur:Float

      fun surface(x:Float,y:Float):Float{
          return  x*y
       }
    }

    class Cuisine(
        override val nom: String,
        override val longueur: Float,
        override val largeur: Float
    ) :Piece(){

    }
    class Salon(
        override val nom: String,
        override val longueur: Float,
        override val largeur: Float
    ) :Piece(){

    }
val piece= listOf(Cuisine("cuisine ",2F,20F),Salon("salon",20F,20F))

    for (p in piece) {
        println(p.nom+"  surface="+p.surface(p.longueur,p.largeur))

    }

   //exercice2
   class Etudiant(name:String,promo:String,matière:String)















}


