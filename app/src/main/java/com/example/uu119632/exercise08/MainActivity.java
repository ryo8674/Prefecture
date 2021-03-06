package com.example.uu119632.exercise08;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * メイン画面
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/07/28
 */
public class MainActivity extends AppCompatActivity {

    /**
     * <p>メイン画面</p>
     * <li>Checkboxボタン押下でCheckActivityに遷移</li>
     * <li>Radiobuttonボタン押下でRadioActivityに遷移</li>
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checkbox画面に遷移
        findViewById(R.id.button_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckboxActivity.class);
                startActivity(intent);
            }
        });

        // Radiobutton画面に遷移
        findViewById(R.id.button_radio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RadiobuttonActivity.class);
                startActivity(intent);
            }
        });


    }
}
