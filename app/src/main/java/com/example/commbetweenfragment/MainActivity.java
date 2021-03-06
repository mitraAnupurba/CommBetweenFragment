package com.example.commbetweenfragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//main activity implements the interface of fragment class:
public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageReadListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!= null){
            if(savedInstanceState != null){
                return;
            }

            MessageFragment messageFragment = new MessageFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,messageFragment,null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onMessageRead(String message) {
        textView = findViewById(R.id.text_display_message);
        textView.setText(message);
    }
}
