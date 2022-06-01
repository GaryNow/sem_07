package semana_07;

public class ArregloEdades {

	//  Atributos privados
	private int[] edad;
	private int indice;
	//  Constructor
	public ArregloEdades() {
		edad = new int[10];
		indice = 0;
	}
	//  Operaciones p�blicas b�sicas
	public int tamanio() {
		return indice;
	}
	public int obtener(int i) {
		return edad[i];
	}
	public void adicionar(int numero) {
		if (indice == edad.length)
			ampliarArreglo();
		edad[indice] = numero;
		indice ++;
	}
	//  Operaciones p�blicas complementarias
	public void eliminarAlFinal() {
		indice --;
	}
	public void eliminarTodo() {
		indice = 0;
	}
	//  Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = edad;
		edad = new int[indice + 10];
		for (int i=0; i<indice; i++)
			edad[i] = aux[i];
	}
	// M�todo que retorne la posici�n de la primera edad adolescente (edad en el rango de 12 a 20 a�os). En caso que no exista, retorne el valor -1
	public int posPrimeraEdadAdolescente() {	
		for(int i = 0; i < tamanio(); i++) {
			if(edad[i] >= 12 && edad[i] <= 20)	return i;
		}
		return -1;
	}
	// M�todo que retorne la posici�n de la �ltima edad adolescente (edad en el rango de 12 a 20 a�os). En caso que no exista, retorne el valor -1.
	public int posUltimaEdadAdolescente() {
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(edad[i] >= 12 && edad[i] <=20)	return i;
		}
		return -1;
	}
	// M�todo que remplace la primera edad adolescente por la �ltima edad.
	public void remplazarPrimeraEdadAdolescente() {
		edad[posPrimeraEdadAdolescente()] = edad[tamanio() - 1];
	}
	// M�todo que intercambie la primera edad adolescente con la �ltima edad adolescente.
	public void intercambiarEdadesAdolescentesExtremas() {
		int primeraEdad = edad[posPrimeraEdadAdolescente()];
		int ultimaEdad = edad[posUltimaEdadAdolescente()];
		edad[posPrimeraEdadAdolescente()] = ultimaEdad;
		edad[posUltimaEdadAdolescente()] = primeraEdad;
	}
	// M�todo que elimine la primera edad adolescente.
	public void eliminarPrimeraEdadAdolescente() {
		int pos = posPrimeraEdadAdolescente();
		for(int i = pos; i < tamanio(); i++) {
			edad[i] = edad[i + 1];
		}
		indice--;
	}
}
