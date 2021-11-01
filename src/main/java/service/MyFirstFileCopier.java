package service;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MyFirstFileCopier {

    public void copyFile() throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        });

        context.start();
        Thread.sleep(1_000);
        context.stop();
    }
}
