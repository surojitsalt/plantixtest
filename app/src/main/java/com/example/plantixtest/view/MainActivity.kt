package com.example.plantixtest.view

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.Menu
import com.example.plantixtest.R
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantixtest.models.DataModel
import com.example.plantixtest.view.adapter.DataListAdapter
import com.example.plantixtest.viewmodels.DataCollectorVM


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.plantixtest.R.layout.activity_main)

        val vDataCollectorVM: DataCollectorVM = DataCollectorVM(MainActivity@this)
        vDataCollectorVM.loadTexts()
        vDataCollectorVM.getTexts().observe(this, Observer<List<DataModel>>{ pTexts ->
            // update UI
            upDateList(pTexts)
        })
    }

    fun upDateList(pDataList: List<DataModel>){
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerList)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val vAdapter = DataListAdapter(pDataList)
        recyclerview.adapter = vAdapter
        vAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        return when (id) {
            R.id.settings -> {
                val vIntent = Intent(this, SettingsActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, "isMain")
                }
                startActivity(vIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}