package facade;

import java.util.TreeMap;

import javax.rmi.CORBA.Util;

import almacenes.AlmacenIndice;
import almacenes.AlmacenMap;
import almacenes.AlmacenRutaDestino;
import almacenes.almacenRutaMapeada;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;

public class Datos {
	private AlmacenIndice<Cliente, String> clientes;
	private almacenRutaMapeada<Articulo, String> articulos;
	private AlmacenRutaDestino<Pedido> pedidos;
	
	public Datos() {
		super();
		this.clientes = new AlmacenIndice<>(Utiles.RUTACLIENTE,Utiles.RUTAINDICECLIENTES);
		this.articulos = new almacenRutaMapeada<>(new AlmacenMap<>(new TreeMap<String, Integer>(), Utiles.ARTICULO_MAP), Utiles.ART, Utiles.ARTICULOS, Utiles.DATA);
		this.pedidos = new AlmacenRutaDestino<>(Utiles.PEDIDORUTA, "ped");
	}
	
	public boolean grabarCliente(Cliente cliente) {
		return clientes.grabar(cliente, cliente.getRazonSocial());
	}
	
	public boolean borrarCliente(Cliente cliente) {
		boolean retorno=false;
		if(clientes.borrar(cliente.getRazonSocial()))retorno=true;
		return retorno;
	}
	
	public Cliente obtenerCliente(String razonSocial) {
		return clientes.obtener(razonSocial);
	}
	
	public boolean grabarArticulo(Articulo articulo) {
		return articulos.grabar(articulo, articulo.getNombre(), articulo.getIdArticulo());
	}
	
	public boolean borrarArticulo(Articulo articulo) {
		boolean retorno=false;
		if(articulos.borrar(articulo.getNombre()))retorno=true;
		return retorno;
	}
	
	public Articulo obtenerArticulo(String nombreArticulo) {
		return articulos.obtener(nombreArticulo);
	}
	
	public boolean grabarPedido(Pedido pedido) {
		return pedidos.grabar(String.valueOf(pedido.getNumero()), String.valueOf(pedido.getCliente().getDniCif()), pedido);
	}
	
	public boolean borrarPedido(Pedido pedido) {
		boolean retorno=false;
		if(pedidos.borrar(pedido))retorno=true;
		return retorno;
	}
	
	public Pedido obtenerPedido(String nombrePedido,String nombreCliente) {
		return pedidos.obtener(nombreCliente, nombrePedido);
	}
	
	
}