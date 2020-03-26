package com.example.uts60

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_prodi_detail.*

class ProdiDetailActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_prodi_detail)

        var intentmain = intent

        if (intentmain.hasExtra(Intent.EXTRA_INTENT)) {
            isitampilan(intentmain)
        }
    }

    private fun isitampilan(intentmain: Intent) {
        var partName = intentmain.getStringExtra(Intent.EXTRA_INTENT)
        var partBahan = intentmain.getStringExtra(Intent.EXTRA_INDEX)
        var partCara = intentmain.getStringExtra(Intent.EXTRA_TEXT)
        var partImage = intentmain.getIntExtra(Intent.EXTRA_CHOSEN_COMPONENT, 0)
        var partEmail = intentmain.getStringExtra(Intent.EXTRA_EMAIL)
        var partWeb = intentmain.getStringExtra(Intent.EXTRA_ORIGINATING_URI)

        tv_nama2.text = partName
        tv_detail_deskripsi.text = partBahan
        tv_detail_bullet.text = partCara
        tv_foto2.contentDescription = partName
        tv_foto2.setImageResource(partImage)

        if (partEmail == "") {
            tv_detail_email.text = ""
            tv_detail_label_email.text = ""
            tv_detail_email.height = 0
            tv_detail_label_email.height = 0
        } else {
            tv_detail_email.text = partEmail
        }
        if (partWeb == "") {
            tv_detail_web.text = ""
            tv_detail_label_web.text = ""
        } else {
            tv_detail_web.text = partWeb
        }

        tv_detail_email.setOnClickListener {
            klikEmail(partEmail)
        }

        tv_detail_web.setOnClickListener {
            klikWeb(partWeb)
        }
    }

    private fun klikEmail(email: String) {
        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email dari aplikasi")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Coba email")

        startActivity(Intent.createChooser(mailIntent, "Pilih Email Client..."))
    }

    private fun klikWeb(url: String) {
        val showWebActivity = Intent(this, ProdiWeb::class.java)
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)

        startActivity(showWebActivity)
    }
}