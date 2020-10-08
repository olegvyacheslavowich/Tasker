package ru.karpenko.huawei.tasker.task_list;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ru.karpenko.huawei.tasker.model.Task;
import ru.karpenko.huawei.tasker.repository.database.Repository;
import ru.karpenko.huawei.tasker.repository.database.TaskData;

public class TaskListPresenter {

    private static final String TAG_TASK_LIST_PRESENTER = "tasker.task_list";

    private TaskListView mTaskListActivity;


    public TaskListPresenter(TaskListView taskListActivity) {
        mTaskListActivity = taskListActivity;
    }

    public void updateTaskList() {

        Repository repository = new TaskData();
        List<Task> tasks = null;
        try {
            tasks = repository.getList();
        } catch (Exception e) {
            tasks = new ArrayList<>();
            Log.e(TAG_TASK_LIST_PRESENTER, e.toString());
        }

        mTaskListActivity.updateList(tasks);
    }
}
