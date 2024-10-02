package Veterinaria;

public class Veterinario {
    private String nombre;
    private String especialidad;
    private int experiencia;

    public Veterinario(String nombre, String especialidad, int experiencia) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Atiende a un animal y lo hace emitir su sonido
     * 
     * @param animal - animal al cual sera atendido
     */
    public void atenderAnimal(Animal animal) {
        animal.hacerSonido();
    }
}
