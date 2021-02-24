package com.example.miprimeraplicacion

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.miprimeraplicacion.databinding.ActivityMainBinding
import com.example.miprimeraplicacion.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val miTag:String = "UdelP"
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Enlaza en la variable binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        //Enlazar con la interfaz gráfica
        setContentView(binding.root)

        //Cachar parametros pasados
            //(nombreParametro, valor default si no pasa nada
        val id: Int = intent.getIntExtra("Id", 0)
        val nombre: String? = intent.getStringExtra("Nombre")
        Toast.makeText(this@SecondActivity, "$id $nombre", Toast.LENGTH_SHORT).show()


        Log.d(miTag, "Estoy en onCreate() SECOND")

        binding.btnUrl.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse("http://www.google.com") }

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No tienes una app para abrir esta opción",
                    Toast.LENGTH_LONG).show()
            }

        }

        binding.btnMapa.setOnClickListener{
            //geo: ubicacion &q: pin
            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse( "geo:19.28958619366017,-99.13938537622406?z=18 &q=19.28958619366017,-99.13938537622406") }

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No tienes una app para abrir esta opción",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.btnLlamada.setOnClickListener{
            var intent = Intent(Intent.ACTION_DIAL).apply { data= Uri.parse( "tel:5544838229") }

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No tienes una app para abrir esta opción",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.btnEmail.setOnClickListener{
            val emails = arrayOf("rockyasesinotv@gmail.com", "rockytv97@hotmail.com")
            var intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                //EXTRA_EMAIL, destinatarios
                putExtra(Intent.EXTRA_EMAIL, emails)
                //Asunto
                putExtra(Intent.EXTRA_SUBJECT, "Correo prueba")
                //Cuerpo
                putExtra(Intent.EXTRA_TEXT, "Hola mundo")
            }

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No tienes una app para abrir esta opción",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(miTag, "Estoy en onStart() SECOND")
    }

    override fun onResume() {
        super.onResume()
        Log.d(miTag, "Estoy en onResume() SECOND")
    }

    override fun onPause() {
        super.onPause()
        Log.d(miTag, "Estoy en onPause() SECOND")
    }

    override fun onStop() {
        super.onStop()
        Log.d(miTag, "Estoy en onStop() SECOND")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(miTag, "Estoy en onRestart() SECOND")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(miTag, "Estoy en onDestroy() SECOND")
    }
}