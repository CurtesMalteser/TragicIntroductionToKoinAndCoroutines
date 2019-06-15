package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    private val myViewModel: MyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel.fetchRepos()

        myViewModel.repoListLiveData.observe(this, Observer {
            it?.let { repoList ->
               repoList.forEach {repo ->
                   Timber.d("repo -> $repo")
               }
            }
        })

    }
}
