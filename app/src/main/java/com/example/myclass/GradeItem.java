package com.example.myclass;

public class GradeItem {
    private String mViewName;
    private String mGradeName;

    public GradeItem(String viewName, String gradeName) {
        mViewName = viewName;
        mGradeName = gradeName;
    }

    public String getViewName() {
        return mViewName;
    }

    public String getGradeName() {
        return mGradeName;
    }
}