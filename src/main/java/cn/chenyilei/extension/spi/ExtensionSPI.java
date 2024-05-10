package cn.chenyilei.extension.spi;

import java.lang.annotation.*;

/**
 * Marker for extension interface
 * 
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtensionSPI {

    /**
     * default extension name
     */
    String value() default "";
}
