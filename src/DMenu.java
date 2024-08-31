import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class DMenu {
	protected PApplet p;
	public PGraphics g;
	public int scrollY = 0;
	public int maxScrollY = 0;
	public int x = 0, y = 0, w = 0, h = 0, backgroundColor = 0xff000000;
	public List<DComponent> dc = new ArrayList<>(0);
	public boolean visible = true;

	public DMenu(PApplet p, int x, int y, int w, int h) {
		this.p = p;
		this.g = p.createGraphics(w, h, PConstants.P3D);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public void add(DComponent i) {
		dc.add(i);
	}

	public void renderAll() {
		if (!visible)
			return;
		g.beginDraw();
		g.pushMatrix();
		g.translate(0,scrollY);
		g.background(backgroundColor);
		for (DComponent i : dc) i.render(g);
		g.endDraw();
		g.popMatrix();
		p.image(g, x, y);
	}

	public void checkClick() {
		if (!visible || p.mouseX > x + w || p.mouseY > y + h + scrollY) {
			return;
		}
		p.mouseY -= scrollY;
// shrug
	}
	
	public void checkScroll(processing.event.MouseEvent e) {
		scrollY += e.getCount()*-20;
		if (scrollY < -maxScrollY) scrollY = -maxScrollY;
		if (scrollY > 0) scrollY = 0;
	}
}