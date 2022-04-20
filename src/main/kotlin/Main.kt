import classes.Country
import utils.attemptNumberValidation

import utils.getValidInput
import utils.parseJsonData
import configvalues.PathValues
import configvalues.RegexValues


fun selectCountry(search: String, countries: List<Country>): Country {
    val options = countries.filter { it.name.lowercase().contains(search.lowercase()) }
    options.forEachIndexed { index, country ->
        println("${index + 1}.) ${country.name}")
    }
    val selectedCountry = getValidInput("Select a country:", RegexValues.numberPattern).toInt()
    return options[(selectedCountry - 1)]
}

fun main() {
    var countries = parseJsonData(PathValues.jsonPath)
    val countrySearch = getValidInput("Enter country name:", RegexValues.countryNamePattern)
    val selectedCountry = selectCountry(countrySearch, countries)
    val numberSearch = getValidInput(
        "Enter phone number for ${selectedCountry.name}:",
        RegexValues.numberPattern
    )
    val ( isValid, phoneNumber ) = attemptNumberValidation(numberSearch, selectedCountry)
    if (isValid) {
        println("Valid phone number for ${selectedCountry.name}: $phoneNumber")
    } else {
        println("$numberSearch is not a valid number in ${selectedCountry.name}")
    }
}