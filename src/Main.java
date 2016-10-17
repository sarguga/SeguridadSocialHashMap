/**
 * Created by Sara on 17/10/2016.
 */
public class Main {

    public static void main(String[] args) {
        SeguridadSocial seguridadSocial = new SeguridadSocial();

        Persona jose = new Persona("29425364H", "111111111", "Jose", "Tomás", 35, 45000.00);
        Persona maria = new Persona("19425654W", "33333333", "Maria", "Gallego", 55, 61300.20);
        Persona carlos = new Persona("39425355Q", "22222222", "Carlos", "Torres", 22, 23000.00);
        Persona anna = new Persona("49425987J", "444444444", "Anna", "Pina", 26, 17654.88);


        seguridadSocial.altaPersona(jose);
        seguridadSocial.altaPersona(maria);
        seguridadSocial.altaPersona(carlos);
        seguridadSocial.altaPersona(anna);


        System.out.println("Altas a la seguridad social: " + seguridadSocial.obtenerTodas());

        System.out.println("Baja a la seguridad social: " + anna);
        seguridadSocial.bajaPersona(anna.getDni());


        System.out.println("Lista de afiliados a la S.S.: " + seguridadSocial.obtenerTodas());

        System.out.println("obtenerPersonaPorDNI: " + seguridadSocial.obtenerPersonaPorDNI(jose.getDni()));

        System.out.println("obtenerPersonaPorNumSS: " + seguridadSocial.obtenerPersonaPorNumSS(maria.getNumSS()));

        System.out.println("obtenerPersonasRangoSalarial: " + seguridadSocial.obtenerPersonasRangoSalarial(23000.00, 45000.00));

        System.out.println("obtenerPersonasMayoresQue: " + seguridadSocial.obtenerPersonasMayoresQue(25));


        System.out.println("Ordenado por DNI"+ seguridadSocial.ordenardni() );
        System.out.println("Ordenado por Nº Seguridad Social"+seguridadSocial.ordenarporss());
        System.out.println("Ordenar por Edad "+seguridadSocial.ordenarporedad());
        System.out.println("Ordenar por nombre "+seguridadSocial.ordenarponombre());

    }
}
