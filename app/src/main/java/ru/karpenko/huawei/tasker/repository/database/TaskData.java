package ru.karpenko.huawei.tasker.repository.database;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;
import ru.karpenko.huawei.tasker.model.Task;

public class TaskData extends DBRepository implements Repository<Task> {

    private static final String TAG_TASK_DATA = "repository.database";

    @Override
    public List<Task> getList() throws IOException {
        List<Task> tasks = new ArrayList<>();

        Request request = new Request.Builder()
                .url(CONNECTION_URL + METHOD_GET_TASKS)
                .build();

        try (Response response = mOkHttpClient.newCall(request).execute()) {
            Log.i(TAG_TASK_DATA, response.body().string());
        }

        return tasks;
    }
}
