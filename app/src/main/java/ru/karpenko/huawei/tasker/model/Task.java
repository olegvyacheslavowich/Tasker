package ru.karpenko.huawei.tasker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Task extends Entity{

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("date")
    @Expose
    private String completeDate;

    @SerializedName("user")
    @Expose
    private String responsible;

    public Task(String title, String completeDate, String responsible) {
        this.title = title;
        this.completeDate = completeDate;
        this.responsible = responsible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
