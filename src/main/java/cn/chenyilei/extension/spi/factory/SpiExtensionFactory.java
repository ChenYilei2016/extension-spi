package cn.chenyilei.extension.spi.factory;


import cn.chenyilei.extension.spi.ExtensionFactory;
import cn.chenyilei.extension.spi.ExtensionLoader;
import cn.chenyilei.extension.spi.SPI;

/**
 * SpiExtensionFactory
 */
public class SpiExtensionFactory implements ExtensionFactory {

    @Override
    public <T> T getExtension(Class<T> type, String name) {
        if (type.isInterface() && type.isAnnotationPresent(SPI.class)) {
            ExtensionLoader<T> loader = ExtensionLoader.getExtensionLoader(type);
            if (!loader.getSupportedExtensions().isEmpty()) {
                return loader.getAdaptiveExtension();
            }
        }
        return null;
    }

}
