package io.github.chenyilei2016.extension.spi.convert.impl;



import io.github.chenyilei2016.extension.spi.convert.AbstractConverter;
import io.github.chenyilei2016.extension.spi.utils.MyBooleanUtils;

/**
 * 布尔转换器MyCharUtils
 */
public class BooleanConverter extends AbstractConverter<Boolean> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Boolean convertInternal(Object value) {
        if (null == value) {
            return Boolean.FALSE;
        }
        if (Boolean.class == value.getClass()) {
            return (Boolean) value;
        }
        String valueStr = convertToStr(value);
        return MyBooleanUtils.toBoolean(valueStr);
    }

}
