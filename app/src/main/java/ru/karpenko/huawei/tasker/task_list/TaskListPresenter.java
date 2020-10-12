package ru.karpenko.huawei.tasker.task_list;

import android.util.Log;

import java.util.List;

import ru.karpenko.huawei.tasker.model.Task;
import ru.karpenko.huawei.tasker.services.ITaskApi;
import ru.karpenko.huawei.tasker.services.TaskApi;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TaskListPresenter {

    private static final String TAG_TASK_LIST_PRESENTER = "tasker.task_list";

    private TaskListView mTaskListActivity;
    private ITaskApi mTaskApi;


    public TaskListPresenter(TaskListView taskListActivity) {
        mTaskListActivity = taskListActivity;
        mTaskApi = new TaskApi();
    }

    public void updateTaskList() {

        Observable<List<Task>> dataObservable = mTaskApi.getTaskList();

        Scheduler scheduler = Schedulers.newThread();

        dataObservable.subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Task>>() {
                               @Override
                               public void onCompleted() {
                                   Log.e(TAG_TASK_LIST_PRESENTER, "COMPLETED");
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.e(TAG_TASK_LIST_PRESENTER, e.getMessage());
                               }

                               @Override
                               public void onNext(List<Task> tasks) {
                                   mTaskListActivity.updateList(tasks);
                               }
                           }
                );
    }
}
