package EntityApp;

import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;

// Main Application

public class EntityMain {

    public static void main(String[] args) {
        ServiceEndpointServer server = new EndpointServerBuilder().setPort(8085).build();
        server.initServices(new EntityData());
        server.start();
    }



}

