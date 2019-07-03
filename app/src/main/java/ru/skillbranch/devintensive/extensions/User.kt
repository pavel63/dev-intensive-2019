package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User .toUserView() : UserView {
    /**returns in translite*/
   // val nickname = Utils.transliteration("$firstName $lastName)
    /**return initials*/
    val initials = Utils.toInitials(firstName ,lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if(isOnline ) "online" else  "Последнний раз был${lastVisit .humanizeDiff()}"

return UserView(
    id,
    fullName = "$firstName $lastName",
    avatar= avatar,
    nickName="",
    initials = initials,
    status = status)
    }


