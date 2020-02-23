package com.example.lottosearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lottoImageStartId = R.drawable.ball_01

        fun updateLottoBallImage(result: List<Int>) {
            if (result.size < 6) return

            imageView1.setImageResource(lottoImageStartId + (result[0]) - 1)
            imageView2.setImageResource(lottoImageStartId + (result[1]) - 1)
            imageView3.setImageResource(lottoImageStartId + (result[2]) - 1)
            imageView4.setImageResource(lottoImageStartId + (result[3]) - 1)
            imageView5.setImageResource(lottoImageStartId + (result[4]) - 1)
            imageView6.setImageResource(lottoImageStartId + (result[5]) - 1)
        }

        searchButton.setOnClickListener {

            fun checkBlank(): Boolean {

                if(TextUtils.isEmpty(editText1.text.toString())) return false
                if(TextUtils.isEmpty(editText2.text.toString())) return false
                if(TextUtils.isEmpty(editText3.text.toString())) return false
                if(TextUtils.isEmpty(editText4.text.toString())) return false
                if(TextUtils.isEmpty(editText5.text.toString())) return false
                if(TextUtils.isEmpty(editText6.text.toString())) return false

                return true
            }

            if (!checkBlank()) {
                Toast.makeText(this, "숫자 6개 모두를 입력해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

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

            fun countOverlap(): Int {

                var checkOverlap = Array(46, {0})

                checkOverlap[numberEditText1] = 1
                checkOverlap[numberEditText2] = 1
                checkOverlap[numberEditText3] = 1
                checkOverlap[numberEditText4] = 1
                checkOverlap[numberEditText5] = 1
                checkOverlap[numberEditText6] = 1

                var countNum: Int = 0
                for (i in 1..45) {
                    if(checkOverlap[i] == 1) countNum++
                }
                return countNum
            }

            if (!(oneTo45(numberEditText1) && oneTo45(numberEditText2) &&
                        oneTo45(numberEditText3) && oneTo45(numberEditText4) &&
                        oneTo45(numberEditText5) && oneTo45(numberEditText6))) {
                Toast.makeText(this, "로또 번호는 1부터 45까지만 입력해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (countOverlap() != 6) {
                Toast.makeText(this, "중복된 숫자가 있는지 확인해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "good", Toast.LENGTH_SHORT).show()
            var lottoNumbers = mutableListOf<Int>()
            lottoNumbers.add(numberEditText1)
            lottoNumbers.add(numberEditText2)
            lottoNumbers.add(numberEditText3)
            lottoNumbers.add(numberEditText4)
            lottoNumbers.add(numberEditText5)
            lottoNumbers.add(numberEditText6)

            lottoNumbers.sort()

            updateLottoBallImage(lottoNumbers)
        }

        randomButton.setOnClickListener {

            fun getShuffleLottoNumbers(): MutableList<Int> {
                var lottoNumbers = mutableListOf<Int>()

                for (i in 1..45) {
                    lottoNumbers.add(i)
                }

                lottoNumbers.shuffle()

                lottoNumbers = lottoNumbers.subList(0, 6)
                lottoNumbers.sort()

                return lottoNumbers
            }
            updateLottoBallImage(getShuffleLottoNumbers())
        }
    }
}
