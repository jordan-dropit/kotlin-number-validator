package utils

import classes.Country
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber

val phoneUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()

fun attemptNumberValidation(inputNumber: String, country: Country): Pair<Boolean, String> {
    val numberOrError = try {
        phoneUtil.parse(inputNumber, country.code)
    } catch(error: NumberParseException) {
       error.errorType
    }

    return if (numberOrError is PhoneNumber) {
        val finalNumber: String = phoneUtil.format(numberOrError, PhoneNumberFormat.INTERNATIONAL)
        Pair(phoneUtil.isValidNumber(numberOrError), finalNumber)
    } else {
        Pair(false, numberOrError.toString())
    }
}