package com.example.user.multiappliyfromlens.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.multiappliyfromlens.Poker.Card;
import com.example.user.multiappliyfromlens.R;

import java.util.List;

public class PokerShowAdapter extends BaseAdapter {

    private List<String> arrayShow;
    private LayoutInflater inflater;
    private static class ViewHolder{
        RelativeLayout rlBorder;
        TextView tvPoint;
    }

    public PokerShowAdapter( List<String> arrayShow, LayoutInflater inflater) {
        this.arrayShow = arrayShow;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return arrayShow.size();//13
    }

    @Override
    public Object getItem(int position) {
        return arrayShow.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.view_lv_point, null);
            viewHolder.tvPoint = (TextView) convertView.findViewById(R.id.tv_show_point);
            viewHolder.rlBorder = (RelativeLayout) convertView.findViewById(R.id.rl_show_point);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvPoint.setText(arrayShow.get(position));
        return convertView;
    }
}
