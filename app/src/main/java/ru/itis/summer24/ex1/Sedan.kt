package ru.itis.summer24.ex1

class Sedan(brand: String, model: String, year: Int, madeIn: String, speed: Int, val trunkCapacity: Int) :
    Car(brand, model, year, madeIn, speed) {

    override fun toString(): String {
        return super.toString() + "\n" + "Объем багажника: $trunkCapacity литров"
    }
}