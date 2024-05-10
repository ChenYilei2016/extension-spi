package io.github.chenyilei2016.extension.spi.utils;

import io.github.chenyilei2016.extension.spi.utils.tmp.TestGenericType;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * https://blog.csdn.net/JokerLJG/article/details/129041452
 * @author chenyilei
 * @date 2023/09/25 15:23
 */
public class MyTypeUtilsTest {


    @Test
    public void toParameterizedType(){

        TestGenericType<String> type = new TestGenericType<String>(){};

        ParameterizedType parameterizedType = MyTypeUtils.toParameterizedType(type.getClass());

        System.err.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
    }

    @Test
    public void getTypeArguments(){
        TestGenericType<String> type = new TestGenericType<String>();
        Type typeArgument = MyTypeUtils.getTypeArgument(type.getClass());

        System.err.println(typeArgument);
    }

}