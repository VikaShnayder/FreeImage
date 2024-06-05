package com.example.freeimage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.freeimage.retrofit.ClientApi
import com.example.freeimage.retrofit.Image
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private lateinit var spinner: Spinner
    private lateinit var search_color: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.images_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        spinner = findViewById(R.id.spinner)
        search_color = findViewById(R.id.search_color)
        updateImagesList()

        search_color.setOnClickListener(){
            updateImagesList()
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        updateImagesList()
    }

    internal var itemListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemClick(view: View, position: Int) {
            val images = adapter.getItemAtPosition(position)
            val intent = Intent(this@MainActivity, FullImageActivity::class.java)
            intent.putExtra(EXTRA_PREWIEWURL, images.previewURL)
            intent.putExtra(EXTRA_TAGS, images.tags)
            intent.putExtra(EXTRA_USER, images.user)
            intent.putExtra(EXTRA_USERIMAGEURL, images.userImageURL)
            startActivityForResult(intent, EDIT_TASK_ACTIVITY_REQUEST_CODE)
        }
    }
    interface RecyclerItemListener {
        fun onItemClick(v: View, position: Int)
    }
    companion object {
        val EXTRA_PREWIEWURL = "MainActivity.EXTRA_PREWIEWURL"
        val EXTRA_TAGS = "MainActivity.EXTRA_TAGS"
        val EXTRA_USER = "MainActivity.EXTRA_USER"
        val EXTRA_USERIMAGEURL = "MainActivity.EXTRA_USERIMAGEURL"

        const val EDIT_TASK_ACTIVITY_REQUEST_CODE = 1
    }
    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS) // время ожидания подключения
        .readTimeout(30, TimeUnit.SECONDS)    // время ожидания чтения
        .writeTimeout(30, TimeUnit.SECONDS)   // время ожидания записи
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pixabay.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
    private lateinit var list: List<Image>
    val clientApi = retrofit.create(ClientApi::class.java)
    val API_KEY = "44234611-61bd91faec11ec6631f07c268"

    fun updateImagesList() {

        CoroutineScope(Dispatchers.Default).launch {
            try {
                val imageResponse = clientApi.getImageByColors(API_KEY,spinner.selectedItem.toString())
                Log.d(TAG, "11111Request URL: ${imageResponse}")

                runOnUiThread {
                    list = imageResponse.items ?: emptyList()
                    Log.d(TAG, "Number of images received: ${list.size}")

                    // Логирование каждого элемента списка
                    list.forEach { image ->
                        Log.d(TAG, "Image: $image")
                    }

                    adapter = MainAdapter(list, itemListener, this@MainActivity)
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                    Log.d(TAG, "Adapter set with ${list.size} items")
                }
                Log.d(TAG, "Response received: $imageResponse")
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching images", e)
            }
            Log.d(TAG, "Request URL: ${retrofit.baseUrl()}?key=$API_KEY")
        }
    }


}