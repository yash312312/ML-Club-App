package com.example.mlclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignIn extends AppCompatActivity {
    AutoCompleteTextView dropdown;
    Button button;
    TextView name,scholarid,phoneno;
    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    FirebaseFirestore db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        db = FirebaseFirestore.getInstance();
        name=findViewById(R.id.name);
        scholarid=findViewById(R.id.scholarid);
        phoneno=findViewById(R.id.phone);
        dropdown = findViewById(R.id.drop);
        user=FirebaseAuth.getInstance().getCurrentUser();
        String[] items = new String[]{"CSE", "ECE", "CIVIL", "MECHANICAL", "E&I"};
        name.setText(user.getEmail());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, items);
        dropdown.setAdapter(adapter);
        button = findViewById(R.id.press);
        final Intent intent = new Intent(this, MainScreen.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadToDatabase();
            }
        });

    }
    public boolean isValid(String scholarid,String phoneno,String branch,String[] items){
        if (scholarid.length()!=7){
            Toast.makeText(this, "Invalid Scholar ID", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(phoneno.length()!=10){
            Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        boolean k=false;
        int year=Integer.parseInt(scholarid.substring(0,2));
        if(year<14){
            Toast.makeText(this, "Invalid Scholar ID", Toast.LENGTH_SHORT).show();
            return false;
        }
        for (int i=0;i<6;i++){
            if (items[i].equals(branch)){
                k=true;
            }
        }
        return k;
    }
    public void uploadToDatabase(){
        String em=user.getEmail();
        String nm=name.getText().toString();
        String sch=scholarid.getText().toString();
        String ph=phoneno.getText().toString();
        String br=dropdown.getText().toString();
        //String name, String scholarid, String phoneno, String email, String branch
        Student student=new Student(nm,sch,ph,em,br);
        db.collection("users").document(em).set(student);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.apply();
    }
}
