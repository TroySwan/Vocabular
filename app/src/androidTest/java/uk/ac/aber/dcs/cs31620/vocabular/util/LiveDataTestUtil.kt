package uk.ac.aber.dcs.cs31620.vocabular.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Code from FAA by Chris Loftus which is:
 * Code adapted from: https://proandroiddev.com/testing-the-un-testable-and-beyond-with-android-architecture-components-part-1-testing-room-4d97dec0f451
 * which in turn is similar to a gist from a medium post from a year prior, see: https://gist.github.com/chandilsachin/d928ef1c70e893f716377d31e5c5e820#file-fooddatabasetest-kt
 * in which the author writes he "copied it from stack overflow" amsuing how far a little block of code can travel and where it goes.
 * When something works, it works and people should use it if it does not define a product to a level of infringement.
 * After so much time one would think this would have been made part of some package and abstracted away from the dev writing tests.
 */
object LiveDataTestUtil {
    fun <T>getValue(liveData: LiveData<T>): T {
        val data: MutableList<T?> = MutableList(1){null}
        val latch = CountDownLatch(1)
        val observer: Observer<T> = object : Observer<T> {
            override fun onChanged(o: T) {
                data[0] = o
                latch.countDown()
                liveData.removeObserver(this)
            }
        }
        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)

        return data[0]!!
    }
}