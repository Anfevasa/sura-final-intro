
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Definimos variables
        Scanner teclado = new Scanner(System.in);

        Integer opcionMenuPpl;
        Integer indice=0;

        String[] nombresEspecialistas = new String[100];
        String[] cedulasEspecialistas = new String[100];
        String[] especialidadesEspecialistas = new String[100];
        Double[] salariosEspecialistas = new Double[100];
        String[] fechasIngresosEspecialistas = new String[100];

        Integer horasEspecialista=0;
        Integer precioHoraEspecialista=150000;
        Double deduccionSalarioEspecialista=0.04;
        Integer opcionesPaciente=0;

        //variables colores:
        String azul="\033[0;34m";
        String blanco="\033[0m";
        String rojo="\033[0;31m";
        String morado="\033[0;35m";
        String cyan="\033[0;36m";

        System.out.println(azul+"-------------- SURA - JJSA soluciones --------------");

        do {
            // Menú principal
            System.out.println(cyan+"Bienvenido. ¿Qué perfil tienes?");
            System.out.println(blanco+"1. Administrador");
            System.out.println(blanco+"2. Especialista");
            System.out.println(blanco+"3. Paciente");
            System.out.println(rojo+"4. SALIR");
            System.out.print(morado+"Digite el número de su opción de su perfil: ");

            opcionMenuPpl = teclado.nextInt();
            switch (opcionMenuPpl){
                case 1:
                    Integer opcionMenuAdmin;
                    String cedulaConsulta;

                    do {
                        System.out.println(cyan+"---------- Menú administrador ----------");
                        System.out.println(cyan+"----"+blanco+" 1. Agregar nuevo especialista  "+cyan+ "----");
                        System.out.println(cyan+"----"+blanco+" 2. Ver datos de especialistas  "+cyan+"----");
                        System.out.println(cyan+"----"+blanco+" 3. Buscar especialista por CC  "+cyan+"----");
                        System.out.println(cyan+"----"+blanco+" 4. Retirar especialista por CC "+cyan+"----");
                        System.out.println(cyan+"----"+rojo+" 5. SALIR                       "+cyan+"----");
                        System.out.println(cyan+"----------------------------------------");
                        System.out.print(morado+"Digite el número de su opción: ");

                        opcionMenuAdmin = teclado.nextInt();
                        teclado.nextLine();

                        switch (opcionMenuAdmin){
                            case 1:
                                System.out.println(cyan+"---- Ingresando un nuevo especialista ----");
                                System.out.print(morado+"Digite el nombre: ");
                                nombresEspecialistas[indice]= teclado.nextLine();
                                System.out.print(morado+"Digite la cédula: ");
                                cedulasEspecialistas[indice]= teclado.nextLine();
                                System.out.print(morado+"Digite la especialidad: ");
                                especialidadesEspecialistas[indice]= teclado.nextLine();
                                System.out.print(morado+"Digite el salario: ");
                                salariosEspecialistas[indice]= teclado.nextDouble();
                                teclado.nextLine();
                                System.out.print(morado+"Digite la fecha de ingreso: ");
                                fechasIngresosEspecialistas[indice]= teclado.nextLine();
                                System.out.println(cyan+"AGREGADO CON ÉXITO."+morado+" Oprima enter para continuar.");
                                teclado.nextLine();
                                indice++;
                                break;
                            case 2:
                                System.out.println(cyan+"---- "+azul+"Base de datos especialistas"+cyan+" ----");
                                System.out.println(blanco+"|#|nombre|cédula|salario|fecha ingreso| ");
                                for (int i=0; i<nombresEspecialistas.length;i++){
                                    if (nombresEspecialistas[i] !=null) {
                                        System.out.println(blanco+"|"+blanco+(i+1)+blanco+"|"+azul+ nombresEspecialistas[i]+blanco+"|"+azul+cedulasEspecialistas[i]+blanco+"|"+azul+salariosEspecialistas[i]+blanco+"|"+azul+fechasIngresosEspecialistas[i]+blanco+"|");
                                    }
                                }
                                System.out.println(morado+"Oprima enter para continuar");
                                teclado.nextLine();

                                break;
                            case 3:
                                System.out.println(cyan+"---- Base de datos especialista ----");
                                System.out.print(morado+"Digite el número de cédula del especialista que desea CONSULTAR: ");
                                cedulaConsulta = teclado.nextLine();
                                Boolean encontradoB = false;
                                for (int i=0; i<cedulasEspecialistas.length;i++){
                                    if (cedulaConsulta.equals(cedulasEspecialistas[i])){
                                        encontradoB=true;
                                        System.out.println(cyan+"Cédula: "+blanco+ cedulasEspecialistas[i]);
                                        System.out.println(cyan+"Nombre: "+blanco+ nombresEspecialistas[i]);
                                        System.out.println(cyan+"Especialidad: "+blanco+ especialidadesEspecialistas[i]);
                                        System.out.println(cyan+"Salario: "+blanco+"$"+ salariosEspecialistas[i]);
                                        System.out.println(cyan+"Fecha de ingreso: "+blanco+ fechasIngresosEspecialistas[i]);
                                        System.out.println(morado+"Oprima enter para continuar");
                                        teclado.nextLine();
                                        break;
                                    }
                                }
                                if (!encontradoB){
                                    System.out.println(cyan+"No se encuentra especialista con esta cédula.");
                                }
                                break;
                            case 4:
                                System.out.println(cyan+"---- Base de datos especialista ----");
                                System.out.print(morado+"Digite el número de cédula del especialista que desea ELIMINAR: ");
                                cedulaConsulta = teclado.nextLine();

                                Boolean encontradoE = false;
                                for (int i=0; i<cedulasEspecialistas.length;i++){
                                    if (cedulaConsulta.equals(cedulasEspecialistas[i])){
                                        System.out.print("Digite 'true' para confirmar: ");
                                        encontradoE=true;
                                        if(teclado.nextBoolean()) {
                                            nombresEspecialistas[i] = null;
                                            cedulasEspecialistas[i] = null;
                                            especialidadesEspecialistas[i] = null;
                                            salariosEspecialistas[i] = null;
                                            fechasIngresosEspecialistas[i] = null;
                                            System.out.print(rojo+ "ELIMINADO."+morado+" Oprima enter para continuar");
                                            teclado.nextLine();
                                            teclado.nextLine();
                                            break;
                                        }
                                    }
                                }
                                if (!encontradoE) {
                                    System.out.println(cyan + "No se encuentra especialista con esta cédula.");
                                }
                                break;
                            case 5:
                                System.out.println(cyan+"Redirigiendo a perfiles");
                                break;
                            default:
                                System.out.println(rojo+"Opción inválida, intente de nuevo.");
                                break;
                        }
                    }while(opcionMenuAdmin!=5);
                    break;
                case 2:
                    Integer opcionMenuEspecialista=0;

                    do {
                        System.out.println(cyan+"----------------------- Menú especialista -----------------------");
                        System.out.println(cyan+"----"+blanco+" 1. Reportar numero de horas trabajadas durante el mes "+cyan+"------");
                        System.out.println(cyan+"----"+blanco+" 2. Consultar salario mensual                          "+cyan+"------");
                        System.out.println(cyan+"----"+blanco+" 3. Consultar la base de datos de los epecialistas     "+cyan+"------");
                        System.out.println(cyan+"----"+rojo+" 4. SALIR                                              "+cyan+"------");
                        System.out.println(cyan+"-----------------------------------------------------------------");
                        System.out.print(morado+"Digite el número de su opción: ");

                        opcionMenuEspecialista= teclado.nextInt();

                        switch (opcionMenuEspecialista){
                            case 1:
                                System.out.print(morado+"Ingresa tu número de horas trabajadas durante el ultimo mes: ");
                                horasEspecialista= teclado.nextInt();
                                break;
                            case 2:
                                Integer salarioEspecialista=horasEspecialista*precioHoraEspecialista;
                                Double descuentoSalarioEspecialista=(salarioEspecialista*deduccionSalarioEspecialista);
                                System.out.println(cyan+"Tu salario del ultimo mes es: "+(salarioEspecialista-descuentoSalarioEspecialista));
                                System.out.println(morado+"Oprima enter para continuar.");
                                teclado.nextLine();
                                teclado.nextLine();
                                break;
                            case 3:
                                System.out.println(morado+"ver la base de datos de todos los especialistas");
                                System.out.println(blanco+"|#|nombre|cédula|fecha ingreso| ");
                                for (int i=0; i<nombresEspecialistas.length;i++){
                                    if (nombresEspecialistas[i]!=null){
                                        System.out.println(blanco+"|"+(i+1)+blanco+"|"+azul+nombresEspecialistas[i]+blanco+"|"+azul+cedulasEspecialistas[i]+blanco+"|"+azul+fechasIngresosEspecialistas[i]+blanco+"|");
                                    }
                                }
                                System.out.println(morado+"Oprima enter para continuar");
                                teclado.nextLine();
                                teclado.nextLine();
                                break;
                            case 4:
                                System.out.println(cyan+"Redirigiendo a perfiles.");
                                break;
                            default:
                                System.out.println(rojo+"Opción invalida.");
                                break;
                        }
                    }while(opcionMenuEspecialista!=4);

                    break;
                case 3:
                    Integer opcionMenuPaciente = 0;

                    do {
                        System.out.println(cyan+"----------------- Menú paciente  -----------------");
                        System.out.println(cyan+"---"+blanco+" 1. Ver base de datos de los especialistas  "+cyan+"---");
                        System.out.println(cyan+"---"+rojo+" 2. SALIR                                   "+cyan+"---");
                        System.out.println(cyan+"--------------------------------------------------");
                        System.out.print(morado+"Digite el número de su opción: ");
                        opcionMenuPaciente= teclado.nextInt();

                        switch (opcionMenuPaciente) {
                            case 1:
                                System.out.println(cyan + "Ver la base de datos de todos los especialistas.");
                                System.out.println(blanco+"|#|nombre|cédula|fecha ingreso| ");
                                int i = 0;
                                for (i = 0; i < nombresEspecialistas.length; i++) {
                                    if (nombresEspecialistas[i]!=null){
                                        System.out.println(blanco + "|" + (i + 1) + azul + blanco + "|" + azul + nombresEspecialistas[i] + blanco + "|" + azul + cedulasEspecialistas[i] + blanco + "|" + azul + fechasIngresosEspecialistas[i]+blanco+"|");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println(cyan + "Redirigiendo a perfiles.");
                                break;
                            default:
                                System.out.println(rojo + "opcion invalida");
                        }
                    }while (opcionMenuPaciente!=2);
                    break;
                case 4:
                    System.out.println(azul+"Gracias por usar nuestros servicios, vuelva pronto.");
                    break;
                default:
                    System.out.println(rojo+"Opción inválida. Intente de nuevo");
                    break;
            }
        }while (opcionMenuPpl!=4);
    }
}