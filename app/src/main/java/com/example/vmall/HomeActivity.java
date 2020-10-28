package com.example.vmall;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
//implements ExerciseFragment.OnTitleListener

public class HomeActivity extends AppCompatActivity implements MyFragment.OnTitleListener {
    private SparseArray<Fragment> fragment;
   FragmentTransaction beginTransaction;
    private ShoppingFragment shoppingFragment=new ShoppingFragment();
    private String[] goodsNames={"新品","华为手机","荣耀手机","笔记本","平叛","智能穿戴&VR","智慧屏","智能家居","耳机音箱","专属配件","通用配件","生态产品","增值服务","智能计算"};
    private int[] goodsContent={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n};
    public int[] getGoodsContent(){
        return goodsContent;
    }
    public String[] getGoodsNames(){
        return goodsNames;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        initFragment();
       RadioGroup rgConcvert=findViewById(R.id.btn_group);
        rgConcvert.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                replaceFragment(fragment.get(i));

            }
        });

    }
    //初始化
    private void initFragment() {
        fragment=new SparseArray<>();
        fragment.put(R.id.btn_home, HomeFragment.newInstance("首页"));
        fragment.put(R.id.btn_classify, ClassifyFragment.newInstance("分类"));
        fragment.put(R.id.btn_discover,DiscoverFragment.newInstance("发现"));
        fragment.put(R.id.btn_shopping,ShoppingFragment.newInstance("购物车"));
        fragment.put(R.id.btn_my,MyFragment.newInstance("我的"));
        replaceFragment(fragment.get(R.id.btn_my));


    }
    //加载
    private void replaceFragment(Fragment fragment) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transcation =manager.beginTransaction();
        transcation.replace(R.id.ll_content,fragment);
        transcation.commit();
        tvTitle=findViewById(R.id.tv_data);
    }
    private TextView tvTitle;
@Override
    public  void setTitle(String title){
    tvTitle.setText(title);
}
}
