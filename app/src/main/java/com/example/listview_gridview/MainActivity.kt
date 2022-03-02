package com.example.listview_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var frutas:ArrayList<String> = ArrayList()
        frutas.add("Manzana")
        frutas.add("Durazno")
        frutas.add("Platano")
        frutas.add("Sandía")


        val lista =findViewById<ListView>(R.id.lista)

        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)//Tiene un elemento por celda. Le decimos que tome los valores de nuestro arreglo de frutas

        lista.adapter = adaptador


        //Escuchando los toques
        lista.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            Toast.makeText(this, frutas.get(position), Toast.LENGTH_SHORT).show()
        }


    }
}