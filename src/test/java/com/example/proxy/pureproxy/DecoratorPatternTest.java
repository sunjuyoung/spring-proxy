package com.example.proxy.pureproxy;

import com.example.proxy.pureproxy.deco.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RequestMapping
public class DecoratorPatternTest {

    @Test
    void noDecoTest() throws SQLException {
        Component realCompoenent = new RealComponent();
        DecoratorClient decoratorClient = new DecoratorClient(realCompoenent);
        decoratorClient.execute();
    }

    @Test
    void decoTest1(){
        Component realCompoenent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realCompoenent);
        DecoratorClient decoratorClient = new DecoratorClient(messageDecorator);
        decoratorClient.execute();
    }

    @Test
    void decoTest2(){
        Component realCompoenent = new RealComponent();

        Component messageDecorator = new MessageDecorator(realCompoenent);
        Component timeDeco = new TimeDecorator(messageDecorator);
        DecoratorClient decoratorClient = new DecoratorClient(timeDeco);
        decoratorClient.execute();
    }
}
