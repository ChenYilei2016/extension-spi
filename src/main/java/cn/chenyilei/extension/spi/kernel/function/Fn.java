package cn.chenyilei.extension.spi.kernel.function;

import java.io.Serializable;
import java.util.function.Function;

/**
 * 
 */
public interface Fn<T, R> extends Function<T, R>, Serializable {
}
