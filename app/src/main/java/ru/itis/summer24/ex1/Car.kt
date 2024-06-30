package ru.itis.summer24.ex1

open class Car(val brand: String, val model: String, val year: Int, val madeIn: String, val speed: Int) {

    private val info: String = "Данные о машине:\n Марка: $brand\n Модель: $model\n Год выпуска: $year\n Сделано: $madeIn\n Мощность двигателя: $speed л.с."

    override fun toString(): String = info

}
