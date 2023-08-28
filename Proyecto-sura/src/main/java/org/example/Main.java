package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int rol = 0;
        int opcionAdministrador = 0;
        int contadorEspecialista = 0;
        String[] especialistas = new String[100];
        String[] cedulas = new String[100];
        String[] especialidades = new String[100];
        double[] salarios = new double[100];
        String[] fechas = new String[100];
        String opcionBuscar;
        String opcionRetirar;
        int horasTrabajadas;
        double totalTrabajado;
        double retencionSalario;
        double totalSalario;
        int opcionEspecialista = 0;
        int opcionPaciente = 0;

        System.out.println("Bienvenidos a Quantumtech.solutions \uD83D\uDE04\uD83D\uDC4D");

        while (rol != 4) {
            opcionPaciente=0;
            opcionEspecialista=0;
            opcionAdministrador=0;

            System.out.println("¿Qué rol desempeñas en la empresa? \uD83D\uDC47");
            System.out.println("1---- Administrador");
            System.out.println("2---- Especialista medico");
            System.out.println("3---- Paciente");
            System.out.println("4---- Salir de Quantumtech.solutions");
            System.out.print("Por favor ingrese una opcion: ");
            rol = teclado.nextInt();
            teclado.nextLine();

            switch (rol) {
                case 1:
                    while (opcionAdministrador != 5) {

                        System.out.println("que te gustaria hacer \uD83D\uDC47");
                        System.out.println("1---- Agregar especialistas ");
                        System.out.println("2---- Acceder a los especialistas de la compañia");
                        System.out.println("3---- Buscar un especialista por cédula");
                        System.out.println("4---- Retirar un especialista");
                        System.out.println("5---- SALIR");
                        System.out.print("Ingrese una opción: ");
                        opcionAdministrador = teclado.nextInt();
                        teclado.nextLine();

                        switch (opcionAdministrador) {
                            case 1:
                                System.out.println("Por favor ingrese nombre completo del especialista");
                                especialistas[contadorEspecialista] = teclado.nextLine();

                                System.out.println("Por favor ingrese la cédula del especialista");
                                cedulas[contadorEspecialista] = teclado.nextLine();

                                System.out.println("Por favor ingrese la especialidad del especialista");
                                especialidades[contadorEspecialista] = teclado.nextLine();

                                System.out.println("Por favor ingrese el salario del especialista");
                                salarios[contadorEspecialista] = teclado.nextDouble();

                                teclado.nextLine();
                                System.out.println("Por favor ingrese la fecha de ingreso al sistema");
                                fechas[contadorEspecialista] = teclado.nextLine();
                                contadorEspecialista++;

                                break;
                            case 2:
                                if (contadorEspecialista == 0) {
                                    System.out.println("No hay especialistas registrados en el sistema \uD83D\uDE22");
                                } else {
                                    for (int indice = 0; indice < contadorEspecialista; indice++) {
                                        System.out.println("Especialista # " + indice + " es: " + especialistas[indice] +
                                                " con cédula " + cedulas[indice] + " y especialidad de  " +
                                                especialidades[indice] + " con un salario de  " + salarios[indice] +
                                                " y con una fecha de ingreso el " + fechas[indice] + "\n");
                                    }
                                }
                                break;
                            case 3:
                                if (contadorEspecialista == 0) {
                                    System.out.println("No hay especialistas registrados en el sistema \uD83D\uDE22");
                                } else {
                                    System.out.print("Ingrese la cédula para acceder a la información del especialista: ");
                                    opcionBuscar = teclado.next();

                                    // en este ciclo lo que hacemos es un comparacion de la opcion del usuario recorriendo el arreglo y comparando


                                    for (int indiceBuscar = 0; indiceBuscar < contadorEspecialista; indiceBuscar++) {

                                        if (cedulas[indiceBuscar].equalsIgnoreCase(opcionBuscar)) {
                                            System.out.println("el especialista medico que quieres buscar es el especialista : # " + indiceBuscar + " con nombre " + especialistas[indiceBuscar] + " con cédula " + cedulas[indiceBuscar] + " especialista en " + especialidades[indiceBuscar]);
                                        } else {
                                            System.out.println("el especialista # "+indiceBuscar+" No coincide \uD83D\uDE22");
                                        }
                                    }
                                }
                                break;
                            case 4:
                                if (contadorEspecialista == 0) {
                                    System.out.println("No hay especialistas registrados en el sistema \uD83D\uDE22");
                                } else {
                                    System.out.print("Ingresar cédula para retirar un especialista: ");
                                    opcionRetirar = teclado.nextLine();

                                    // en este ciclo lo que hacemos es correr un indice mas el arreglo que queremos eliminar para que en el arreglo en el indice buscado no queden en null

                                    for (int indiceRetirar = 0; indiceRetirar < contadorEspecialista; indiceRetirar++) {

                                        if (cedulas[indiceRetirar].equals(opcionRetirar)) {
                                            System.out.println("el especialista # "+indiceRetirar+" ha sido eliminado de la base de datos");

                                            for (int i = indiceRetirar; i < contadorEspecialista - 1; i++) {
                                                especialistas[i] = especialistas[i + 1];
                                                cedulas[i] = cedulas[i + 1];
                                                especialidades[i] = especialidades[i + 1];
                                                salarios[i] = salarios[i + 1];
                                                fechas[i] = fechas[i + 1];
                                            }
                                            contadorEspecialista--;
                                            break;
                                        }
                                    }
                                }

                                break;
                        }
                    }
                    break;
                case 2:
                    while (opcionEspecialista != 3) {

                        System.out.println("que te gustaria hacer \uD83D\uDC47");
                        System.out.println("1---- Consultar salario");
                        System.out.println("2---- Acceder a los especialistas de la compañia");
                        System.out.println("3---- Salir");
                        System.out.print("Ingrese una opción: ");
                        opcionEspecialista = teclado.nextInt();
                        teclado.nextLine();

                        switch (opcionEspecialista) {
                            case 1:
                                System.out.println("Consulte su salario escribiendo cuantas horas trabajó este mes en la compañía");
                                horasTrabajadas = teclado.nextInt();

                                totalTrabajado = horasTrabajadas * 150000;
                                retencionSalario = totalTrabajado * 0.04;
                                totalSalario = totalTrabajado - retencionSalario;

                                System.out.println("Su salario con la retención de este mes trabajando en la compañía es de: " + totalSalario);
                                break;
                            case 2:
                                if (contadorEspecialista == 0) {
                                    System.out.println("No hay especialistas registrados en el sistema \uD83D\uDE22");
                                } else {
                                    for (int indice = 0; indice < contadorEspecialista; indice++) {
                                        System.out.println("Especialista # " + indice + " es: " + especialistas[indice] +
                                                " con cédula " + cedulas[indice] + " y especialidad de  " +
                                                especialidades[indice] + " con un salario CONFIDENCIAL " +
                                                " y con una fecha de ingreso el " + fechas[indice] + "\n");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Usted salió");
                                break;
                            default:
                                System.out.println("Por favor ingrese una opción correcta \uD83D\uDE22");
                                break;
                        }
                    }
                    break;
                case 3:
                    while (opcionPaciente != 2) {

                        System.out.println("que te gustaria hacer \uD83D\uDC47");
                        System.out.println("1---- Acceder a los especialistas de la compañia");
                        System.out.println("2---- Salir");
                        System.out.print("Ingrese una opción: ");
                        opcionPaciente = teclado.nextInt();
                        teclado.nextLine();

                        switch (opcionPaciente) {
                            case 1:
                                if (contadorEspecialista == 0) {
                                    System.out.println("No hay especialistas registrados en el sistema.");
                                } else {
                                    for (int indice = 0; indice < contadorEspecialista; indice++) {
                                        System.out.println("Especialista # " + indice + " es: " + especialistas[indice] +
                                                " con cédula " + cedulas[indice] + " y especialidad de  " +
                                                especialidades[indice] + " con un salario CONFIDENCIAL " +
                                                " y con una fecha de ingreso CONFIDENCIAL"+ "\n");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Usted salió \uD83E\uDD1A\uD83D\uDE43");
                                break;
                            default:
                                System.out.println("Por favor ingrese un número correcto");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("usted ha salido de Quantumtech.solutions le agradezemos por elegirnos y que tenga un feliz dia \uD83D\uDE01");
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
                    break;
            }
        }
    }
}
