package com.example.daggerkotlinmvvm_myown.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.daggerkotlinmvvm_myown.R
import com.example.mvvm_mytestgrechkakotlin_3.model.ServerApi
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var serverApi: ServerApi

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var handler: Handler


    private fun subscribe(disposable: Disposable): Disposable {
        compositeDisposable.add(disposable)
        return disposable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribe(mainActivityViewModel.getObject(serverApi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    Log.d("myLogs", "splashUrl =  ${it.splash}")

                    picasso
                            .load(it.splash)
                            .into(imgHello)

                    val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.myalpha)
                    imgHello.startAnimation(anim)

                    handler.postDelayed(Runnable {

                        picasso
                                .load(R.mipmap.ic_launcher)
                                .into(imgHello)

                    }, 3000)


                }, {
                    Toast.makeText(this, "Проверьте интернет соединение !!!", Toast.LENGTH_SHORT).show()
                }))

    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
