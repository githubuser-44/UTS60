package com.example.uts60

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = tambahData()
        prodi_parts.layoutManager = LinearLayoutManager(this)
        prodi_parts.setHasFixedSize(true)
        prodi_parts.adapter =
                ProdiAdapter(testData) { prodiItem: ProdiData -> klikResepItem(prodiItem) }
    }

    private fun klikResepItem(prodiItem: ProdiData) {
        val showDetailActivityIntent = Intent(this, ProdiDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_INTENT, prodiItem.namaFakultas)
        showDetailActivityIntent.putExtra(Intent.EXTRA_INDEX, prodiItem.deskripsiFakultas)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, prodiItem.bulletFakultas)
        showDetailActivityIntent.putExtra(Intent.EXTRA_CHOSEN_COMPONENT, prodiItem.image)
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL, prodiItem.email)
        showDetailActivityIntent.putExtra(Intent.EXTRA_ORIGINATING_URI, prodiItem.web)

        startActivity(showDetailActivityIntent)
    }
}
