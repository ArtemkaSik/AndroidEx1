package ru.itis.summer24.ex1

class Crossover(brand: String, model: String, year: Int, madeIn: String, speed: Int, val driveType: String, val enginePower: Int) :
    Car(brand, model, year, madeIn, speed) {

    override fun toString(): String {
        return super.toString() + "\n" + "Тип привода: $driveType"
    }

}