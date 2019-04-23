package com.gigya.android.sdk.interruption;

import com.gigya.android.sdk.GigyaLoginCallback;
import com.gigya.android.sdk.api.IApiObservable;
import com.gigya.android.sdk.network.GigyaApiResponse;

public interface IInterruptionsHandler {

    void setEnabled(boolean enabled);

    boolean isEnabled();

    void resolve(GigyaApiResponse apiResponse, IApiObservable observable, final GigyaLoginCallback loginCallback);

}