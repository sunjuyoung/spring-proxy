package com.example.proxy.pureproxy;


import com.example.proxy.pureproxy.proxy.CacheProxy;
import com.example.proxy.pureproxy.proxy.ProxyClient;
import com.example.proxy.pureproxy.proxy.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyClient client  = new ProxyClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void proxyTest(){

        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyClient client = new ProxyClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
