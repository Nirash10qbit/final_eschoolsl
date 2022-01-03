package com.example.myclass;

public class SubjectItem {
    private String mViewSubject;
    private String mSubjectName;

    public SubjectItem(String viewSubject, String subjectName) {
        mViewSubject    = viewSubject;
        mSubjectName = subjectName;
    }

    public String getViewSubject() {
        return mViewSubject;
    }

    public String getSubjectName() {
        return mSubjectName;
    }

}
