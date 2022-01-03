package com.example.myclass;

public class SimItem {

    private String mViewSim;
    private String mSimName;

    public SimItem(String viewSim, String simName) {
        mViewSim    = viewSim;
        mSimName = simName;
    }

    public String getSimName() {return mViewSim; }

    public String getViewSim() {return mSimName; }
}

