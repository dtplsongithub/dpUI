/* package dpUI;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DScrollableMenu extends DMenu {
	protected PApplet p;
	public int scrollY = 0;
	public int maxScrollY = 0;

	public DScrollableMenu(PApplet p, int x, int y, int maxScrollY) {
		super();
		this.p = p;
		this.maxScrollY = maxScrollY;
	}
	
	public void renderAll() {
		p.translate(0, scrollY);
		super.renderAll();
	}
	
	public void mouseWheel(processing.event.MouseEvent e) {
		scrollY = e.getCount()*20;
		if (scrollY > maxScrollY) scrollY = maxScrollY;
	}
}
*/