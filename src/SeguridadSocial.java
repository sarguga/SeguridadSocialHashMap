import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocial {

    private ArrayList<Persona> personasList;

    Map<String, Persona> personamapdni;
    Map<String, Persona> personamapnumss;

    public SeguridadSocial() {
        personasList = new ArrayList<>();

        //Crear 2 HashMap (NumSS y DNI)

        personamapdni = new HashMap<>();
        personamapnumss = new HashMap<>();

    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {
        //java8 values=recorre todos los valores stream = flujo , anymatch = si alguna coincide con la funcion (-> persona1.....)

        boolean repetida = personamapdni.values().stream().anyMatch(persona1 -> persona1.getDni().equals(persona.getDni()));
        //if (repetida == false) {

        if (!personamapdni.containsKey(persona.getDni()) && !personamapnumss.containsKey(persona.getNumSS())) {

            personamapdni.put(persona.getDni(), persona);
            personamapnumss.put(persona.getNumSS(), persona);

        }

    }

    public void bajaPersona(String dni) {

        Persona p = personamapdni.get(dni);
        personamapdni.remove(p.getDni());
        personamapnumss.remove(p.getNumSS());


    }

    public Persona obtenerPersonaPorDNI(String dni) {

        return personamapdni.get(dni);


    }

    public Persona obtenerPersonaPorNumSS(String numSS) {

        return personamapnumss.get(numSS);

    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max) {
        //max
        return personamapdni.values().stream().filter(persona -> persona.getSalario() >= min && persona.getSalario() <= max).collect(Collectors.toList());


    }

    public List<Persona> obtenerPersonasMayoresQue(int edad) {
        return personamapdni.values().stream().filter(persona -> persona.getEdad() > edad).collect(Collectors.toList());

    }


    public Persona obtenerPersonaSalarioMax() {
        //: indica que metodo de la clase persona tiene que utilizar para generar el comparador que utilizara internamente max
        return personamapdni.values().stream().max(Comparator.comparing(Persona::getSalario)).get();
    }


    public List<Persona> ordenardni() {
        //values coge todos los valores en este caso del hashmap y los pone en el arraylist
        List<Persona> ordenardni = new ArrayList<>(personamapdni.values());

        Collections.sort(ordenardni, Comparator.comparing(Persona::getDni));

        return ordenardni;

    }

    public List<Persona> ordenarporss() {
        List<Persona> ordenarporss = new ArrayList<>(personamapdni.values());
        Collections.sort(ordenarporss, Comparator.comparing(Persona::getNumSS));

        return ordenarporss;
    }

    public List<Persona> ordenarporedad() {
        List<Persona> ordenarporedad = new ArrayList<>(personamapdni.values());
        Collections.sort(ordenarporedad, Comparator.comparing(Persona::getEdad));
        return ordenarporedad;
    }

    public List<Persona> ordenarponombre() {

        List<Persona> ordenarporNombre = new ArrayList<>(personamapdni.values());
        Collections.sort(ordenarporNombre, Comparator.comparing(Persona::getNombre));
        return ordenarporNombre;
    }


    public List<Persona> obtenerTodas() {

        return personamapdni.values().stream().collect(Collectors.toList());

    }


    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }

}
