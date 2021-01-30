package java0.nio01.homework;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 使用HttpClient访问Server
 * @author ohYoung
 * @date 2021/1/31 1:29
 */
public class MyHttpClient {

    public static void main(String[] args) throws IOException {
        getContent();
    }

    public static String getContent() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://localhost:8801");
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        System.out.println("返回状态: " + response.getStatusLine());
        if (entity != null) {
            String content = EntityUtils.toString(entity);
            System.out.println("返回内容长度: " + entity.getContentLength());
            System.out.println("返回内容: " + content);
            return content;
        }
        return null;
    }

}
