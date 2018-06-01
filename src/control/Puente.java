package control;

import javax.swing.JPanel;

import acciones.AddLinea;
import acciones.BorrarCliente;
import acciones.BuscarArticulo;
import acciones.BuscarCliente;
import acciones.ConsultarPedido;
import acciones.GuardarCliente;
import acciones.ListenerAccederAltaArticulo;
import acciones.ListenerAccederAltaCliente;
import acciones.ListenerAccederAltaPedido;
import acciones.ListenerAccederBorrarCliente;
import acciones.ListenerAccederBuscarArticulo;
import acciones.ListenerAccederBuscarCliente;
import acciones.ListenerAccederBuscarPedido;
import acciones.ListenerMainArticulo;
import acciones.ListenerMainCliente;
import acciones.ListenerMainPedido;
import acciones.ModificarArticulo;
import acciones.RegistrarArticulo;
import acciones.RegistrarCliente;
import acciones.RegistrarPedido;
import vista.VistaPrincipal;

public class Puente extends VistaPrincipal {

	private ConsultarPedido consultarPedido;
	private BuscarArticulo buscadorArticulo;
	private RegistrarCliente registrarCliente;
	private BorrarCliente borrarCliente;
	private ModificarArticulo modificarArticulo;
	private BuscarCliente buscarCliente;
	private RegistrarPedido registrarPedido;
	private RegistrarArticulo registarArticulo;
	private Logica logica;
	private Validador validador;
	private ListenerMainArticulo listenerMainArticulo;
	private ListenerAccederAltaArticulo listenerAccederAltaArticulo;
	private ListenerAccederBuscarArticulo listenerAccederBuscarArticulo;
	private ListenerAccederAltaCliente listenerAccederAltaCliente;
	private ListenerAccederBuscarCliente listenerAccederBuscarCliente;
	private ListenerAccederBorrarCliente listenerAccederBorrarCliente;
	private ListenerAccederAltaPedido listenerAccederAltaPedido;
	private ListenerAccederBuscarPedido listenerAccederBuscarPedido;
	private ListenerMainPedido listenerMainPedido;
	private ListenerMainCliente listenerMainCliente;
	private GuardarCliente guardarCliente;
	private AddLinea addLinea;

	public void inicializarListeners() {
		listenerMainArticulo = new ListenerMainArticulo(this);
		listenerAccederAltaArticulo = new ListenerAccederAltaArticulo(this);
		listenerAccederBuscarArticulo = new ListenerAccederBuscarArticulo(this);
		listenerAccederAltaCliente = new ListenerAccederAltaCliente(this);
		listenerAccederBuscarCliente = new ListenerAccederBuscarCliente(this);
		listenerAccederBorrarCliente = new ListenerAccederBorrarCliente(this);
		registrarCliente = new RegistrarCliente(this);
		listenerAccederAltaPedido = new ListenerAccederAltaPedido(this);
		listenerAccederBuscarPedido = new ListenerAccederBuscarPedido(this);
		registrarPedido = new RegistrarPedido(this);
		listenerMainPedido = new ListenerMainPedido(this);
		registarArticulo = new RegistrarArticulo(this);
		listenerMainCliente = new ListenerMainCliente(this);
		guardarCliente = new GuardarCliente(this);
		addLinea = new AddLinea(this);
	}

	public Puente() {
		super();
		inicializarListeners();
		validador = new Validador();
		asignarListeners();

	}

	private void asignarListeners() {
		this.getBotonArticulo().addActionListener(listenerMainArticulo);
		this.panelArticulo.getBotonAltaArticulo().addActionListener(listenerAccederAltaArticulo);
		this.panelArticulo.getBotonBuscarArticulo().addActionListener(listenerAccederBuscarArticulo);
		this.mntmDarDeAlta.addActionListener(listenerAccederAltaArticulo);
		this.mntmBuscarArticulo.addActionListener(listenerAccederBuscarArticulo);
		this.getVistaEjecutarAltaArticulo().getBtnGuardar().addActionListener((registarArticulo));

		this.panelCliente.getBotonCliente().addActionListener(listenerMainCliente);
		this.panelCliente.getBtnAltaCliente().addActionListener(listenerAccederAltaCliente);
		this.panelCliente.getBtnBorrarCliente().addActionListener(listenerAccederBorrarCliente);
		this.panelCliente.getBtnBuscarCliente().addActionListener(listenerAccederBuscarCliente);
		this.mntmBuscarCliente.addActionListener(listenerAccederBuscarCliente);
		this.mntmDarAltaCliente.addActionListener(listenerAccederAltaCliente);
		this.getVistaAccederAltaCliente().getVistaEjecutarAltaCliente().getBtnValidar()
				.addActionListener(guardarCliente);
		this.getVistaAccederAltaCliente().getVistaEjecutarAltaCliente().getBtnValidar()
				.addActionListener(registrarCliente);

		this.panelPedido.getBotonPedido().addActionListener(listenerMainPedido);
		this.panelPedido.getBtnAccederAltaPedido().addActionListener(listenerAccederAltaPedido);
		this.panelPedido.getBtnConsultarPedidos().addActionListener(listenerAccederBuscarPedido);
		this.mntmBuscarPedido.addActionListener(listenerAccederBuscarPedido);
		this.mntmNuevoPedido.addActionListener(listenerAccederAltaPedido);
		this.getVistaAccederAltaPedido().getVistaEjecutarAltaPedido().getBtnConfirmarPedido()
				.addActionListener(registrarPedido);
		this.getVistaAccederAltaPedido().getVistaEjecutarAltaPedido().getBtnAddLinea().addActionListener(addLinea);

	}

	public Validador getValidador() {
		return validador;
	}

}