package utils

import classes.Country
import classes.CountryData
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File

fun parseJsonData(filePath: String): List<Country> {
    val bufferedReader: BufferedReader = File(filePath).bufferedReader()
    val inputStr: String = bufferedReader.use { it.readText() }

    val gson = Gson()
    val data = gson.fromJson(inputStr, CountryData::class.java)
    return data.countries
}