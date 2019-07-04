package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val fullNameArray = fullName?.split(" ")

        var firstName = fullNameArray ?.getOrNull(0)
        var lastName = fullNameArray ?.getOrNull(1)

        if(firstName.isNullOrEmpty()) firstName = null
        if(lastName.isNullOrEmpty()) lastName = null

        return Pair(firstName, lastName)
    }




    fun transliteration(cyryllicString: String): String {

        var stringInit = ""

        cyryllicString.forEach {

            val isUpperCase = it.isUpperCase()

            var latCh = when (it.toLowerCase().toString()) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "yo"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                " " -> " "
                else -> ""
            }


            if (isUpperCase) {
                latCh = latCh.toUpperCase()
            }

            stringInit += latCh

        }

        return stringInit
    }








    fun transliteration(cyryllicString: String, connecter : String): String {

        var stringInit = ""

        cyryllicString.forEach {

            val isUpperCase = it.isUpperCase()

            var latCh = when (it.toLowerCase().toString()) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "yo"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                " " -> " "
                else -> ""
            }


            if (isUpperCase) {
                latCh = latCh.toUpperCase()
            }

            stringInit += latCh

        }

        stringInit = stringInit .replace(" ",connecter)

        return stringInit
    }






    fun toInitials(firstName: String?, lastName: String?): String {

        var firstInitial = firstName?. take(1) ?.toUpperCase()
        var lastInitial = lastName?.take(1) ?.toUpperCase()

        if(firstInitial.isNullOrBlank()) firstInitial = null
        if(lastInitial.isNullOrEmpty()) lastInitial = null

        return "$firstInitial$lastInitial"
    }




    fun numbersDeclination(number: String, term: String) :String {
        var myDig = 0

         number .toCharArray() .apply {
             myDig = get(size-1).toString() .toInt()
        }

       return when (term) {
            "minutes" ->
                when (myDig) {
                    in 2..4 -> "минуты"
                    1 -> "минута"
                    else -> "минут"
                }

            "hours" ->
                when (myDig) {
                    in 2..4 -> "часа"
                    1 -> "час"
                    else -> "часов"
               }

            "days" ->
                when (myDig) {
                    in 2..4 -> "дня"
                    1 -> "день"
                    else -> "дней"
               }

            else -> ""
        }

    }


}