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


    public Integer getSelectedSpinnerValue(String value) {
        try{
            if(value.contains("0-1 MONTH")){
                return 1;
            }
            return Integer.valueOf(value.replace("MONTH", "").replace("S", "").replace("ALL","").trim());
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
