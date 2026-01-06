package com.example.oge_sine_theorem.model

import androidx.compose.runtime.MutableState
import kotlin.math.abs
import kotlin.math.asin
import kotlin.math.sin

fun SineCount(sides: ArrayList<Double>, angles: ArrayList<Double>, sins: ArrayList<Double>, R: MutableState<Double>): ArrayList<Double> {

   //чистая теорема синусов (даны только синусы, без углов)
    if ((abs(sides[0])<0.000001) && !(abs(sins[0])<0.000001) && !(abs(sins[2])<0.000001) && !(abs(sides[1])<0.000001)){
        sides[0] = (sides[1] * sins[2])/sins[0]
    }
    else if ((abs(sides[0])<0.000001) && !(abs(sins[1])<0.000001) && !(abs(sins[2])<0.000001) && !(abs(sides[2])<0.000001)){
        sides[0] = (sides[2] * sins[2])/sins[1]
    }

    if ((abs(sides[0])<0.000001) && !(abs(sins[0])<0.000001) && !(abs(sins[2])<0.000001) && !(abs(sides[1])<0.000001)){
        sides[0] = (sides[1] * sins[2])/sins[0]
    }
    else if ((abs(sides[0])<0.000001) && !(abs(sins[1])<0.000001) && !(abs(sins[2])<0.000001) && !(abs(sides[2])<0.000001)){
        sides[0] = (sides[2] * sins[2])/sins[1]
    }

    //подсчёт синусы+стороны+углы
    if (!(abs(sins[0])<0.000001) || !(abs(sins[1])<0.000001) || !(abs(sins[2])<0.000001)){
        if (!(abs(sins[0])<0.000001) && !(abs(sides[1])<0.000001)){
            if (!(abs(sides[0])<0.000001) && (abs(angles[2])<0.000001)){
                angles[2] = Math.toDegrees(asin((sides[0] * sins[0])/sides[1]))
            }
            else if ((abs(sides[0])<0.000001) && !(abs(angles[2])<0.000001)){
                sides[0] = (sin(Math.toRadians(angles[2]))*sides[1])/sins[1]
            }

            if (!(abs(sides[2])<0.000001) && (abs(angles[1])<0.000001)){
                angles[1] = Math.toDegrees(asin((sides[2] * sins[0])/sides[1]))
            }
            else if ((abs(sides[2])<0.000001) && !(abs(angles[1])<0.000001)){
                sides[2] = (sin(Math.toRadians(angles[1]))*sides[1])/sins[1]
            }
        }
        if (!(abs(sins[1])<0.000001) && !(abs(sides[2])<0.000001)){
            if (!(abs(sides[1])<0.000001) && (abs(angles[0])<0.000001)){
                angles[0] = Math.toDegrees(asin((sides[1] * sins[1])/sides[2]))
            }
            else if ((abs(sides[1])<0.000001) && !(abs(angles[0])<0.000001)){
                sides[1] = (sin(Math.toRadians(angles[0]))*sides[2])/sins[1]
            }

            if (!(abs(sides[0])<0.000001) && (abs(angles[2])<0.000001)){
                angles[2] = Math.toDegrees(asin((sides[0] * sins[1])/sides[2]))
            }
            else if ((abs(sides[0])<0.000001) && !(abs(angles[2])<0.000001)){
                sides[0] = (sin(Math.toRadians(angles[2]))*sides[2])/sins[1]
            }
        }
        if (!(abs(sins[2])<0.000001) && !(abs(sides[0])<0.000001)){
            if (!(abs(sides[1])<0.000001) && (abs(angles[0])<0.000001)){
                angles[0] = Math.toDegrees(asin((sides[1] * sins[2])/sides[0]))
            }
            else if ((abs(sides[1])<0.000001) && !(abs(angles[0])<0.000001)){
                sides[1] = (sin(Math.toRadians(angles[0]))*sides[0])/sins[2]
            }

            if (!(abs(sides[2])<0.000001) && (abs(angles[1])<0.000001)){
                angles[1] = Math.toDegrees(asin((sides[2] * sins[2])/sides[0]))
            }
            else if ((abs(sides[2])<0.000001) && !(abs(angles[1])<0.000001)){
                sides[2] = (sin(Math.toRadians(angles[1]))*sides[0])/sins[2]
            }
        }

    }
    //углы
    if (abs(angles[2])<0.000001){
        if (!(abs(sides[0])<0.00001) && !(abs(angles[0])<0.00001) && !(abs(sides[1])<0.000001)){
            angles[2] = Math.toDegrees(asin((sides[0]*sin(Math.toRadians(angles[0])))/sides[1]))
        }
        else if (!(abs(sides[0])<0.00001) && !(abs(angles[1])<0.00001) && !(abs(sides[2])<0.000001)){
            angles[2] = Math.toDegrees(asin((sides[0]*sin(Math.toRadians(angles[1])))/sides[2]))
        }
    }
    if (abs(angles[1])<0.000001){
        if (!(abs(sides[1])<0.00001) && !(abs(angles[0])<0.00001) && !(abs(sides[2])<0.000001)){
            angles[1] = Math.toDegrees(asin((sides[2]*sin(Math.toRadians(angles[0])))/sides[1]))
        }
        else if (!(abs(sides[0])<0.00001) && !(abs(angles[2])<0.00001) && !(abs(sides[2])<0.000001)){
            angles[1] = Math.toDegrees(asin((sides[2]*sin(Math.toRadians(angles[2])))/sides[0]))
        }
    }
    if (abs(angles[0])<0.000001){
        if (!(abs(sides[1])<0.00001) && !(abs(angles[1])<0.00001) && !(abs(sides[2])<0.000001)){
            angles[0] = Math.toDegrees(asin((sides[1]*sin(Math.toRadians(angles[1])))/sides[2]))
        }
        else if (!(abs(sides[0])<0.00001) && !(abs(angles[2])<0.00001) && !(abs(sides[1])<0.000001)){
            angles[0] = Math.toDegrees(asin((sides[1]*sin(Math.toRadians(angles[2])))/sides[0]))
        }
    }

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