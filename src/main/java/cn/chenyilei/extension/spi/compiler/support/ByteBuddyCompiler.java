package cn.chenyilei.extension.spi.compiler.support;

import cn.chenyilei.extension.spi.ExtensionActivate;

/**
 * @author chenyilei
 * @date 2023/09/24 16:21
 */
@ExtensionActivate()
public class ByteBuddyCompiler extends AbstractCompiler {

    @Override
    protected Class<?> doCompile(String name, String source) throws Throwable {
        return null;
    }
}
