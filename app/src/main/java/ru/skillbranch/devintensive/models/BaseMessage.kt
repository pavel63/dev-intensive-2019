package ru.skillbranch.devintensive.models

import java.util.*

 abstract class BaseMessage(
    val id: String,
    var from: User?,
    var chat: Chat,
    val isIncoming : Boolean = false,
    val date: Date = Date()
){
   abstract fun formatMessage():String

    companion object AbstractFactory{

       var lastId = -1

       fun makeMessage(from: User?, chat: Chat, date: Date=Date(),type:String="text", payload : Any, isIncoming :Boolean =false) : BaseMessage{
          lastId++
          return when(type){
             "image"->ImageMessage("$lastId", from ,chat ,false, date=date, image=payload as String)
             else ->TextMessage("$lastId", from ,chat ,false, date=date, text=payload as String)
          }
       }

    }
 }
