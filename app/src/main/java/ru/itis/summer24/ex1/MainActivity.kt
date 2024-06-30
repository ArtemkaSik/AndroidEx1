package ru.itis.summer24.ex1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import ru.itis.summer24.ex1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var viewBinding: ActivityMainBinding? = null

    private var cars: MutableList<Car> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)

        enterNumber()
        start()
    }

    private fun start(){
        viewBinding?.apply {
            button.setOnClickListener{
                var round = 1
                while (cars.size > 1) {
                    conductRace(round)
                    round++
                }

                // Display the winner in the console
                if (cars.isNotEmpty()) {
                    println("Winner: ${cars[0].brand}")
                }
            }
        }
    }

    private fun enterNumber(){
        viewBinding?.apply{
            count.doOnTextChanged { text, start, before, count ->
                if(!text.isNullOrEmpty()){
                    val numCars = text.toString().toInt()
                    button.isEnabled = true
                    createCars(numCars)
                } else {
                    button.isEnabled = false
                }
            }
        }
    }

    private fun createCars(numCars: Int) {
        for (i in 1..numCars) {
            val car = AutoBuilder("Brand $i")
                .setModel("Model $i")
                .setYear(Random.nextInt(1990, 2023))
                .setSpeed(Random.nextInt(100, 250))
                .setMadeIn("Country $i")
                .build()
            cars.add(car)
        }
    }

    fun race(car1: Car, car2: Car): Car {
        return if (car1.speed > car2.speed) car1 else car2
    }

    private fun conductRace(round: Int) {
        val winners: MutableList<Car> = mutableListOf()
        var index = 0

        while (index < cars.size) {
            val car1 = cars[index]
            val car2 = if (index + 1 < cars.size) cars[index + 1] else null

            if (car2 != null) {
                val winner = race(car1, car2)
                winners.add(winner)
                println("--- Race ${car1.brand} and ${car2.brand}, Winner - ${winner.brand}")
            } else {
                winners.add(car1)
                println("--- ${car1.brand} - No enemy, next race")
            }

            index += 2
        }

        cars.clear()
        cars.addAll(winners)
    }


    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}