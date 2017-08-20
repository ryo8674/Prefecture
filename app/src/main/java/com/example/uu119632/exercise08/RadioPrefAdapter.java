package com.example.uu119632.exercise08;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

import java.util.List;

/**
 * RadioPrefAdapter
 * ラジオボタン画面用CustomAdapter
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/07/28
 */
class RadioPrefAdapter extends ArrayAdapter<Prefecture> {

    /**
     * 都道府県のリスト
     */
    List<Prefecture> list;
    /**
     * LayoutInflater
     */
    private LayoutInflater layoutInflater;

    /**
     * コンストラクタ
     *
     * @param context    クラスのオブジェクト
     * @param resourceId リソースID
     * @param list       データのリスト
     */
    RadioPrefAdapter(Context context, int resourceId, List<Prefecture> list) {
        super(context, resourceId, list);
        this.list = list;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * ViewHolder
     */
    private class ViewHolder {
        /**
         * Radiobutton
         */
        RadioButton radioBtn;
    }

    /**
     * getViewメソッド
     *
     * @param position    リストの番号
     * @param convertView リストのView情報
     * @param parent      親のView
     * @return view view
     */
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.radio_item_list, null);

            holder = new ViewHolder();
            holder.radioBtn = view.findViewById(R.id.radio_id);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        final Prefecture pref = list.get(position);
        holder.radioBtn.setChecked(pref.isSelected());
        holder.radioBtn.setText(pref.getPrefName());

        // Radiobutton押下時の処理
        holder.radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // すべてのチェックをクリア
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setSelected(false);
                }
                // クリックしたボタンのみチェックする
                pref.setSelected(true);
                // アダプタ内容を即時反映
                notifyDataSetChanged();
            }
        });

        return view;
    }
}

