package app.com.rxjavaandrxandroid.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import app.com.rxjavaandrxandroid.MainActivity;
import app.com.rxjavaandrxandroid.R;
import app.com.rxjavaandrxandroid.adapters.CreatingAnObservableFromListRecyclerViewAdapter;
import app.com.rxjavaandrxandroid.adapters.RecyclerItemClickListener;
import app.com.rxjavaandrxandroid.adapters.SubjectsRecyclerViewAdapter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * About this subject help us control list data easily, check and handle condition for each item and easy to know completed on onCompleted() .
 * easy to implement and so fast
 * all task run outside main thread and return each data item to main thread on onNext()
 * Created by quoc1132 on 12/22/17.
 */

@EActivity(R.layout.activity_creating_an_observable_from_a_list)
public class CreatingAnObservableFromListActivity extends AppCompatActivity {

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    CreatingAnObservableFromListRecyclerViewAdapter subjectsRecyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;

    List<String> arrayList;

    @AfterViews
    void initViews() {

        String[] arrayListTemp = {"1", "2", "3"};
        arrayList = new ArrayList();
        subjectsRecyclerViewAdapter = new CreatingAnObservableFromListRecyclerViewAdapter(CreatingAnObservableFromListActivity.this, arrayList, R.layout.subject_title_item);
        linearLayoutManager = new LinearLayoutManager(CreatingAnObservableFromListActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(subjectsRecyclerViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(CreatingAnObservableFromListActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        CreatingAnObservableFromListActivity_.intent(CreatingAnObservableFromListActivity.this).start();
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        Observable.fromArray(arrayListTemp).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String s) {
                //you can change data or check condition in there
                arrayList.add("Hello " + s);
                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        subjectsRecyclerViewAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
