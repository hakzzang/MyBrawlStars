package com.hbs.mybrawlstars.ui.main

import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.hbs.mybrawlstars.core.BaseActivity
import com.hbs.mybrawlstars.databinding.ActivityMainBinding
import com.hbs.mybrawlstars.domain.remote.api.ApiResult
import com.hbs.mybrawlstars.model.BrawlStarsPlayer
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    val mainViewModel by viewModels<MainViewModel>()

    override fun bindBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun isUseTransition(): Boolean = true

    override fun transitionLogic() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            window.sharedElementsUseOverlay = false
            setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeMainViewModel(binding, mainViewModel)
    }

    private fun observeMainViewModel(binding: ActivityMainBinding, mainViewModel: MainViewModel){
        mainViewModel.playerInformation.observe(this, Observer{
            showPlayerInformation(binding, it)
        })
    }

    private fun showPlayerInformation(binding: ActivityMainBinding, apiResult: ApiResult<BrawlStarsPlayer>){
        binding.tvInformationApiTest.text = when(apiResult){
            is ApiResult.Loading ->{
                "LOADING"
            }
            is ApiResult.Success->{
                apiResult.status.name
            }
            is ApiResult.Error ->{
                apiResult.status.name
            }
            is ApiResult.Fail->{
                apiResult.throwable.message
            }
            is ApiResult.InternalError->{
                apiResult.status.name
            }
        }
    }
}