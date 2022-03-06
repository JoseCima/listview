package com.example.listview_gridview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.w3c.dom.Text

class Adaptador(var context:Context, items:ArrayList<Fruta>):BaseAdapter() {

    var items:ArrayList<Fruta>? = null
    ///var boton: Button? = null



    init {
        this.items = items


    }


    override fun getCount(): Int {
        return items?.count()!! //Obtener el conteo de datos
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var holder:ViewHolder? =null
        var vista:View? = convertView
        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(vista)
            vista.tag = holder

            if(position %2 == 1){
                vista.setBackgroundColor(Color.LTGRAY)
            }else{
                vista.setBackgroundColor(Color.WHITE)
            }
        }else{
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Fruta
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource(item.imagen)
        //holder?.boton?.setOnClickListener { item.nombre }




        return vista!!
    }

    private class ViewHolder(vista:View){
        var nombre: TextView? = null
        var imagen: ImageView? = null
       //var boton: Button? = null
       var boton : Button? =null

        init{
            nombre =  vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
           boton = vista.findViewById(R.id.bMostrar)



            boton?.setOnClickListener {
                Toast.makeText(vista.context, nombre?.text, Toast.LENGTH_SHORT ).show()
            }
        }
    }


}