package com.web.saude.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.Toast
import com.web.saude.R
import com.web.saude.model.SampleSearchModel
import ir.mirrajabi.searchdialog.core.SearchResultListener
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat



class MainActivity : AppCompatActivity() {

    private var buttonSeach: FloatingActionButton? = null

    private fun createSampleData(): ArrayList<SampleSearchModel> {
        val items = ArrayList<SampleSearchModel>()
        items.add(SampleSearchModel("First item"))
        items.add(SampleSearchModel("Second item"))
        items.add(SampleSearchModel("Third item"))
        items.add(SampleSearchModel("The ultimate item"))
        items.add(SampleSearchModel("Last item"))
        items.add(SampleSearchModel("Lorem ipsum"))
        items.add(SampleSearchModel("Dolor sit"))
        items.add(SampleSearchModel("Some random word"))
        items.add(SampleSearchModel("guess who's back"))
        return items
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSeach = findViewById<FloatingActionButton>(R.id.search)

        buttonSeach!!.setOnClickListener{
            SimpleSearchDialogCompat(this@MainActivity, "Search...",
                    "What are you looking for...?", null, createSampleData(),
                    SearchResultListener { dialog, item, position ->
                        Toast.makeText(this@MainActivity, item.title,
                                Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                        val intent = Intent(this, ItemDetailActivity::class.java)
                        startActivity(intent)
                    }).show()
        }
    }
}
