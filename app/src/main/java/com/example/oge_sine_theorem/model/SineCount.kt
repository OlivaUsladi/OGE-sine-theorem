package com.example.oge_sine_theorem.model

import kotlin.math.abs
import kotlin.math.sin

fun SineCount(sides: ArrayList<Double>, angles: ArrayList<Double>): ArrayList<Double> {
    if (abs(sides[0]) < 0.000001){
        if (!(abs(sides[1]) < 0.000001) && !(abs(angles[2]) < 0.000001) && !(abs(angles[0]) < 0.000001)){
            sides[0]=(sides[1]* sin(Math.toRadians(angles[2])))/sin(Math.toRadians(angles[0]))
        }
        else if (!(abs(sides[2]) < 0.000001) && !(abs(angles[2]) < 0.000001) && !(abs(angles[1]) < 0.000001)){
            sides[0]=(sides[2]* sin(Math.toRadians(angles[2])))/sin(Math.toRadians(angles[1]))
        }
    }
    if (abs(sides[1]) < 0.000001){
        if (!(abs(sides[0]) < 0.000001) && !(abs(angles[2]) < 0.000001) && !(abs(angles[0]) < 0.000001)){
            sides[1]=(sides[0]* sin(Math.toRadians(angles[0])))/sin(Math.toRadians(angles[2]))
        }
        else if (!(abs(sides[2]) < 0.000001) && !(abs(angles[0]) < 0.000001) && !(abs(angles[1]) < 0.000001)){
            sides[1]=(sides[2]* sin(Math.toRadians(angles[0])))/sin(Math.toRadians(angles[1]))
        }
    }
    if (abs(sides[2]) < 0.000001){
        if (!(abs(sides[1]) < 0.000001) && !(abs(angles[1]) < 0.000001) && !(abs(angles[0]) < 0.000001)){
            sides[2]=(sides[1]* sin(Math.toRadians(angles[1])))/sin(Math.toRadians(angles[0]))
        }
        else if (!(abs(sides[0]) < 0.000001) && !(abs(angles[2]) < 0.000001) && !(abs(angles[1]) < 0.000001)){
            sides[2]=(sides[0]* sin(Math.toRadians(angles[1])))/sin(Math.toRadians(angles[2]))
        }
    }
    val result = ArrayList<Double>()
    result.addAll(sides)
    result.addAll(angles)
    return result
}