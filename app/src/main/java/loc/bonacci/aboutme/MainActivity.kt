package loc.bonacci.aboutme

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import loc.bonacci.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Bonacci Bigollo")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName
        binding.btnDone.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View?) {
        binding.apply {
//            tvNickname.text = binding.etNickname.text
            myName?.nickname = etNickname.text.toString()
            invalidateAll()
            view?.visibility = View.GONE
            etNickname.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE
        }
        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}