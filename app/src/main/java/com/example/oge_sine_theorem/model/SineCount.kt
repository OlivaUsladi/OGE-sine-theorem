package com.example.oge_sine_theorem.model

import kotlin.math.abs
import kotlin.math.sin

fun SineCount(sides: ArrayList<Double>, angles: ArrayList<Double>): ArrayList<Double> {
    //высчитывание третьего угла по двум углам
    if (!(abs(angles[2]) < 0.000001) && !(abs(angles[0]) < 0.000001) && (abs(angles[1]) < 0.000001)){
        angles[1] = 180.0 - angles[0] - angles[2]
    }
    else if (!(abs(angles[2]) < 0.000001) && !(abs(angles[1]) < 0.000001) && (abs(angles[0]) < 0.000001)){
        angles[0] = 180.0 - angles[1] - angles[2]
    }
    else if (!(abs(angles[0]) < 0.000001) && !(abs(angles[1]) < 0.000001) && (abs(angles[2]) < 0.000001)){
        angles[2] = 180.0 - angles[1] - angles[0]
    }

    //теорема синусов
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

    //радиус
    var R = 0.0
    if (!(abs(sides[0])<0.000001) && !(abs(angles[2])<0.0000001)){
        R = sides[0]/(2*sin(Math.toRadians(angles[2])))
    }
    else if (!(abs(sides[1])<0.000001) && !(abs(angles[0])<0.0000001)){
        R = sides[1]/(2*sin(Math.toRadians(angles[0])))
    }
    else if (!(abs(sides[2])<0.000001) && !(abs(angles[1])<0.0000001)){
        R = sides[2]/(2*sin(Math.toRadians(angles[1])))
    }
    val result = ArrayList<Double>()
    result.addAll(sides)
    result.addAll(angles)
    result.add(R)
    return result
}