package com.example.freeimage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.net.URI

private const val TAG = "FullImageActivity"

class FullImageActivity : AppCompatActivity() {
    private lateinit var imageViewPhoto: ImageView
    private lateinit var imageViewUser: ImageView
    private lateinit var textViewUserName: TextView
    private lateinit var textViewLikes: TextView
    private lateinit var textViewViews: TextView
    private lateinit var textViewDownloads: TextView
    private lateinit var textViewComments: TextView
    private lateinit var textViewTags: TextView
    private lateinit var textViewType: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val intent = getIntent()
        val previewURL = intent.getStringExtra(MainActivity.EXTRA_PREWIEWURL) ?: ""
        val user = intent.getStringExtra(MainActivity.EXTRA_USER) ?: ""
        val userImageURL = intent.getStringExtra(MainActivity.EXTRA_USERIMAGEURL) ?: ""
        val tags = intent.getStringExtra("tags") ?: ""
        val type = intent.getStringExtra(MainActivity.EXTRA_TYPE) ?: ""
        val likes = intent.getStringExtra(MainActivity.EXTRA_LIKES) ?: ""
        val downloads = intent.getStringExtra(MainActivity.EXTRA_DOWNLOADS) ?: ""
        val comments = intent.getStringExtra(MainActivity.EXTRA_COMMENTS) ?: ""
        val views = intent.getStringExtra(MainActivity.EXTRA_VIEWS) ?: ""

        Log.d(TAG, "intent1= ${intent.getStringExtra(MainActivity.EXTRA_PREWIEWURL)}")
        Log.d(TAG, "intent2= ${intent.getStringExtra(MainActivity.EXTRA_USERIMAGEURL)}")

        imageViewPhoto = findViewById(R.id.image_view)
        imageViewUser = findViewById(R.id.user_image)
        textViewUserName = findViewById(R.id.user_name)
        textViewViews = findViewById(R.id.number_view)
        textViewDownloads = findViewById(R.id.number_download)
        textViewComments = findViewById(R.id.number_comment)
        textViewTags = findViewById(R.id.tags)
        textViewLikes = findViewById(R.id.number_likes)
        textViewType = findViewById(R.id.type)

        try {
            if (previewURL.isEmpty()) {
                imageViewPhoto.setImageDrawable(getDrawable(R.drawable.baseline_image_24))
            } else {
                Glide.with(this)
                    .load(previewURL)
                    .into(imageViewPhoto)
            }
            if (userImageURL.isEmpty()) {
                imageViewUser.setImageDrawable(getDrawable(R.drawable.baseline_person_24))
            } else {
                Glide.with(this)
                    .load(userImageURL)
                    .into(imageViewUser)
            }
            textViewUserName.setText(user)
            textViewViews.setText(views)
            textViewLikes.setText(likes)
            textViewDownloads.setText(downloads)
            textViewComments.setText(comments)
            textViewTags.setText(tags)
            textViewType.setText(type)
        }catch (e: Exception) {
            Log.e(TAG, "Error getting information for images", e)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    /*companion object {
        const val SEARCH_ACTIVITY_REQUEST_CODE = 2
        const val EXTRA_PREWIEWURL = "EXTRA_PREWIEWURL"
        const val EXTRA_USER = "EXTRA_USER"
        const val EXTRA_USERIMAGEURL = "EXTRA_USERIMAGEURL"
        const val EXTRA_TAGS = "EXTRA_TAGS"
        const val EXTRA_LIKES = "EXTRA_LIKES"
        const val EXTRA_DOWNLOADS = "EXTRA_DOWNLOADS"
        const val EXTRA_COMMENTS = "EXTRA_COMMENTS"
        const val EXTRA_VIEWS = "EXTRA_VIEWS"
        const val EXTRA_TYPE = "EXTRA_TYPE"
    }*/
}