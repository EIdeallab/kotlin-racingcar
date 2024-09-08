package com.racingCar.mainKt

fun main(args : Array<String>) {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = readlnOrNull()?.split(",")?: listOf()
    val races: MutableMap<String, Int> = cars.associateWith { 0 }.toMutableMap()

    println("시도할 회수는 몇회인가요?")
    val count = readlnOrNull()?.toInt()?: 0

    println("실행 결과")
    for (i in 0 until count) {
        for (race in races) {
            val range = kotlin.random.Random.nextInt(0, 10)
            val add = when(range) {
                in 4..9 -> 1
                else -> 0
            }
            race.setValue(race.value + add)
            print(race.key + " : ")
            for (j in 0 until race.value) {
                print("-")
            }
            println()
        }
        println()
    }

    val maxValue = races.values.maxOrNull()
    val maxKeys = races.filter { it.value == maxValue }.keys

    println("최종 우승자 : " + maxKeys.joinToString(", "))
}