package com.example.greymatter.livedata_viewmodel_demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

class CounterViewModel extends ViewModel {

    private CounterData userData;

    public CounterViewModel() {
        userData = new CounterData();
    }

    public LiveData<String> getData() {
        return userData;
    }

    private class CounterData extends LiveData<String> {
        private CounterData() {
            generateCounterData();
        }

        private void generateCounterData() {
            Observable
                    .interval(1, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Long>() {
                        @Override
                        public void call(Long aLong) {
                            setValue(String.valueOf(aLong));
                        }
                    });
        }
    }
}
