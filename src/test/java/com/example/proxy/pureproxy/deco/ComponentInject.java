package com.example.proxy.pureproxy.deco;

public abstract class ComponentInject implements Component{

    private  Component component;

    public ComponentInject(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {

        return component.operation();
    }
}
