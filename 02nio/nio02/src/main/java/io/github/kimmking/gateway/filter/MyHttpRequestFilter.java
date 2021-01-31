package io.github.kimmking.gateway.filter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.CharsetUtil;

/**
 * @author ohYoung
 * @date 2021/1/31 2:15
 */
public class MyHttpRequestFilter implements HttpRequestFilter{

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        ByteBuf contentByte = fullRequest.content();
        if (contentByte == null) {
            return;
        }
        /*String content = contentByte.toString(CharsetUtil.UTF_8);
        if ("".equals(content)) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
