package com.vpdevs.snackbardemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_snackBar_default.setOnClickListener {
            showDefaultSnackBar(it)
        }

        button_snackBar_clicked.setOnClickListener {
            showCallBackSnackBar(it)
        }

        button_snackBar_custom.setOnClickListener {
            showCustomChangesSnackBar(it)
        }
    }

    private fun showDefaultSnackBar(view: View) {
        Snackbar
            .make(view, resources.getString(R.string.sb_default), Snackbar.LENGTH_LONG)
            .setAction("Undo") {
                textView_snackBar_status.text = resources.getString(R.string.sb_clicked)
            }
            .show()
    }

    private fun showCallBackSnackBar(view: View) {
        Snackbar
            .make(view, resources.getString(R.string.sb_action), Snackbar.LENGTH_LONG)
            .addCallback(object : Snackbar.Callback() {
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    textView_snackBar_status.text = resources.getString(R.string.sb_status_dismiss)
                }

                override fun onShown(sb: Snackbar?) {
                    super.onShown(sb)
                    textView_snackBar_status.text = resources.getString(R.string.sb_status_show)
                }
            })
            .show()
    }

    private fun showCustomChangesSnackBar(view: View) {
        Snackbar
            .make(view, resources.getString(R.string.sb_custom), Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(this@MainActivity, android.R.color.holo_green_dark))
            .setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.darker_gray))
            .show()
    }
}
