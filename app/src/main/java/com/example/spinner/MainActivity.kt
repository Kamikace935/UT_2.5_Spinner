package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    private lateinit var tema: Spinner
    private lateinit var opcion: Spinner
    private lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tema = findViewById(R.id.tema)
        val arrTemas = resources.getStringArray(R.array.temas).toList()
        tema.adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrTemas)
        opcion = findViewById(R.id.opcion)
        imagen = findViewById(R.id.imagen)



        tema.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, positon: Int, id: Long) {
                val temas : String = parent?.getItemAtPosition(positon).toString()
                elecciones(temas)
            }
        }

        opcion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, positon: Int, id: Long) {
                val opciones: String = parent?.getItemAtPosition(positon).toString()
                portada(opciones)

            }
        }
    }

    fun elecciones(temas: String) {
        lateinit var arrOpciones: List<String>
        when (temas) {
            "Libros" -> {
                arrOpciones = resources.getStringArray(R.array.Libros).toList()
            }

            "Comics" -> {
                arrOpciones = resources.getStringArray(R.array.Comics).toList()
            }

            "Mangas" -> {
                arrOpciones = resources.getStringArray(R.array.Mangas).toList()
            }
        }
        opcion.adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrOpciones)
    }

    fun portada(opciones: String)  {

        when (opciones) {
            "Piromides" -> {
                imagen.setImageResource(R.drawable.piromides)
            }

            "¡Guardias! ¡Guardias!" -> {
                imagen.setImageResource(R.drawable.guardias)
            }

            "Que dificil es ser Dios" -> {
                imagen.setImageResource(R.drawable.qdesd)
            }

            "Blacksad" -> {
                imagen.setImageResource(R.drawable.blacksad)
            }

            "Fabulas" -> {
                imagen.setImageResource(R.drawable.fabulas)
            }

            "Hellboy" -> {
                imagen.setImageResource(R.drawable.hellboy)
            }

            "Berserk" -> {
                imagen.setImageResource(R.drawable.berserk)
            }

            "Buenas noches Punpun" -> {
                imagen.setImageResource(R.drawable.punpun)
            }

            "Bakemonogatari" -> {
                imagen.setImageResource(R.drawable.bakemono)
            }
        }
    }

}
