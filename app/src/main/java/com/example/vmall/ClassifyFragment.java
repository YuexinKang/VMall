package com.example.vmall;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassifyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClassifyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;


    public ClassifyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ClassifyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClassifyFragment newInstance(String param1) {
        ClassifyFragment fragment = new ClassifyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
private FragmentTransaction beginTransaction;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        beginTransaction=getFragmentManager().beginTransaction();
//        beginTransaction.replace(R.id.menu,new MenuFragment());
//        beginTransaction.replace(R.id.content,new ContentFragment());
//        beginTransaction.commit();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_classify, container, false);
        TextView tvData=view.findViewById(R.id.tv_data);
        tvData.setText(mParam1);
        return view;
    }
    OnTitleListener onTitleListener;
    public interface  OnTitleListener{
        void setTitle(String title);
    }
}