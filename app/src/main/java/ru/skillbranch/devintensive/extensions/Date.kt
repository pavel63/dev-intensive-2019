package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.utils.Utils
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}


fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}


enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}



fun Date.humanizeDiff(): String {
    val timeDiff = Date().time -this.time

    return when (timeDiff) {
        in 0..999 -> "только что"

        in 1000..44_999 -> "несколько секунд назад"

        in 45_000..75_000 -> "минуту назад"

        in 75_000..2_699_999 -> {
            val strNumb = timeDiff / 60_000
            "$strNumb ${(Utils .numbersDeclination(strNumb.toString(), "minutes"))} назад"
        }

        in 2_700_000..4_499_999 -> "час назад"

        in 4_500_000..79_199_999 -> {
            val strNumb = timeDiff / 3_600_000
            "$strNumb ${(Utils .numbersDeclination(strNumb.toString(), "hours"))} назад"
        }

        in 79_200_000..92_599_999 -> "день назад"

        in 592_600_000..31_103_999_999 -> {
            val strNumb = timeDiff / 86_000_000
            "$strNumb ${(Utils .numbersDeclination(strNumb.toString(), "days"))} назад"
        }

        in 31_104_000_000..Long.MAX_VALUE -> "более года назад"

        else -> ""
    }

}


