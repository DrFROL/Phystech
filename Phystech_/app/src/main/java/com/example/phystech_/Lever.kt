package com.example.phystech_

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains
import com.example.phystech_.R.*


class Lever : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.lever)

        val img_kub : ImageView
        val img_pulka :ImageView
        val img_opora : ImageView
        val img_doska : ImageView


        var position_kub_x = 0
        var position_kub_y = 0

        var position_pulka_x = 0
        var position_pulka_y = 0

        var position_opora_x = 0
        var position_opora_y = 0

        var position_doska_x = 0
        var position_doska_y = 0

        img_kub  = findViewById(id.img_kub)
        img_pulka = findViewById(id.img_pulka)
        img_opora = findViewById(id.img_opora)
        img_doska = findViewById(id.img_doska)

        val txt = TextView(this)
        val myLayout = findViewById<FrameLayout>(id.main)

        txt.setText("\nПринцип действия:\n \n" +
                "Прикладывая силу, вектор которой направлен вниз, на рычаг с неподвижной точкой опоры, мы получаем выйгрыш в силе.Так, например, прикладывая к рычагу силу 400 Н, сможет приподнять груз весом 800 Н. Разделив 800 Н на 400 Н, мы получим выигрыш в силе, равный 2, тем самым мы можем поднимать  большие грузы.")

        txt.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        val img_strelka_up = ImageView(this)
        val img_strelka_down = ImageView(this)

        img_strelka_up.setBackgroundResource(drawable.strelka_up)
        img_strelka_down.setBackgroundResource(drawable.strelka_down)

        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        val params1 = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        val container : RelativeLayout = findViewById(id.container)
        var xDelta = 0
        var yDelta = 0
        val touchListener_kub: View.OnTouchListener = object : View.OnTouchListener {
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                val x = event.rawX.toInt()
                val y = event.rawY.toInt()
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_DOWN -> {
                        val lParams = view.layoutParams as FrameLayout.LayoutParams
                        xDelta = x - lParams.leftMargin
                        yDelta = y - lParams.topMargin
                    }

                    MotionEvent.ACTION_MOVE -> {
                        if (x - xDelta + view.width <= container.width
                            && y - yDelta + view.height <= container.height
                            && x - xDelta >= 0
                            && y - yDelta >= 0) {
                            val layoutParams = view.layoutParams as FrameLayout.LayoutParams
                            layoutParams.leftMargin = x - xDelta
                            layoutParams.topMargin = y - yDelta
                            layoutParams.rightMargin = 0
                            layoutParams.bottomMargin = 0
                            view.layoutParams = layoutParams
                            position_kub_x = x - xDelta
                            position_kub_y = y - yDelta

                            println("Куб: $position_kub_x $position_kub_y")

                            if (position_opora_x - position_doska_x > 80 && position_opora_x - position_doska_x  < 200 &&
                                position_doska_y - position_opora_y > 75 &&  position_doska_y - position_opora_y < 87 &&

                                position_opora_x - position_pulka_x > 153 && position_opora_x - position_pulka_x < 250 &&
                                position_opora_y - position_pulka_y > 138 && position_opora_y - position_pulka_y < 250 &&

                                position_kub_x - position_opora_x > 190 && position_kub_x - position_opora_x < 270 &&
                                position_opora_y - position_kub_y > 50 && position_opora_y - position_kub_y < 110

                            ) {
                                if (txt !in myLayout)
                                    myLayout.addView(txt)

                                if (img_strelka_up !in myLayout && img_strelka_down !in myLayout){
                                    params.setMargins(position_pulka_x - 80,  position_pulka_y, 0, 0)
                                    img_strelka_down.setLayoutParams(params)
                                    myLayout.addView(img_strelka_down)


                                    params1.setMargins( position_kub_x + 210,  position_pulka_y, 0, 0)
                                    img_strelka_up.setLayoutParams(params1)
                                    myLayout.addView(img_strelka_up)
                                }
                            }
                        }
                    }
                }
                container.invalidate()
                return true
            }
        }


        xDelta = 0
        yDelta = 0
        val touchListener_pulka: View.OnTouchListener = object : View.OnTouchListener {
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                val x = event.rawX.toInt()
                val y = event.rawY.toInt()
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_DOWN -> {
                        val lParams = view.layoutParams as FrameLayout.LayoutParams
                        xDelta = x - lParams.leftMargin
                        yDelta = y - lParams.topMargin
                    }

                    MotionEvent.ACTION_MOVE -> {
                        if (x - xDelta + view.width <= container.width
                            && y - yDelta + view.height <= container.height
                            && x - xDelta >= 0
                            && y - yDelta >= 0) {
                            val layoutParams = view.layoutParams as FrameLayout.LayoutParams
                            layoutParams.leftMargin = x - xDelta
                            layoutParams.topMargin = y - yDelta
                            layoutParams.rightMargin = 0
                            layoutParams.bottomMargin = 0
                            view.layoutParams = layoutParams
                            position_pulka_x = x - xDelta
                            position_pulka_y = y - yDelta

                            println("Палка: $position_pulka_x $position_pulka_y")

                            if (position_opora_x - position_doska_x > 80 && position_opora_x - position_doska_x  < 150 &&
                                position_doska_y - position_opora_y > 75 &&  position_doska_y - position_opora_y < 87 &&

                                position_opora_x - position_pulka_x > 153 && position_opora_x - position_pulka_x < 200 &&
                                position_opora_y - position_pulka_y > 178 && position_opora_y - position_pulka_y < 220 &&

                                position_kub_x - position_opora_x > 240 && position_kub_x - position_opora_x < 320 &&
                                position_opora_y - position_kub_y > 50 && position_opora_y - position_kub_y < 110

                            ) {
                                if (txt !in myLayout)
                                    myLayout.addView(txt)

                                if (img_strelka_up !in myLayout && img_strelka_down !in myLayout){
                                    params.setMargins(position_pulka_x - 80,  position_pulka_y, 0, 0)
                                    img_strelka_down.setLayoutParams(params)
                                    myLayout.addView(img_strelka_down)


                                    params1.setMargins( position_kub_x + 210,  position_pulka_y, 0, 0)
                                    img_strelka_up.setLayoutParams(params1)
                                    myLayout.addView(img_strelka_up)
                                }
                            }
                        }
                    }
                }
                container.invalidate()
                return true
            }
        }


        xDelta = 0
        yDelta = 0
        val touchListener_opora: View.OnTouchListener = object : View.OnTouchListener {
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                val x = event.rawX.toInt()
                val y = event.rawY.toInt()
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_DOWN -> {
                        val lParams = view.layoutParams as FrameLayout.LayoutParams
                        xDelta = x - lParams.leftMargin
                        yDelta = y - lParams.topMargin
                    }

                    MotionEvent.ACTION_MOVE -> {
                        if (x - xDelta + view.width <= container.width
                            && y - yDelta + view.height <= container.height
                            && x - xDelta >= 0
                            && y - yDelta >= 0) {
                            val layoutParams = view.layoutParams as FrameLayout.LayoutParams
                            layoutParams.leftMargin = x - xDelta
                            layoutParams.topMargin = y - yDelta
                            layoutParams.rightMargin = 0
                            layoutParams.bottomMargin = 0
                            view.layoutParams = layoutParams
                            position_opora_x = x - xDelta
                            position_opora_y = y - yDelta

                            println("Опора: $position_opora_x $position_opora_y")

                            if (position_opora_x - position_doska_x > 80 && position_opora_x - position_doska_x  < 150 &&
                                position_doska_y - position_opora_y > 75 &&  position_doska_y - position_opora_y < 87 &&

                                position_opora_x - position_pulka_x > 153 && position_opora_x - position_pulka_x < 200 &&
                                position_opora_y - position_pulka_y > 178 && position_opora_y - position_pulka_y < 220 &&

                                position_kub_x - position_opora_x > 240 && position_kub_x - position_opora_x < 320 &&
                                position_opora_y - position_kub_y > 50 && position_opora_y - position_kub_y < 110

                            ) {
                                if (txt !in myLayout)
                                    myLayout.addView(txt)

                                if (img_strelka_up !in myLayout && img_strelka_down !in myLayout){
                                    params.setMargins(position_pulka_x - 80,  position_pulka_y, 0, 0)
                                    img_strelka_down.setLayoutParams(params)
                                    myLayout.addView(img_strelka_down)


                                    params1.setMargins( position_kub_x + 210,  position_pulka_y, 0, 0)
                                    img_strelka_up.setLayoutParams(params1)
                                    myLayout.addView(img_strelka_up)
                                }
                            }
                        }
                    }
                }
                container.invalidate()
                return true
            }
        }

        xDelta = 0
        yDelta = 0
        val touchListener_doska: View.OnTouchListener = object : View.OnTouchListener {
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                val x = event.rawX.toInt()
                val y = event.rawY.toInt()
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_DOWN -> {
                        val lParams = view.layoutParams as FrameLayout.LayoutParams
                        xDelta = x - lParams.leftMargin
                        yDelta = y - lParams.topMargin
                    }

                    MotionEvent.ACTION_MOVE -> {
                        if (x - xDelta + view.width <= container.width
                            && y - yDelta + view.height <= container.height
                            && x - xDelta >= 0
                            && y - yDelta >= 0) {
                            val layoutParams = view.layoutParams as FrameLayout.LayoutParams
                            layoutParams.leftMargin = x - xDelta
                            layoutParams.topMargin = y - yDelta
                            layoutParams.rightMargin = 0
                            layoutParams.bottomMargin = 0
                            view.layoutParams = layoutParams
                            position_doska_x = x - xDelta
                            position_doska_y = y - yDelta

                            println("Доска: $position_doska_x $position_doska_y")

                            if (position_opora_x - position_doska_x > 80 && position_opora_x - position_doska_x  < 150 &&
                                position_doska_y - position_opora_y > 75 &&  position_doska_y - position_opora_y < 87 &&

                                position_opora_x - position_pulka_x > 153 && position_opora_x - position_pulka_x < 200 &&
                                position_opora_y - position_pulka_y > 178 && position_opora_y - position_pulka_y < 220 &&

                                position_kub_x - position_opora_x > 240 && position_kub_x - position_opora_x < 320 &&
                                position_opora_y - position_kub_y > 50 && position_opora_y - position_kub_y < 110

                            ) {
                                if (txt !in myLayout)
                                    myLayout.addView(txt)

                                if (img_strelka_up !in myLayout && img_strelka_down !in myLayout){
                                    params.setMargins(position_pulka_x - 80,  position_pulka_y, 0, 0)
                                    img_strelka_down.setLayoutParams(params)
                                    myLayout.addView(img_strelka_down)


                                    params1.setMargins( position_kub_x + 210,  position_pulka_y, 0, 0)
                                    img_strelka_up.setLayoutParams(params1)
                                    myLayout.addView(img_strelka_up)
                                }
                            }
                        }
                    }
                }
                container.invalidate()
                return true
            }
        }

        img_kub.setOnTouchListener(touchListener_kub)
        img_pulka.setOnTouchListener(touchListener_pulka)
        img_opora.setOnTouchListener(touchListener_opora)
        img_doska.setOnTouchListener(touchListener_doska)
    }
}