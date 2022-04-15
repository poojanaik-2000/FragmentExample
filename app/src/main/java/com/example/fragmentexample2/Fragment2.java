package com.example.fragmentexample2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private EditText editText;
    private Button button;

    private Fragment2Listener listener;

    public interface Fragment2Listener{
        void onInput2sent(String input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment1,container,false);
        editText=v.findViewById(R.id.edit_text);
        button=v.findViewById(R.id.button_ok);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                listener.onInput2sent(input);
            }
        });

        return v;
    }

    public void updateEditText(CharSequence newText)
    {
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Fragment2Listener)
        {
            listener=(Fragment2Listener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()+"must implement Fragment2Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;

    }
}
