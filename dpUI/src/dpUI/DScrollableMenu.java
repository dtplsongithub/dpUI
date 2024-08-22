package dpUI;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DScrollableMenu extends DMenu {
	PApplet p;
	int scrollY = 0;

	public DScrollableMenu(PApplet p, int x, int y, int w, int h, String renderer) {
		super(p, x, y, w, h, renderer);
	}
	
	public void renderAll() {
		p.translate(0, scrollY);
		super.renderAll();
	}
	
	public void mouseWheel(MouseEvent e) {
		scrollY = e.getCount()*20;
	}
}
