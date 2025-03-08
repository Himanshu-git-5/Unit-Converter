package com.example.myunitconverter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun UnitConverter(){

    var inputvalue by remember { mutableStateOf("") }
    var outputvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("Meter") }
    var outputunit by remember { mutableStateOf("Meter") }
    var iexpand by remember { mutableStateOf(false) }
    var oexpand by remember { mutableStateOf(false) }
    val conversionfactor = remember { mutableStateOf(1.0) }
    val oconversionfactor = remember { mutableStateOf(1.0) }

    fun converunit(){
        // ?: - elvis operator
        val inputvalueNumber = inputvalue.toDoubleOrNull() ?: 0.0
        val result = (inputvalueNumber * conversionfactor.value * 100.0/ oconversionfactor.value).roundToInt() /100.0
        outputvalue = result.toString()
    }

    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter",
            fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputvalue,
            onValueChange = {
                inputvalue = it
                converunit()
                //Here goes what should happen ,when the value of our Oun
            },
            label = { Text(text = "Enter value") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //input box
            Box( Modifier.wrapContentSize() ){
                //input button
                Button(onClick = { iexpand =true }) {
                    Text(inputunit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iexpand, onDismissRequest = { iexpand=false }) {
                    DropdownMenuItem(text = { Text("Kilometer") },
                        onClick = {
                            iexpand = false
                            inputunit = "Kilometer"
                            conversionfactor.value = 1000.0
                            converunit()
                        })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            iexpand=false
                            inputunit="Meters"
                            conversionfactor.value =1.0
                            converunit()
                        })
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            iexpand=false
                            inputunit="Centimeter"
                            conversionfactor.value =0.01
                            converunit()
                        })
                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            iexpand = false
                            inputunit = "Millimeter"
                            conversionfactor.value = 0.001
                            converunit()
                        })
                    DropdownMenuItem(
                        text = { Text("Micrometer") },
                        onClick = {
                            iexpand = false
                            inputunit = "Micrometer"
                            conversionfactor.value = 0.000001
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Nanometer") },
                        onClick = {
                            iexpand = false
                            inputunit = "Nanometer"
                            conversionfactor.value = 0.000000001
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Mile") },
                        onClick = {
                            iexpand = false
                            inputunit = "Mile"
                            conversionfactor.value = 1609.34
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Yard") },
                        onClick = {
                            iexpand = false
                            inputunit = "Yard"
                            conversionfactor.value = 0.9144
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            iexpand = false
                            inputunit = "Feet"
                            conversionfactor.value = 0.3048
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Inches") },
                        onClick = {
                            iexpand = false
                            inputunit = "Inches"
                            conversionfactor.value = 0.0254
                            converunit()
                        })
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            //output box
            Box(Modifier.wrapContentSize()){
                //output button
                Button(onClick = { oexpand=true }) {
                    Text(outputunit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oexpand, onDismissRequest = { oexpand=false }) {
                    DropdownMenuItem(text = { Text("Kilometer") }, onClick = {
                        oexpand = false
                        outputunit = "Kilometer"
                        oconversionfactor.value = 1000.0
                        converunit()
                    })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            oexpand=false
                            outputunit="Meters"
                            oconversionfactor.value =1.0
                            converunit()
                        })
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            oexpand=false
                            outputunit="Centimeter"
                            oconversionfactor.value =0.01
                            converunit()
                        })
                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            oexpand = false
                            outputunit = "Millimeter"
                            oconversionfactor.value = 0.001
                            converunit()
                        })
                    DropdownMenuItem(
                        text = { Text("Micrometer") },
                        onClick = {
                            oexpand = false
                            outputunit = "Micrometer"
                            oconversionfactor.value = 0.000001
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Nanometer") },
                        onClick = {
                            oexpand = false
                            outputunit = "Nanometer"
                            oconversionfactor.value = 0.000000001
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Mile") },
                        onClick = {
                            oexpand = false
                            outputunit = "Mile"
                            oconversionfactor.value = 1609.34
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Yard") },
                        onClick = {
                            oexpand = false
                            outputunit = "Yard"
                            oconversionfactor.value = 0.9144
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            oexpand = false
                            outputunit = "Feet"
                            oconversionfactor.value = 0.3048
                            converunit()
                        })
                    DropdownMenuItem(text = { Text("Inches") },
                        onClick = {
                            oexpand = false
                            outputunit = "Inches"
                            oconversionfactor.value = 0.0254
                            converunit()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: ${outputvalue} ${outputunit}",
            fontSize = 16.sp)
    }

}

