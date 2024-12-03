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
   class Etudiant(val name:String,val promo:String,val matieres:List<String>)

    val etudiant= listOf(
        Etudiant("Paul","2025", listOf("mobile","web","bdd")),
        Etudiant("Yazid","2024",listOf("mobile","android","network")),
        Etudiant("Caroline","2025",listOf("SE","Anglais"))
    )



    println("taille du tableau=${etudiant.size} elements")
    val promo2024= etudiant.filter{ it.promo=="2024"}

    promo2024.forEach{println("etudiant de la promo 2024 nom=${it.name}")}


    val etu2matiere= etudiant.filter { it.matieres.size>2 }
    etu2matiere.forEach{println("etudiant suivant plus de 2 matières nom=${it.name}")}

    val sommeMatiere= etudiant.fold(0){acc,e->acc+e.matieres.size}
println("le nombre de matière est $sommeMatiere")














}


