package com.example.tree.workflow.treelist.scene

import com.example.tree.api.RestApi
import com.example.tree.models.Tree
import com.example.tree.models.api.TreeList
import com.example.tree.models.api.toTree
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class TreeListWorker {
    companion object {
        const val BASE_URL = "https://opendata.paris.fr/"
    }

    fun fetchTrees(start: Int, rows: Int, callBack: (List<Tree>?) -> Unit) {
        val httpCallBack = object : Callback<TreeList> {
            override fun onResponse(call: Call<TreeList>, response: Response<TreeList>) {
                when (response.code()) {
                    200 -> {
                        val list = response.body()?.records?.map {
                            it.toTree()
                        }?.toList()
                        callBack(list)
                    }
                    else -> callBack(null)
                }
            }

            override fun onFailure(call: Call<TreeList>, t: Throwable) {
                callBack(null)
            }
        }
        getService().getTrees(start, rows).enqueue(httpCallBack)
    }

    private fun getService(): RestApi {
        val okHttpClientBuilder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        okHttpClientBuilder.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
        return retrofit.create(RestApi::class.java)
    }
}