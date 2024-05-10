package io.github.chenyilei2016.extension.spi.convert.impl;


import io.github.chenyilei2016.extension.spi.convert.AbstractConverter;
import io.github.chenyilei2016.extension.spi.utils.MyBooleanUtils;
import io.github.chenyilei2016.extension.spi.utils.MyDateUtils;
import io.github.chenyilei2016.extension.spi.utils.MyNumberUtils;
import io.github.chenyilei2016.extension.spi.utils.MyStrUtils;

import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * 原始类型转换器<br>
 * 支持类型为：<br>
 * <ul>
 * 		<li><code>byte</code></li>
 * 		<li><code>short</code></li>
 * 		<li><code>int</code></li>
 * 		<li><code>long</code></li>
 * 		<li><code>float</code></li>
 * 		<li><code>double</code></li>
 * 		<li><code>char</code></li>
 * 		<li><code>boolean</code></li>
 * </ul>MyCharUtils
 */
public class PrimitiveConverter extends AbstractConverter<Object> {
    private static final long serialVersionUID = 1L;

    private Class<?> targetType;

    /**
     * 构造<br>
     *
     * @param clazz 需要转换的原始
     * @throws IllegalArgumentException 传入的转换类型非原始类型时抛出
     */
    public PrimitiveConverter(Class<?> clazz) {
        if (null == clazz) {
            throw new NullPointerException("PrimitiveConverter not allow null target type!");
        } else if (!clazz.isPrimitive()) {
            throw new IllegalArgumentException("[" + clazz + "] is not a primitive class!");
        }
        this.targetType = clazz;
    }

    @Override
    protected Object convertInternal(Object value) {
        try {
            if (byte.class == this.targetType) {
                if (value instanceof Number) {
                    return ((Number) value).byteValue();
                } else if (value instanceof Boolean) {
                    return MyBooleanUtils.toByte((Boolean) value);
                }
                final String valueStr = convertToStr(value);
                if (MyStrUtils.isBlank(valueStr)) {
                    return 0;
                }
                return Byte.parseByte(valueStr);

            } else if (short.class == this.targetType) {
                if (value instanceof Number) {
                    return ((Number) value).shortValue();
                } else if (value instanceof Boolean) {
                    return MyBooleanUtils.toShort((Boolean) value);
                }
                final String valueStr = convertToStr(value);
                if (MyStrUtils.isBlank(valueStr)) {
                    return 0;
                }
                return Short.parseShort(valueStr);

            } else if (int.class == this.targetType) {
                if (value instanceof Number) {
                    return ((Number) value).intValue();
                } else if (value instanceof Boolean) {
                    return MyBooleanUtils.toInt((Boolean) value);
                } else if (value instanceof Date) {
                    return ((Date) value).getTime();
                } else if (value instanceof Calendar) {
                    return ((Calendar) value).getTimeInMillis();
                } else if (value instanceof TemporalAccessor) {
                    return MyDateUtils.toInstant((TemporalAccessor) value).toEpochMilli();
                }

                final String valueStr = convertToStr(value);
                if (MyStrUtils.isBlank(valueStr)) {
                    return 0;
                }
                return MyNumberUtils.parseInt(valueStr);

            } else if (long.class == this.targetType) {
                if (value instanceof Number) {
                    return ((Number) value).longValue();
                } else if (value instanceof Boolean) {
                    return MyBooleanUtils.toLong((Boolean) value);
                } else if (value instanceof Date) {
                    return ((Date) value).getTime();
                } else if (value instanceof Calendar) {
                    return ((Calendar) value).getTimeInMillis();
                } else if (value instanceof TemporalAccessor) {
                    return MyDateUtils.toInstant((TemporalAccessor) value).toEpochMilli();
                }

                final String valueStr = convertToStr(value);
                if (MyStrUtils.isBlank(valueStr)) {
                    return 0;
                }
                return MyNumberUtils.parseLong(valueStr);

            } else if (float.class == this.targetType) {
                if (value instanceof Number) {
                    return ((Number) value).floatValue();
                } else if (value instanceof Boolean) {
                    return MyBooleanUtils.toFloat((Boolean) value);
                }
                final String valueStr = convertToStr(value);
                if (MyStrUtils.isBlank(valueStr)) {
                    return 0;
                }
                return Float.parseFloat(valueStr);

            } else if (double.class == this.targetType) {
                if (value instanceof Number) {
                    return ((Number) value).doubleValue();
                } else if (value instanceof Boolean) {
                    return MyBooleanUtils.toDouble((Boolean) value);
                }
                final String valueStr = convertToStr(value);
                if (MyStrUtils.isBlank(valueStr)) {
                    return 0;
                }
                return Double.parseDouble(valueStr);

            } else if (char.class == this.targetType) {
                if (value instanceof Character) {
                    //noinspection UnnecessaryUnboxing
                    return ((Character) value).charValue();
                } else if (value instanceof Boolean) {
                    return MyBooleanUtils.toChar((Boolean) value);
                }
                final String valueStr = convertToStr(value);
                if (MyStrUtils.isBlank(valueStr)) {
                    return 0;
                }
                return valueStr.charAt(0);
            } else if (boolean.class == this.targetType) {
                if (value instanceof Boolean) {
                    //noinspection UnnecessaryUnboxing
                    return ((Boolean) value).booleanValue();
                }
                String valueStr = convertToStr(value);
                return MyBooleanUtils.toBoolean(valueStr);
            }
        } catch (Throwable e) {
            // Ignore Exception
        }
        return 0;
    }

    @Override
    protected String convertToStr(Object value) {
        return MyStrUtils.trim(super.convertToStr(value));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Object> getTargetType() {
        return (Class<Object>) this.targetType;
    }
}
