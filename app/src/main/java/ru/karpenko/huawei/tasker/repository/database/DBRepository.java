package ru.karpenko.huawei.tasker.repository.database;

import okhttp3.OkHttpClient;

public class DBRepository {

    protected static final String CONNECTION_URL = "http://cabinetos.ru/tasker/hs/mobile/";
    protected static final String METHOD_GET_TASKS = "/getTasks";

    protected OkHttpClient mOkHttpClient;

    public DBRepository(){mOkHttpClient = new OkHttpClient();}

}
