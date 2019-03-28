package com.example.kineduexample.ui.main;

import com.example.kineduexample.data.network.KineduInteractor;

public class MainPresenter {
    private KineduInteractor interactor;
    private MainView view;

    public MainPresenter(KineduInteractor interactor){
        this.interactor = interactor;
    }

    public void bind(MainView view){
        this.view = view;
    }

    public void unbind(){
        view = null;
    }




}