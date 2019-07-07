package ru.skillbranch.devintensive.extensions

import android.text.Html


fun String.truncate(): String {

    val shortedString= this .substring(0, 16).trimEnd()
    val lastChar = shortedString .takeLast(1)
    if (lastChar ==" ") return shortedString .dropLast(1)+ "..." else return shortedString + "..."

}



fun String.truncate(limit : Int): String {

    val shortedString= this .substring(0, limit).trimEnd()
    val lastChar = shortedString .takeLast(1)
    if (lastChar ==" ") return shortedString .dropLast(1)+ "..." else return shortedString + "..."

}



fun String.stripHtml(): String{
return removeTags(this).replace("&","").replace("\\s+".toRegex(), " ")
}



fun removeTags(`in`: String): String {
    var `in` = `in`
    var index = 0
    var index2 = 0
    while (index != -1) {
        index = `in`.indexOf("<")
        index2 = `in`.indexOf(">", index)
        if (index != -1 && index2 != -1) {
            `in` = `in`.substring(0, index) + `in`.substring(index2 + 1, `in`.length)
        }
    }
    return `in`
}