package com.example.vmall;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private RecyclerAdapter adapter;
    //1 准备模拟数据
    //商品名称与数据的集合
    private String[] titles={"HUAWEI Mata 40 Pro 5G全网通","HUAWEI Mata 40 Pro 5G全网通","HUAWEI Mata 40 Pro 5G全网通","HUAWEI Mata 40 Pro 5G全网通","HUAWEI Mata 40 Pro 5G全网通"};
    private String[] prices={"￥5666","￥5666","￥5666","￥5666","￥5666"};
    //图片数据的集合
    private int[] icons={
            R.drawable.phone,R.drawable.phone,R.drawable.phone,
            R.drawable.phone,R.drawable.phone,R.drawable.phone
    };
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
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

    //BaseAdapter要求数据的集合
    private List<Goods> goods;
    private void initData() {
        goods=new ArrayList<>();
        for(int i=0;i<titles.length;i++){
            goods.add(new Goods(titles[i],prices[i],icons[i]));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        context=view.getContext();
        recyclerView=view.findViewById(R.id.lv_goods);
        goods=new ArrayList<Goods>();
        initData();
//        LinearLayoutManager manager = new LinearLayoutManager(context);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        //recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false));


        adapter = new RecyclerAdapter(context, goods);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));//添加下划线
        //return inflater.inflate(R.layout.tab03, container, false);
        TextView tvData=view.findViewById(R.id.tv_data);
        tvData.setText(mParam1);
        return view;
    }
    OnTitleListener onTitleListener;
    public interface  OnTitleListener{
        void setTitle(String title);
    }
}