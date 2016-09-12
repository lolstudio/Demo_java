package com.vipabc.common;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vipabc.data.Account;
import com.vipabc.data.NetWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/8/12 0012.
 */
public class FeatureActivity extends ListActivity {
    public static String FEATURE_NAME = "featureName";
    public static String CURRENT_NETWORK = "network";
    private String netWorkUrl;

    /**
     * 选择测试账号
     */
    public static String INTENT_EXTRA_ACCOUNT = "account";
    public static int REQUEST_CODE_ACCOUNT = 1;

    /**
     * 切换网络环境
     */
    public static String INTENT_EXTRA_NETWORK = "network";
    public static int REQUEST_CODE_NETWORK = 2;

    /**
     * 日志开关
     */
    public static String INTENT_EXTRA_LOG = "log";
    public static int REQUEST_CODE_LOG = 3;
    /**
     * 版本相关
     */
    public static String INTENT_EXTRA_VERSION = "version";
    public static int REQUEST_CODE_VERSION = 4;
    /**
     * crash开关
     */
    public static String INTENT_EXTRA_CRASH = "crash";
    public static int REQUEST_CODE_CRASH = 5;
    /**
     * 设置代理IP
     */
    public static String INTENT_EXTRA_PROXY = "proxy";
    public static int REQUEST_CODE_PROXY = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Material_Light);
        setTitle("功能列表");

        netWorkUrl = getIntent().getStringExtra(CURRENT_NETWORK);
        List<String> items = fillArray();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, items);
        this.setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String name = (String) getListAdapter().getItem(position);
        Intent intent = new Intent();
        int requestCode = 0;
        switch (position) {
            case 0:
                requestCode = REQUEST_CODE_ACCOUNT;
                intent.setClass(this, TestAccountActivity.class);
                break;
            case 1:
                requestCode = REQUEST_CODE_NETWORK;
                intent.setClass(this, NetWorkActivity.class);
                intent.putExtra(CURRENT_NETWORK, netWorkUrl);
                break;
            case 2:
                requestCode = REQUEST_CODE_LOG;
                break;
            case 3:
                requestCode = REQUEST_CODE_VERSION;
                break;
            case 4:
                requestCode = REQUEST_CODE_CRASH;
                break;
            case 5:
                requestCode = REQUEST_CODE_PROXY;
                break;
        }
        intent.putExtra(FEATURE_NAME, name);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Intent intent = new Intent();
            if (requestCode == REQUEST_CODE_ACCOUNT) {
                Account account = (Account) data.getSerializableExtra(INTENT_EXTRA_ACCOUNT);
                if (account != null) {
                    intent.putExtra(INTENT_EXTRA_ACCOUNT, account);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            } else if (requestCode == REQUEST_CODE_NETWORK) {
                NetWork network = (NetWork) data.getSerializableExtra(INTENT_EXTRA_NETWORK);
                if (network != null) {
                    intent.putExtra(INTENT_EXTRA_NETWORK, network);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }
    }

    private List<String> fillArray() {
        List<String> featureList = new ArrayList<>();
        featureList.add("选择测试账号");
        featureList.add("切换网络环境");
        featureList.add("日志开关");
        featureList.add("版本相关");
        featureList.add("crash开关");
        featureList.add("设置代理IP");
        return featureList;
    }
}
