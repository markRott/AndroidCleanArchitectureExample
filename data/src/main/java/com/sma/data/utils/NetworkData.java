package com.sma.data.utils;

/**
 * Created by sma on 09.09.17.
 */

public final class NetworkData {

    public final boolean hasInternetConnection;
    public final boolean isMobileConnection;

    public NetworkData(final boolean hasInternetConnection, final boolean isMobileConnection) {

        this.hasInternetConnection = hasInternetConnection;
        this.isMobileConnection = isMobileConnection;
    }
}