package FuncionesCH;

import java.util.Scanner;

import java.io.IOException;


public class Planificador extends Persona {

    
    public void opcionesP() throws IOException{
        Scanner sc = new Scanner(System.in);
        
        showOpcP();
        
        System.out.print(">>Elija una opción: ");
        int opc = sc.nextInt();  
        
        switch (opc) {
            case(1): 
                Curso curso = new Curso ();
                curso.CrearCurso();
                break;
            case(2):
                Profesor profe = new Profesor();
                profe.crearProfesor();
                break;
<<<<<<< HEAD
        }   
    }
    
    public static void showOpcP() {
        System.out.println("\n/** Qué desea hacer? **/\n"
                + "1. Crear curso\n"
                + "2. Crear Profesor\n"
                + "3. Crear estudiante\n"
                + "4. Ver Horarios Planificados\n"
                + "5. Listado de estudiantes");
    }
}
=======
            } else if (conf.equalsIgnoreCase("n")) {
                System.out.println("¡Se volverá a pedir datos!");
            } else {
                System.out.println("Sólo puede ingresar S en caso que desee guardar ó N en caso de volver a ingresar los datos.");
            }

        }
    }

    public static void addCursosTXT(Curso curso) {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("..\\ColegioHogwarts\\cursos.txt");
            outputStream.println(curso.getMateria() + "," + (curso.getProfesor()).getNombre() + " " + (curso.getProfesor()).getApellido() + "," + curso.getDia() + "," + curso.getHorario() + "," + curso.getCapacidad());

        } catch (FileNotFoundException e) {
            System.out.println("¡Archivo no encontrado!");
            System.exit(0);
        } finally {
            outputStream.close();
        }
    }

    private static boolean existeCurso(int num, Academico_Hogwarts AH) {
        Materia M = null;
        if (num <= 8 && num > 0) {
            switch (num) {
                case (1):
                    M = Materia.POCIONES;
                    break;
                case (2):
                    M = Materia.DEFENSA_CONTRA_LAS_ARTES_OSCURAS;
                    break;
                case (3):
                    M = Materia.ADIVINACION;
                    break;
                case (4):
                    M = Materia.ASTRONOMIA;
                    break;
                case (5):
                    M = Materia.HISTORIA_DE_LA_MAGIA;
                    break;
                case (6):
                    M = Materia.HERBOLOGIA;
                    break;
                case (7):
                    M = Materia.ENCANTAMIENTO;
                    break;
                case (8):
                    M = Materia.VUELO;
                    break;
            }
        }
        for (Curso C : AH.getHorarios()) {
            if (C.getMateria() == M) {
                return true;
            }
        }
        return false;
    }

    private static void showMaterias() {
        System.out.println("/** MATERIAS **/\n");
        System.out.println("1. Pociones");
        System.out.println("2. Defensa contra las artes oscuras");
        System.out.println("3. Adivinación");
        System.out.println("4. Astronomia");
        System.out.println("5. Historia de la Magia");
        System.out.println("6. Herbología");
        System.out.println("7. Encantamiento");
        System.out.println("8. Vuelo");
    }

    private static void showProfesores(Academico_Hogwarts AH) {
        ArrayList<Profesor> profes = AH.getProfesores();
        if (profes != null) {
            System.out.println("/** PROFESORES **/");
            int i = 1;
            for (Profesor profe : profes) {
                System.out.println(i + ". " + profe.getNombre() + " " + profe.getApellido());
                i++;
            }
        } else {
            System.out.println("No hay profesores todavía.");
        }
    }

    public void crearProfesor(ArrayList<Profesor> profes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("/** CREAR PROFESOR **/");

        System.out.println("Ingrese Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese Apellidos: ");
        String apellidos = sc.nextLine();

        System.out.println("Ingrese Edad: ");
        int edad = sc.nextInt();

        System.out.println("Varita: ");
        String varita = sc.nextLine();

        System.out.println("Fecha de Ingreso: ");
        String fechaIn = sc.nextLine();

        Hechizero H = elegirTipoMago();

        System.out.println("\n¿Desea guardar los datos? S/N");
        String conf = sc.nextLine();
        if (conf.equalsIgnoreCase("s")) {
            Profesor profe = new Profesor(fechaIn, nombre, apellidos, edad, varita, H);
            profes.add(profe);
            System.out.println("Sus datos se han guardado correctamente");
        } else if (conf.equalsIgnoreCase("n")) {
            System.out.println("¡Se volverá a pedir datos!");
        } else {
            System.out.println("Sólo puede ingresar S en caso que desee guardar ó N en caso de volver a ingresar los datos.");
        }

    }

    public void addProfesoresTXT(Profesor P) {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("..\\ColegioHogwarts\\profesores.txt");
            Hechizero H = P.getTipoMago();
            if (H instanceof Animago) {
                outputStream.println(P.getNombre() + "," + P.getApellido() + "," +  P.getEdad() + "," + P.getVarita() + "," + P.getFechaIngreso() + ",Animago,"+ ((Animago) H).getAnimal()+","+((Animago)H).getHechizo()+",null,null");
            }else if (H instanceof Metamorfomago) {
                outputStream.println(P.getNombre() + "," + P.getApellido() + "," +  P.getEdad() + "," + P.getVarita() + "," + P.getFechaIngreso() + ",Metamorfomago,null,null,"+((Metamorfomago)H).getPocion()+",null");
            }else if (H instanceof Normal){
                outputStream.println(P.getNombre() + "," + P.getApellido() + "," +  P.getEdad() + "," + P.getVarita() + "," + P.getFechaIngreso() + ",Normal,null,null,null,"+((Normal)H).getDeporte());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("¡Archivo no encontrado!");
            System.exit(0);
        } finally {
            outputStream.close();
        }

    }

    public void crearEstudiante(ArrayList<Estudiante> estudiantes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("/** CREAR ESTUDIANTE **/");

        System.out.println("Ingrese Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese Apellidos: ");
        String apellidos = sc.nextLine();

        System.out.println("Ingrese Edad: ");
        int edad = sc.nextInt();

        System.out.println("Varita: ");
        String varita = sc.nextLine();

        System.out.println("Casa: ");
        String casa = sc.nextLine();

        Casa c = elegirCasa(casa);

        Hechizero H = elegirTipoMago();

        System.out.println("\n¿Desea guardar los datos? S/N");

        String conf = sc.nextLine();
        if (conf.equalsIgnoreCase("s")) {
            Estudiante est = new Estudiante(c, nombre, apellidos, edad, varita, H);
            estudiantes.add(est);
            System.out.println("Sus datos se han guardado correctamente");
        } else if (conf.equalsIgnoreCase("n")) {
            System.out.println("¡Se volverá a pedir datos!");
        } else {
            System.out.println("Sólo puede ingresar S en caso que desee guardar ó N en caso de volver a ingresar los datos.");
        }

    }

    public static void addEstudiantesTXT(Estudiante e) {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("..\\ColegioHogwarts\\estudiantes.txt");
            if (e.getTipoMago() instanceof Animago) {
                outputStream.println(e.getNombre() + "," + e.getApellido() + "," + e.getEdad() + "," + e.getVarita() + "," + e.getCasa() + "," + "Animago");
            }else if (e.getTipoMago() instanceof Metamorfomago) {
                outputStream.println(e.getNombre() + "," + e.getApellido() + "," + e.getEdad() + "," + e.getVarita() + "," + e.getCasa() + "," + "Metamorfomago");
            }else if (e.getTipoMago() instanceof Normal){
                outputStream.println(e.getNombre() + "," + e.getApellido() + "," + e.getEdad() + "," + e.getVarita() + "," + e.getCasa() + "," + "Normal");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("¡Archivo no encontrado!");
            System.exit(0);
        } finally {
            outputStream.close();
        }
    }

    private static void showTiposMagos() {
        System.out.println("Tipos de Magos/Brujas");
        System.out.println("1.Animago");
        System.out.println("2.Metamorfomago");
        System.out.println("3.Estandar");
    }

    private static Casa elegirCasa(String casa) {
        Casa c;
        while (true) {
            if (casa.equalsIgnoreCase("gryffindor")) {
                c = Casa.GRYFFINDOR;
                return c;
            } else if (casa.equalsIgnoreCase("ravenclaw")) {
                c = Casa.RAVENCLAW;
                return c;
            } else if (casa.equalsIgnoreCase("hufflepuff")) {
                c = Casa.HUFFLEPUFF;
                return c;
            } else if (casa.equalsIgnoreCase("slytherin")) {
                c = Casa.SLYTHERIN;
                return c;
            } else {
                System.out.println("Solo puede elegir entre éstas 4 casas: Gryffindor, Ravenclaw, Hufflepuff y Slytherin");
            }
        }
    }

    private static Dia elegirDia(String dia) {
        Dia d;
        while (true) {
            if (dia.equalsIgnoreCase("lunes")) {
                d = Dia.LUNES;
                return d;
            } else if (dia.equalsIgnoreCase("martes")) {
                d = Dia.MARTES;
                return d;
            } else if (dia.equalsIgnoreCase("miercoles")) {
                d = Dia.MIERCOLES;
                return d;
            } else if (dia.equalsIgnoreCase("jueves")) {
                d = Dia.JUEVES;
                return d;
            } else if (dia.equalsIgnoreCase("viernes")) {
                d = Dia.VIERNES;
                return d;
            } else if (dia.equalsIgnoreCase("sabado")) {
                d = Dia.SABADO;
                return d;
            } else if (dia.equalsIgnoreCase("domingo")) {
                d = Dia.DOMINGO;
                return d;
            } else {
                System.out.println("Solo puede elegir entre los días de la semana.");
            }
        }
    }

    private static Hechizero elegirTipoMago() {
        Scanner sc = new Scanner(System.in);
        showTiposMagos();
        System.out.println("Elija el tipo de mago/bruja que es:");
        while (true) {
            int tipo = sc.nextInt();
            String animal, hechizo, pocion, deporte;
            Hechizero H;
            switch (tipo) {
                case (1):
                    System.out.println("\n¿En qúe clase de animal puede convertirse?: ");
                    animal = sc.nextLine();
                    System.out.println("\n¿Qúe hechizo está usando?: ");
                    hechizo = sc.nextLine();
                    H = new Animago(animal, hechizo);
                    return H;
                case (2):
                    System.out.println("\n¿Qué poción usa?: ");
                    pocion = sc.nextLine();
                    H = new Metamorfomago(pocion);
                    return H;
                case (3):
                    System.out.println("\n¿Cuál es su deporte favorito?: ");
                    deporte = sc.nextLine();
                    H = new Normal(deporte);
                    return H;
                default:
                    System.out.println("\n¡La opción no existe, ingrese de nuevo!");
            }
        }
    }

    public void verHorarios(ArrayList<Curso> cursos) {
        Scanner sc = new Scanner(System.in);
        if (cursos != null) {
            int i = 1;
            System.out.println("/** CURSOS PLANIFICADOS **/");
            for (Curso C : cursos) {
                System.out.println(i + ". " + C.getMateria());
                i++;
            }
            System.out.println("Elija una materia del listado de materias: ");
            int num = sc.nextInt();
            sc.nextLine();
            Curso curso = cursos.get(num - 1);

            System.out.println("MATERIA: " + curso.getMateria());
            System.out.println("PROFESOR: " + (curso.getProfesor()).getNombre() + " " + (curso.getProfesor()).getApellido());
            System.out.println("HORARIO: " + curso.getDia() + ", " + curso.getHorario());
            System.out.println("REGISTRADOS: " + curso.getRegistrados());

        } else {
            System.out.println("¡Aún no hay cursos creados!");
        }

    }

    public void verListadoEstudiantes(ArrayList<Estudiante> estudiantes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("/** LISTADO DE ESTUDIANTES **/");
        System.out.println("1. Edad");
        System.out.println("2. Nombre");
        System.out.println("3. Número de materias registradas");
        System.out.println("Elija el criterio para ordenar: ");
        while (true) {
            int num = sc.nextInt();
            sc.nextLine();
            if (num <= 3 && num > 0) {
                if (num == 1) {
                    Collections.sort(estudiantes);
                    showListado(estudiantes);
                    break;
                } else if (num == 2) {
                    Collections.sort(estudiantes, new PorEdad());
                    showListado(estudiantes);
                    break;
                } else if (num == 3) {
                    Collections.sort(estudiantes, new PorMatReg());
                    showListado(estudiantes);
                    break;
                }
            } else {
                System.out.println("Dicha opción no existe, elija de nuevo:");
            }
        }

    }

    public static void showListado(ArrayList<Estudiante> ests) {
        for (Estudiante e : ests) {
            System.out.println(e.toString());
        }
    }

}
>>>>>>> parent of 5293592... :(
