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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.computersoftware.week12.examplefragment.R;

public class Fragment_frist extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
            init(view);
        return  view;

    }

    public void init(View view){

        final String [] data_list = {"Dog","Cat","Pig","Fish"};

        ListView listView = view.findViewById(R.id.list_data);
        ArrayAdapter<String> mAdapter
                = new ArrayAdapter<String>(getContext(),
                                            android.R.layout.simple_list_item_1,
                                            data_list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Bundle bundle = new Bundle();
                Fragment_scond fragment_scond = new Fragment_scond();

                bundle.putString(Fragment_scond.RESULT,data_list[position]);
                fragment_scond.setArguments(bundle);
                transaction.replace(R.id.contentFragment,fragment_scond)
                                    .addToBackStack(null)
                                    .commit();



            }
        });


    }
}
