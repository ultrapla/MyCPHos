package cph.nakhundee.wannapa.mycphos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Meeting on 27/4/2560.
 */

public class MyAdapter extends BaseAdapter{

    private Context context;
    private String[] nameStrings, dateStrings, detailStrings;

    public MyAdapter(Context context,
                     String[] nameStrings,
                     String[] dateStrings,
                     String[] detailStrings) {
        this.context = context;
        this.nameStrings = nameStrings;
        this.dateStrings = dateStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return nameStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  // getSystemService คือ ต้องการเปิดใช้ service
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);

        TextView nameTextView = (TextView) view.findViewById(R.id.txtName);
        TextView dateTextView = (TextView) view.findViewById(R.id.txtDate);
        TextView detailTextView = (TextView) view.findViewById(R.id.txtDetail);

        nameTextView.setText(nameStrings[position]);
        dateTextView.setText(dateStrings[position]);
        detailTextView.setText(detailStrings[position]);






        return view;
    }
} //main class
