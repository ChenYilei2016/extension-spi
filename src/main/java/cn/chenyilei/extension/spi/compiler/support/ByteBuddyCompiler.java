package cn.chenyilei.extension.spi.compiler.support;

import cn.chenyilei.extension.spi.Activate;

/**
 * @author chenyilei
 * @date 2023/09/24 16:21
 */
@Activate()
public class ByteBuddyCompiler extends AbstractCompiler {

    @Override
    protected Class<?> doCompile(String name, String source) throws Throwable {
        return null;
    }
}
