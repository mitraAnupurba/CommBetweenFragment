package com.example.commbetweenfragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText editText;
    private Button button;

    //call back for the interface:
    OnMessageReadListener messageReadListener;

    public MessageFragment() {
        // Required empty public constructor
    }

    //interface created for button on click listener:
    public interface OnMessageReadListener
    {
        public void onMessageRead(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        editText = view.findViewById(R.id.text_message_entered);
        button = view.findViewById(R.id.bn);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //when the user tymes a message and clicks send, the message is stored here:
                String message = editText.getText().toString();

                //pass the message to the interface:
                messageReadListener.onMessageRead(message);
            }
        });
        return view;
    }

    //to check if the interface is created by the parent activity: onAttach is a lifecycle method of fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity)context;
        //get the callback for the inteerface:
        try{
            messageReadListener = (OnMessageReadListener)activity;
        }
        catch(ClassCastException e){
            throw new ClassCastException(activity.toString()+"    must override on main");
        }

    }
}
