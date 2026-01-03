package com.example.oge_sine_theorem.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.oge_sine_theorem.model.SineCount

@Composable
public fun NamePage (navController: NavHostController){
    val A = remember{mutableStateOf("A")}
    val B = remember{mutableStateOf("B")}
    val C = remember{mutableStateOf("C")}

    Column (modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "Введите названия точек треугольника", fontSize = 35.sp, fontStyle = FontStyle.Normal, fontWeight= FontWeight.Bold)
        Spacer(modifier = Modifier.height(50.dp))
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Box(modifier = Modifier.width(100.dp)) {
                TextField(
                    value = A.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> A.value = newText }
                )
            }
            Box(modifier = Modifier.width(100.dp)) {
                TextField(
                    value = B.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> B.value = newText }
                )
            }
            Box(modifier = Modifier.width(100.dp)) {
                TextField(
                    value = C.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> C.value = newText }
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(modifier = Modifier.width(200.dp).height(60.dp).fillMaxWidth().align(Alignment.CenterHorizontally), onClick = {
            navController.navigate("canvasPage"+"/${A.value}/${B.value}/${C.value}")
        }) {  Text(text="Отправить", fontSize = 16.sp, textAlign = TextAlign.Center) }
    }
}

@Composable
fun CanvasPage(navController: NavHostController, A: String, B: String, C: String){
    val textA = rememberTextMeasurer()
    val textB= rememberTextMeasurer()
    val textC = rememberTextMeasurer()

    val Aangle = remember{mutableStateOf("0")}
    val Bangle = remember{mutableStateOf("0")}
    val Cangle = remember{mutableStateOf("0")}

    val AB = remember{mutableStateOf("0")}
    val BC = remember{mutableStateOf("0")}
    val AC = remember{mutableStateOf("0")}

    val ADouble = remember{mutableStateOf(0.0)}
    val BDouble = remember{mutableStateOf(0.0)}
    val CDouble = remember{mutableStateOf(0.0)}

    val ABDouble = remember{mutableStateOf(0.0)}
    val BCDouble = remember{mutableStateOf(0.0)}
    val ACDouble = remember{mutableStateOf(0.0)}

    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(50.dp))
        Canvas(Modifier.size(300.dp).background(Color.LightGray)) {
            val height = size.height
            val width = size.width
            drawLine(
                start = Offset(x = width / 2, y = 0f),
                end = Offset(x = width / 2 - 300, y = height / 2),
                color = Color.Blue,
                strokeWidth = 12.0f
            )
            drawText(textA, A, topLeft = Offset(x = width / 2, y = 0f) - Offset(70f, 0f))
            drawLine(
                start = Offset(x = width / 2 - 300, y = height / 2),
                end = Offset(x = width / 2 + 300, y = height / 2),
                color = Color.Blue,
                strokeWidth = 12.0f
            )
            drawText(
                textB,
                B,
                topLeft = Offset(x = width / 2 - 300, y = height / 2) - Offset(20f, 0f)
            )
            drawLine(
                start = Offset(x = width / 2 + 300, y = height / 2),
                end = Offset(x = width / 2, y = 0f),
                color = Color.Blue,
                strokeWidth = 12.0f
            )
            drawText(
                textC,
                C,
                topLeft = Offset(x = width / 2 + 300, y = height / 2) + Offset(10f, 0f)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Column {
                Text(text="$A$B", fontSize = 14.sp)
                TextField(
                    modifier = Modifier.width(100.dp),
                    value = AB.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> AB.value = newText }
                )
            }
            Column {
                Text(text="$B$C", fontSize = 14.sp)
                TextField(
                    modifier = Modifier.width(100.dp),
                    value = BC.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> BC.value = newText }
                )
            }
            Column {
                Text(text="$A$C", fontSize = 14.sp)
                TextField(
                    modifier = Modifier.width(100.dp),
                    value = AC.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> AC.value = newText }
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Column {
                Text(text="угол $A", fontSize = 14.sp)
                TextField(
                    modifier = Modifier.width(100.dp),
                    value = Aangle.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> Aangle.value = newText }
                )
            }
            Column {
                Text(text="угол $B", fontSize = 14.sp)
                TextField(
                    modifier = Modifier.width(100.dp),
                    value = Bangle.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> Bangle.value = newText }
                )
            }
            Column {
                Text(text="угол $C", fontSize = 14.sp)
                TextField(
                    modifier = Modifier.width(100.dp),
                    value = Cangle.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText -> Cangle.value = newText }
                )
            }
        }
        Button(onClick = {
            if (AB.value.contains(".") || AB.value.contains(",")){
                AB.value.replace(",", ".")
                ABDouble.value = AB.value.toDouble()
            }
            else if (AB.value.contains("/")){
                val ab = AB.value.split("/")
                ABDouble.value = ab[0].toDouble()/ab[1].toDouble()
            }
            else{
                ABDouble.value = AB.value.toDouble()
            }

            if (BC.value.contains(".") || BC.value.contains(",")){
                BC.value.replace(",", ".")
                BCDouble.value = BC.value.toDouble()
            }
            else if (BC.value.contains("/")){
                val bc = BC.value.split("/")
                BCDouble.value = bc[0].toDouble()/bc[1].toDouble()
            }
            else{
                BCDouble.value = BC.value.toDouble()
            }

            if (AC.value.contains(".") || AC.value.contains(",")){
                AC.value.replace(",", ".")
                ACDouble.value = AC.value.toDouble()
            }
            else if (AC.value.contains("/")){
                val ac = AC.value.split("/")
                ACDouble.value = ac[0].toDouble()/ac[1].toDouble()
            }
            else{
                ACDouble.value = AC.value.toDouble()
            }

            ADouble.value = Aangle.value.toDouble()
            BDouble.value = Bangle.value.toDouble()
            CDouble.value = Cangle.value.toDouble()

            val sides = ArrayList<Double>()
            val angles = ArrayList<Double>()
            sides.add(ABDouble.value)
            sides.add(BCDouble.value)
            sides.add(ACDouble.value)

            angles.add(ADouble.value)
            angles.add(BDouble.value)
            angles.add(CDouble.value)

            val result = SineCount(sides, angles)
            println(result)
        }) {
            Text("Проверить")
        }
    }

}

@Composable
fun ResultPage(result: ArrayList<Double>, A: String, B: String, C: String){

}