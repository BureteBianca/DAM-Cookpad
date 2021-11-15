package com.example.cookpad;

import java.util.List;

public interface IResponse {
    void onSuccess(List<Model> preparat);
    void onError(String mesaj);
}
