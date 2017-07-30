package com.example.peter.prefectures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


/**
 * チェックボタンで選択し、選択したアイテムを表示するクラス
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/07/28
 */
public class CheckActivity extends AppCompatActivity {
    /** ListView */
    ListView listView;
    /** 都道府県インスタンス */
    Prefecture pref;
    /** 都道府県のリスト */
    List<Prefecture> prefList;
    /** Adapter */
    CheckPrefAdapter arrayAdapter;

    /**
     * 都道府県のリストを表示するメソッド
     */
    public void createPrefList() {
        prefList = new ArrayList<>();
        final String[] prefName = getResources().getStringArray(R.array.prefectures);

        for (int i = 0; i < prefName.length; i++) {
            pref = new Prefecture(prefName[i], false);
            prefList.add(pref);
        }
        arrayAdapter = new CheckPrefAdapter(this, R.layout.check_item_list, prefList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

    }



    /**
     * onCreate
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        createPrefList();

        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                StringBuilder responseText = new StringBuilder();
                List<Prefecture> prefList = arrayAdapter.list;
                for (int i = 0; i < prefList.size(); i++) {
                    Prefecture pref = prefList.get(i);
                    if (pref.isSelected()) {
                        if (responseText.length() != 0) {
                            responseText.append(", ");
                        }
                        responseText.append(pref.getPrefName());
                    }
                }
                if (responseText.length() == 0) {
                    responseText.append("選択なし");
                }

                Toast.makeText(CheckActivity.this, responseText.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

