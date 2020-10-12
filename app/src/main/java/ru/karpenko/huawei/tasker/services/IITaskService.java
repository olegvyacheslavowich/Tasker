package ru.karpenko.huawei.tasker.services;

import java.util.List;

import retrofit2.http.GET;
import ru.karpenko.huawei.tasker.model.Task;
import rx.Observable;

public interface IITaskService {

    @GET("/tasker/hs/mobile/getTasks")
    Observable<List<Task>> getTaskList();

}
