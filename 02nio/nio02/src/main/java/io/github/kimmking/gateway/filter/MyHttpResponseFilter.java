package io.github.kimmking.gateway.filter;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.CharsetUtil;

/**
 * @author ohYoung
 * @date 2021/1/31 2:19
 */
public class MyHttpResponseFilter implements HttpResponseFilter{

    @Override
    public void filter(FullHttpResponse response) {
        ByteBuf contentByte = response.content();
        String content = contentByte.toString(CharsetUtil.UTF_8);
        response.headers().set("MyResponseHead", "success");
    }
}
