package com.acadview.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button sendBtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference messageReference;
    ListView listView;

    ArrayList<String> messageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =  findViewById(R.id.editText);
        sendBtn = findViewById(R.id.sendBtn);
        listView = findViewById(R.id.listView);


        messageData = new ArrayList<>();

//        1
        firebaseDatabase = FirebaseDatabase.getInstance();
//        2
        messageReference = firebaseDatabase.getReference("message");

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = editText.getText().toString().trim();

                if(userMessage.length() == 0){
                    return;
                }

                messageReference.setValue(userMessage);

            }
        });

        messageReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String receiveMessage = dataSnapshot.getValue(String.class);

                messageData.add(receiveMessage);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,messageData);
                listView.setAdapter(adapter);

                Toast.makeText(MainActivity.this,receiveMessage,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {



            }
        });



    }
}
