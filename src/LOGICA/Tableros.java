package LOGICA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tableros {

	//Variables constantes con palabra BINGO
	static String BINGO="BINGO";
	static int matrizGanadoraFinal = 999;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		String [][] arregloMatricesModificadas[]  = new String[5] [][];
		Map <String, String> datosCliente = new HashMap<String, String>();
		Map <String, String> datosDictador = new HashMap<String, String>();
		Map arregloDatosClientes[] = new Map[5];
		//Creación de los 5 tableros de los clientes
		//Creación del tablero del dictador
		String [][] matrizDictador = new String[15][5];
		matrizDictador = inicializarMatriz(matrizDictador);
		llenarTablero(matrizDictador, false);
		//Se crean los tableros para los clientes
		String [][] matrizJugador1 = new String[5][5];
		matrizJugador1 = inicializarMatriz(matrizJugador1);
		llenarTablero(matrizJugador1, true);
		String [][] matrizJugador2 = new String[5][5];
		matrizJugador2 = inicializarMatriz(matrizJugador2);
		llenarTablero(matrizJugador2, true);
		String [][] matrizJugador3 = new String[5][5];
		matrizJugador3 = inicializarMatriz(matrizJugador3);
		llenarTablero(matrizJugador3, true);
		String [][] matrizJugador4 = new String[5][5];
		matrizJugador4 = inicializarMatriz(matrizJugador4);
		llenarTablero(matrizJugador4, true);
		String [][] matrizJugador5 = new String[5][5];
		matrizJugador5 = inicializarMatriz(matrizJugador5);
		llenarTablero(matrizJugador5, true);
		
		//Creación de datos dictador 
		datosDictador.put("cedula", "1115195022");
		datosDictador.put("nombre", "Daniela Andrea");
		
		
		while(i<5){
			System.out.println();
			System.out.println("***********************");
			System.out.println("   Datos del usuario  "+(i+1));
			System.out.println("************************");
			switch(i){
			case 0:
				datosCliente = solicitarInformacioncliente(matrizJugador1) ;
				arregloDatosClientes[i] = datosCliente;
			    break;
			case 1:
				datosCliente = solicitarInformacioncliente(matrizJugador2) ;
				arregloDatosClientes[i] = datosCliente;
				break;
			case 2:
				datosCliente = solicitarInformacioncliente(matrizJugador3) ;
				arregloDatosClientes[i] = datosCliente;
				break;
			case 3:
				datosCliente = solicitarInformacioncliente(matrizJugador4) ;
				arregloDatosClientes[i] = datosCliente;
				break;
			case 4:
				datosCliente = solicitarInformacioncliente(matrizJugador5) ;
				arregloDatosClientes[i] = datosCliente;
				break;
			}
			i++;
		}
		
		//int modoJuego = seleccionarModoJuego();
		//mostrarTablero(matrizDictador);
		//Genera una balota aleatoria 
		
		int columnaBalota = 0;
		int numeroBalota=0;
		String matriz[][] = new String[15][5];
		String matrizResultadoJugador1[][] = new String[5][5];
		String matrizResultadoJugador2[][] = new String[5][5];
		String matrizResultadoJugador3[][] = new String[5][5];
		String matrizResultadoJugador4[][] = new String[5][5];
		String matrizResultadoJugador5[][] = new String[5][5];
		
		System.out.println();
		int opcion = seleccionarModoJuego();
		boolean validarGanadorCompleto=true;
		String [][] matrizprueba = {
				{"1-X","2-X","3-X","4-X","5-X"},
				{"6-X","7-X","8-X","9-X","10-X"},
				{"11-X","12-X","13-X","14-X","15-X"},
				{"16-X","17-X","18-X","19-X","20-X","21-X"},
				{"22-X","23-X","24-X","25-X","26"}};
		while (validarGanadorCompleto) {
			columnaBalota = generarNumerosAleatorios(0, 4);
			numeroBalota= generarNumeroBalota(columnaBalota);
			switch(opcion){
			case 1:
				matriz = modificarTableroCompleto(matrizDictador, numeroBalota, columnaBalota);
				matrizResultadoJugador1 = modificarTableroModoX(matrizJugador1, numeroBalota);
				matrizResultadoJugador2 = modificarTableroModoX(matrizJugador2, numeroBalota);
				matrizResultadoJugador3 = modificarTableroModoX(matrizJugador3, numeroBalota);
				matrizResultadoJugador4 = modificarTableroModoX(matrizJugador4, numeroBalota);
				matrizResultadoJugador5 = modificarTableroModoX(matrizJugador5, numeroBalota);
				arregloMatricesModificadas [0]= matrizResultadoJugador1;
				arregloMatricesModificadas [1]= matrizResultadoJugador2;
				arregloMatricesModificadas [2]= matrizResultadoJugador3;
				arregloMatricesModificadas [3]= matrizResultadoJugador4;
				arregloMatricesModificadas [4]= matrizResultadoJugador5;
								
				if(!validardadorMatrizGanadora(arregloMatricesModificadas,opcion)){
					validarGanadorCompleto= true;
				}else{
					validarGanadorCompleto= false;
				}
				
				
				break;
				
			case 2:
				matriz = modificarTableroCompleto(matrizDictador, numeroBalota, columnaBalota);
				matrizResultadoJugador1 = modificarTableroCuadro(matrizJugador1, numeroBalota);
				matrizResultadoJugador2 = modificarTableroCuadro(matrizJugador2, numeroBalota);
				matrizResultadoJugador3 = modificarTableroCuadro(matrizJugador3, numeroBalota);
				matrizResultadoJugador4 = modificarTableroCuadro(matrizJugador4, numeroBalota);
				matrizResultadoJugador5 = modificarTableroCuadro(matrizJugador5, numeroBalota);
				arregloMatricesModificadas [0]= matrizResultadoJugador1;
				arregloMatricesModificadas [1]= matrizResultadoJugador2;
				arregloMatricesModificadas [2]= matrizResultadoJugador3;
				arregloMatricesModificadas [3]= matrizResultadoJugador4;
				arregloMatricesModificadas [4]= matrizResultadoJugador5;
				
				if(!validardadorMatrizGanadora(arregloMatricesModificadas,opcion)){
					validarGanadorCompleto= true;
				}else{
					validarGanadorCompleto= false;
				}
				
				
				break;
			case 3:
				matriz = modificarTableroCompleto(matrizDictador, numeroBalota, columnaBalota);
				matrizResultadoJugador1 = modificarTableroCompleto(matrizJugador1, numeroBalota,columnaBalota);
				matrizResultadoJugador2 = modificarTableroCompleto(matrizJugador2, numeroBalota,columnaBalota);
				matrizResultadoJugador3 = modificarTableroCompleto(matrizJugador3, numeroBalota,columnaBalota);
				matrizResultadoJugador4 = modificarTableroCompleto(matrizJugador4, numeroBalota,columnaBalota);
				matrizResultadoJugador5 = modificarTableroCompleto(matrizJugador5, numeroBalota,columnaBalota);
				arregloMatricesModificadas [0]= matrizResultadoJugador1;
				arregloMatricesModificadas [1]= matrizResultadoJugador2;
				arregloMatricesModificadas [2]= matrizResultadoJugador3;
				arregloMatricesModificadas [3]= matrizResultadoJugador4;
				arregloMatricesModificadas [4]= matrizResultadoJugador5;
				
				if(!validardadorMatrizGanadora(arregloMatricesModificadas,opcion)){
					validarGanadorCompleto= true;
				}else{
					validarGanadorCompleto= false;
				}
				break;
			}
			
		}
		System.out.println();
		System.out.println("**************************************************");
		System.out.println("\t INICIA EL JUEGO"+" "+obtenerModoJuego(opcion));
		System.out.println("**************************************************");
		mostrarTablero(matriz,datosDictador);
		System.out.println();
		mostrarTablero(matrizResultadoJugador1,arregloDatosClientes[0]);
		System.out.println();
		mostrarTablero(matrizResultadoJugador2,arregloDatosClientes[1]);
		System.out.println();
		mostrarTablero(matrizResultadoJugador3,arregloDatosClientes[2]);
		System.out.println();
		mostrarTablero(matrizResultadoJugador4,arregloDatosClientes[3]);
		System.out.println();
		mostrarTablero(matrizResultadoJugador5,arregloDatosClientes[4]);
		System.out.println();
		
		System.out.println("\n");
		
		System.out.println();
		System.out.println("**************************************************");
		System.out.println("\t FIN DEL JUEGO  ");
		System.out.println("**************************************************");
		System.out.println();
		double premio= validarGanador(arregloDatosClientes[matrizGanadoraFinal].get("nombre").toString(), arregloDatosClientes[matrizGanadoraFinal].get("segundoNombre").toString(), arregloDatosClientes[matrizGanadoraFinal].get("apellido").toString(),500000);
		generarGanador(premio, arregloMatricesModificadas[matrizGanadoraFinal], arregloDatosClientes[matrizGanadoraFinal]);
		
		
		//String [][] matrizprueba = {{"1","2","3","4","5"},{"6","7","8","9","10"},{"11","12","13","14","15"},{"16","17","18","19","20","21"},{"22","23","24","25","26"}};
		
	}
	private static boolean validardadorMatrizGanadora(String[][] arregloMatricesModificadas[],int opcion) {
		boolean esMatrizLlena=false;
		boolean romper = true;
		for (int i = 0; (i < arregloMatricesModificadas.length && romper); i++) {
			
			switch(opcion){
			case 1:
				if(!validarGanadorModoJuegoX(arregloMatricesModificadas[i])){
					esMatrizLlena = true;
					matrizGanadoraFinal = i;
					System.out.println("Matriz ganadora"+i);
					romper = false;	
				}
				break;
			case 2:
				if(!validarGanadorModoJuegoCuadro(arregloMatricesModificadas[i])){
					esMatrizLlena = true;
					matrizGanadoraFinal = i;
					System.out.println("Matriz ganadora"+i);
					romper = false;		
				}
				break;
			case 3:
				if(!validarGanadorModoJuegoCompleto(arregloMatricesModificadas[i])){
					esMatrizLlena = true;
					matrizGanadoraFinal = i;
					System.out.println("Matriz ganadora"+i);
					romper = false;
				}
				break;
				
			}
			
			
		}
		return esMatrizLlena;
	}
	
	
	/**
	 * Función que obtiene el nombre del modo de juego a partir de la opcion ingresada por el usuario 
	 * que se envía por parametro
	 * @param opcion
	 * @return una cadena con el nombre de modo que se va a jugar
	 */
	public static String obtenerModoJuego(int opcion){
		String cadena="";
		switch(opcion){
		case 1: 
			cadena = "MODO DE JUEGO X";
			break;
		case 2:
			cadena = "MODO DE JUEGO CUADRO";
			break;
		case 3:
			cadena = "MODO DE JUEGO COMPLETO";
			break;
		}
		return cadena;	
	}
	
	
	/**
	 * Función que lee un número entero, y recibe por paramétro el mensaje a mostrar al usuarios
	 * @param mensaje
	 * @return devuelve el número entero ingresado por el usuario
	 */
	public static int leerEntero(String mensaje){
		int numero = 0;
		Scanner dato= new Scanner(System.in);
		System.out.println(mensaje);
		numero=dato.nextInt();
		return numero;
	}
	
	/**
	 * Función que lee un número real, y recibe por paramétro el mensaje a mostrar al usuario
	 * @param mensaje
	 * @return devuelve el número decimal ingressado por el usuario
	 */
	public static double leerReal(String mensaje){
		double numero = 0;
		Scanner dato= new Scanner(System.in);
		System.out.println(mensaje);
		numero=dato.nextInt();
		return numero;
	}
	
	/**
	 * Función que lee una cadena, y recibe por paramétro el mensaje a mostrar al usuario
	 * @param mensaje
	 * @return devuelve la cadena ingresada por usuario
	 */
	public static String leerCadena(String mensaje){
		String cadena="";
		Scanner dato= new Scanner(System.in);
		System.out.println(mensaje);
		cadena = dato.nextLine();
		return cadena;
	}
	
	/**
	 * Función que genera una balota aleatoria dependiendo del rango de la columna
	 * @param columnaBalota
	 * @return la balota aleatoria
	 */
	
	public static int generarNumeroBalota(int columnaBalota){
		int numeroBalota =0;
		switch(columnaBalota){
		//En caso de que la columna sea 0, se hace referencia a la letra 'B'
		case 0:
			numeroBalota= generarNumerosAleatorios(1, 15);
			break;
			//En caso de que la columna sea 1, se hace referencia a la letra 'I'
		case 1:
			numeroBalota= generarNumerosAleatorios(16, 30);
			break;
			//En caso de que la columna sea 2, se hace referencia a la letra 'N'
		case 2:
			numeroBalota= generarNumerosAleatorios(31, 45);
			break;
			//En caso de que la columna sea 3, se hace referencia a la letra 'G'
		case 3:
			numeroBalota= generarNumerosAleatorios(46, 60);
			break;
			//En caso de que la columna sea 4, se hace referencia a la letra 'O'
		case 4:
			numeroBalota= generarNumerosAleatorios(61, 75);
			break;
		}
		return numeroBalota;
	}
	
	/**
	 * Función que permite imprimir los datos básicos del ganador
	 * @param nombre
	 * @param cedula
	 * @param valorGanado
	 */
	public static void generarGanador(double valorGanado,String [][] matrizGanadora,Map datosCliente){
		System.out.println("****************************************************");
		System.out.println("*\t"+"                GANADOR" +"    ");
		System.out.println("****************************************************");
		System.out.println("Valor ganado: "+" "+valorGanado);
		System.out.println("****************************************************");
		mostrarTablero(matrizGanadora, datosCliente);
	}
	

	
	/**
	 * Función que retorna el modo de juego seleccionado por el usuario, de ingresar
	 * una opción diferente, vuelve y solicita la opción correcta
	 * @return retorna 1 si el modo de juego es x, retorna 2 si el modo de juego es cuadro y
	 * retorna 3 si el modo de juego es cuadro completo
	 */
	public static int seleccionarModoJuego(){
		
		boolean bandera=true; 
		int opcion =0;
		while(bandera){
			String cadena = "Ingrese la opción a jugar: \n 1. Presione '1' para jugar en modo 'X' \n"
					+ " 2. Presione '2' para jugar en modo de juego 'Cuadro' "
					+ "\n 3. Presione '3' para jugar en modo de juego 'Cuadro completo' ";
			 opcion = leerEntero(cadena);
			if (opcion == 1 || opcion == 2 || opcion == 3){
				bandera=false;
			}else{
				System.out.println("¡Error! Seleccione una opción correcta");
				bandera=true;
			}
		}
		
		
		return opcion;
	}
	/**
	 * Función que modifica el tablero del dictador
	 * @param matrizDictador
	 * @param numeroAleatorio
	 * @param columna
	 * @return retorna la misma matriz con una x para saber que dicho número ya salió
	 */
	public static String[][] modificarTableroCompleto(String [][] matrizDictador,int numeroAleatorio,int columna){
		
		for(int i=0; i<matrizDictador.length;i++){
			
			if (matrizDictador[i][columna].equals(numeroAleatorio+"")){
				matrizDictador[i][columna] =matrizDictador[i][columna]+"-X";
				
			}
		}
	
		return matrizDictador;
	}
	/**
	 * Función que valida si la matriz en modo de juego completo está llena
	 * @param matriz
	 * @return un dato booleano indicando si está llena o no, para saber cual es el ganador
	 */
	public static boolean validarGanadorModoJuegoCompleto(String [][] matriz){
		
		boolean esCompleta = false;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz.length;j++){
				if (!validarcaracterDentroCadena(matriz[i][j], 'X',".es")){
					esCompleta = true;
				}
			}
		}	
		return esCompleta;
	}
	/**
	 * Función que valida si la matriz en modo juego en X está llena
	 * Se hacen dos for uno para recorrer la diagonal principal y la otra para recorrer la diagonal secundaria
	 * @param matriz
	 * @return devuelve un dato de tipo booleano que indica si está llena o no
	 */
	
	public static boolean validarGanadorModoJuegoX(String [][] matriz){
		
		boolean esCompleta = false;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz.length;j++){
				if(i==j)
				   {
				if (!validarcaracterDentroCadena(matriz[i][j], 'X',".es")){
					esCompleta = true;
				   }
				}
			}
		}
		for(int i=matriz.length-1;i>=0;i--){
			for(int j=0; j<matriz.length;j++){
				if(matriz.length-1-i == j){
					if (!validarcaracterDentroCadena(matriz[i][j], 'X',".es")){
						esCompleta = true;
					}
				}
			}
		}
		return esCompleta;
	}
	public static boolean validarGanadorModoJuegoCuadro(String [][] matriz){
		
		boolean esCompleta = false;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz.length;j++){
				if(i==0){
					if (!validarcaracterDentroCadena(matriz[i][j], 'X',".es")){
						esCompleta = true;
					}
				}
				if(j==0){
					if (!validarcaracterDentroCadena(matriz[i][j], 'X',".es")){
						esCompleta = true;
					}	
				}
				if(i==matriz.length-1){
					if (!validarcaracterDentroCadena(matriz[i][j], 'X',".es")){
						esCompleta = true;
					}
				}
				if(j==matriz.length-1){
					if (!validarcaracterDentroCadena(matriz[i][j], 'X',".es")){
						esCompleta = true;
					}	
				}	
			}
		}	
		return esCompleta;
	}
	
	/**
	 * Función que valida si existe en la última posición de la cadena un último carácter
	 * @param elemento
	 * @param caracter
	 * @return un dato de tipo booleano 
	 */
	public static boolean validarcaracterDentroCadena(String elemento,char caracter,String caracter2){
		char ultimaLetra = elemento.charAt(elemento.length()-1);
		boolean existeLetra=false;
		//El caracter 2 se envía para validar el elemento del centro, ya que sin esta razón
		//se queda infitio porque siempre va a encontrar un caracter que no tenga X
		if(ultimaLetra == caracter || elemento.equals(caracter2)){
			existeLetra = true;
		   }	
		return existeLetra;
	}
	/**
	 * Función que modifica el modo de juego en X en la tabla de los jugadores 
	 * recorre la matriz en x con dos for uno para la diagonal principal y el otro
	 * para la diagonal secundaria y obtener el recorrido en x
	 * @param matriz
	 * @param numeroAleatorio
	 * @return la matriz añadiendole una "X" a cada elemento que encuentre igual al numero o balota aleatorio ingresado
	 * por parametro
	 */
	public static String[][] modificarTableroModoX(String [][] matriz,int numeroAleatorio){
		/*\
		 * \
		 *  \
		 *   \
		 * */
		//diagonal principal
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz.length;j++){
				if (i==j ){
					if(matriz[i][j].equals(numeroAleatorio+"")){
						matriz[i][j] = matriz[i][j] +"-X";	
					}	
				}
			}
		}
		
		/*     /
		 *    /
		 *   / 
		 * "/"   
		 * */
		//Diagonal secundaria
		for(int i=matriz.length-1;i>=0;i--){
			for(int j=0; j<matriz.length;j++){
				if(matriz.length-1-i == j){
					if(matriz[i][j].equals(numeroAleatorio+"")){
					matriz[i][j] = matriz[i][j] +"-X";
					}
				}
			}
		}
		return matriz;
	}
	/***
	 * Función que modificar la matriz del jugador en modo de juego cuadro
	 * las esquinas de cada posición tanto filas como columnas
	 * @param matriz
	 * @param numeroAleatorio
	 * @return la matriz modificada con el elemento que sea igual al número aleatorio
	 * añadiendole una "X"
	 */
	public static String[][] modificarTableroCuadro(String [][] matriz,int numeroAleatorio){
		
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz.length;j++){
				if(i==0){
					if(matriz[i][j].equals(numeroAleatorio+"")){
						matriz[i][j] = matriz[i][j] +"-X";
					}
				}
				if(j==0){
					if(matriz[i][j].equals(numeroAleatorio+"")){
						matriz[i][j] = matriz[i][j] +"-X";
					}	
				}
				if(i==matriz.length-1){
					if(matriz[i][j].equals(numeroAleatorio+"")){
						matriz[i][j] = matriz[i][j] +"-X";
					}
				}
				if(j==matriz.length-1){
					if(matriz[i][j].equals(numeroAleatorio+"")){
						matriz[i][j] = matriz[i][j] +"-X";
					}	
				}
			}
		}
		return matriz;
	}
	
	
	
	/**
	 * Función que imprime el título "BINGO"
	 */
 	public static void imprimirTitulo(Map datos){
 		System.out.println(" _______________________________________");
 		System.out.println("|  Cédula:"+datos.get("cedula"));
 		System.out.println("|  Nombre:"+datos.get("nombre"));
 		System.out.println("|                                       |"); 
		String titulo[] = {"| B","I","N","G","O       |"};
		System.out.println(" _______________________________________");
		System.out.println("|                                       |");
		for(int i=0;i<titulo.length;i++){
			System.out.print(titulo[i]+"\t");
		}
		System.out.println("");
		System.out.println("|                                       |");
	}
	
	/**
	 * Función que me imprime los elementos de una matriz que se envía por parámetro
	 * sin retornan nada
	 * @param matriz
	 */
	public static void mostrarTablero(String [][]matriz,Map datosClientes){
		
		imprimirTitulo(datosClientes);
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++){				
				System.out.print("|" + matriz[i][j] +"\t");
			}
			System.out.println("|");
		}
		System.out.print("|_______________________________________|");
	}
	
	/**
	 *Función que llena el tablero del bingo para cada usuario 
	 * @param matriz a llenar
	 * @return retorna la matriz llena con lo números aleatorios 
	 */
	public static String[][] llenarTablero(String [][] matriz,boolean esMatrizJugador){
		int numeroAleatorio =0;
		boolean seguir =true;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++){
				
				/**Se rellena la columna B*/
				if (j==0){
					
					/*Se pide un numero aleatorio hasta que la funcion validarNumeroRepetido devuelva un false*/
					seguir =true;
					while(seguir){
						numeroAleatorio = generarNumerosAleatorios(1,15);
						if(validarNumeroRepetido(matriz,numeroAleatorio , j) == false){
							seguir = false;
						}
					}
					// se inserta el numero aleatorio
					matriz[i][j] = ""+numeroAleatorio;
				}
				/**Se rellena la columna I*/
				if (j==1){
					seguir =true;
					while(seguir){
						numeroAleatorio = generarNumerosAleatorios(16,30);
						if(validarNumeroRepetido(matriz,numeroAleatorio , j) == false){
							seguir = false;
						}
					}
					
					matriz[i][j] =  ""+numeroAleatorio;
				
				}
				/**Se rellena la columna N*/
				if(j==2){
					seguir =true;
					while(seguir){
						numeroAleatorio = generarNumerosAleatorios(31,45);
						if(validarNumeroRepetido(matriz,numeroAleatorio , j) == false){
							seguir = false;
						}
					}
					 // se valida si es el centro para que esa posición no se llene
					if(i ==j && esMatrizJugador){
						
						matriz[i][j] = ""+".es";
					}else{
						// se inserta el numero aleatorio
						matriz[i][j] = ""+ numeroAleatorio;
					}
				}
				/**Se rellena la columna G*/
				if(j==3){
					seguir =true;
					while(seguir){
						numeroAleatorio = generarNumerosAleatorios(46,60);
						if(validarNumeroRepetido(matriz,numeroAleatorio , j) == false){
							seguir = false;
						}
					}
					// se inserta el numero aleatorio
					matriz[i][j] = ""+ numeroAleatorio;
				}
				/**Se rellena la columna O*/
				if(j==4){
					seguir =true;
					while(seguir){
						numeroAleatorio = generarNumerosAleatorios(61,75);
						if(validarNumeroRepetido(matriz,numeroAleatorio , j) == false){
							seguir = false;
						}
					}
					// se inserta el numero aleatorio
					matriz[i][j] =  ""+numeroAleatorio;
				}
				
			}
		}
	
		return matriz;
	}
	
	public static String[][] inicializarMatriz(String [][] matriz){
		
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++){
				matriz[i][j] = " ";
			}
		}
		
		return matriz;
	}
	
	
	/**
	 * Función que recorre la columna de una matriz y valida si un numeroAleatorio ya existe en la columna.
	 * @param matriz a recorrer
	 * @param numeroAleatorio a validar
	 * @param columna columna de la matriz a recorrer
	 * @return existeNumero, false si el numero no existe y true si el numero existe
	 */
	public static boolean validarNumeroRepetido(String [][] matriz,int numeroAleatorio, int columna){		
		boolean existeNumero = false;
					
		/*Se recorre todas las filas de la matriz, pero solo se accede a la columna pasada por parametro*/
		for (int i=0;i<matriz.length;i++){				
		
			if(matriz[i][columna].equals(numeroAleatorio+"")){
				existeNumero = true;
			}	
		}
		return existeNumero;
	}
	
	
	
	/**
	 * Función que permite generar números aleatorios entre el parámetro n y el parámetro m
	 * @param m, m es el rango mayor, hasta donde se quiere generar los números aleatorios y
	 * n es es rango minímo desde donde comienza a generar los números aleatorios
	 * 
	 * @return un número entero aleatorio
	 */
	public static int generarNumerosAleatorios (int n,int m){
		int valorEntero = (int)(Math.random()* ((m+1)-n))+n;  
		
		return valorEntero;
	}
	
	/**
	 * Función que solicita al usuario nombre y cédula, se retorna un mapa
	 * @return datos
	 */
	public static Map<String, String> solicitarInformacioncliente(String [][]matriz){
		
		String cedula = leerCadena("Ingrese su cédula: ");
		String primerNombre= leerCadena("Ingrese el primer nombre ");
		String segundoNombre= leerCadena("Ingrese el segundo nombre: (si tiene) ");
		String primerApellido = leerCadena("Ingrese el apellido");
		System.out.println("-------------------------");
		
		/*El hashmap nos permite representar una estructura de datos para 
		 * representar clave/valor 
		 * Para acceder a su dato llamamos su clave Ejemplo: datos.get(k clave)
		 */
		Map <String, String> datos=  new HashMap<String, String>();
		
		/*El método put permite agregar un valor al map, en este caso la clave es nombre y el valor
		 * será lo que el usuario ingrese, de la misma manera para la cédula.
		 */
		datos.put("nombre", primerNombre);
		datos.put("segundoNombre", segundoNombre);
		datos.put("apellido", primerApellido);
		datos.put("cedula", cedula);
		
		System.out.println("Tablero comprado: ");
		mostrarTablero(matriz,datos);
			
		
		return datos;
	}
	
	/**
	 * 
	 * @param primerNombreJugador
	 * @param segundoNombreJugador
	 * @param apellidoJugador
	 * @param premioNeto
	 * @return
	 */
	public static double validarGanador(String primerNombreJugador,String segundoNombreJugador,String apellidoJugador,double premioNeto){
		double premioSumarCienMil=100000;
		double premioCincuentaMil=50000;
		double premioCientoCincuentaMil=150000;
		String segundoNombreInversa="";
		//se captura la última letra del nombre del jugador
		char ultimaLetraNombre = primerNombreJugador.charAt(primerNombreJugador.length()-1);
		/*se valida si la última letra es igual a esos caracteres (b-i-n-g-o)*/
		if (ultimaLetraNombre=='b' || ultimaLetraNombre=='i' || ultimaLetraNombre=='n' 
				|| ultimaLetraNombre=='g' || ultimaLetraNombre=='o' ){
			premioNeto +=premioSumarCienMil;
		}
		/*Se valida si el primer apellido, después de una consonante es una vocal se le sumará al 
		premio neto $50.000*/
		for(int i=0; i<apellidoJugador.length()-1;i++){
			if (esConsonante(apellidoJugador.charAt(i)) && (apellidoJugador.charAt(i+1) == 'a'
					|| apellidoJugador.charAt(i+1) == 'e' || apellidoJugador.charAt(i+1) == 'i'
					|| apellidoJugador.charAt(i+1) == 'o' || apellidoJugador.charAt(i+1) == 'u')) {
				premioNeto+=premioCincuentaMil;
				break;
			 }
		}
		//Un ciclo for el cual recorre la cadena el segundo nombre, y saca su inversa
		for(int i=segundoNombreJugador.length()-1;i>=0;i--){
			segundoNombreInversa = segundoNombreInversa+ segundoNombreJugador.charAt(i);	
		}
		/*Se valida si el segundo nombre es igual al segundo nombre inverso
		para saber si es palindroma y obtener un premio equivalente a $150.000*/
		if (segundoNombreInversa.equals(segundoNombreJugador)){
			premioNeto+=premioCientoCincuentaMil;
		}
		return premioNeto;
	}
	
	public static boolean esConsonante(char c) {
			char[] consonantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
		   boolean esIgual=false;
			for ( int i=0; i<consonantes.length;i++){
			   if (c ==consonantes[i]){
				   esIgual = true;
			   }
		   }
			return esIgual;
	}
}
