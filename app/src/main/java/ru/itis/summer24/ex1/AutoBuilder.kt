package ru.itis.summer24.ex1

class AutoBuilder(val brand: String) {
    private var model: String = ""
    private var year: Int = 0
    private var madeIn: String = ""
    private var speed: Int = 0

    fun setModel(model: String): AutoBuilder {
        this.model = model
        return this
    }

    fun setYear(year: Int): AutoBuilder {
        this.year = year
        return this
    }

    fun setMadeIn(madeIn: String): AutoBuilder {
        this.madeIn = madeIn
        return this
    }

    fun setSpeed(speed: Int): AutoBuilder {
        this.speed = speed
        return this
    }

    fun build(): Car {
        return Car(brand, model, year, madeIn, speed)
    }
}