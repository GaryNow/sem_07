package semana_07;

public class ArregloNotas {

	//  Atributos privados
	private int[] nota;
	private int indice;
	//  Constructor
	public ArregloNotas() {
		nota = new int[10];
		indice = 0;
	}
	//  Operaciones p�blicas b�sicas
	public int tamanio() {
		return indice;
	}
	public int obtener(int i) {
		return nota[i];
	}
	public void adicionar(int numero) {
		if (indice == nota.length)
			ampliarArreglo();
		nota[indice] = numero;
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
		int[] aux = nota;
		nota = new int[indice + 10];
		for (int i=0; i<indice; i++)
			nota[i] = aux[i];
	}
	// M�todo que retorne la menor de todas las notas
	public int notaMenor() {
		int menor = nota[0]; // 10 20 16 8
		for(int i = 1; i < tamanio(); i++) {
			if(nota[i] < menor)	menor = nota[i];
		}
		return menor;
	}
	// M�todo que retorne la posici�n de la primera nota aprobatoria (nota en el rango de 13 a 20). En caso que no exista, retorne -1.
	public int posPrimeraNotaAprobatoria() {
		for(int i = 0; i < tamanio(); i++) {
			if(nota[i] >= 13 && nota[i] <= 20)	return i;
		}
		return -1;
	}
	// M�todo que retorne la posici�n de la �ltima nota aprobatoria (nota en el rango de 13 a 20). En caso que no exista, retorne -1.
	public int posUltimaNotaAprobatoria() {
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(nota[i] >= 13 && nota[i] <= 20)	return i;
		}
		return -1;
	}
	// M�todo que remplace la �ltima nota aprobatoria por la nota menor
	public void remplazarUltimaNotaAprobatoria() {
		nota[posUltimaNotaAprobatoria()] = notaMenor();
	}
	// M�todo que elimine la primera nota aprobatoria.
	public void eliminarPrimeraNotaAprobatoria() {
		int pos = posPrimeraNotaAprobatoria();
		for(int i = pos; i < tamanio(); i++) {
			nota[i] = nota[i + 1];
		}
		indice--;
	}
	
}
