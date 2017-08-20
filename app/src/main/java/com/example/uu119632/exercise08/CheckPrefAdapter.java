package com.example.uu119632.exercise08;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.List;

/**
 * CheckPrefAdapter
 * チェックボックス画面用CustomAdapter
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/07/28
 */

class CheckPrefAdapter extends ArrayAdapter<Prefecture> {

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
    CheckPrefAdapter(Context context, int resourceId, List<Prefecture> list) {
        super(context, resourceId, list);
        this.list = list;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * ViewHolder
     */
    private class ViewHolder {
        /**
         * Checkbox
         */
        CheckBox checkBox;
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
            view = layoutInflater.inflate(R.layout.check_item_list, null);

            holder = new ViewHolder();
            holder.checkBox = (CheckBox) view.findViewById(R.id.checkbox_id);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        Prefecture pref = list.get(position);
        holder.checkBox.setChecked(pref.isSelected());
        holder.checkBox.setText(pref.getPrefName());
        holder.checkBox.setTag(pref);

        // CheckBox押下時の処理
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb = (CheckBox) view;
                Prefecture pref = (Prefecture) cb.getTag();
                pref.setSelected(cb.isChecked());
            }
        });

        return view;
    }
}

