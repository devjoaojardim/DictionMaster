package br.com.jvjp.dictionmaster.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Application
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import br.com.jvjp.dictionmaster.R
import br.com.jvjp.dictionmaster.view.SearchActivity

open class MyFragment : DialogFragment() {
    private lateinit var buttonEng: LinearLayout
    private lateinit var buttonEsp: LinearLayout
    private lateinit var buttonFra: LinearLayout

    private lateinit var choice_text: TextView
    private lateinit var eng_icon: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onSaveInstanceState(outState: Bundle) {

    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view: View = requireActivity().layoutInflater.inflate(R.layout.my_dialog, null)
        val vi: View = requireActivity().layoutInflater.inflate(R.layout.activity_search, null)


        this.buttonEng = view.findViewById(R.id.button_eng)
        this.buttonEsp = view.findViewById(R.id.button_esp)
        this.buttonFra = view.findViewById(R.id.button_fra)

        eng_icon = vi.findViewById(R.id.flag_icon)
        choice_text = vi.findViewById(R.id.choice_text)


        val alert = AlertDialog.Builder(activity)
        alert.setView(view)


        this.buttonEng.setOnClickListener {
            eng_icon.setImageResource(R.drawable.eng_icon)
            choice_text.text = R.string.english.toString()
            flag(eng_icon,choice_text)
            dismiss()
        }
        this.buttonEsp.setOnClickListener {
            eng_icon.setImageResource(R.drawable.espn_icon1)
            choice_text.text = R.string.spanish.toString()
            flag(eng_icon,choice_text)
            dismiss()


        }
        this.buttonFra.setOnClickListener {

            eng_icon.setImageResource(R.drawable.franc_icon)
            choice_text.text = R.string.french.toString()
            flag(eng_icon,choice_text)
            dismiss()
        }



        return alert.create()
    }

    fun flag(i: ImageView, t: TextView){
        val image = i
        val text = t

    }
    interface Result {
        fun onResult(image: ImageView, text: TextView)

    }


}
