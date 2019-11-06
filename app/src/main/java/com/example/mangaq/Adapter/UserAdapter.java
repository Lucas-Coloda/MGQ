package com.example.mangaq.Adapter;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;

import com.example.mangaq.R;

public class UserAdapter {

    @BindingAdapter("userAdapter")
    public static void changeTextColor(TextView view, Integer likes) {
        Context context = view.getContext();
        int color = 0;

        view.setTextColor(color);
    }
}