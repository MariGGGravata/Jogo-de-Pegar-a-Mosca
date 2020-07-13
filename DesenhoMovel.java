public class DesenhoMovel extends Desenho{

	public DesenhoMovel() {}

    public DesenhoMovel(int x, int y, String path) {
        super(x, y, path);
    }

    public void moverDireita() {
    	
        this.setX(this.getX() + 10);
        
    }

    public void moverEsquerda() {
    	
        this.setX(this.getX() - 10);
        
        
    }
    
    public void moverCima() {
    	
    	this.setY(this.getY() - 10);
    	
    }
    
    public void moverBaixo() {
    	
    	this.setY(this.getY() + 10);
    }
}
