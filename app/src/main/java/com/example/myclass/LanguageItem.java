package com.example.myclass;

public class LanguageItem {

    private String mViewLanguage;
    private String mLanguageName;

    public LanguageItem(String viewLanguage, String languageName) {
        mViewLanguage    = viewLanguage;
        mLanguageName = languageName;
    }

    public String getViewLanguage() {
        return mViewLanguage;
    }

    public String getLanguageName() {
        return mLanguageName;
    }

}
