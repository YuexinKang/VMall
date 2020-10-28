package com.example.vmall;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
private View view;
private int[] goodsContent;
private String[] goodsNames;
private ListView mListView;
private ImageView mImageView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_menu, container, false);
        Fragment fragment=getParentFragment();
        HomeActivity homeActivity= (HomeActivity) fragment.getParentFragment().getActivity();
        goodsNames=homeActivity.getGoodsNames();
        if (view!=null){
            initView();
        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContentFragment listFragment= (ContentFragment) getParentFragment().getActivity().getSupportFragmentManager().findFragmentById(R.id.content);
                mImageView=view.findViewById(R.id.iv_content);
                mImageView.setBackgroundResource(goodsContent[0]);
            }
        });
        return view;
    }

    private void initView() {
        mListView=view.findViewById(R.id.menulist);

        if (goodsNames!=null){
            mListView.setAdapter(new MyAdapter());
        }
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return goodsNames.length;
        }

        @Override
        public Object getItem(int i) {
            return goodsNames[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=View.inflate(getActivity(),R.layout.item_list,null);
            TextView goodsName=view.findViewById(R.id.good_name);
            goodsName.setText(goodsNames[i]);
            return view;

        }
    }
}