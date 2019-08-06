package com.mateocvas.ptractica2

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.ventana_login_ingresar.*


class LoginActivity: AppCompatActivity(),View.OnClickListener{
    lateinit var ventana:Dialog
     var usuario=""
     var correo =""
     var contrasena=""


    override fun onClick(v: View?) {
        when (v?.id){
            R.id.log_facebook-> {
                ventana.ven_bt_ingresar.setText(resources.getString(R.string.facebook))
                ventana.ven_iv_usuario.setImageDrawable(resources.getDrawable(R.drawable.facebook))
                ventana.show()
            }
            R.id.log_gmail->{
                ventana.ven_bt_ingresar.setText(resources.getString(R.string.gmail))
                ventana.ven_iv_usuario.setImageDrawable(resources.getDrawable(R.drawable.google))
                ventana.show()
            }
            R.id.log_ingresar->{
                    ventana.ven_bt_ingresar.setText(resources.getString(R.string.bt_ingresar))
                    ventana.ven_iv_usuario.setImageDrawable(resources.getDrawable(R.drawable.user))
                    ventana.show()

            }

            R.id.log_registro->{
                    val intento=Intent(this@LoginActivity,RegisterActiviy::class.java)
                    intento.putExtra("correo",usuario)
                    startActivityForResult(intento,1)
            }

            R.id.ven_bt_salir->{
                    ventana.dismiss()
            }
            R.id.ven_bt_ingresar->{
                      if(ventana.ven_et_usuario.text.toString().equals(correo)&&ventana.ven_ed_contrasena.text.toString().equals(contrasena)){
                          val intento =Intent()
                          intento.putExtra("nombre",usuario)
                          intento.putExtra("correo",correo)
                          intento.putExtra("contrasena",contrasena)
                          setResult(Activity.RESULT_OK,intento)
                          finish()
                      }
                else(Toast.makeText(ventana.context,contrasena,Toast.LENGTH_LONG).show())
            }




        }



    }



            override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_login)
                contrasena=intent.getStringExtra("contrasena")
                correo=intent.getStringExtra("correo")
                usuario=intent.getStringExtra("nombre")
        super.onCreate(savedInstanceState)
        inicie()

    }

    fun inicie() {
        ventana= Dialog(this)
        ventana.setContentView(R.layout.ventana_login_ingresar)
        ventana.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        ventana.window.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT));

        ventana.ven_bt_salir.setOnClickListener(this)
        ventana.ven_bt_ingresar.setOnClickListener(this)
        log_ingresar.setOnClickListener(this)
       log_facebook.setOnClickListener(this)
       log_gmail.setOnClickListener(this)
        log_registro.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==1 && resultCode==Activity.RESULT_OK) {
               correo=data!!.getStringExtra("correo")
               usuario=data.getStringExtra("nombre")
               contrasena=data.getStringExtra("contrasena")
               Toast.makeText(this,resources.getString(R.string.exito_registro),Toast.LENGTH_LONG).show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onBackPressed() {

        setResult(Activity.RESULT_CANCELED,Intent())
        finish()
    }

}