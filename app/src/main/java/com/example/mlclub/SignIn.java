package com.example.mlclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class SignIn extends AppCompatActivity {
    AutoCompleteTextView dropdown;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_sign_in);
       /* val items = listOf("Material", "Design", "Components", "Android")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)*/
       dropdown=findViewById(R.id.drop);
        String[] items = new String[]{"CSE", "ECE", "CIVIL","MECHANICAL","E&I"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        button=findViewById(R.id.press);
        final Intent intent=new Intent(this,MainScreen.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}
