
public class Arbol {

	private NodoArbol raiz;

	public Arbol() {
		raiz = null;
	}

	// Muestra los elementos del arbol binario en orden central ---------------
	public void mostrar() {
		this.mostrar(raiz, "  ");
	}

	private void mostrar(NodoArbol nodo, String espacios) {
		if (nodo != null) {
			this.mostrar(nodo.getIzquierdo(), espacios + "    ");
			System.out.print(espacios);
			nodo.getDato().mostrar();
			this.mostrar(nodo.getDerecho(), espacios + "    ");
		}
	}

	// Inserta un elemento con una cierta clave -------------------------------
	public void insertar(Alumno dato) {
		raiz = this.insertar(raiz, dato);
	}

	private NodoArbol insertar(NodoArbol nodo, Alumno dato) {
		if (nodo != null) {
			if (nodo.getDato().getMatricula() < dato.getMatricula()) {
				nodo.setDerecho(this.insertar(nodo.getDerecho(), dato));
			} else if (nodo.getDato().getMatricula() > dato.getMatricula()) {
				nodo.setIzquierdo(this.insertar(nodo.getIzquierdo(), dato));
			} else {
				System.out.println("la clave ya existe");
			}
		} else {
			nodo = new NodoArbol(dato);
		}
		return nodo;
	}

	// ------------------------------------------------------------------------
	// TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
	public int getNumElementos() {
		return getNumElementos(raiz);
	}

	private int getNumElementos(NodoArbol nodo){
		int contador=0;
		if(nodo!=null){
			contador = 1 + getNumElementos(nodo.getIzquierdo()) + getNumElementos(nodo.getDerecho());
			return contador;
		}else{
			contador=0;
			return contador;
		}
	}

	// ------------------------------------------------------------------------
	// TODO 3.3: Devuelve el numero de nodos del arbol con clave
	// menor a una clave dada de forma RECURSIVA
	public int getNumMenores(int clave) {
		return getNumMenores(clave, raiz);

	}
	private int getNumMenores(int clave, NodoArbol nodo){
		int contador=0;
		if(nodo!=null){
			if(nodo.getDato().getMatricula()<clave){
				contador= 1 + getNumMenores(clave, nodo.getIzquierdo()) + getNumMenores(clave, nodo.getDerecho());
			}else{
				contador= getNumMenores(clave, nodo.getIzquierdo());
			}
			return contador;
		}else{
			return contador;
		}
	}

	// ------------------------------------------------------------------------
	// TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
	public Alumno getMenorElemento() {

		return getMenorElemento(raiz);
	}
	private Alumno getMenorElemento(NodoArbol nodo){
		NodoArbol pequeño;
		if(nodo.getIzquierdo()!=null){
			return getMenorElemento(nodo.getIzquierdo());
		}else{
			return nodo.getDato();
		}
	}

	// ------------------------------------------------------------------------
	// TODO 3.5: Devuelve el elemento con la mayor clave y menor que una clave
	// dada de forma RECURSIVA
	public Alumno getMenorElementoClave(int clave) {
		return getMenorElementoClave(clave, raiz);
	}
	private Alumno getMenorElementoClave(int clave, NodoArbol nodo){
		if(nodo!=null){
			if(nodo.getDato().getMatricula()>clave){
				return getMenorElementoClave(clave, nodo.getIzquierdo());
			}
			if(nodo.getDato().getMatricula()==clave){
				if(nodo.getIzquierdo()!=null)
					return nodo.getIzquierdo().getDato();
				else
					return null;
			}
			if(nodo.getDato().getMatricula()<clave){
				Alumno aux = getMenorElementoClave(clave, nodo.getDerecho());
				if(aux==null)
					return  nodo.getDato();
				else
					return aux;

			}
		}else{
			return null;
		}
		return null;
	}
}
