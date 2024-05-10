package io.github.chenyilei2016.extension.spi.kernel;

/**
 * Holder
 */
public class Holder<T> {

    private volatile T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}
