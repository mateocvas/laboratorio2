package com.mateocvas.ptractica2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*

class RegisterActiviy:AppCompatActivity(),View.OnClickListener{
    var correo=""

    override fun onClick(v: View?) {
    when (v?.id){
        R.id.reg_bt_aceptar->{
            val nombre=reg_et_nombre.text.toString()
            val correo=reg_et_correo.text.toString()
            val contrasena1=reg_et_contrasena.text.toString()
            val contrasena2=reg_et_contrasena2.text.toString()

            if(nombre.equals("")|| correo.equals("")||contrasena1.equals("")||contrasena2.equals(""))
                Toast.makeText(this,resources.getString(R.string.error_campos_incompletos),Toast.LENGTH_LONG).show()
            else if(!contrasena1.equals(contrasena2))
                Toast.makeText(this,resources.getString(R.string.error_contrasenas_diferente),Toast.LENGTH_LONG).show()
            else if (correo.equals(this.correo))
                Toast.makeText(this,resources.getString(R.string.error_correo_registrado),Toast.LENGTH_LONG).show()
            else{
                val intento=Intent()
                intento.putExtra("nombre",nombre)
                intento.putExtra("correo",correo)
                intento.putExtra("contrasena",contrasena1)
                setResult(Activity.RESULT_OK,intento)
                finish()
            }

        }
        R.id.reg_bt_cancelar->{
            setResult(Activity.RESULT_CANCELED, Intent());
            finish();

        }

    }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_registro)
        inicie()
        super.onCreate(savedInstanceState)
    }

    fun inicie(){
        this.correo=intent.getStringExtra("correo")
        this.reg_bt_aceptar.setOnClickListener(this)
        this.reg_bt_cancelar.setOnClickListener(this)
     }





}