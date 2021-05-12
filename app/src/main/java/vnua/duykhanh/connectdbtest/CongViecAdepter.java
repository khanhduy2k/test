package vnua.duykhanh.connectdbtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CongViecAdepter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Congviec> congviecList;

    public CongViecAdepter(Context context, int layout, List<Congviec> congviecList) {
        this.context = context;
        this.layout = layout;
        this.congviecList = congviecList;
    }

    @Override
    public int getCount() {
        return congviecList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    private class viewHolder {
        TextView txtTen;
        ImageView btnDel, btnEdit;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null) {
            holder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTen = (TextView) convertView.findViewById(R.id.txtTen);
            holder.btnDel = (ImageView) convertView.findViewById(R.id.btnDel);
            holder.btnEdit = (ImageView) convertView.findViewById(R.id.btnEdit);
            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }

        Congviec congviec = congviecList.get(position);

        holder.txtTen.setText(congviec.getTenCv());

        return convertView;
    }
}
