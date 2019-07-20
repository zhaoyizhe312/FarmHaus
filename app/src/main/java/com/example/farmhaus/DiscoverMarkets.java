package com.example.farmhaus;



import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class DiscoverMarkets extends AppCompatActivity implements View.OnClickListener{
    //UI Object
    private TextView txt_sun;
    private TextView txt_mon;
    private TextView txt_tue;
    private TextView txt_wed;
    private TextView txt_thu;
    private TextView txt_fri;
    private TextView txt_sat;
    private FrameLayout ly_content;

    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<Data> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;


    //Fragment Object
    private NewListFragment fg1,fg2,fg3,fg4,fg5,fg6,fg7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_markets);
        mContext = DiscoverMarkets.this;
        fManager = getSupportFragmentManager();
        bindViews();
        txt_sun.performClick();


    }
    private void bindViews() {
        txt_sun = (TextView) findViewById(R.id.txt_sun);
        txt_mon = (TextView) findViewById(R.id.txt_mon);
        txt_tue = (TextView) findViewById(R.id.txt_tue);
        txt_wed = (TextView) findViewById(R.id.txt_wed);
        txt_thu = (TextView) findViewById(R.id.txt_thu);
        txt_fri = (TextView) findViewById(R.id.txt_fri);
        txt_sat = (TextView) findViewById(R.id.txt_sat);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_sun.setOnClickListener(this);
        txt_mon.setOnClickListener(this);
        txt_tue.setOnClickListener(this);
        txt_wed.setOnClickListener(this);
        txt_thu.setOnClickListener(this);
        txt_fri.setOnClickListener(this);
        txt_sat.setOnClickListener(this);
    }

    private void setSelected(){
        txt_sun.setSelected(false);
        txt_mon.setSelected(false);
        txt_tue.setSelected(false);
        txt_wed.setSelected(false);
        txt_thu.setSelected(false);
        txt_fri.setSelected(false);
        txt_sat.setSelected(false);
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
        if(fg5 != null)fragmentTransaction.hide(fg5);
        if(fg6 != null)fragmentTransaction.hide(fg6);
        if(fg7 != null)fragmentTransaction.hide(fg7);
    }

    @Override
    public void onClick(View v) {
        datas = new ArrayList<Data>();
        Data data = new Data("Stearns Homestead Farmers' Market", "~Market Details~~~~~~~~");
        datas.add(data);
        data = new Data("106 S. Main Street Farmers Market" , "~Market Details~~~~~~~~");
        datas.add(data);
        data = new Data("10th Steet Community Farmers Market" , "~Market Details~~~~~~~~");
        datas.add(data);
        data = new Data("14th & Kennedy Street Farmers Market" , "~Market Details~~~~~~~~");
        datas.add(data);
        for (int i = 5; i <= 20; i++) {
            data = new Data("Market Name" + i, i + "~Market Details~~~~~~~~");
            datas.add(data);
        }
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.txt_sun:
                setSelected();
                txt_sun.setSelected(true);
                if(fg1 == null){
                    fg1 = new NewListFragment(fManager,datas);
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.txt_mon:
                setSelected();
                txt_mon.setSelected(true);
                if(fg2 == null){
                    fg2 = new NewListFragment(fManager,datas);
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.txt_tue:
                setSelected();
                txt_tue.setSelected(true);
                if(fg3 == null){
                    fg3 = new NewListFragment(fManager,datas);
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;
            case R.id.txt_wed:
                setSelected();
                txt_wed.setSelected(true);
                if(fg4 == null){
                    fg4 = new NewListFragment(fManager,datas);
                    fTransaction.add(R.id.ly_content,fg4);
                }else{
                    fTransaction.show(fg4);
                }
                break;
            case R.id.txt_thu:
                setSelected();
                txt_thu.setSelected(true);
                if(fg5 == null){
                    fg5 = new NewListFragment(fManager,datas);
                    fTransaction.add(R.id.ly_content,fg5);
                }else{
                    fTransaction.show(fg5);
                }
                break;
            case R.id.txt_fri:
                setSelected();
                txt_fri.setSelected(true);
                if(fg6 == null){
                    fg6 = new NewListFragment(fManager,datas);
                    fTransaction.add(R.id.ly_content,fg6);
                }else{
                    fTransaction.show(fg6);
                }
                break;
            case R.id.txt_sat:
                setSelected();
                txt_sat.setSelected(true);
                if(fg7 == null){
                    fg7 = new NewListFragment(fManager,datas);
                    fTransaction.add(R.id.ly_content,fg7);
                }else{
                    fTransaction.show(fg7);
                }
                break;
        }
        fTransaction.commit();
    }
}