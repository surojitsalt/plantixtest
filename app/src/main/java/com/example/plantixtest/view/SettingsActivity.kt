package com.example.plantixtest.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.example.plantixtest.R
import com.example.plantixtest.utility.GenericUtility

class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        return when (id) {
            R.id.up -> {
                finish()
                true
            }
            R.id.done -> {
                saveData()
                finish()
                true
            }
            else -> {
                finish()
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun loadData(){
        var etText = SettingsActivity@this.findViewById<EditText>(R.id.etText)
        if(GenericUtility.mServerAddress != null && GenericUtility.mServerAddress != "") {
            etText.setText(GenericUtility.mServerAddress)
        }
    }

    private fun saveData(){
        var etText = SettingsActivity@this.findViewById<EditText>(R.id.etText)
        if(etText.text != null && etText.text.toString() != "") {
            GenericUtility.mServerAddress = etText.text.toString()
        }
    }
}