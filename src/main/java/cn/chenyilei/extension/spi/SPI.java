package cn.chenyilei.extension.spi;

import java.lang.annotation.*;

/**
 * Marker for extension interface
 * 
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SPI {

    /**
     * default extension name
     */
    String value() default "";
}
