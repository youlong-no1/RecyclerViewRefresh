package denoceshi.example.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<String> arrayList;
    /**����ˢ��*/
    private SwipeRefreshLayout swipeRefreshLayout;
    /**list�б�*/
    private RecyclerView mRecyclerView;

    private ListView listView;

    private CustomAdapter customAdapter;

    private ListViewAdapter listViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        listView= (ListView) findViewById(R.id.listview);
        View view= LayoutInflater.from(this).inflate(R.layout.item_head,null);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.list);

//        mLayoutManager = new LinearLayoutManager(MainActivity.this);

        // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        arrayList=new ArrayList<String>();
        for (int i=0;i<5;i++){
            arrayList.add("list item"+i);
        }

        customAdapter=new CustomAdapter(arrayList);
        mRecyclerView.setAdapter(customAdapter);


        listView.addHeaderView(view, null, true);
        listViewAdapter=new ListViewAdapter(this,arrayList);
        listView.setAdapter(listViewAdapter);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                arrayList.add("item"+1);
                customAdapter.notifyDataSetChanged();
                listViewAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
