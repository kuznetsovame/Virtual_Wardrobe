package com.example.virtualwardrobe.screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.virtualwardrobe.R;


public class ConstractClothes extends Fragment {

    private TextView save;
    private EditText name;
    private EditText des;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
      @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_constract_clothes, container, false);
        name = root.findViewById(R.id.et_name);
        des = root.findViewById(R.id.et_description);
        radioGroup = root.findViewById(R.id.et_description);
        rb1 = root.findViewById(R.id.rb1);
        rb2 = root.findViewById(R.id.rb2);
        rb3 = root.findViewById(R.id.rb3);


        save = root.findViewById(R.id.add);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() || des.getText().toString().isEmpty() || !radioGroup.isSelected())
                {
                    Toast.makeText(getContext(),"Заполните все поля!", Toast.LENGTH_SHORT);
                    return;
                }

                int k;
                if(rb1.isSelected())
                    k = 1;
                else if(rb2.isSelected())
                    k = 2;
                else
                    k = 3;
            }
        });

        return root;

    }


    void method(String name,String desc,int k)
    {


    }
}