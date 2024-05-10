package cn.chenyilei.extension.spi.compiler.support;

import cn.chenyilei.extension.spi.kernel.URL;
import cn.chenyilei.extension.spi.ExtensionLoader;
import cn.chenyilei.extension.spi.compiler.Compiler;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author chenyilei
 * @date 2023/09/24 16:14
 */
public class JavassistCompilerTest {

    @Test
    public void testCode(){
        System.err.println("1");

        Compiler defaultExtension = ExtensionLoader.getExtensionLoader(Compiler.class).getDefaultExtension();

        System.err.println(defaultExtension);

        defaultExtension = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();

        System.err.println(defaultExtension);

        System.err.println(ExtensionLoader.getExtensionLoader(Compiler.class).getDefaultExtension() ==
                ExtensionLoader.getExtensionLoader(Compiler.class).getDefaultExtension());
    }

    @Test
    public void classList(){
        ExtensionLoader<Compiler> extensionLoader = ExtensionLoader.getExtensionLoader(Compiler.class);
        Set<String> supportedExtensions = extensionLoader.getSupportedExtensions();
        System.err.println(supportedExtensions); //[byteBuddy, javassist, jdk]

        Set<Class<? extends Compiler>> supportedExtensionClass = extensionLoader.getSupportedExtensionClass();
        supportedExtensionClass.forEach(aClass -> System.err.println(aClass));
        System.err.println(supportedExtensionClass);

        Set<Pair<String, Class<? extends Compiler>>> supportedExtensionPairs = ExtensionLoader.getExtensionLoader(Compiler.class).getSupportedExtensionPairs();
        System.err.println(supportedExtensionPairs);


        Class<Compiler> c = ExtensionLoader.getExtensionLoader(Compiler.class).getDefaultExtensionClass();
        System.err.println(c);
    }


    @Test
    public void activate(){
        URL url = new URL(new HashMap<>());
        List<Compiler> activateExtension = ExtensionLoader.getExtensionLoader(Compiler.class)
                .getActivateExtension(url, "");
        System.err.println(activateExtension);

        for (Compiler compiler : activateExtension) {

        }
    }

    @Test
    public void adapter(){
        Compiler adaptiveExtension = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();
        System.err.println(adaptiveExtension);
    }
}