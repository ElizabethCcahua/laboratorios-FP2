import java.util.ArrayList;
class Soldado {
    
  private String nombre;
    private int fila;
    private int columna;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;

    public void setFila(int nuevaFila) {
    fila = nuevaFila;
    }

    public void setColumna(int nuevaColumna) {
        columna = nuevaColumna;
    }
    public int getFila() {
    return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getNombre() {
        
        return nombre;
    }
    public void setNombre(String nuevoNombre) {
    nombre = nuevoNombre;
    }
    
    public Soldado() {
        this.nombre = "";
        this.nivelAtaque = Aleatorio(1, 5);
        this.nivelDefensa = Aleatorio(1, 5);
        this.nivelVida = Aleatorio(1, 5);
        this.vidaActual = this.nivelVida;
        this.velocidad = 0;
        this.actitud = "";
        this.vive = true;
    }

    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, String actitud) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = nivelVida;
        this.velocidad = velocidad;
        this.actitud = actitud;
        this.vive = true;
    }

    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int vidaActual, int velocidad, String actitud, boolean vive) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
        this.actitud = actitud;
        this.vive = vive;
    }


    private int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }


    public void atacar() {
        avanzar();
        this.nivelAtaque++;
        this.actitud = "ofensiva";
    }

    public void defender() {
        this.velocidad = 0;
        this.actitud = "defensiva";
    }
      
    public void huir() {
        this.velocidad += 2;
        this.actitud = "fuga";
    }

    public void avanzar() {
        this.velocidad++;
    }

    public void retroceder() {
        if (this.velocidad > 0) {
            this.velocidad = 0;
            this.actitud = "defensiva";
        }  else if (this.velocidad <0){
            this.velocidad--;
        }
    }

    public void Atacado() {
        this.vidaActual--;
        if (this.vidaActual <= 0) {
            morir();
        }
    }

    public void morir() {
        this.vive = false;
    }

    public void setVidaActual(int vida) {
        this.vidaActual = vida;
    }

    public int getVidaActual() {
        return this.vidaActual;
    }

   
}
