package com.example.kineduexample.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.example.kineduexample.R
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    private var dialog: AlertDialog? = null

    fun setProgressDialog(message: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.progress_dialog_layout, null)
        val tvMessage = dialogView.findViewById<TextView>(R.id.tvMessage)
        tvMessage.text = message
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        dialog = dialogBuilder.create()
    }

    fun hideProgressDialog() {
        if (dialog!!.isShowing)
            dialog!!.dismiss()
    }

    fun showProgressDialog() {
        dialog!!.show()
    }
}
