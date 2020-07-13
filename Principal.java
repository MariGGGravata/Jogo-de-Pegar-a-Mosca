import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//ESTA CLASSE DEVE SE OBRIGATORIAMENTE MANTIDA NO PROJETO. QUALQUER ALTERAÇÃO REALIZADA DEVE OBEDECER A HIERARQUIA
public class Principal extends JFrame implements KeyListener {

	private Desenho fundo;
	private Cachorra cachorra;
	private static List<Mosca> moscas = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	private static Random rand = new Random();
	private static int num = rand.nextInt(2000);
	private static List<Coracao> coracao = new ArrayList<>();
	double c = 1, cont = 0.1;

	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Desenhando a tela e seus elementos
		fundo = new Desenho(0, 0, "Fundo.jpg");
		cachorra = new Cachorra(460, 600, "Sem_Titulo-2.png");
		for (int i = 0; i < 10; i++) {
			moscas.add(new Mosca(num, -200 * (i + 1), "Sem_Titulo-1.png"));
			num = rand.nextInt(1000);
		}
		coracao.add(new Coracao(15, 40, "corazaum.jpg"));
		coracao.add(new Coracao(15, 40, "corazaum1.jpg"));
		coracao.add(new Coracao(15, 40, "corazaum2.jpg"));
		coracao.add(new Coracao(15, 40, "corazaum3.jpg"));
		

		// Adicionando o evento de teclado
		this.addKeyListener(this);
	}

	// EVITAR ALTERAR ESSE MÉTODO
	public static void main(String[] args) {
		// Criando uma instância da classe principal
		Principal t = new Principal();
		t.setSize(1530, 900);
		t.createBufferStrategy(1);
		t.setVisible(true);
		t.createBufferStrategy(2);
		for (Mosca a : moscas) {
			a.run();
		}
		/*for(Contador c: contador) {
			c.getContentPane().add(contador);
		}*/

	}

	// EVITAR ALTERAR ESSE MÉTODO
	public void renderizarGraphics() {
		if (!getBufferStrategy().contentsLost())
			getBufferStrategy().show();
		Graphics g = getBufferStrategy().getDrawGraphics();

		// Criando um contexto gráfico
		Graphics g2 = g.create();
		// Limpando a tela
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());

		renderizarImagens(g2);

		// Liberando os contextos criados.
		g.dispose();
		g2.dispose();

	}

	// ESSE É O MÉTODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics g2) {
        //Desenhando as imagens
        fundo.desenhar(g2);
        cachorra.desenhar(g2);
        for (Mosca a: moscas) {
            a.desenhar(g2);
        }
        coracao.get(0).desenhar(g2);
        
        /*for ( int i = 120; i > 0; i--){
        	if (c > 0){
        	c += cont;
        	g2.drawString("Tempo:" + c, 1500, 40);
        	}
        }*/
        
        pegou();
        
        /*for (Contador c: contador) {
            c.desenhar(g2);
        }*/
        
        if(pegou == true) { 
    		moscas.get(0).setY(-1500);
        	moscas.add(moscas.get(0));
        	moscas.remove(0);
        	
        	if(a == 150 && b >= 0) {
        		
        		JOptionPane.showMessageDialog(null, "Parab�ns voce ganhou!");
        		System.exit(0);
        		
        	} else if(a >= 0 && b == 1){
            	
            	coracao.remove(0);
                coracao.get(0).desenhar(g2);
        	
        	} else if(a >= 0 && b == 2){
            	
            	coracao.remove(0);
                coracao.get(0).desenhar(g2);
                
        	} else if(a >= 0 && b == 3){
                	
                coracao.remove(0);
                coracao.get(0).desenhar(g2);
                   
        	} else if(a >= 0 && b == 4){
        		
                JOptionPane.showMessageDialog(null, "Voc� perdeu :( ");
                System.exit(0);
                
            }
                     
        }

	}

	// EVITAR ALTERAR ESSE MÉTODO
	public void paint(Graphics g) {
		this.renderizarGraphics();
		repaint();
	}

	public void keyPressed(KeyEvent evt) {
		// Especificando o comportamento das teclas
		if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			cachorra.moverDireita();
			repaint();

		} else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			cachorra.moverEsquerda();
			repaint();

		} else if (evt.getKeyCode() == KeyEvent.VK_UP) {
			cachorra.moverCima();
			repaint();

		} else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
			cachorra.moverBaixo();
			repaint();

		}
	}

	int a = 0;
	int b = 0;
	boolean pegou = false;

	public void pegou() {

		Rectangle cachorra1 = cachorra.bounds();
		Rectangle mosca1 = moscas.get(0).bounds();
		Rectangle fundo1 = Desenho.bounds1();

		if (cachorra1.intersects(mosca1)) {

			pegou = true;
			a += 10;
			
			//throw new 

		} else if (mosca1.intersects(fundo1)) {

			pegou = true;
			b += 1;

		} else {

			pegou = false;
		}

	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

}
