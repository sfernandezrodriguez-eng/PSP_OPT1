/**Clase en la que se guarda los mensajes,
 * mediante el metodo escribir se guarda el mensaje en el buzon,
 * cuando tenga un mensaje es cuando los lectores pueden leer,
 * para eso se hace el metodo leer.
 * @author Sergio
 **/
public class Buzon {
    private String mensaje = "";


    /**
     * Si hay mensaje en el buzon, los escritores esperan a que se borre,
     * para eso se utiliza el wait y sale un mensaje por pantalla,
     * si no recibe del escritor el nuevo mensaje y se lo manda al buzón
     * @param nombreEscritor
     * @param nuevoMensaje
     * @throws InterruptedException
     */
    public synchronized void escribir(String nombreEscritor, String nuevoMensaje)
            throws InterruptedException {
        while (!mensaje.isEmpty()) {
            System.out.println(nombreEscritor + " espera: el buzón está ocupado.");
            wait();
        }

        mensaje = nuevoMensaje;
        System.out.println(nombreEscritor + " escribe: " + mensaje);
        notifyAll();
    }

    /**
     * Si no hay mensaje los lectores esperan para eso se utiliza el wait y sale un mensaje por pantalla,
     * en el caso de que haya un mensaje en el buzon printea el hilo lector y el mensaje del buzón
     * @param nombreLector
     * @return mensajeLeido
     * @throws InterruptedException
     */
    public synchronized String leer(String nombreLector) throws InterruptedException {
        while (mensaje.isEmpty()) {
            System.out.println(nombreLector + " espera: el buzón está vacío.");
            wait();
        }

        String mensajeLeido = mensaje;
        mensaje = "";
        System.out.println(nombreLector + " lee: " + mensajeLeido);
        notifyAll();
        return mensajeLeido;
    }
}