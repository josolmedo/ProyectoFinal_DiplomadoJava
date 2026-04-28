/*package dgtic.core.mapping;

import dgtic.core.model.dto.venta.VentaDTO;
import dgtic.core.model.dto.cliente.ClienteDTO;
import dgtic.core.model.dto.producto.ProductoDTO;

public class Mapper {
    //Producto a ProductoDTO
    public static ProductoDTO toProductoDTO(Producto producto){
        if(producto==null){
            return null;
        }
        return ProductoDTO.builder()
                .id_producto(producto.getId_producto())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .imagen(producto.getImagen())
                .build();
    }
    //ProductoDTO a Producto
    public static Producto toProducto(ProductoDTO producto){
        if(producto==null){
            return null;
        }
        return Producto.builder()
                .id_producto(producto.getId_producto())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .imagen(producto.getImagen())
                .build();
    }

    //Cliente a ClienteDTO
    public static ClienteDTO toClienteDTO(Cliente cliente){
        if(cliente==null){
            return null;
        }
        return ClienteDTO.builder()
                .id_cliente(cliente.getId_cliente())
                .nombre(cliente.getNombre())
                .email(cliente.getEmail())
                .telefono(cliente.getTelefono())
                .ciudad(cliente.getCiudad())
                .build();

    }
    //ClienteDTO a Cliente
    public static Cliente toCliente(ClienteDTO clienteDTO){
        if(clienteDTO==null){
            return null;
        }
        return Cliente.builder()
                .id_cliente(clienteDTO.getId_cliente())
                .nombre(clienteDTO.getNombre())
                .email(clienteDTO.getEmail())
                .telefono(clienteDTO.getTelefono())
                .ciudad(clienteDTO.getCiudad())
                .build();

    }

    //Venta a VentaDTO
    public static VentaDTO toVentaDTO(Venta venta){
        if(venta==null){
            return null;
        }
        return VentaDTO.builder()
                .id_venta(venta.getId_venta())
                .cliente(venta.getCliente().getId_cliente())
                .fecha(venta.getFecha())
                .total(venta.getTotal())
                .build();
    }

}*/
