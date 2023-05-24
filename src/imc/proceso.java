package imc;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class proceso {
	ArrayList<String>  listaNombres= new ArrayList<String>();
	ArrayList<Double> listaPeso = new ArrayList<Double>();
	ArrayList<Double> listaTalla = new ArrayList<Double>();
	int cantPersonas;
	String nombres="";
	
	public proceso(){
		iniciar();
	}
	
	public void iniciar() {
		System.out.println("Iniciar");
		String menu="IMC PERSONAS\n";
		menu+="1. Llenar Datos\n";
		menu+="2. Imprimir IMC\n";
		menu+="3. Eliminar persona\n";
		menu+="4. Actualizar\n";
		menu+="5. Limpiar lista\n";
		menu+="6. Buscar por nombre\n";
		menu+="7. Salir\n";
		menu+="Ingrese una opción:\n";

		int vlrMenu=0;
		do {
			vlrMenu=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(vlrMenu);
			
		} while (vlrMenu!=7);
	}
	
	public void validarMenu(int vlrMenu) {
		
		switch (vlrMenu) {
		case 1:
			llenarDatos();
			 	break;
		case 2:
			imprimirImc();
			 	break;
		case 3:
			eliminarPersona();
			 	break;
		case 4:
			actualizar();
			 	break;
		case 5:
			limpiarLista();
			 	break;
		case 6:
			BuscarPorNombre();
			 	break;
		case 7:
			break;
		default:System.out.println("Ingrese una opción valida");
				break;
		}
	}
	

	public void limpiarLista() {
		listaNombres.clear();
		System.out.println(listaNombres); 
		
	}

	public void eliminarPersona() {
		System.out.println("esta es su lista actual: /n " + listaNombres); 
		String eliminar=JOptionPane.showInputDialog("Ingrese el nombre que desea eliminar de la lista.");
		listaNombres.remove(eliminar);
		System.out.println(listaNombres); 
		
	}
	public void actualizar() {
		
		int indice=0;
		String Actualizar=JOptionPane.showInputDialog("Ingrese el nombre que desea Actualizar");
		indice= listaNombres.indexOf(Actualizar);
		if (indice!=-1) {
			listaNombres.set(indice, Actualizar);
		} else {
			System.out.println("el usuario no se encuentra en la lista");
		}
	}

	public void llenarDatos() {
		double peso, talla; 
		
			nombres=JOptionPane.showInputDialog("Ingrese su nombre");
			listaNombres.add(nombres);
			peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de " + nombres));
			listaPeso.add(peso);
			talla=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla de " + nombres));
			listaTalla.add(talla);
		}
	
	public void BuscarPorNombre() {
		System.out.println("buscar Nombre, nombres="+listaNombres);
		String nombreBuscar=JOptionPane.showInputDialog("Ingrese el nombre a buscar");
		
		if(listaNombres.contains(nombreBuscar)) {
		for (int i = 0; i < listaNombres.size(); i++) {
			if (listaNombres.get(i).equalsIgnoreCase(nombreBuscar)) {
					System.out.println("El nombre: "+nombreBuscar+ " se encontro en la posición: "+i);
					
			}
		}
		}else System.out.println("No se encontró el nombre.");
		
	}
				
	
	
	public void imprimirImc() {
		for (int i = 0; i < listaNombres.size(); i++) {
			calcularImc(listaPeso.get(i), listaTalla.get(i),listaNombres.get(i));
		}
	}
	
	public void calcularImc(double peso, double talla, String nombres) {
		double resultado=0;
		resultado=peso/(talla*talla);
		
		if (resultado<18) {
			System.out.println(nombres + " Usted tiene anorexia");
		}
		else if(resultado>=18 && resultado<20) {
			System.out.println(nombres + " Usted tiene delgadez" );
		}
		else if(resultado>=20 && resultado<27) {
			System.out.println(nombres + " Usted esta en su normalidad" );
		}
		else if(resultado>=27 && resultado<30) {
			System.out.println(nombres + " Usted tiene obesidad grado 1" );
		}
		else if(resultado>=30 && resultado<35) {
			System.out.println(nombres + " Usted tiene obesidad grado 2" );
		}
		else if(resultado>=35 && resultado<40) {
			System.out.println(nombres + " Usted tiene obesidad grado 3" );
		}
		else {
			System.out.println(nombres + " Usted tiene obesidad morbida" );
		}
	}
	
	
	
}
