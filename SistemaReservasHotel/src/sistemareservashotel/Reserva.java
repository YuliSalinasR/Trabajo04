package sistemareservashotel;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private int noches;

    public Reserva(Cliente cliente, Habitacion habitacion, int noches) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.noches = noches;
        habitacion.setDisponible(false);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public int getNoches() {
        return noches;
    }

    public double calcularTotal() {
        return habitacion.getPrecioPorNoche() * noches;
    }

    @Override
    public String toString() {
        return "Reserva:\nCliente: " + cliente + "\nHabitacion: " + habitacion 
                + "\nNoches: " + noches + "\nTotal: $" + calcularTotal();
    }
}
