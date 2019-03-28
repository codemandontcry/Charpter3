package com.example.tired.charpter3;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LastActivity extends AppCompatActivity {

    String [] number = new String[]{"One", "Two", "Three", "Four", "Five" };
    MySimpleAdapter sim;
    List<Map<String,Object>> listItems;
    //重写适配器getView
    class MySimpleAdapter extends SimpleAdapter {
        public MySimpleAdapter(Context context, List<Map<String,Object>> data, int resource, String[] from, int[] to){
            super(context, data, resource, from, to);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            ListView temp=(ListView)findViewById(R.id.listView);
            if (view != null) {
                //若被选中
                if (temp.isItemChecked(position)) {
                    view.setBackgroundColor(Color.parseColor("#33B5E5"));
                } else {
                    view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        //创建List合集，元素是Map
        listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<number.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("title",number[i]);
            listItem.put("image",R.drawable.leftpic);
            listItems.add(listItem);
        }
        //创建SimpleAdapter
        sim=new MySimpleAdapter(this,listItems,R.layout.last_item,
                new String[] {"title","image"},
                new int[]{R.id.textID ,R.id.leftPic});
        final ListView l=(ListView)findViewById(R.id.listView);
        l.setAdapter(sim);
        l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        l.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                //当列表中的项目选中或取消勾选时，这个方法会被触发
                //可以在这个方法中做一些更新操作，比如更改上下文操作栏的标题
                //这里显示已选中的项目数
                mode.setTitle(l.getCheckedItemCount()+" selected");
                //通知样式变化
                sim.notifyDataSetChanged();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater=mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu,menu);
                return true;
            }
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                boolean ret = false;
                if (item.getItemId() == R.id.menu_delete) {
                    mode.finish();
                    ret = true;
                }
                return  ret;
            }
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                //可以对上下文操作栏做一些更新操作（会被ActionMode的invalidate方法触发）
                return false;
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                //在上下文操作栏被移除时会触发，可以对Activity做一些必要的更新
                //默认情况下，此时所有的选中项将会被取消选中
            }
        });



    }

}
