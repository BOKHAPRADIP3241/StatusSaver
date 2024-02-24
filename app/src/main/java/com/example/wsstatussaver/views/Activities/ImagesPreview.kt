package com.example.wsstatussaver.views.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wsstatussaver.Models.MediaModel
import com.example.wsstatussaver.Utils.Constants
import com.example.wsstatussaver.databinding.ActivityImagesPreviewBinding
import com.example.wsstatussaver.views.Adapters.ImagePreviewAdapter


class ImagesPreview : AppCompatActivity() {
    private val activity = this
    private val binding by lazy {
        ActivityImagesPreviewBinding.inflate(layoutInflater)
    }
    lateinit var adapter: ImagePreviewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            val list =
                intent.getSerializableExtra(Constants.MEDIA_LIST_KEY) as ArrayList<MediaModel>
            val scrollTo = intent.getIntExtra(Constants.MEDIA_SCROLL_KEY, 0)
            adapter = ImagePreviewAdapter(list, activity)
            imagesViewPager.adapter = adapter
            imagesViewPager.currentItem = scrollTo
        }

    }
}