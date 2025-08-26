/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ncquality.sad.util;

import java.lang.reflect.Constructor;

/**
 *
 * @author USUARIO
 */
public class GenericMapper {
      public static <T> T mapFromObjectArray(Object[] values, Class<T> clazz) {
        for (Constructor<?> constructor : clazz.getConstructors()) {
            if (constructor.getParameterCount() == values.length) {
                try {
                    return (T) constructor.newInstance(values);
                } catch (Exception e) {
                    throw new RuntimeException("Error al instanciar DTO: " + e.getMessage(), e);
                }
            }
        }
        throw new IllegalArgumentException("No constructor coincide con el número de parámetros.");
    }
}
