/**Clase que escribe mensajes al buzón,
 * para ello utiliza el metodo escribir de buzon,
 * se hace un bucle para las 3 veces que tiene
 * que escribir y se llama al metodo para que compruebe que
 * no haya ningun mensaje y pueda escribir.
 * @author Sergio
 **/
public class Escritor extends Thread {
    private final String nombre;
    private final Buzon buzon;
    private final String mensaje;

    public Escritor(String nombre, String mensaje, Buzon buzon) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.buzon = buzon;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                buzon.escribir(nombre, mensaje + " (" + (i + 1) + "/3)");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

