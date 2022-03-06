package com.example.listview_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var frutas:ArrayList<Fruta> = ArrayList()
        frutas.add(Fruta("Manzana", R.drawable.manzana))
        frutas.add(Fruta("Durazno", R.drawable.durazno))
        frutas.add(Fruta("Platano", R.drawable.platano))
        frutas.add(Fruta("Sandía", R.drawable.sandia))


        val lista =findViewById<ListView>(R.id.lista)
        val boton =  findViewById<Button>(R.id.bMostrar)

        //val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)//Tiene un elemento por celda. Le decimos que tome los valores de nuestro arreglo de frutas
        val adaptador =  Adaptador(this, frutas)
        lista.adapter = adaptador







        //Escuchando los toques
        lista.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
          // boton.setOnClickListener(View.OnClickListener{
                Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_SHORT).show()
          // })
        }





    }
}