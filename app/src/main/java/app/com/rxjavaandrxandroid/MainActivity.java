package app.com.rxjavaandrxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import app.com.rxjavaandrxandroid.activities.CreatingAnObservableFromListActivity_;
import app.com.rxjavaandrxandroid.adapters.RecyclerItemClickListener;
import app.com.rxjavaandrxandroid.adapters.SubjectsRecyclerViewAdapter;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    SubjectsRecyclerViewAdapter subjectsRecyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;

    String[] arrayList;

    @AfterViews
    void initViews() {

        arrayList = getResources().getStringArray(R.array.subject_titles);
        subjectsRecyclerViewAdapter = new SubjectsRecyclerViewAdapter(arrayList, R.layout.subject_title_item, this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(subjectsRecyclerViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        CreatingAnObservableFromListActivity_.intent(MainActivity.this).start();
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
    }
}
