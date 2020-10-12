package ru.karpenko.huawei.tasker.services;

import java.util.List;

import retrofit2.Retrofit;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.karpenko.huawei.tasker.model.Task;
import rx.Observable;

public class TaskApi implements ITaskApi {

    private static final String CONNECTION_URL = "http://cabinetos.ru";

    @Override
    public Observable<List<Task>> getTaskList() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(CONNECTION_URL)
                .build();
        IITaskService taskService = retrofit.create(IITaskService.class);
        return taskService.getTaskList();
    }

}
