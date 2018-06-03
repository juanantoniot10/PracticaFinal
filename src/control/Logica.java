package control;

import org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Vector;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Datos;
import modelo.Pedido;

public class Logica {
	private Datos datos;
	Puente puente;

	public Logica(Puente puente) {
		super();
		this.datos = new Datos();
		this.puente = puente;
	}

	public Boolean darAltaArticulo(Articulo articulo) {
		return datos.grabarArticulo(articulo);
	}

	public Articulo buscarArticulo() {
		return null;
	}

	public Boolean modificarPrecio() {
		return null;
	}

	public Boolean darAltaCliente(Cliente cliente) {
		assertTrue(new Validador(puente).validarCliente(cliente));
		return datos.grabarCliente(cliente);
	}

	public Cliente buscarCliente() {
		return null;
	}

	public Boolean borrarCliente() {
		return null;
	}

	private Boolean darAltaPedido() {
		return null;
	}

	public Pedido consultarPedido() {
		return null;
	}

	public ArrayList consultarHistorico() {
		return null;
	}

	public Boolean insertarLineaPedido() {
		return null;
	}

	private int idArticulo = 0;

	public int getIdArticulo() {
		this.idArticulo=this.idArticulo+1;
		return idArticulo;
	}

}