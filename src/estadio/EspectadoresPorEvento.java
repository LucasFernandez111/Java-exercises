package estadio;

public class EspectadoresPorEvento {
    private int MAX_PUERTAS = 15;
    private int[] puertas = new int[MAX_PUERTAS];
    private int cantidadTotalDeEspectadores = 0;

    public int[] getPuertas() {
        return puertas;
    }

    public int getEspectadoresQueIngresaronPorLaPuerta(int puerta) {
        return this.puertas[puerta - 1];
    }

    public void setPuertas(int[] puertas) {
        this.puertas = puertas;
    }

    public int getCantidadTotalDeEspectadores() {
        return cantidadTotalDeEspectadores;
    }

    public void setCantidadTotalDeEspectadores(int cantidadTotalDeEspectadores) {
        this.cantidadTotalDeEspectadores = cantidadTotalDeEspectadores;
    }

    public void ingresarEspectadoresPorLaPuerta(int puerta, int espectadores) {
        if (espectadores < 0) {
            throw new IllegalArgumentException("El número de espectadores debe ser mayor o igual a 0.");
        }
        this.puertas[puerta - 1] += espectadores;
        setCantidadTotalDeEspectadores(getCantidadTotalDeEspectadores() + espectadores);

    }

    @Override
    public String toString() {

        StringBuilder puertasString = new StringBuilder();

        for (int i = 0; i < MAX_PUERTAS; i++) {

            int numeroPuerta = i + 1;
            puertasString.append(numeroPuerta + "=" + puertas[i] + " ");

        }

        return cantidadTotalDeEspectadores + "," + puertasString + "\n";

    }

}
