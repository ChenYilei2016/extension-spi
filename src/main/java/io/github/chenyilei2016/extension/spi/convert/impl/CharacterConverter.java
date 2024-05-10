package io.github.chenyilei2016.extension.spi.convert.impl;


import io.github.chenyilei2016.extension.spi.convert.AbstractConverter;
import io.github.chenyilei2016.extension.spi.utils.MyBooleanUtils;
import io.github.chenyilei2016.extension.spi.utils.MyStrUtils;

/**
 * 字符转换器
 */
public class CharacterConverter extends AbstractConverter<Character> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Character convertInternal(Object value) {
        if (value == null) {
            return null;
        }

        if (Character.class == value.getClass()) {
            return (Character) value;
        } else if (value instanceof Boolean) {
            return MyBooleanUtils.toCharacter((Boolean) value);
        } else {
            final String valueStr = convertToStr(value);
            if (MyStrUtils.isNotBlank(valueStr)) {
                return valueStr.charAt(0);
            }
        }
        return null;
    }

}
