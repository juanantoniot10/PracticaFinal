package almacenes;

import java.io.File;

import acceso.DAO;
import acceso.DAORuta;
import modelo.Cliente;
import modelo.Pedido;

public class AlmacenRutaDestino<T> {
	private DAORuta<T> daoRuta;
	private String pathInicial;
	private String extension;
	
	

	public AlmacenRutaDestino(String pathInicial,String extension) {
		super();
		this.pathInicial = pathInicial;
		this.extension=extension;
		daoRuta=new DAORuta<>();
	}

	/**
	 * Introduce el nombre de la carpeta destino donde se encuentran los archivos a tratar
	 * introduce el nombre del elemento sin usar la extension
	 * @param pathDestino
	 * @param nombreElemento
	 * @param t
	 * @return
	 */
	public boolean grabar(String pathDestino, String nombreElemento,T t){
		return daoRuta.grabar(t, nombreElemento+"."+extension, pathInicial+"/"+pathDestino);
	}
	

	/**
	 * Introduce el nombre de la carpeta destino donde se encuentran los archivos a tratar
	 * introduce el nombre del elemento sin usar la extension
	 * @param pathDestino
	 * @param nombreElemento
	 * @return
	 */
	public T obtener(String pathDestino,String nombreElemento){
		
		return daoRuta.obtener(pathInicial+"/"+pathDestino, nombreElemento+"."+extension);
	}
	
	/**
	 * Devuelve los nombres de los archivos que estan dentro de la carpeta destino sin extension 
	 * @param pathDestino
	 * @return
	 */
	public String[] getFiles(String pathDestino){
		String[] elements=null;
		File carpeta=new File(pathInicial+"/"+pathDestino);
		if(carpeta.exists()&&carpeta.isDirectory()){
			elements=carpeta.list();
			quitarExtension(elements);
		}
		return elements;
	}

	private void quitarExtension(String[] elements) {
		String[] definitivos=new String[elements.length];
		for (int i = 0; i < elements.length; i++) {
			definitivos[i]=elements[i].split("\\.")[0];
		}
	}

	public int getCantidadElementos() {
		 if(new File(pathInicial).listFiles()!=null) {
			 return new File(pathInicial).listFiles().length;
		 }
		return 0;
	}

	public int getCantidadElementos(String subpath) {
		if(new File(pathInicial+'/'+subpath).listFiles()!=null) {
			 return new File(pathInicial+'/'+subpath).listFiles().length;
		 }
		return 0;
	}

	public Object getElementoConArchivos(int i) {
		return ((Object)new DAO<>().leer(new File(pathInicial).listFiles()[i].listFiles()[0].getPath()));
	}
}
