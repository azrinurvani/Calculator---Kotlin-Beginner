package com.mobile.azrinurvani.kotlinbeginner_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       Binding View Menggunakan Kotlin Synthetic
        btn_plus.setOnClickListener {
            validation(edt_angka_awal.text.toString(),edt_angka_akhir.text.toString(),'+')
        }
        btn_minus.setOnClickListener {
            validation(edt_angka_awal.text.toString(),edt_angka_akhir.text.toString(),'-')
        }

        btn_multipli.setOnClickListener {
            validation(edt_angka_awal.text.toString(),edt_angka_akhir.text.toString(),'*')
        }

        btn_divide.setOnClickListener {
            validation(edt_angka_awal.text.toString(),edt_angka_akhir.text.toString(),'/')
        }
    }

    fun validation(awal:String, akhir:String, operator:Char){
        if (awal.isEmpty()){
            edt_angka_awal.error = "Angka awal tidak boleh kosong"
        }

        if (akhir.isEmpty()){
            edt_angka_akhir.error = "Angka akhir tidak boleh kosong"
        }
        if (awal.isNotEmpty() && akhir.isNotEmpty()){
            calculation(awal.toDouble(),akhir.toDouble(),operator)
        }
    }

    fun calculation(awal:Double,akhir:Double,operator:Char){
        var hasil = 0.0

        when(operator){
            '+' -> hasil = awal + akhir
            '-' -> hasil = awal - akhir
            '*' -> hasil = awal * akhir
            '/' -> hasil = awal / akhir
        }
        txt_result.text = hasil.toString()
    }
}