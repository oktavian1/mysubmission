//package com.example.mycabaca.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.mycabaca.data.source.remote.RemoteRepository
//import com.example.mycabaca.di.Injection
//import java.lang.IllegalArgumentException
//
//@Suppress("UNCHECKED_CAST")
//class ViewModelFactory(private val remote: RemoteRepository): ViewModelProvider.NewInstanceFactory() {
//
//    companion object{
//        @Volatile
//        private var INSTANCE : ViewModelFactory? = null
//
//        fun getInstance(): ViewModelFactory? {
//            if (INSTANCE == null){
//                synchronized(ViewModelFactory::class.java){
//                    if (INSTANCE == null){
//                        INSTANCE =
//                    }
//                }
//            }
//            return INSTANCE
//        }
//    }
//
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return when{
//            modelClass.isAssignableFrom(GenreViewModel::class.java) -> {
//                return GenreViewModel(remote) as T
//            }
//            else -> throw IllegalArgumentException("error view model " + modelClass.name)
//        }
//    }
//
//}