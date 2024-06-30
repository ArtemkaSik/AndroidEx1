package ru.itis.summer24.ex1

class Сonvertible(brand: String, model: String, year: Int, madeIn: String, speed: Int, val closingRoofAbility: Boolean, val accelerationTime: Double) :
    Car(brand, model, year, madeIn, speed) {

    override fun toString(): String {
        return super.toString() + "\n" + "Время разгона до максимальной скорости: $accelerationTime" + "\n" +  "Возможность закрыть крышу: ${if (closingRoofAbility) "есть" else "отсутствует"}"
    }

}