package org.example.generics;

import java.util.List;

public class Print {
    public List<? extends Vehicle> setPrintValues(List<? extends Vehicle> vehicleList) {
        return vehicleList;
    }
}
