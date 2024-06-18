package sistemareservashotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaHotel sistemaHotel = new SistemaHotel();

        // Agregar algunas habitaciones de ejemplo
        sistemaHotel.agregarHabitacion(new Habitacion(101, "Individual", 50.0));
        sistemaHotel.agregarHabitacion(new Habitacion(102, "Doble", 75.0));
        sistemaHotel.agregarHabitacion(new Habitacion(103, "Suite", 120.0));

        int opcion;
        do {
            System.out.println("Sistema de Gestion de Reservas de Hotel");
            System.out.println("1. Gestionar Habitaciones");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Crear Reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    gestionarHabitaciones(scanner, sistemaHotel);
                    break;
                case 2:
                    gestionarClientes(scanner, sistemaHotel);
                    break;
                case 3:
                    crearReserva(scanner, sistemaHotel);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void gestionarHabitaciones(Scanner scanner, SistemaHotel sistemaHotel) {
        System.out.println("Gestionar Habitaciones");
        for (Habitacion habitacion : sistemaHotel.getHabitacionesDisponibles()) {
            System.out.println(habitacion);
        }
    }

    private static void gestionarClientes(Scanner scanner, SistemaHotel sistemaHotel) {
        System.out.println("Gestionar Clientes");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        Cliente cliente = new Cliente(nombre, apellido, dni);
        sistemaHotel.agregarCliente(cliente);
        System.out.println("Cliente agregado: " + cliente);
    }

    private static void crearReserva(Scanner scanner, SistemaHotel sistemaHotel) {
        System.out.println("Crear Reserva");
        System.out.println("Seleccione un cliente:");
        for (int i = 0; i < sistemaHotel.getClientes().size(); i++) {
            System.out.println((i + 1) + ". " + sistemaHotel.getClientes().get(i));
        }
        int indiceCliente = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Seleccione una habitación:");
        for (int i = 0; i < sistemaHotel.getHabitacionesDisponibles().size(); i++) {
            System.out.println((i + 1) + ". " + sistemaHotel.getHabitacionesDisponibles().get(i));
        }
        int indiceHabitacion = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Numero de noches: ");
        int noches = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Cliente cliente = sistemaHotel.getClientes().get(indiceCliente);
        Habitacion habitacion = sistemaHotel.getHabitacionesDisponibles().get(indiceHabitacion);

        Reserva reserva = new Reserva(cliente, habitacion, noches);
        sistemaHotel.realizarReserva(reserva);

        System.out.println("Reserva realizada con exito:");
        System.out.println(reserva);
    }
}
