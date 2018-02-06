package com.remote.newestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action4;
import rx.functions.Func1;

public class Test2Activity extends AppCompatActivity implements View.OnClickListener {

    private List<String> l;
    private TextView aaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        aaa = (TextView) findViewById(R.id.aaa);
        aaa.setOnClickListener(this);
        init();
    }

    private void init() {
        l = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            l.add("str - " + i);
        }
    }

    public Observable<List<String>> query() {
        return Observable.just(l);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aaa:
                query().flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        return Observable.from(strings);
                    }
                })
                        .filter(new Func1<String, Boolean>() {
                            @Override
                            public Boolean call(String s) {
                                boolean b = s.contains("2");
                                String q = null;
                                if (b) {
                                    q.hashCode();
                                }
                                return !b;
                            }
                        })
//                        .subscribe(new Action1<String>() {
//                            @Override
//                            public void call(String o) {
//                                Log.e("xxxx", "sstr -- " + o);
//                            }
//                        });
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                Log.e("subsub", "--> done");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("subsub", "--> ouch " + e.toString());
                            }

                            @Override
                            public void onNext(String s) {
                                Log.e("subsub", "--> sstr " + s);
                            }
                        });

                Observable.create(new Observable.OnSubscribe<Object>() {
                    @Override
                    public void call(Subscriber<? super Object> subscriber) {

                    }
                });

                Action0 a = new Action0() {
                    @Override
                    public void call() {

                    }
                };

                Observable.OnSubscribe os = new Observable.OnSubscribe<String>() {

                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("time");
                        subscriber.onNext("is");
                        subscriber.onNext("pass");
                        subscriber.onNext("away");
                        subscriber.onCompleted();
                    }
                };

                Observable observable = Observable.create(os);
                observable.subscribe(new Subscriber() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {

                    }
                });

                break;
        }
    }
}
