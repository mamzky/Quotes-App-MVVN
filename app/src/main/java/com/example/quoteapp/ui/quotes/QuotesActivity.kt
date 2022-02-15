package com.example.quoteapp.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProviders
import com.example.quoteapp.R
import com.example.quoteapp.data.Quote
import com.example.quoteapp.utilities.InjectorUtils

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
//        val viewModel = ViewModelProviders.of(this, factory)
//            .get(QuotesViewModel::class.java)

        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)
        val btn_add_quote = findViewById<Button>(R.id.button_add_quote)
        val textViewQuotes = findViewById<TextView>(R.id.textView_quotes)
        val editTextQuote = findViewById<EditText>(R.id.editText_quote)
        val editTextAuthor = findViewById<EditText>(R.id.editText_author)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }

            textViewQuotes.text = stringBuilder.toString()
        })


        btn_add_quote.setOnClickListener {
            val quote = Quote(editTextQuote.text.toString(), editTextAuthor.text.toString())
            viewModel.addQuotes(quote)
            editTextAuthor.setText("")
            editTextQuote.setText("")

        }
    }
}