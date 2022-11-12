package com.example.tech11Test.business.abstractModule;

import java.util.List;

public abstract class AbstractGetAllState<T > {

    public  abstract  List<T> getAllUsers (int limit, int offset );


}
