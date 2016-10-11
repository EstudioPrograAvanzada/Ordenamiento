package ordenamiento;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ordenamiento {
	int vec [] = { -3, 8, -2, 5, 3, -1 }; 
		//{ 4, 8, -2, 5, 3, -1 };
	
	public void vector (String Tipo) {
		System.out.print(Tipo);
		for(int j=0; j<vec.length; j++){
			System.out.print(vec[j] + " ");
		}
		System.out.println();		
	}
	
	public void burbujeo () {
		int aux;
		int flag=1;
		for(int j=1; j<vec.length; j++){
			if (flag ==1){
				for (int i=0; i<vec.length-j; i++){
					flag=0;
					if(vec[i]>vec[i+1]){
						aux = vec[i];
						vec[i] = vec [i+1];
						vec [i+1] = aux;
						flag=1;
					}
				}
			}
		}
		this.vector("Burbujeo: ");
	}
		
	public void seleccion () {
		int aux;
		int pos;
		for(int j=0; j<vec.length-1; j++){
			aux=vec[j];
			pos = j;
			for (int i=j+1; i<vec.length; i++){
				if (vec[i]<aux){
					aux=vec[i];
					pos=i;
				}
			}
			vec [pos]=vec[j];
			vec [j]=aux;
		}
		this.vector("Seleccion: ");
	}
	
	public void insercion () {
		int aux;
		int pos=0;
		for(int i=0; i<vec.length-1; i++){
			if(vec[i+1]<vec[i]){
				aux=vec[i+1];
				vec[i+1]=vec[i];
				if(i>0){
					for(int j=i-1; j>=0;j--){
						if(aux<vec[j]){
							vec[j+1]=vec[j];
						}
						else{
							pos=j+1;
							break;
						}
					}
				}
				vec[pos]=aux;
			}
		}
		this.vector("Inserci�n: ");	
	}
	
	public void insercion1() {
		int aux;
		int j;
		for (int i = 1; i < vec.length; i++) {
			aux = vec[i];
			j = i - 1;
			while ((j >= 0) && (aux < vec[j])) {
				vec[j + 1] = vec[j];
				j--;
			}
			vec[j + 1] = aux;
		}
		this.vector("Inserci�n1: ");	
	}

	
	public void shell (){
		int i=1;
		int cant =1;
		int aux;
		boolean cambios;
		while (i<vec.length){
			i=i*3+1;
			cant++;
		}
		int serie []=new int [cant-1];
		serie[0]=1;
		for (i=1 ; i<serie.length; i++){
			serie[i]=serie[i-1]*3+1;			
		}
		
		for(int j =serie.length-1; j>=0; j--){
			cambios = true;
			while (cambios) { 
				cambios = false;
				for (int k = serie[j];k<vec.length;k++){
					if (vec[k - serie[j]] > vec[k]) {
						aux = vec[k]; 
						vec[k] = vec [k - serie[j]];
						vec[k - serie[j]] = aux;
						cambios = true; 
					}
				}
			}
		}
		System.out.print("shell: ");
		for(int j=0; j<vec.length; j++){
			System.out.print(vec[j] + " ");
		}
		System.out.println();	
	}
	
	public void shell1() {
		int salto, aux, i;
		boolean cambios;
		for (salto = vec.length / 2; salto != 0; salto /= 2) {
			cambios = true;
			while (cambios) { 
				cambios = false;
				for (i = salto; i < vec.length; i++) 
					if (vec[i - salto] > vec[i]) {
						aux = vec[i]; 
						vec[i] = vec [i - salto];
						vec[i - salto] = aux;
						cambios = true; 
					}
			}
		}
		this.vector("Shell 1: ");		
	}
	/*public void quicksort(){
		int i=0;
		int aux;
		int j=vec.length-1;
		int pivote=(vec.length/2)-1;
		aux=vec[pivote];
		vec[pivote]=vec[j];
		vec[j]=aux;
		pivote=j;
		System.out.println(pivote);
		j--;
		while (i<j){
			if (vec[i]>vec [pivote]){
				if (vec[j]<vec [pivote]){
					aux=vec[i];
					vec[i]=vec[j];
					vec[j]=aux;
					i++;
					j--;
				}else{
					j--;
				}
			}else{
				i++;
			}
			
		}
		System.out.print("quicksort: ");
		for(int k=0; k<vec.length; k++){
			System.out.print(vec[k] + " ");
		}
		System.out.println();
	}*/
	

	public void quicksort1(int izq, int der) {
		int pivote = vec[izq]; // tomamos primer elemento como pivote
		int i = izq; // i realiza la b�squeda de izquierda a derecha
		int j = der; // j realiza la b�squeda de derecha a izquierda
		int aux;
		while (i < j) { // mientras no se crucen las b�squedas
			while (vec[i] <= pivote && i < j){
				i++; // busca elemento mayor que pivote
				System.out.println("la i es: " + vec[i]);}
			System.out.println("fdadfa");
			while (vec[j] > pivote){
				j--; // busca elemento menor que pivote
				System.out.println("la j es: " + vec[j]);}
			System.out.println("adfadfa");
			if (i < j) { // si no se han cruzado
				aux = vec[i]; // los intercambia
				vec[i] = vec[j];
				vec[j] = aux;
			}
		}
		vec[izq] = vec[j]; // se coloca el pivote en su lugar de forma que tendremos
		vec[j] = pivote; // los menores a su izquierda y los mayores a su derecha
		if (izq < j - 1)
			quicksort1(izq, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < der)
			quicksort1(j + 1, der); // ordenamos subarray derecho
	}

	public void fusion(int init, int n){
		int n1;
		int n2;
		if (n > 1){
			n1 = n / 2;
			n2 = n - n1;
			fusion(init, n1);
			fusion(init + n1, n2);
			mezcla(init, n1, n2);
		}
	}
		
	
	public void mezcla(int init, int n1, int n2){
		int[ ] buffer = new int[n1+n2];
		int temp = 0;
		int temp1 = 0;
		int temp2 = 0;
		int i;
		while ((temp1 < n1) && (temp2 < n2)){
			if (vec[init + temp1] < vec[init + n1 + temp2])
				buffer[temp++] = vec[init + (temp1++)];
			else
				buffer[temp++] = vec[init + n1 + (temp2++)];
		}
		while (temp1 < n1)
			buffer[temp++] = vec[init + (temp1++)];
		while (temp2 < n2)
			buffer[temp++] = vec[init + n1 + (temp2++)];
		for (i = 0; i < n1+n2; i++)
			vec[init + i] = buffer[i];
	}
	
	public static void main(String[] args) {
		ordenamiento ord= new ordenamiento();
		ordenamiento ord1= new ordenamiento();
		ordenamiento ord2= new ordenamiento();
		ordenamiento ord3= new ordenamiento();
		ordenamiento ord4= new ordenamiento();
		ordenamiento ord5= new ordenamiento();
		ordenamiento ord6= new ordenamiento();
		ordenamiento ord7= new ordenamiento();
		ordenamiento ord8= new ordenamiento();
		ord.vector("Original: ");
		ord1.burbujeo();
		ord2.seleccion();
		ord3.insercion();
		ord4.shell1();
		ord5.shell();
		ord6.insercion1();
		ord7.quicksort1(0,ord7.vec.length-1);
		ord7.vector("Quicksort: ");
		ord8.quicksort1(0,ord7.vec.length-1);
		ord8.vector("Mezcla: ");
	}

}
