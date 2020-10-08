package ru.karpenko.huawei.tasker.task_list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.karpenko.huawei.tasker.R;
import ru.karpenko.huawei.tasker.model.Task;

public class TaskListActivity extends AppCompatActivity implements TaskListView {

    private RecyclerView mRecyclerView;
    private TaskListPresenter mTaskListPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.task_list_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTaskListPresenter = new TaskListPresenter(this);
        mTaskListPresenter.updateTaskList();
    }

    @Override
    public void updateList(List<Task> tasks) {
        mRecyclerView.setAdapter(new TaskAdapter(tasks));
    }

    private class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mTaskTitleTextView;
        private TextView mResponsibleTextView;
        private TextView mCompleteDateTextView;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            mTaskTitleTextView = itemView.findViewById(R.id.taskTitleTextView);
            mResponsibleTextView = itemView.findViewById(R.id.responsibleTextView);
            mCompleteDateTextView = itemView.findViewById(R.id.completeDateTextView);
        }

        public TextView getTaskTitleTextView() {
            return mTaskTitleTextView;
        }

        public TextView getResponsibleTextView() {
            return mResponsibleTextView;
        }

        public TextView getCompleteDateTextView() {
            return mCompleteDateTextView;
        }

    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            this.mTasks = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View taskView = inflater.inflate(R.layout.activity_task_list_item, parent, false);
            return new TaskHolder(taskView);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.getCompleteDateTextView().setText(task.getCompleteDate());
            holder.getResponsibleTextView().setText(task.getResponsible());
            holder.getTaskTitleTextView().setText(task.getTitle());
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }

}
