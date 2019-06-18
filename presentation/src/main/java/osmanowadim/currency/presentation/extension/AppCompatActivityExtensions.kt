package osmanowadim.currency.presentation.extension

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import osmanowadim.currency.presentation.R

fun AppCompatActivity.snackbar(view: View, message: Int) = Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()

fun AppCompatActivity.animateChangingActivitySlideRight() = overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)

fun AppCompatActivity.animateChangingActivitySlideLeft() = overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_left)
