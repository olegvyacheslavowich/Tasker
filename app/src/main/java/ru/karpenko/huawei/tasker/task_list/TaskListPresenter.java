package ru.karpenko.huawei.tasker.task_list;

import java.util.ArrayList;
import java.util.List;

import ru.karpenko.huawei.tasker.model.Task;

public class TaskListPresenter {
    private TaskListView mTaskListActivity;

    public TaskListPresenter(TaskListView taskListActivity) {
        mTaskListActivity = taskListActivity;
    }

    public void updateTaskList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Выполнить дз", "Завтра", "Петрович Петр"));
        tasks.add(new Task("Выполнить кз", "Вчера", "Петрович Михаил"));
        tasks.add(new Task("Выполнить мз", "Сегодня", "Петрович Ворон"));

        mTaskListActivity.updateList(tasks);
    }
}
