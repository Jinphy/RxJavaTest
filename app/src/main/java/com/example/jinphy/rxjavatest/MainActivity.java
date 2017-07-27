package com.example.jinphy.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable.fromIterable(Student.getStudents())
//                .flatMap(student -> Observable.fromIterable(student.getCourses()))
//                .map(course -> course.getName())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(name -> {
//                    Log.d(TAG, name);
//                });


        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: observer");

            }

            @Override
            public void onNext(@NonNull Integer s) {
                Log.d(TAG, "onNext: observer "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d(TAG, "onError: observer "+e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: observer");
            }
        };

        observable.subscribeWith(observer);
    }






}
