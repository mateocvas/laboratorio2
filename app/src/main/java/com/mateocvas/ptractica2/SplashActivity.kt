package com.mateocvas.ptractica2


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    // Duración en milisegundos que se mostrará el splash
    private val DURACION_SPLASH = 3000 // 3 segundos

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Tenemos una plantilla llamada splash.xml donde mostraremos la información que queramos (logotipo, etc.)
        setContentView(R.layout.splash)

        Handler().postDelayed({
            setResult(Activity.RESULT_OK,Intent());
            finish()
        }, DURACION_SPLASH.toLong())
      setContentView(R.layout.splash)

    }
}