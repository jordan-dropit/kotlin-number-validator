package configvalues

import java.nio.file.Paths

object PathValues {
    private val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
    private val resourcesPath = Paths.get(projectDirAbsolutePath, "/src/main/resources")
    val jsonPath = "$resourcesPath/countries.json"
}

object RegexValues {
    val countryNamePattern: Regex = Regex("^\\p{L}+(?: \\p{L}+)*\$")
    val numberPattern: Regex = Regex("[0-9 ]+")
}