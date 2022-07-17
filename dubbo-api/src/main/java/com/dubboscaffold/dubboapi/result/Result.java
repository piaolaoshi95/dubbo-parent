package com.dubboscaffold.dubboapi.result;

import lombok.Data;

@Data
public class Result {
    private int code;

    public Result(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                '}';
    }
}
