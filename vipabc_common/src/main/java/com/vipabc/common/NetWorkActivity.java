package com.vipabc.common;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.vipabc.data.NetWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/8/12 0012.
 */
public class NetWorkActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Material_Light);
        setTitle(getIntent().getStringExtra(FeatureActivity.FEATURE_NAME));

        TextView tvNowNetWork = new TextView(this);
        tvNowNetWork.setText("当前网络" + getIntent().getStringExtra(FeatureActivity.CURRENT_NETWORK));

        Button btn = new Button(this);
        btn.setText(android.R.string.ok);
        getListView().addHeaderView(tvNowNetWork);
        getListView().addFooterView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        List<NetWork> items = fillArray();
        ArrayAdapter<NetWork> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, items);
        this.setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        NetWork netWork = (NetWork) getListAdapter().getItem(position);
        if (netWork != null) {
            intent.putExtra(FeatureActivity.INTENT_EXTRA_NETWORK, netWork);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private List<NetWork> fillArray() {
        List<NetWork> featureList = new ArrayList<>();
        featureList.add(new NetWork("http://mobapi.vipabc.com/mobcommon/webapi/", "MOBCOMMON_NAME"));
        featureList.add(new NetWork("http://mobresource01.tutorabc.com/mobcommon/webapi/", "mobcommon_test"));
        featureList.add(new NetWork("http://mobresource01.tutorabc.com/mobcommon/webapi/", "MOBCOMMON_NAME"));
        return featureList;
    }
}
