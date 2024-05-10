package io.github.chenyilei2016.extension.spi;

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
