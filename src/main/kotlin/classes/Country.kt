package classes

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("code"      ) var code     : String,
    @SerializedName("name"      ) var name     : String,
    @SerializedName("emoji"     ) var emoji    : String,
    @SerializedName("dial_code" ) var dialCode : String
)