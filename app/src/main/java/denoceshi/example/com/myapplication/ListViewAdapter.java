package denoceshi.example.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 项目名称：RecyclerViewRefresh
 * 类描述：
 * 创建人：fjl
 * 创建时间：2016/5/2 19:40
 * 修改人：fjl
 * 修改时间：2016/5/2 19:40
 * 修改备注：
 */
public class ListViewAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<String> list;
    private ViewHolder viewHolder;

    public ListViewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_list,null);
            viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) convertView.findViewById(R.id.txt);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position));
        return convertView;
    }

    private class ViewHolder{
        TextView textView;
    }
}
