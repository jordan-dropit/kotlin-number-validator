import classes.Country
import utils.attemptNumberValidation

import utils.getValidInput
import utils.parseJsonData
import java.nio.file.Paths

val countryNamePattern: Regex = Regex("^\\p{L}+(?: \\p{L}+)*\$")
val numberPattern: Regex = Regex("[0-9 ]+")

val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
val resourcesPath = Paths.get(projectDirAbsolutePath, "/src/main/resources")
val jsonPath = "$resourcesPath/countries.json"

fun selectCountry(search: String, countries: List<Country>): Country {
    val options = countries.filter { it.name.lowercase().contains(search.lowercase()) }
    options.forEachIndexed { index, country ->
        println("${index + 1}.) ${country.name}")
    }
    val selectedCountry = getValidInput("Select a country:", numberPattern).toInt()
    return options[(selectedCountry - 1)]
}

fun main() {
    var countries = parseJsonData(jsonPath)
    val countrySearch = getValidInput("Enter country name:", countryNamePattern)
    val selectedCountry = selectCountry(countrySearch, countries)
    val numberSearch = getValidInput(
        "Enter phone number for ${selectedCountry.name}:",
        numberPattern
    )
    val ( isValid, phoneNumber ) = attemptNumberValidation(numberSearch, selectedCountry)
    if (isValid) {
        println("Valid phone number for ${selectedCountry.name}: $phoneNumber")
    } else {
        println("$numberSearch is not a valid number in ${selectedCountry.name}")
    }
}