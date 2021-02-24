package com.example.miprimeraplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.miprimeraplicacion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    val miTag:String = "UdelP"
    //Enlaza en la variable binding ActivityMainBinding cambia por el nombre de la actividad
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //savedInstanceState guarda el estado de la act anterior
        super.onCreate(savedInstanceState)

        //Enlazar con la interfaz gráfica
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(miTag, "Estoy en onCreate() HOME")

        binding.btnAceptar.setOnClickListener{
            //Definir donde se encuentra y adonde quiere ir
            val i = Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra("Id", 10)
                putExtra("Nombre", "Rod Vazquez")
            }
            startActivity(i)
        }

        binding.btnToast.setOnClickListener{
            //Contexto, mesaje, longitud del mensaje
            Toast.makeText(this@MainActivity, "Ejemplo de mensaje Toast", Toast.LENGTH_LONG).show()
        }

        binding.btnSnackBar.setOnClickListener{
            //vista, mensaje, duracion
            Snackbar.make(it, "Ejemplo de snack bar", Snackbar.LENGTH_LONG).show()
        }

        binding.btnDialog.setOnClickListener{
            miDialogo().show()
        }

        binding.fabMiBoton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Botón flotante", Toast.LENGTH_LONG).show()
        }
    }

    fun miDialogo(): AlertDialog{
        val miAlerta = AlertDialog.Builder(this@MainActivity)
        miAlerta.setTitle("TITULO")
        miAlerta.setMessage("Mensaje de mi dialogo")
        //Poner btn de aceptar y su texto
        miAlerta.setPositiveButton("Si"){_,_ ->
            //codigo
            Toast.makeText(this@MainActivity, "Click en sí", Toast.LENGTH_LONG).show()
        }
        //Btn negativo
        miAlerta.setNegativeButton("No"){_,_ ->
            Toast.makeText(this@MainActivity, "Click en no", Toast.LENGTH_LONG).show()
        }
        return  miAlerta.create()
    }

    override fun onStart() {
        super.onStart()
        Log.d(miTag, "Estoy en onStart() HOME")
    }

    override fun onResume() {
        super.onResume()
        Log.d(miTag, "Estoy en onResume() HOME")
    }

    override fun onPause() {
        super.onPause()
        Log.d(miTag, "Estoy en onPause() HOME")
    }

    override fun onStop() {
        super.onStop()
        Log.d(miTag, "Estoy en onStop() HOME")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(miTag, "Estoy en onRestart() HOME")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(miTag, "Estoy en onDestroy() HOME")
    }
}