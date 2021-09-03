package id.uviwi.qrcodescanner

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val intent = intent.getStringExtra("result")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = intent
        val imageCopy = findViewById<ImageView>(R.id.imageView)
        imageCopy.setOnClickListener {
            val text = textView.text.toString()
            copyTextToClipboard(text)
        }
    }
    private fun copyTextToClipboard(textToCopy : String) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}