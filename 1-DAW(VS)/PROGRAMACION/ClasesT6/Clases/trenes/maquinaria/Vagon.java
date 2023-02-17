package ClasesT6.Clases.trenes.maquinaria;

class Vagon {
    
    // Atributo

    private int codigo;
    private int cargaMax;
    private int cargaActual;
    private String tipoMercancia;

    static int contadorVagon;

    // Contructores

    public Vagon(){

    }

    public Vagon(int cargaMax, int cargaActual, String tipoMercancia){

        this.cargaMax = cargaMax;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
        this.contadorVagon = contadorVagon + 1;
    }

    // Metodos

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(int cargaActual) {
        this.cargaActual = cargaActual;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    
}
