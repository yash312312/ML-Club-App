package com.example.mlclub;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    private TextView name,phoneno,scholarid,branch;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.profile,container,false);
        name=view.findViewById(R.id.name);
        phoneno=view.findViewById(R.id.phone);
        scholarid=view.findViewById(R.id.scholarid);
        branch=view.findViewById(R.id.branch2);
        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("X", 0);
        name.setText(name.getText()+settings.getString("name", "Name"));
        phoneno.setText(phoneno.getText()+settings.getString("phoneno", "Phone Number"));
        scholarid.setText(scholarid.getText()+settings.getString("scholarid", "ScholarID"));
        branch.setText(branch.getText()+settings.getString("branch", "branch"));
        return view;
    }
}
