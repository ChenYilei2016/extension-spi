package cn.chenyilei.extension.spi.convert.impl;


import cn.chenyilei.extension.spi.convert.AbstractConverter;
import cn.chenyilei.extension.spi.utils.MyBooleanUtils;
import cn.chenyilei.extension.spi.utils.MyNumberUtils;
import cn.chenyilei.extension.spi.utils.MyStrUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 数字转换器<br>
 * 支持类型为：<br>
 * <ul>
 * <li><code>java.lang.Byte</code></li>
 * <li><code>java.lang.Short</code></li>
 * <li><code>java.lang.Integer</code></li>
 * <li><code>java.lang.Long</code></li>
 * <li><code>java.lang.Float</code></li>
 * <li><code>java.lang.Double</code></li>
 * <li><code>java.math.BigDecimal</code></li>
 * <li><code>java.math.BigInteger</code></li>
 * </ul>
 *
 *
 */
public class NumberConverter extends AbstractConverter<Number> {
    private static final long serialVersionUID = 1L;

    private Class<? extends Number> targetType;

    public NumberConverter() {
        this.targetType = Number.class;
    }

    /**
     * 构造<br>
     *
     * @param clazz 需要转换的数字类型，默认 {@link Number}
     */
    public NumberConverter(Class<? extends Number> clazz) {
        this.targetType = (null == clazz) ? Number.class : clazz;
    }

    @Override
    protected Number convertInternal(Object value) {
        final Class<?> targetType = this.targetType;
        if (Byte.class == targetType) {
            if (value instanceof Number) {
                return ((Number) value).byteValue();
            } else if (value instanceof Boolean) {
                return MyBooleanUtils.toByteObj((Boolean) value);
            }
            final String valueStr = convertToStr(value);
            return MyStrUtils.isBlank(valueStr) ? null : Byte.valueOf(valueStr);

        } else if (Short.class == targetType) {
            if (value instanceof Number) {
                return ((Number) value).shortValue();
            } else if (value instanceof Boolean) {
                return MyBooleanUtils.toShortObj((Boolean) value);
            }
            final String valueStr = convertToStr(value);
            return MyStrUtils.isBlank(valueStr) ? null : Short.valueOf(valueStr);

        } else if (Integer.class == targetType) {
            if (value instanceof Number) {
                return ((Number) value).intValue();
            } else if (value instanceof Boolean) {
                return MyBooleanUtils.toInteger((Boolean) value);
            }
            final String valueStr = convertToStr(value);
            return MyStrUtils.isBlank(valueStr) ? null : MyNumberUtils.parseInt(valueStr);

        } else if (AtomicInteger.class == targetType) {
            final AtomicInteger intValue = new AtomicInteger();
            if (value instanceof Number) {
                intValue.set(((Number) value).intValue());
            } else if (value instanceof Boolean) {
                intValue.set(MyBooleanUtils.toInt((Boolean) value));
            }
            final String valueStr = convertToStr(value);
            if (MyStrUtils.isBlank(valueStr)) {
                return null;
            }
            intValue.set(MyNumberUtils.parseInt(valueStr));
            return intValue;
        } else if (Long.class == targetType) {
            if (value instanceof Number) {
                return ((Number) value).longValue();
            } else if (value instanceof Boolean) {
                return MyBooleanUtils.toLongObj((Boolean) value);
            }
            final String valueStr = convertToStr(value);
            return MyStrUtils.isBlank(valueStr) ? null : MyNumberUtils.parseLong(valueStr);

        } else if (AtomicLong.class == targetType) {
            final AtomicLong longValue = new AtomicLong();
            if (value instanceof Number) {
                longValue.set(((Number) value).longValue());
            } else if (value instanceof Boolean) {
                longValue.set(MyBooleanUtils.toLong((Boolean) value));
            }
            final String valueStr = convertToStr(value);
            if (MyStrUtils.isBlank(valueStr)) {
                return null;
            }
            longValue.set(MyNumberUtils.parseLong(valueStr));
            return longValue;

        } else if (Float.class == targetType) {
            if (value instanceof Number) {
                return ((Number) value).floatValue();
            } else if (value instanceof Boolean) {
                return MyBooleanUtils.toFloatObj((Boolean) value);
            }
            final String valueStr = convertToStr(value);
            return MyStrUtils.isBlank(valueStr) ? null : Float.valueOf(valueStr);

        } else if (Double.class == targetType) {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            } else if (value instanceof Boolean) {
                return MyBooleanUtils.toDoubleObj((Boolean) value);
            }
            final String valueStr = convertToStr(value);
            return MyStrUtils.isBlank(valueStr) ? null : Double.valueOf(valueStr);

        } else if (BigDecimal.class == targetType) {
            return toBigDecimal(value);

        } else if (BigInteger.class == targetType) {
            return toBigInteger(value);

        } else if (Number.class == targetType) {
            if (value instanceof Number) {
                return (Number) value;
            } else if (value instanceof Boolean) {
                return MyBooleanUtils.toInteger((Boolean) value);
            }
            final String valueStr = convertToStr(value);
            return MyStrUtils.isBlank(valueStr) ? null : MyNumberUtils.parseNumber(valueStr);
        }

        throw new UnsupportedOperationException(MyStrUtils.format("Unsupport Number type: {}", this.targetType.getName()));
    }

    /**
     * 转换为BigDecimal<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     *
     * @param value 被转换的值
     * @return 结果
     */
    private BigDecimal toBigDecimal(Object value) {
        if (value instanceof Long) {
            return new BigDecimal((Long) value);
        } else if (value instanceof Integer) {
            return new BigDecimal((Integer) value);
        } else if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger) value);
        } else if (value instanceof Boolean) {
            return new BigDecimal((boolean) value ? 1 : 0);
        }

        //对于Double类型，先要转换为String，避免精度问题
        final String valueStr = convertToStr(value);
        if (MyStrUtils.isBlank(valueStr)) {
            return null;
        }
        return new BigDecimal(valueStr);
    }

    /**
     * 转换为BigInteger<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     *
     * @param value 被转换的值
     * @return 结果
     */
    private BigInteger toBigInteger(Object value) {
        if (value instanceof Long) {
            return BigInteger.valueOf((Long) value);
        } else if (value instanceof Boolean) {
            return BigInteger.valueOf((boolean) value ? 1 : 0);
        }
        final String valueStr = convertToStr(value);
        if (MyStrUtils.isBlank(valueStr)) {
            return null;
        }
        return new BigInteger(valueStr);
    }

    @Override
    protected String convertToStr(Object value) {
        return MyStrUtils.trim(super.convertToStr(value));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Number> getTargetType() {
        return (Class<Number>) this.targetType;
    }
}
