package br.com.jvjp.dictionmaster.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import br.com.jvjp.dictionmaster.R
import br.com.jvjp.dictionmaster.fragment.MyFragment

class SearchActivity : AppCompatActivity(), MyFragment.Result {
    private lateinit var choice_text: TextView
    private lateinit var eng_icon: ImageView
    private lateinit var edit_text_word: TextView
    private lateinit var button_search: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        inacilize()

    }

    fun callAlert() {
        val myFragment: MyFragment = MyFragment()
        myFragment.show(supportFragmentManager, "my_fragment")
        myFragment.flag(eng_icon,choice_text)
    }

    fun selectLang(v: View) {
        callAlert()
    }


    override fun onResult(image: ImageView, text: TextView) {
        choice_text = text
        eng_icon = image
    }

    fun inacilize() {
        choice_text = findViewById(R.id.choice_text)
        eng_icon = findViewById(R.id.flag_icon)
        edit_text_word = findViewById(R.id.edit_text_word)
        button_search = findViewById(R.id.button_search)
        edit_text_word.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                apareceButao()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                apareceButao()
            }

            override fun afterTextChanged(ps: Editable?) {
                apareceButao()
            }

        })
        val str = edit_text_word.text.toString().trim()




        button_search.setOnClickListener {


        }


    }
    fun apareceButao(){
        if (edit_text_word.length() != 0 && edit_text_word.text.isNotEmpty()){
            button_search.visibility = View.VISIBLE
        }else{
            button_search.visibility = View.INVISIBLE
        }
    }

}