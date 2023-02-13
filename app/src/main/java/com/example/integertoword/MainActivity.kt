package com.example.integertoword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.integertoword.ui.theme.IntegerToWordTheme
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntegerToWordTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    IntegerToEnglish()
                }
            }
        }
    }
}


fun numberToWords(num: Int): String {

    var number: Int = num
    val LESS_THAN_20 = arrayOf(
        "",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen"
    )
    val TENS = arrayOf(
        "",
        "ten",
        "twenty",
        "thirty",
        "forty",
        "fifty",
        "sixty",
        "seventy",
        "eighty",
        "ninety"
    )

    if (number == 0) return "zero"

    var words = ""
    if (number < 0) {
        words = "minus "
        number *= -1
    }

    if (number < 20) {
        words += LESS_THAN_20[number]
    } else if (number < 100) {
        words += TENS[number / 10]
        if (number % 10 > 0) {
            words += " " + LESS_THAN_20[number % 10]
        }
    } else if (number < 1000) {
        words += numberToWords(number / 100) + " hundred"
        if (number % 100 > 0) {
            words += " and " + numberToWords(number % 100)
        }
    } else if (number < 1000000) {
        words += numberToWords(number / 1000) + " thousand"
        if (number % 1000 > 0) {
            words += " " + numberToWords(number % 1000)
        }
    } else if (number < 1000000000) {
        words += numberToWords(number / 1000000) + " million"
        if (number % 1000000 > 0) {
            words += " " + numberToWords(number % 1000000)
        }
    } else {
        words += numberToWords(number / 1000000000) + " billion"
        if (number % 1000000000 > 0) {
            words += " " + numberToWords(number % 1000000000)
        }
    }
    return words
}

@Composable
fun IntegerToEnglish() {
    var number by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Enter an integer:") }
        )

        TextButton(onClick = {
            val num = number.toIntOrNull()
            if (num != null) {
                result = numberToWords(num)
            } else {
                result = "Please enter a valid integer."
            }
        }) {
            Text("Convert")
        }

        Text(text = result)
    }
}


@Preview
@Composable
fun PreviewIntegerToEnglish() {
    MaterialTheme {
        IntegerToEnglish()
    }
}


