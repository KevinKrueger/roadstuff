package com.kevinkrueger.roadstuff;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ReflectionUtils {
    public ReflectionUtils() {
    }

    public static boolean hasAnnotation(Field field, Class<? extends Annotation> annotationClass) {
        Annotation[] var2 = field.getAnnotations();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Annotation annotation = var2[var4];
            if (annotation.annotationType().equals(annotationClass)) {
                return true;
            }
        }

        return false;
    }
}
