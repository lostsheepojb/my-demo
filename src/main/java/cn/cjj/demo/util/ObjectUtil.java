package cn.cjj.demo.util;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author cjj
 * @Date 2022/9/24 16:39
 **/
public class ObjectUtil {
    /**
     * 判断对象及其属性是否为为空，属性需要有对应的getter方法，否则会抛出异常
     *
     * @param t
     * @param propertyName 属性变量名
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> boolean isNull(T t, String propertyName) {
        if (propertyName == null) {
            throw new IllegalArgumentException("propertyName is null");
        }
        propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        String getterName = "get" + propertyName;
        return isNull2(t, getterName);
    }


    /**
     * 判断对象及其属性是否为为空
     *
     * @param t
     * @param getterName getter方法名称
     * @param <T>
     * @return
     */
    public static <T> boolean isNull2(T t, String getterName) {
        if (t == null) {
            return true;
        }
        if (getterName == null) {
            throw new IllegalArgumentException("getterName is null");
        }

        Class<T> clazz = (Class<T>) t.getClass();
        Method method = null;
        Object invoke = null;
        try {
            method = clazz.getMethod(getterName);
            invoke = method.invoke(t);
        } catch (Exception e) {
            return true;
        }

        return invoke != null;
    }
}
