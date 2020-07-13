
//ESTA CLASSE FOI CRIADA AQUI APENAS COMO EXEMPLO. O ALUNO DEVE SUBSTITUI-LA POR OUTRA CLASSE CONFORME O PROJETO.
public class Mosca extends DesenhoAnimado {

  private Thread t = new Thread(this);

  public Mosca() {}

  public Mosca(int x, int y, String path) {
      super(x, y, path);
      t.start();
      
  }

  
  @SuppressWarnings("static-access")
  @Override
  public synchronized void run() {
      while(true) {
          //Random rand = new Random();
          this.setY(this.getY() + 10);

          if(Math.random() > 0.5)
        	  this.setX(getX() + 30);
                  	            
          else
        	  this.setX(getX() - 30);
          
          
          if(this.getX() <= 50)
    		  this.setX(getX() + 60);
    	  else if(this.getX() >= 950)
    		  this.setX(getX() - 60);
    	 
    		          
          try {
              t.sleep(200);
          } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          
      }
  }
  
}


