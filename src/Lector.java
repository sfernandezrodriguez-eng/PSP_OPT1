/**Clase que lee los mensajes del buzón,
 * para ello utiliza el metodo leer de buzon,
 * se hace un bucle para las 3 veces que tiene
 * que leer y se llama al metodo para que compruebe que
 * haya algún mensaje y si lo hay, pues lo lee.
 * @author Sergio
 **/
public class Lector extends Thread {
    private final String nombre;
    private final Buzon buzon;

    public Lector(String nombre, Buzon buzon) {
        this.nombre = nombre;
        this.buzon = buzon;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                buzon.leer(nombre);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}