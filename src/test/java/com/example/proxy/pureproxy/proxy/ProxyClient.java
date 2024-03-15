package com.example.proxy.pureproxy.proxy;

public class ProxyClient {

    private Subject subject;

    public ProxyClient(Subject subject) {
        this.subject = subject;
    }

    public void execute(){
        subject.operation();
    }
}
