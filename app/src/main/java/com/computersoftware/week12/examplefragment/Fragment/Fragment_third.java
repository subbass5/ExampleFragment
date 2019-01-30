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
import android.widget.TextView;

import com.computersoftware.week12.examplefragment.R;

public class Fragment_third extends Fragment implements View.OnClickListener {

    FragmentManager manager;
    FragmentTransaction transaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment,container,false);
          init(view);
        return view;
    }

    private void init(View view) {

        TextView tv_result,tv_name,tv_phone,tv_email;
        tv_result = view.findViewById(R.id.tv_result);
        tv_name  = view.findViewById(R.id.tv_name);
        tv_phone = view.findViewById(R.id.tv_phone);
        tv_email = view.findViewById(R.id.tv_email);

        view.findViewById(R.id.btn_back).setOnClickListener(this);
        view.findViewById(R.id.btn_end).setOnClickListener(this);

        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();

        tv_result.setText(getArguments().getString(Fragment_scond.RESULT));
        tv_name.setText(getArguments().getString(Fragment_scond.NAME));
        tv_phone.setText(getArguments().getString(Fragment_scond.PHONE));
        tv_email.setText(getArguments().getString(Fragment_scond.EMAIL));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_back:

                    Bundle bundle = new Bundle();
                    bundle.putString(Fragment_scond.RESULT,
                                   getArguments().getString(Fragment_scond.RESULT));
                    Fragment_scond fragmentScond = new Fragment_scond();
                    fragmentScond.setArguments(bundle);
                    manager.popBackStack();
                    transaction.replace(R.id.contentFragment,fragmentScond)
                            .addToBackStack(null)
                            .commit();
                break;
            case  R.id.btn_end:

                    endFunc();

                break;

        }
    }

    private void endFunc() {
        manager.popBackStack();
        manager.popBackStack();
    }
}
