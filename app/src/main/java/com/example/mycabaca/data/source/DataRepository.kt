//package com.example.mycabaca.data.source
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.example.mycabaca.data.source.local.LocalRepository
//import com.example.mycabaca.data.source.remote.RemoteRepository
//import com.example.mycabaca.data.source.remote.response.genre.Genre
//import javax.security.auth.callback.Callback
//
//class DataRepository(private val localRepos: LocalRepository, private val remoteRepos: RemoteRepository): /*DataSource*/ {
//
////    companion object{
////        @Volatile
////        private var INSTANCE : DataRepository? = null
////
////        fun getInstance(localRepos: LocalRepository, remoteRepos: RemoteRepository): DataRepository?{
////            if (INSTANCE == null){
////                synchronized(DataRepository::class.java){
////                    if (INSTANCE == null){
////                        INSTANCE = DataRepository(localRepos, remoteRepos)
////                    }
////                }
////            }
////            return INSTANCE
////        }
////    }
////
////    override fun getGenre(): LiveData<List<Genre>> {
////        val genreList = MutableLiveData<List<Genre>>()
////        remoteRepos.getGenre(object : RemoteRepository.GetGenreCallBack{
////            override fun onResponse(genreResponse: List<Genre>) {
////                genreList.postValue(genreResponse)
////            }
////
////            override fun onErrorResponse() {
////                null
////            }
////        })
////        return genreList
////    }
////
//
//}