package com.tani.catchthekenny

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random
import kotlin.math.nextTowards

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = this.getSharedPreferences("com.tani.catchthekenny", android.content.Context.MODE_PRIVATE)
        //sharedPref.edit().putInt("highscore", 0).apply()

      //  var hs = sharedPref.getInt("highscore", 69)

        txtHIghscore.text = "Highscore : " +  sharedPref.getInt("highscore", 0)


        object : CountDownTimer(15000, 1000){
            override fun onFinish() {
                txtTime.text="Time's Up"

                handler.removeCallbacks(runnable)
                for(img in imgarr){
                    img.visibility= View.INVISIBLE

                }

                if(sharedPref.getInt("highscore", 0)< score)
                {
                    sharedPref.edit().putInt("highscore", score).apply()
                    Toast.makeText(applicationContext, "Congratulations! You beat the Highscore", Toast.LENGTH_LONG).show()
                }

                txtHIghscore.text = "Highscore :" + sharedPref.getInt("highscore", score)



            }

            override fun onTick(p0: Long) {
                val time=p0/1000
                txtTime.text="Time : $time"


            }
        }.start()

        imgarr= arrayListOf(imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9)
        hideimage()






    }

    var score : Int=0
    var imgarr = arrayListOf<ImageView>()
    var runnable : Runnable = Runnable{ }
    var handler = Handler()

    fun incScore(view: View){
        score++


        txtScore.text="Score : $score"
    }

    fun hideimage(){

        runnable= object : Runnable{
            override fun run(){
                for (img in imgarr) {
                    img.visibility = View.INVISIBLE
                }

                var rand  = random()
                var index  = random().nextTowards(100.0)
                var i :  Int = (index*100).toInt()%9
                println(i)

                imgarr[i].visibility = View.VISIBLE
                handler.postDelayed(runnable, 400)


            }

        }

        handler.post(runnable)

        }
    }


