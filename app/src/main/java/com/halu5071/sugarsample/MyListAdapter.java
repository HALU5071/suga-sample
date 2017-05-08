package com.halu5071.sugarsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by HALU on 2017/05/08.
 */

public class MyListAdapter extends ArrayAdapter<Book> {

    Context mContext;
    LayoutInflater mInflater;
    int mResourceId;

    public MyListAdapter(Context context, int resourceId){
        super(context, resourceId);
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mResourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if (convertView == null){
            convertView = mInflater.inflate(mResourceId, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = ((ViewHolder) convertView.getTag());
        }

        Book item = getItem(position);

        if (item != null){
            viewHolder.textTitle.setText(item.getTitle());
            viewHolder.textContent.setText(item.getContentBook());
            viewHolder.textIsbn.setText(String.valueOf(item.getIsbn()));
        }

        return convertView;
    }

    private class ViewHolder{

        TextView textTitle;
        TextView textContent;
        TextView textIsbn;

        public ViewHolder(View view){
            textTitle = ((TextView) view.findViewById(R.id.text_title));
            textContent = ((TextView) view.findViewById(R.id.text_content));
            textIsbn = ((TextView) view.findViewById(R.id.text_isbn));
        }
    }
}
