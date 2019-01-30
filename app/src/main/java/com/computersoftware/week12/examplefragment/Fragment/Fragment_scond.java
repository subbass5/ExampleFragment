package com.computersoftware.week12.examplefragment.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.computersoftware.week12.examplefragment.R;

public class Fragment_scond extends Fragment {

    public static final String RESULT = "result";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,container,false);
            init(view);
        return view;
    }

    private void init(View view) {

        final EditText et_name,et_phone,et_email;
        final TextView tv_result;
        tv_result = view.findViewById(R.id.tv_result);

        et_name = view.findViewById(R.id.et_name);
        et_phone = view.findViewById(R.id.et_phone);
        et_email = view.findViewById(R.id.et_email);

        String result = getArguments().getString(RESULT);
        tv_result.setText(result);

        final FragmentManager manager = getActivity().getSupportFragmentManager();

        view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = manager.beginTransaction();
                Bundle bundle = new Bundle();

                bundle.putString(RESULT,tv_result.getText().toString());
                bundle.putString(NAME,et_name.getText().toString());
                bundle.putString(PHONE,et_phone.getText().toString());
                bundle.putString(EMAIL,et_email.getText().toString());

                Fragment_third fragmentThird = new Fragment_third();
                fragmentThird.setArguments(bundle);

                transaction.replace(R.id.contentFragment,fragmentThird)
                        .addToBackStack(null)
                        .commit();


            }
        });

        Button btn_back = view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.popBackStack();
            }
        });
    }
}
