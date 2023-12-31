package com.dand0129.evenodd

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class UIComponents {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Components(Class: IsEven = IsEven()) {
        val inputNumber = remember { mutableStateOf("") }
        val isTrue = remember { mutableStateOf(true) }
        val result = remember { mutableStateOf("") }

        Column {
            TextField(
                value = inputNumber.value,
                onValueChange = {
                    inputNumber.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = result.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                isTrue.value = Class.isEven(inputNumber.value.toInt())
                if (isTrue.value && inputNumber.value != "") {
                    result.value = "The number is even"
                } else if (!isTrue.value && inputNumber.value != "") {
                    result.value = "The number is odd"
                } else {
                    result.value = "Enter a number"
                }
            }
            ) {
                Text(text = "Calculate")
            }
        }

    }

}