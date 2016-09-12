package com.vipabc.common;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vipabc.data.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/8/12 0012.
 */
public class TestAccountActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Material_Light);
        setTitle(getIntent().getStringExtra(FeatureActivity.FEATURE_NAME));

        List<Account> items = fillArray();
        ArrayAdapter<Account> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, items);
        this.setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        Account item = (Account) getListAdapter().getItem(position);
        if (item != null) {
            intent.putExtra(FeatureActivity.INTENT_EXTRA_ACCOUNT, item);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private List<Account> fillArray() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("qatest_quenna6@vipabc.com"));
        accountList.add(new Account("qatest@chaozhi.com"));
        accountList.add(new Account("qatest_30min@vipabc.com"));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        accountList.add(new Account(""));
        return accountList;
    }

}
