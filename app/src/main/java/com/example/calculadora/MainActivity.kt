package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity(), View.OnClickListener {

        var operacion = ""
        var operacionPendiente = false
        var existeResultado= false

        lateinit var btn1:Button
        lateinit var btn2:Button
        lateinit var btn3:Button
        lateinit var btn4:Button
        lateinit var btn5:Button
        lateinit var btn6:Button
        lateinit var btn7:Button
        lateinit var btn8:Button
        lateinit var btn9:Button
        lateinit var btnCero:Button
        lateinit var btnSum:Button
        lateinit var btnRes:Button
        lateinit var btnIgual:Button
        lateinit var btnMult:Button
        lateinit var btnDiv:Button
        lateinit var btnBorrar:Button
        lateinit var etVisor:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()

    }
        private fun initUI(){
            btn1 = findViewById(R.id.btn1)
            btn2 = findViewById(R.id.btn2)
            btn3 = findViewById(R.id.btn3)
            btn4 = findViewById(R.id.btn4)
            btn5 = findViewById(R.id.btn5)
            btn6 = findViewById(R.id.btn6)
            btn7 = findViewById(R.id.btn7)
            btn8 = findViewById(R.id.btn8)
            btn9 = findViewById(R.id.btn9)
            btnCero = findViewById(R.id.btnCero)
            btnSum = findViewById(R.id.btnSum)
            btnRes =findViewById(R.id.btnRes)
            btnIgual = findViewById(R.id.btnIgual)
            btnMult = findViewById(R.id.btnMult)
            btnDiv = findViewById(R.id.btnDiv)
            btnBorrar = findViewById(R.id.btn_Borrar)
            etVisor = findViewById(R.id.etVisor)
            btn1.setOnClickListener(this)
            btn2.setOnClickListener(this)
            btn3.setOnClickListener(this)
            btn4.setOnClickListener(this)
            btn5.setOnClickListener(this)
            btn6.setOnClickListener(this)
            btn7.setOnClickListener(this)
            btn8.setOnClickListener(this)
            btn9.setOnClickListener(this)
            btnCero.setOnClickListener(this)
            btnSum.setOnClickListener(this)
            btnRes.setOnClickListener(this)
            btnMult.setOnClickListener(this)
            btnDiv.setOnClickListener(this)
            btnBorrar.setOnClickListener(this)
            btnIgual.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn1->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("1")
            }
            R.id.btn2->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("2")
            }
            R.id.btn3->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("3")
            }
            R.id.btn4->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("4")
            }
            R.id.btn5->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("5")
            }
            R.id.btn6->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("6")
            }
            R.id.btn7->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("7")
            }
            R.id.btn8->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("8")
            }
            R.id.btn9->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("9")
            }
            R.id.btnCero->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("0")
            }
            R.id.btnSum->{
                if (!operacionPendiente){
                    operacion = "suma"
                    etVisor.append("+")
                    operacionPendiente = true
                }
            }
            R.id.btnDiv->{
                if (!operacionPendiente){
                    operacion = "division"
                    etVisor.append("/")
                    operacionPendiente = true
                }
            }
            R.id.btnRes->{
                 if (!operacionPendiente){
                     operacion = "resta"
                     etVisor.append("-")
                     operacionPendiente = true
                }
            }
            R.id.btnMult->{
                if (!operacionPendiente){
                    operacion = "multiplicacion"
                    etVisor.append("x")
                    operacionPendiente = true
                }
            }
            R.id.btn_Borrar->{
                limpiarPantalla()
            }
            R.id.btnIgual->{
                if(operacionPendiente){
                    val textoOperacion = etVisor.text.toString()
                    var delimitador = ""
                    when(operacion){
                        "suma"->delimitador="+"
                        "resta"->delimitador="-"
                        "division"->delimitador="/"
                        "multiplicacion"->delimitador="x"
                    }

                    val operandos = textoOperacion.split(delimitador)
                    val operando1 = operandos[0].toDouble()
                    val operando2 = operandos[1].toDouble()
                    var resultado = 0.0
                    when(operacion){
                        "suma"->{
                            resultado = operando1+operando2
                        }
                        "resta"->{
                            resultado = operando1-operando2
                        }
                        "division"->{
                            resultado = operando1/operando2
                        }
                        "multiplicacion"->{
                           resultado = operando1*operando2
                        }

                    }
                     etVisor.setText("${resultado}")
                     existeResultado = true
                }
            }
        }
    }
    fun limpiarPantalla(){
        etVisor.setText("")
        operacionPendiente=false
        existeResultado=false
    }
}