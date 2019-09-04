package com.example.jarvis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*;
class MainActivity : AppCompatActivity() {

    //Text To Speech
    lateinit var mTTS:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                //if there is no error then set language
                mTTS.language = Locale.US
            }
        })

        val second:String=textView2.text.toString()

        mTTS.speak(second, TextToSpeech.QUEUE_FLUSH, null)

        //speak button click
        button.setOnClickListener {
            //get text from edit text
            val toSpeak = editText.text.toString()
            if (toSpeak == ""){
                //if there is no text in edit text

                val se:String=textView3.text.toString()

                mTTS.speak(se, TextToSpeech.QUEUE_FLUSH, null)

                Toast.makeText(this, "Enter text", Toast.LENGTH_SHORT).show()
            }
            else{
                //if there is text in edit text
                Toast.makeText(this, toSpeak, Toast.LENGTH_SHORT).show()
                mTTS.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
            }
        }

        //stop speaking button click
help.setOnClickListener {
    val second:String=textView2.text.toString()

    mTTS.speak(second, TextToSpeech.QUEUE_FLUSH, null)
}
    }


    override fun onPause() {
        if (mTTS.isSpeaking){
            //if speaking then stop
            mTTS.stop()
            //mTTS.shutdown()
        }
        super.onPause()
    }
}


















//class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
//
//
//
//    private var tts: TextToSpeech? = null
//    private var buttonSpeak: Button? = null
//    private var editText: EditText? = null
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        buttonSpeak = this.button
//        editText = this.editText
//
//        buttonSpeak!!.isEnabled = false;
//        tts = TextToSpeech(this, this)
//
//        buttonSpeak!!.setOnClickListener { speakOut() }
//    }
//
//
//    private fun textToSpeechFunction() {
//
//    }
//
//    override fun onInit(status: Int) {
//
//        if (status == TextToSpeech.SUCCESS) {
//            // set US English as language for tts
//            val result = tts!!.setLanguage(Locale.US)
//
//            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                Log.e("TTS","The Language specified is not supported!")
//            } else {
//                buttonSpeak!!.isEnabled = true
//            }
//
//        } else {
//            Log.e("TTS", "Initilization Failed!")
//        }
//
//    }
//    private fun speakOut() {
//        val text = editText!!.text.toString()
//        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
//    }
//    public override fun onDestroy() {
//        // Shutdown TTS
//        if (tts != null) {
//            tts!!.stop()
//            tts!!.shutdown()
//        }
//        super.onDestroy()
//    }
//}




//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.speech.tts.TextToSpeech
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import kotlinx.android.synthetic.main.activity_main.*
//import java.util.*



