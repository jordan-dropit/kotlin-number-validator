package utils

import classes.Country
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber

val phoneUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()

fun attemptNumberValidation(inputNumber: String, country: Country): Pair<Boolean, String> {
    lateinit var formattedNumber: PhoneNumber
    try {
        formattedNumber = phoneUtil.parse(inputNumber, country.code)
    } catch(error: NumberParseException) {
        println("Failed to parse number: ${error.toString()}")
    }

    val finalNumber: String = phoneUtil.format(formattedNumber, PhoneNumberFormat.INTERNATIONAL)

    return Pair(phoneUtil.isValidNumber(formattedNumber), finalNumber)
}