package com.example.kineduexample.ui.base;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.kineduexample.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private AlertDialog dialog;

    public void setProgressDialog(String message) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.progress_dialog_layout, null);
        TextView tvMessage = dialogView.findViewById(R.id.tvMessage);
        tvMessage.setText(message);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        dialog = dialogBuilder.create();
    }

    public void hideProgressDialog() {
        if(dialog.isShowing())
            dialog.dismiss();
    }

    public void showProgressDialog(){
        dialog.show();
    }
}
