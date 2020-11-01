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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNickname: EditText = findViewById(R.id.et_nickname)
        val tvNickname: TextView = findViewById(R.id.tv_nickname)
        val btnDone: Button = findViewById(R.id.btn_done)
        btnDone.setOnClickListener {
            tvNickname.text = etNickname.text
            tvNickname.visibility = View.VISIBLE
            etNickname.visibility = View.GONE
            it.visibility = View.GONE
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}