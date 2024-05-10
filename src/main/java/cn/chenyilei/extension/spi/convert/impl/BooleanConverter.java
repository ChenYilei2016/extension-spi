package cn.chenyilei.extension.spi.convert.impl;



import cn.chenyilei.extension.spi.convert.AbstractConverter;
import cn.chenyilei.extension.spi.utils.MyBooleanUtils;

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
