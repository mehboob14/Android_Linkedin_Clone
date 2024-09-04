package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button buttonSet, buttonUpdate, buttonDelete, buttonGet;
    EditText textName, textEmail, textHobby;
    DatabaseReference myRef,myRef1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonSet = findViewById(R.id.setdata);
        buttonUpdate = findViewById(R.id.updatedata);
        buttonDelete = findViewById(R.id.deletedata);
        buttonGet = findViewById(R.id.getdata);

        textName = findViewById(R.id.getname);
        textEmail = findViewById(R.id.Email);
        textHobby = findViewById(R.id.Hobby);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("RatingList");

        myRef1 = database.getReference("Customers");
        myRef1.setValue("Sample Customers");

        buttonSet.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            @Override
            public void onClick(View view) {
                String name = textName.getText().toString();
                String email = textEmail.getText().toString();
                String hobby = textHobby.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !hobby.isEmpty()) {
                    Users user = new Users(name, email, hobby);
                    counter++;
                    myRef.child("user"+counter).child("subuser").setValue(user);
                    Toast.makeText(MainActivity.this, "Data Set Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Users user = dataSnapshot.getValue(Users.class);
                        if (user != null) {
                            textName.setText(user.getName());
                            textEmail.setText(user.getEmail());
                            textHobby.setText(user.getHobby());
                            Toast.makeText(MainActivity.this, "Data Retrieved Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textName.getText().toString();
                String email = textEmail.getText().toString();
                String hobby = textHobby.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !hobby.isEmpty()) {
                    myRef.child("user").child("name").setValue(name);
                    myRef.child("user").child("email").setValue(email);
                    myRef.child("user").child("hobby").setValue(hobby);
                    Toast.makeText(MainActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("user1").removeValue();
                textName.setText("");
                textEmail.setText("");
                textHobby.setText("");
                Toast.makeText(MainActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
