package ru.karpenko.huawei.tasker.model;

public class Task extends Entity{

    private String title;
    private String completeDate;
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
