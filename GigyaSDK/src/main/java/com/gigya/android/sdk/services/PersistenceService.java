package com.gigya.android.sdk.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gigya.android.sdk.GigyaDefinitions;

import java.util.HashSet;
import java.util.Set;

/**
 * Service for accessing Gigya context specific shared preference persistence.
 */
public class PersistenceService {

    /*
     * File key for SDK preferences persistence.
     */
    private static final String PREFS_FILE_KEY = "GSLIB";

    /*
     * Value key for Session persistence.
     */
    private static final String PREFS_KEY_SESSION = "GS_PREFS";

    /**
     * Value key for last used social providers.
     */
    private static final String PREFS_KEY_PROVIDER_SET = "GS_PROVIDER_SET";

    @NonNull
    private SharedPreferences _prefs;

    public PersistenceService(Context appContext) {
        _prefs = appContext.getSharedPreferences(PREFS_FILE_KEY, Context.MODE_PRIVATE);
    }

    //region Object access.

    /**
     * Check element availability by given key.
     *
     * @param key Specified key.
     * @return True if available.
     */
    public boolean contains(String key) {
        return _prefs.contains(key);
    }

    /**
     * Request a String object from persistence.
     *
     * @param key      Specified key.
     * @param fallback Fallback String value.
     * @return String requested or fallback value if not available.
     */
    @Nullable
    public String getString(String key, @Nullable String fallback) {
        return _prefs.getString(key, fallback);
    }

    /**
     * Request a Long object from persistence.
     *
     * @param key      Specified key.
     * @param fallback Fallback long value.
     * @return long requested or fallback value if not available.
     */
    public long getLong(String key, @NonNull Long fallback) {
        return _prefs.getLong(key, fallback);
    }

    /**
     * Add String element to persistence given key value.
     *
     * @param key     Specified key.
     * @param element String element to persist.
     */
    public void add(String key, String element) {
        _prefs.edit().putString(key, element).apply();
    }

    /**
     * Remove multiple String elements from persistence.
     *
     * @param keys Specified keys (varargs).
     */
    public void remove(String... keys) {
        final SharedPreferences.Editor editor = _prefs.edit();
        for (String key : keys) {
            editor.remove(key);
        }
        editor.apply();
    }

    //endregion

    // Session specific.

    public void setSession(String encrypted) {
        add(PREFS_KEY_SESSION, encrypted);
    }

    @Nullable
    public String getSession() {
        return getString(PREFS_KEY_SESSION, null);
    }

    void clearSession() {
        remove(PREFS_KEY_SESSION);
    }

    boolean hasSession() {
        return contains(PREFS_KEY_SESSION);
    }

    //endregion

    //region Social providers

    /**
     * Get all used social providers.
     *
     * @return Set<String> of user used social providers.
     */
    @Nullable
    public Set<String> getSocialProviders() {
        return _prefs.getStringSet(PREFS_KEY_PROVIDER_SET, null);
    }

    /**
     * Track social providers used.
     *
     * @param provider Social provider descriptor {@link GigyaDefinitions.Providers.SocialProvider}.
     */
    public void addSocialProvider(@GigyaDefinitions.Providers.SocialProvider String provider) {
        Set<String> providerSet = getSocialProviders();
        if (providerSet == null) {
            providerSet = new HashSet<>();
        }
        providerSet.add(provider);
        _prefs.edit().putStringSet(PREFS_KEY_PROVIDER_SET, providerSet).apply();
    }

    //endregion
}