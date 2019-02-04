package jx.hello.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private List<String> dummyData = new ArrayList<>();

    public void init() {
        for (int i = 0; i < 10; i++) {
            dummyData.add("Hello " + i);
        }
    }

    public List<String> getDummyData() {
        return dummyData;
    }


}
