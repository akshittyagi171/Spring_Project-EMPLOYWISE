package com.employee_wise.assignment.entity;

import java.lang.reflect.Field;
import java.util.Arrays;

public interface NonNullCopier<T> {

    default void autoCopy(T src){
        if ( getClass() != src.getClass() ) return;
        Field[] fields = getClass().getDeclaredFields();
        Arrays.stream(fields).forEach( f -> {
            try {
                Object val = f.get(src) ;
                if ( val != null ){
                    f.set(this, val);
                }
            } catch (IllegalAccessException ignored) {
            }
        });
    }
}
