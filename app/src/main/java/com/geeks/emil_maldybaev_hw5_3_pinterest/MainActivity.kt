package com.geeks.emil_maldybaev_hw5_3_pinterest

import android.net.DnsResolver.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geeks.emil_maldybaev_hw5_3_pinterest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var adapter = ImageAdapter(arrayListOf())
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        binding.recyclerView.adapter = adapter

    }

    private fun initClickers() {
        with(binding) {
            btnNextPage.setOnClickListener {
                page++
                getImages(page)
            }
            btnSearch.setOnClickListener {
                getImages(1)
            }
        }
    }
    private fun ActivityMainBinding.getImages(page: Int){
        RetrofitService().api.getImages(etWord.text.toString(),page = page)
            .enqueue(object : retrofit2.Callback<PixaModel> {
                override fun onResponse(
                    call: Call<PixaModel>,
                    response: Response<PixaModel>
                ) {
                    if (response.isSuccessful) {

                        response.body()?.let {
                            adapter.addNewImages(it.hits as ArrayList<ImageModel>)
                        }
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }


}