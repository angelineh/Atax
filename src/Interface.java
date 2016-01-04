import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

	public void initialize(){

				MouseAdapter mAdapter = new MouseAdapter(){
				 boolean dragging = false;
				 int dragColonne, dragLigne;

				 public void mousePressed(MouseEvent e){
				    int size = (int)((float)Math.min(plateau.hauteur, plateau.largeur) /
						     (float)Math.max(plateau.hauteur,plateau.largeur)) ;
				    dragColonne = (e.getX())/ size;
				    dragLigne = (e.getY())/ size;
				    if( dragColonne >=0 && dragColonne < plateau.hauteur &&
					dragLigne >=0 && dragLigne < plateau.largeur)
				       dragging = true;
				 }

				 public void mouseReleased(MouseEvent e){
				    int size = (int)((float)Math.min(plateau.hauteur, plateau.largeur) /
						     (float)Math.max(plateau.hauteur,plateau.largeur)) ;
				    if ( !dragging )
				       return;
				    if ( null == plateauDragReporter )
				       return;

				    int dragColonne = (e.getX())/ size;
				    int dragLigne = (e.getY())/ size;
				    if( dragColonne >=0 && dragColonne < plateau.hauteur &&
					dragLigne >=0 && dragLigne < plateau.largeur)
				    	plateauDragReporter.dragged(new Move(plateau.playerToGo, 
							    dragColonne, dragLigne,
							    dragColonne, dragLigne),
						   plateau);
				    dragging = false;
				
			      };
			      
			      addMouseListener(mAdapter);
				} 
	
	public static void main(String[] args){

	    JFrame fenetre = new JFrame();
	    fenetre.setTitle("Attax");
	    fenetre.setSize(400, 100);
	    fenetre.setLocationRelativeTo(null);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	    fenetre.setVisible(true);
	  }       

   public class Interface extends JPanel{   
			    	  
		 final static boolean DRAWBOARD=true;
		 
		 public Graphics drawBoard(Graphics g){
				g.setColor(Interface.BACKGROUNDCOLOR);
				g.fillRect(0, 0, Interface.SQUARESIZE*Interface.GRIDLENGTH, Interface.SQUARESIZE*Interface.GRIDHEIGHT);
				for (int c=0;c<grid.length; c++ )
					for (int r=0;r<grid[1].length; r++ ){
						drawShape(g, c*Interface.SQUARESIZE, r*Interface.SQUARESIZE,grid[c][r]);
			    	  
		 public Graphics drawShape(Graphics g, int x, int y, int choice){
		 return drawShape(g,x,y,Interface.SQUARESIZE,choice);
						}
		 public Graphics drawShape(Graphics g, int x, int y, int r, int choice){
							r++;
							g.setColor(Interface.getColor(0));
							int w=Math.max((int)(r*.9), 3);
							g.fillRect(x+(r-w)/2,y+(r-w)/2,w, w);
							g.setColor(Interface.getColor(choice));
							if (choice<=1){
								if (choice!=0)
								g.fillRect(x,y,r, r);
							}
							else
							{
								g.fillOval(x+(r-w)/2,y+(r-w)/2,w, w);
								
								int littleRadius=w*14/40;
								if(littleRadius>1){
									g.setColor(g.getColor().darker());
									g.fillOval(x+r/2-littleRadius,y+r/2-littleRadius,littleRadius*2,littleRadius*2);

									g.setColor(new Color(255-Interface.getColor(choice).getRed(), 
											255-Interface.getColor(choice).getGreen(),
											255-Interface.getColor(choice).getBlue()
											));
								g.drawOval(x+r/2-littleRadius,y+r/2-littleRadius,littleRadius*2,littleRadius*2);
								}
							}
							return g;
						
		public void paintComponent(Graphics g){
			    			super.paintComponent(g);
			    			if (!Interface.DRAWBOARD) return;
			    			int w=getSize().width, h=getSize().height;
			    			offsetx=w/2;
			    			offsety=h/2;
			    			g.drawImage(backgroundImage.getImage(),0,0,w,h,null);
			    			
			    			g.translate(w/2+100, 0);
			    			g.setColor(Interface.BACKGROUNDCOLOR);
			    			g.fillRect(0, 0, 50,50);
			    			g.setColor(Color.black);
			    			g.drawRect(0,0,50,50);
			    			g.drawLine(0, 15, 50, 15);
			    			g.setColor(new Color(250-Interface.BACKGROUNDCOLOR.getRed(), 
			    					250-Interface.BACKGROUNDCOLOR.getGrey(),
			    					250-Interface.BACKGROUNDCOLOR.getBlue()));	
			    			
			    			plateau.drawBoard(g);
			    			g.translate(-offsetx+w/2-75,-offsety);
			    			g.setColor(new Color(RNG.nextInt(50),200+RNG.nextInt(50),RNG.nextInt(50)));
			    			g.drawString("Ataxx",0,50);
			    			g.translate(-w/2+75,0);
			    			g.setColor(new Color(250,250,250,200));
			    			g.fillRect(0,0,w/2-75,52);
			    			g.setColor(Color.black);
			    			g.drawRect(0,0,w/2-75,52);
			    			
		}
		
    }
			      
			    		 
			      
	
