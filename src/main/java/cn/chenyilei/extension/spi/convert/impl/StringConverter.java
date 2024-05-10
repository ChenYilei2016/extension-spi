package cn.chenyilei.extension.spi.convert.impl;


import cn.chenyilei.extension.spi.convert.AbstractConverter;

/**
 * 字符串转换器MyCharUtils
 */
public class StringConverter extends AbstractConverter<String> {
    private static final long serialVersionUID = 1L;

    @Override
    protected String convertInternal(Object value) {
        return convertToStr(value);
    }

}
