package com.fadhlanhawali.medijour.Time;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fadhlanhawali.medijour.R;

public class TimeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_time, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);

        return root;
    }
}