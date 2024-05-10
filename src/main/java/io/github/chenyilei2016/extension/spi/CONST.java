package io.github.chenyilei2016.extension.spi;

import java.util.regex.Pattern;

/**
 * @author chenyilei
 * @date 2023/09/22 16:18
 */
public interface CONST {
    Pattern COMMA_SPLIT_PATTERN = Pattern.compile("\\s*[,]+\\s*");

    String PROJECT_NAME = "async-excel-center";

    String SPI_LOWER_KEY = "extension-spi";

    String DEFAULT_KEY = "default";

    String REMOVE_PREFIX = "-";

    String DOT = ".";

    String AT = "@";

    String SUB = "-";

    int MAX_TIMEOUT_TIME_MS = 3 * 60 * 60 * 1000;
}
