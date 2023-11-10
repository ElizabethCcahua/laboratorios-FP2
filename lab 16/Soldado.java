
package lab.pkg16;

class Soldado {
    
  private String nombre;
    private int fila;
    private int columna;
    private String caracteristica;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;

    public Soldado() {
        this.nombre = "Soldado";
        this.nivelAtaque = Aleatorio(1, 5);
        this.nivelDefensa = Aleatorio(1, 5);
        this.nivelVida = Aleatorio(1, 5);
        this.vidaActual = this.nivelVida;
        this.velocidad = Aleatorio(1, 5);
        this.actitud = "defensiva";
        this.vive = true;
    }

    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int vidaActual, int velocidad, String actitud,String caracteristica) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
        this.actitud = actitud;
        this.vive = true;
        this.caracteristica=caracteristica;
                
    }

    public Soldado( int nivelAtaque, int nivelDefensa, int nivelVida,  int velocidad, String actitud, boolean vive) {
        
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = nivelVida;
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

    public void serAtacado() {
        this.vidaActual--;
        if (this.vidaActual <= 0) {
            morir();
        }
    }

    public void morir() {
        this.vive = false;
    }

   public Soldado sumar(Soldado soldado) {
    int nuevoNivelAtaque = this.nivelAtaque + soldado.nivelAtaque;
    int nuevoNivelDefensa = this.nivelDefensa + soldado.nivelDefensa;
    int nuevaVidaActual = this.vidaActual + soldado.vidaActual;
    int nuevaVelocidad = this.velocidad + soldado.velocidad;
    
    Soldado soldadoSuma = new Soldado("SumaSoldado", nuevoNivelAtaque, nuevoNivelDefensa, nuevaVidaActual, nuevaVelocidad, "", "");
    return soldadoSuma;
}
    
   public String toString() {
    return "Nombre: " + nombre + "\n" +
            "Nivel de ataque: " + nivelAtaque + "\n" +
            "Nivel de defensa: " + nivelDefensa + "\n" +
            "Nivel de vida: " + nivelVida + "\n" +
            "Vida actual: " + vidaActual + "\n" +
            "Velocidad: " + velocidad + "\n" +
            "Actitud: " + actitud + "\n" +
            "Vive: " + vive + "\n" +
            "Característica: " + caracteristica + "\n"+
            "\n"+"\n";
}
    
   // Métodos set y get para el atributo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Métodos set y get para el atributo fila
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getFila() {
        return fila;
    }

    // Métodos set y get para el atributo columna
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getColumna() {
        return columna;
    }

    // Métodos set y get para el atributo nivelAtaque
    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    // Métodos set y get para el atributo nivelDefensa
    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    // Métodos set y get para el atributo nivelVida
    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    // Métodos set y get para el atributo vidaActual
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    // Métodos set y get para el atributo velocidad
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    // Métodos set y get para el atributo actitud
    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public String getActitud() {
        return actitud;
    }

    // Métodos set y get para el atributo vive
    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean isVive() {
        return vive;
    }
    
 public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    // Método get para el atributo caracteristica
    public String getCaracteristica() {
        return caracteristica;
    }

     
}
 


