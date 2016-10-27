package com.iamhabib.easy_preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.Set;

/**
 * Created by HABIB on 10/27/2016.
 */

public class EasyPreference {

    public static Builder with(Context context) {
        return new Builder(context);
    }

    public static class Builder {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        Context context;

        public Builder(Context context) {
            this.context = context;
            preferences = context.getSharedPreferences("EasyPreferencePref", Context.MODE_PRIVATE);
            editor = preferences.edit();
        }

        public Builder addBoolean(String key, boolean value) {
            editor.putBoolean(key, value);
            return this;
        }

        public Builder addString(String key, String value) {
            editor.putString(key, value);
            return this;
        }

        public Builder addInt(String key, int value) {
            editor.putInt(key, value);
            return this;
        }

        public Builder addFloat(String key, float value) {
            editor.putFloat(key, value);
            return this;
        }

        public Builder addLong(String key, long value) {
            editor.putLong(key, value);
            return this;
        }

        public Builder addStringSet(String key, Set<String> value) {
            editor.putStringSet(key, value);
            return this;
        }

        public Builder addObject(String key, Object value) {
            Gson gson = new Gson();
            editor.putString(key, gson.toJson(value));
            return this;
        }

        public Builder save() {
            editor.commit();
            return this;
        }

        public boolean getBoolean(String key, boolean defalutValue) {
            return preferences.getBoolean(key, defalutValue);
        }

        public String getString(String key, String defalutValue) {
            return preferences.getString(key, defalutValue);
        }

        public int getInt(String key, int defalutValue) {
            return preferences.getInt(key, defalutValue);
        }

        public float getFloat(String key, float defalutValue) {
            return preferences.getFloat(key, defalutValue);
        }

        public long getLong(String key, long defalutValue) {
            return preferences.getLong(key, defalutValue);
        }

        public Set<String> getStringSet(String key, Set<String> defalutValue) {
            return preferences.getStringSet(key, defalutValue);
        }

        public <GenericClass> GenericClass getObject(String key, Class<GenericClass> classType) {
            if (preferences.contains(key)) {
                Gson gson = new Gson();
                return gson.fromJson(preferences.getString(key, ""), classType);
            }
            return null;
        }

        public Builder remove(String key) {
            editor.remove(key);
            return this;
        }

        public Builder clearAll() {
            editor.clear();
            return this;
        }
    }
}
