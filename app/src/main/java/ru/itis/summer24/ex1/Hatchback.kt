package ru.itis.summer24.ex1

class Hatchback(brand: String, model: String, year: Int, madeIn: String, speed: Int, val fuelType: String) :
    Car(brand, model, year, madeIn, speed) {

    override fun toString(): String {
        return super.toString() + "\n" + "Тип топлива: $fuelType"
    }

}