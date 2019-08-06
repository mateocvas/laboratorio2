package com.mateocvas.ptractica2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ventana_confirmar.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
     var contrasena=""
     var correo=""
     var nombre=""

    lateinit var dialog:Dialog
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.vencon_bt_aceptar->{
                finish()
            }
            R.id.vencon_bt_cancelar->{
                dialog.dismiss()
            }

        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val i = Intent(this, LoginActivity::class.java)
        i.putExtra("contrasena",contrasena)
        i.putExtra("correo",correo)
        i.putExtra("nombre",nombre)
        startActivityForResult(i, 2)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicie()
    }

    fun inicie(){
        val toolbar=findViewById<android.support.v7.widget.Toolbar>(R.id.my_toolbar)
        toolbar.inflateMenu(R.menu.main_menu)
        setSupportActionBar(toolbar)
        val i = Intent(this, SplashActivity::class.java)
        startActivityForResult(i, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode==Activity.RESULT_OK) {
            val i = Intent(this, LoginActivity::class.java)
            i.putExtra("contrasena",contrasena)
            i.putExtra("correo",correo)
            i.putExtra("nombre",nombre)
            startActivityForResult(i, 2)
        }

        else if ((requestCode == 1 ||requestCode==2) && resultCode==Activity.RESULT_CANCELED) {
            finish()
        }

        else if(requestCode==2 && resultCode==Activity.RESULT_OK){
            contrasena=data!!.getStringExtra("contrasena")
            correo=data.getStringExtra("correo")
            nombre=data.getStringExtra("nombre")
            this.main_nombre.setText(nombre)

        }



    }

    override fun onBackPressed() {
        dialog= Dialog(this)
        dialog.setContentView(R.layout.ventana_confirmar)
        dialog.show()
            dialog.window.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT));
        dialog.vencon_bt_aceptar.setOnClickListener(this)
        dialog.vencon_bt_cancelar.setOnClickListener(this)

    }



}
