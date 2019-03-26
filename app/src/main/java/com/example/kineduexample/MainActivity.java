package com.example.kineduexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.kineduexample.api.KineduInteractor;
import com.example.kineduexample.api.KineduInteractorImpl;
import com.example.kineduexample.entities.DataActivities;
import com.example.kineduexample.interfaces.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    KineduInteractor interactor;
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interactor = new KineduInteractorImpl();
        presenter = new MainPresenter(interactor);
        presenter.bind(this);

        presenter.searchActivities();
    }

    @Override
    public void updateUI(DataActivities activities) {
        Log.d("Result", activities.toString());
    }

    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }
}
