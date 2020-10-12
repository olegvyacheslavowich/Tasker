package ru.karpenko.huawei.tasker.repository.database;

import java.util.List;

public interface Repository<T> {

    List<T> getList() throws Exception;

}
