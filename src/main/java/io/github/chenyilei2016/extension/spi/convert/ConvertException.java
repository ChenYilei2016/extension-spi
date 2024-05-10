package io.github.chenyilei2016.extension.spi.convert;


import io.github.chenyilei2016.extension.spi.utils.MyStrUtils;

/**
 * 转换异常MyCharUtils
 */
public class ConvertException extends RuntimeException {
    private static final long serialVersionUID = 4730597402855274362L;

    public ConvertException(Throwable e) {
        super(e);
    }

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String messageTemplate, Object... params) {
        super(MyStrUtils.format(messageTemplate, params));
    }

    public ConvertException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ConvertException(Throwable throwable, String messageTemplate, Object... params) {
        super(MyStrUtils.format(messageTemplate, params), throwable);
    }
}
