package java0.nio01.homework;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 使用Netty访问Server
 * @author ohYoung
 * @date 2021/1/31 11:47
 */
public class MyNettyClient {

    /**
     * @param host
     * @param port
     * @throws Exception
     */
    public void connect(String host, int port) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    // 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast(new MyHttpInboundHandler());
                }
            });
            // 发起连接.
            ChannelFuture f = b.connect(host, port).sync();
            sendRequest(f);
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * @param cf
     * @throws Exception
     */
    public static void sendRequest(ChannelFuture cf) throws Exception{
        URI uri = new URI("http://localhost:8801");
        String msg = "xxx";
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1,
                HttpMethod.GET,uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes(StandardCharsets.UTF_8)));

        // 构建http请求
        request.headers().set(HttpHeaders.Names.HOST, "127.0.0.1");
        request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());
        // 发送http请求
        cf.channel().write(request);
        cf.channel().flush();
    }

    public static void main(String[] args) throws Exception {
        MyNettyClient client = new MyNettyClient();
        client.connect("localhost", 8801);
    }
}
