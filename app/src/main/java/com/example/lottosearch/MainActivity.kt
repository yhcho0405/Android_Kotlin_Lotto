package com.example.lottosearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var numberEditText1: Int = editText1.text.toString().toInt()
            var numberEditText2: Int = editText2.text.toString().toInt()
            var numberEditText3: Int = editText3.text.toString().toInt()
            var numberEditText4: Int = editText4.text.toString().toInt()
            var numberEditText5: Int = editText5.text.toString().toInt()
            var numberEditText6: Int = editText6.text.toString().toInt()

            fun oneTo45(p: Int): Boolean {
                if (p <= 0 || p > 45) return false
                return true
            }

            if (oneTo45(numberEditText1) || oneTo45(numberEditText2) || oneTo45(numberEditText3) || oneTo45(numberEditText4)|| oneTo45(numberEditText5) || oneTo45(numberEditText6)) {
                
            }
        }
    }
}
