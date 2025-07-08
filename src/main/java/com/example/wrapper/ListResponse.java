package com.example.wrapper;

import java.util.List;

public class ListResponse<T> {
    private List<T> data;
    public ListResponse(List<T> data) { this.data = data; }
    public List<T> getData() { return data; }
    public void setData(List<T> data) { this.data = data; }
} 