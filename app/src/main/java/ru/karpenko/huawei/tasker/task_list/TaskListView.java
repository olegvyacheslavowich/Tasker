package ru.karpenko.huawei.tasker.task_list;

import java.util.List;

import ru.karpenko.huawei.tasker.model.Task;

public interface TaskListView {

    void updateList(List<Task> tasks);

}
