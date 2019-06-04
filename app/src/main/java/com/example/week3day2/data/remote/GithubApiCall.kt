package com.example.week3day2.data.remote

import com.example.week3day2.common.BASE_URL
import com.example.week3day2.model.Repos
import com.example.week3day2.model.User
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GithubApiCall {

    @GET
    fun getuser(@Url query: String): Deferred<User>


    @GET
    fun getUUser(@Url user:String): Deferred<User>



    @GET("users/{username}/repos")
    fun getrepos(@Path("username") username: String): Deferred<List<Repos>>



companion object{
        fun create(): GithubApiCall{
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder().addCallAdapterFactory(
                RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build()

            return retrofit.create(GithubApiCall::class.java)

        }
    }
}