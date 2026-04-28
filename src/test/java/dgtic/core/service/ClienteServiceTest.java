package dgtic.core.service;

import dgtic.core.service.cliente.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteServiceTest {
    @Autowired
    ClienteServiceImpl cliente;

    @Test
    void clienteVenta(){


        Cliente cliente1=cliente.obtenerCliente(1L);
        for (Venta v:cliente1.getVentas()) {
            System.out.println(v);
        }
    }
}