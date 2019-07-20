package com.example.farmhaus;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class NewListFragment extends Fragment {
    private FragmentManager fManager;
    private ArrayList<Data> datas;
    private ListView list_news;

    public NewListFragment(FragmentManager fManager, ArrayList<Data> datas) {
        this.fManager = fManager;
        this.datas = datas;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_new_list_fragment, container, false);
        list_news = (ListView) view.findViewById(R.id.list_news);
        MyAdapter myAdapter = new MyAdapter(datas, getActivity());
        list_news.setAdapter(myAdapter);
        //list_news.setOnItemClickListener(this);
        return view;
    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        FragmentTransaction fTransaction = fManager.beginTransaction();
//        NewContentFragment ncFragment = new NewContentFragment();
//        Bundle bd = new Bundle();
//        bd.putString("content", datas.get(position).getNew_content());
//        ncFragment.setArguments(bd);
//        //获取Activity的控件
//        TextView txt_title = (TextView) getActivity().findViewById(R.id.txt_title);
//        txt_title.setText(datas.get(position).getNew_content());
//        //加上Fragment替换动画
//        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
//        fTransaction.replace(R.id.ly_content, ncFragment);
//        //调用addToBackStack将Fragment添加到栈中
//        fTransaction.addToBackStack(null);
//        fTransaction.commit();
//    }
}