package com.example.uu119632.exercise08;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * ラジオボタンで選択し、選択したアイテムを表示するクラス
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/07/28
 */
public class RadiobuttonActivity extends AppCompatActivity {
    /**
     * ListView
     */
    ListView listView;
    /**
     * 都道府県インスタンス
     */
    Prefecture pref;
    /**
     * 都道府県のリスト
     */
    List<Prefecture> prefList;
    /**
     * Adapter
     */
    RadioPrefAdapter arrayAdapter;
    /**
     * デフォルトの都道府県コード
     */
    final int DEFAULT_PREF_CODE = 12;

    /**
     * 都道府県のリストを表示するメソッド
     */
    public void createPrefList() {
        prefList = new ArrayList<>();
        final String[] prefName = getResources().getStringArray(R.array.prefectures);

        for (String aPrefName : prefName) {
            pref = new Prefecture(aPrefName, false);
            prefList.add(pref);
        }
        arrayAdapter = new RadioPrefAdapter(this, R.layout.radio_item_list, prefList);

        // デフォルトの設定
        if (!arrayAdapter.isEmpty()) {
            arrayAdapter.getItem(DEFAULT_PREF_CODE).setSelected(true);
        }

        listView = (ListView) findViewById(R.id.list_view2);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(arrayAdapter);
    }

    /**
     * onCreate
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);

        //リストの表示
        createPrefList();

        // OKボタン押下時の処理
        findViewById(R.id.button_ok2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String responseText = null;
                prefList = arrayAdapter.list;
                for (int i = 0; i < prefList.size(); i++) {
                    Prefecture pref = prefList.get(i);
                    if (pref.isSelected()) {
                        responseText = pref.getPrefName();
                    }
                }

                Toast.makeText(RadiobuttonActivity.this, responseText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
