package drawcircle;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class drawcircle {
	Frame f;

	public static void main(String[] args) {
		drawcircle app=new drawcircle();

	}

	public drawcircle() {
		
		f=new Frame();
		f.setSize(1028,768);
		f.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});

		f.setVisible(true);
		mycanvas c=new mycanvas();
		c.setSize(f.getWidth(),f.getHeight());
		c.setVisible(true);
		f.add(c);
	}
	

}
class mycanvas<E> extends Canvas
{

	List<shape> list=new ArrayList<shape>();
	Point p1=new Point();
	Point p2=new Point();
	int check;
	public mycanvas() {
		
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.print("("+e.getX()+","+e.getY()+")");
				p1.setLocation(e.getPoint());
				//p2.setLocation(e.getPoint());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.print("Release:("+e.getX()+","+e.getY()+")");
				//p1.setLocation(e.getPoint());
				p2.setLocation(e.getPoint());
				shape s=new circle();
				s.set(p1,p2);
				list.add(s);
				repaint();
			}
			
		});
	    addMouseMotionListener(new MouseMotionListener()
			{

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
		
			});
	}

	@Override
	public void paint(Graphics g) {
	for(shape s:list)
		s.draw(g);
}
	}

abstract class shape
{
	Point p1=new Point();
	Point p2=new Point();
	void set(Point p1,Point p2)
	{
		this.p1=(Point) p1.clone();
		this.p2=(Point) p2.clone();
	}
	abstract void draw(Graphics g);
	
}


class circle extends shape
{
	void draw(Graphics g) {
		g.drawOval(p1.x, p1.y, 30, 30);
	}
}