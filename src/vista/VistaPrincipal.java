package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;

public class VistaPrincipal extends JFrame {

	protected JPanel contentPane;
	protected PanelArticulo panelArticulo = new PanelArticulo();
	protected PanelCliente panelCliente = new PanelCliente();
	protected PanelPedido panelPedido = new PanelPedido();
	protected JPanel panel;
	protected JMenuItem mntmDarDeAlta;
	protected JMenuItem mntmBuscarArticulo;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArticulos = new JMenu("Articulos");
		menuBar.add(mnArticulos);

		mntmDarDeAlta = new JMenuItem("Nuevo Articulo");
		mnArticulos.add(mntmDarDeAlta);

		mntmBuscarArticulo = new JMenuItem("Buscar Articulo");
		mnArticulos.add(mntmBuscarArticulo);

		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);

		JMenuItem mntmDarAltaCliente = new JMenuItem("Nuevo Cliente");
		mnClientes.add(mntmDarAltaCliente);

		JMenuItem mntmBuscarCliente = new JMenuItem("Buscar Cliente");
		mnClientes.add(mntmBuscarCliente);

		JMenu mnPedidos = new JMenu("Pedidos");
		menuBar.add(mnPedidos);

		JMenuItem mntmNuevoPedido = new JMenuItem("Nuevo Pedido");
		mnPedidos.add(mntmNuevoPedido);

		JMenuItem mntmBuscarPedido = new JMenuItem("Buscar Pedido");
		mnPedidos.add(mntmBuscarPedido);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(panelArticulo);
		contentPane.add(panelCliente);
		contentPane.add(panelPedido);

	}

	public JButton getBotonArticulo() {
		return panelArticulo.getBotonArticulo();
	}

	public PanelArticulo getPanelArticulo() {
		return panelArticulo;
	}

	public VistaAccederAltaArticulo getVistaAccederAltaArticulo() {
		return panelArticulo.getVistaAccederAltaArticulo();
	}

	public VistaAccederBuscarArticulo getVistaAccederBuscarArticulo() {
		return panelArticulo.getVistaAccederBuscarArticulo();
	}

}