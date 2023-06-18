package com.example.worldsofart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.widget.*

class DetailMuseumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_museum)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val museum = intent.getParcelableExtra<Museum>(MainActivity.INTENT_PARCELABLE)

        val imgmuseum = findViewById<ImageView>(R.id.img_item_photo)
        val namemuseum = findViewById<TextView>(R.id.tv_item_name)
        val descmuseum = findViewById<TextView>(R.id.tv_item_description)
        val more = findViewById<Button>(R.id.moree)

        more.setOnClickListener {
            val url = museum?.url!!
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }



        imgmuseum.setImageResource(museum?.imgmuseum!!)
        namemuseum.text = museum.namemuseum
        descmuseum.text = museum.descmuseum
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}