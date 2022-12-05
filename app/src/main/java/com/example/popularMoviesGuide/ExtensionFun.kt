package com.example.popularMoviesGuide

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.makeToast(textResource: Int) {
    Toast.makeText(
        this,
        textResource,
        Toast.LENGTH_LONG
    ).show()
}

fun Fragment.makeToast(textResource: Int) {
    Toast.makeText(
        requireActivity(),
        textResource,
        Toast.LENGTH_LONG
    ).show()

}