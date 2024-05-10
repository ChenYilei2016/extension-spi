package cn.chenyilei.extension.spi.factory;


import cn.chenyilei.extension.spi.ExtensionFactory;
import cn.chenyilei.extension.spi.ExtensionLoader;
import cn.chenyilei.extension.spi.ExtensionSPI;

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
