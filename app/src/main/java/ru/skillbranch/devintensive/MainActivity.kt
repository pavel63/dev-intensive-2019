package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.extensions.hideKeyboard
import ru.skillbranch.devintensive.models.Bender


fun EditText .onClickKeyboardDoneButton(funExecute: () -> Unit) {
    this.setOnEditorActionListener { _, actionId, _ ->
        when (actionId) {
            EditorInfo.IME_ACTION_DONE -> {
                funExecute.invoke()
                true
            }
            else -> false
        }
    }
}




class MainActivity : AppCompatActivity() {

    private var status : String ?= null
    private var benderColor : Triple<Int,Int,Int> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       textHeader.text = Bender().askQuestion()

        et_message?.onClickKeyboardDoneButton { myFunctionToExecuteWhenUserClickDone() }

    }




   private fun myFunctionToExecuteWhenUserClickDone() {

       this.hideKeyboard()

        val (first, second) = Bender().listenAnswer(et_message ?.text.toString())

       status = first
       benderColor = second

      populateWiews(status ,benderColor)

    }




    private fun populateWiews(innerStatus : String?, innerColor: Triple<Int,Int,Int>?){
        textHeader ?.text = innerStatus
        benderImage ?.setColorFilter(Color.rgb(innerColor?.first ?:256, innerColor?.second?:256 ,innerColor?.third?:256), PorterDuff.Mode.MULTIPLY)
    }




    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState .putString("STATUS" ,status)
       // outState .putString("QUESTION")
        outState .putSerializable("COLOR", benderColor)
    }





    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        status = savedInstanceState .getString("STATUS" ,status)
        benderColor = savedInstanceState .getSerializable("COLOR")as? Triple<Int, Int, Int>

       populateWiews(status ,benderColor)

    }


    }

