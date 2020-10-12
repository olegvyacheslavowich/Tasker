package ru.karpenko.huawei.tasker.services;

import java.util.List;

import ru.karpenko.huawei.tasker.model.Task;
import rx.Observable;

public interface ITaskApi {

    Observable<List<Task>> getTaskList();

}
