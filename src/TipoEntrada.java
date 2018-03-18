public enum TipoEntrada{
    ESTUDIANTE(0.7f),
    FIESTA(0.8f),
    MAYORES(0.7f),
    MINUSVALIDO(0.5f),
    NORMAL(1f);
    
    private float descuento;
    
    TipoEntrada(float descuento){
        this.descuento = descuento;
    }
    
    public float getDescuento(){
        return descuento;
    }
    
    public void setDescuento(float descuento){
        this.descuento = descuento;
    }
}
