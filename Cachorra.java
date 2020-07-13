
public class Cachorra extends DesenhoMovel {

    public Cachorra() {}

    public Cachorra(int x, int y, String path) {
        super(x, y, path);
    }
    
    @Override
    public void moverDireita() {
    	
    	super.moverDireita();
    	this.setImg("Sem_Titulo-3.png");
    	
    }
    
    @Override
    public void moverEsquerda() {
    	
    	super.moverEsquerda();
    	this.setImg("Sem_Titulo-2.png");
    	
    }
    
    
 }

