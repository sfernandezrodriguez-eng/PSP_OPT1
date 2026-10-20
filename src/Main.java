public class Main {
    public static void main(String[] args) {
        Buzon buzon = new Buzon();

        Lector lector1 = new Lector("Lector 1", buzon);
        Lector lector2 = new Lector("Lector 2", buzon);

        Escritor escritor1 = new Escritor("Escritor 1", "Mensaje 1", buzon);
        Escritor escritor2 = new Escritor("Escritor 2", "Mensaje 2", buzon);

        lector1.start();
        lector2.start();
        escritor1.start();
        escritor2.start();
    }

}