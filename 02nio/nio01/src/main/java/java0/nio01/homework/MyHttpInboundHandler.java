package java0.nio01.homework;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.CharsetUtil;

/**
 * @author ohYoung
 * @date 2021/1/31 11:51
 */
public class MyHttpInboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) msg;
            HttpHeaders header = response.headers();
            System.out.println("> CONTENT_TYPE:" + header.get(HttpHeaders.Names.CONTENT_TYPE));
        }
        if(msg instanceof HttpContent) {
            HttpContent content = (HttpContent)msg;
            ByteBuf buf = content.content();
            System.out.println("> CONTENT:");
            System.out.println(buf.toString(CharsetUtil.UTF_8));
            buf.release();
        }
        ctx.fireChannelRead(msg);
    }
}
