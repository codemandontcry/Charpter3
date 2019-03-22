package com.example.tired.charpter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LastActivity extends AppCompatActivity {

    String [] number = new String[]{"One", "Two", "Three", "Four", "Five" };

    private ActionMode.Callback mAMC = new ActionMode.Callback(){
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            boolean ret = false;
            if (item.getItemId() == R.id.menu_delete) {
                mode.finish();
                ret = true;
            }
            return ret;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        //创建List合集，元素是Map
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<number.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("title",number[i]);
            listItem.put("image",R.drawable.leftpic);
            listItems.add(listItem);
        }
        //创建SimpleAdapter
        final SimpleAdapter sim=new SimpleAdapter(this,listItems,R.layout.last_item,
                new String[] {"title","image"},
                new int[]{R.id.textID ,R.id.leftPic});
        final ListView l=(ListView)findViewById(R.id.listView);
        l.setAdapter(sim);

        l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);



        l.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View view, int position, long id){
                view.setSelected(true);
                ActionMode m1 = startActionMode(mAMC);
                m1.setTitle((position+1)+" selected");
            }
        });



    }
}
