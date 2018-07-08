package com.web.saude.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.web.saude.R
import com.web.saude.fragments.ItemDetailFragment
import kotlinx.android.synthetic.main.activity_item_detail.*


class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (savedInstanceState == null) {
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ItemDetailFragment.ARG_ITEM_ID,
                            intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }


        val imageMapView = findViewById<ImageView>(R.id.image_map)
        Glide.with(applicationContext)
//        &markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284
                .load("https://maps.googleapis.com/maps/api/staticmap?center=-15.80078,-47.9577013&zoom=12&size=600x300&maptype=roadmap")
                .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(imageMapView)
    }

//    override fun onOptionsItemSelected(item: MenuItem) =
//            when (item.itemId) {
//                android.R.id.home -> {
//
//                    navigateUpTo(Intent(this, MainActivity::class.java))
//                    true
//                }
//                else -> super.onOptionsItemSelected(item)
//            }


    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, PagerActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        return true
    }
}
