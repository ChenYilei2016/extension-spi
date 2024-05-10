package io.github.chenyilei2016.extension.spi.factory;


import io.github.chenyilei2016.extension.spi.ExtensionFactory;
import io.github.chenyilei2016.extension.spi.ExtensionLoader;
import io.github.chenyilei2016.extension.spi.ExtensionSPI;

/**
 * SpiExtensionFactory
 */
public class SpiExtensionFactory implements ExtensionFactory {

    @Override
    public <T> T getExtension(Class<T> type, String name) {
        if (type.isInterface() && type.isAnnotationPresent(ExtensionSPI.class)) {
            ExtensionLoader<T> loader = ExtensionLoader.getExtensionLoader(type);
            if (!loader.getSupportedExtensions().isEmpty()) {
                return loader.getAdaptiveExtension();
            }
        }
        return null;
    }

}
