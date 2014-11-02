package com.sviat.k.criminalintent.app;

import java.util.UUID;

/**
 * Created by Sviat on 02.11.14.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
}