package dpUI;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

// please ignore any "DSomething cannot be resolved to a type" errors.
// eclipse just hates me

public class DMenu {
	protected PApplet p;
	public PGraphics g;
	public int scrollY = 0;
	public int maxScrollY = 0;
	public int x = 0, y = 0, w = 0, h = 0, backgroundColor = 0xff000000;
	public List<DButton> db = new ArrayList<>(0);
	public List<DProgressBar> dpb = new ArrayList<>(0);
	public List<DCheckbox> dc = new ArrayList<>(0);
	public List<DRadioButtonGroup> drbg = new ArrayList<>(0);
	public List<DLabel> dl = new ArrayList<>(0);
	public boolean visible = true;

	public DMenu(PApplet p, int x, int y, int w, int h) {
		this.p = p;
		this.g = p.createGraphics(w, h, PConstants.P3D);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void add(DButton i) {
		db.add(i);
	}

	public void add(DProgressBar i) {
		dpb.add(i);
	}

	public void add(DCheckbox i) {
		dc.add(i);
	}

	public void add(DRadioButtonGroup i) {
		drbg.add(i);
	}

	public void add(DLabel i) {
		dl.add(i);
	}

	public void renderAll() {
		if (!visible)
			return;
		g.translate(x, y+scrollY);
		g.beginDraw();
		g.background(0);
		for (DButton i : db) i.render(g);
		for (DProgressBar i : dpb) i.render(g);
		for (DCheckbox i : dc) i.render(g);
		for (DRadioButtonGroup i : drbg) i.renderAll(g);
		for (DLabel i : dl) i.render(g);
		g.endDraw();
		p.image(g, x, y);
	}

	public void checkClick() {
		if (!visible) {
			return;
		}
		for (DButton i : db) {
			if (i.checkIfHovered()) {
				i.event.run();
			}
		}
		for (DCheckbox i : dc) {
			if (i.checkIfHovered()) {
				if (i.visible && i.active)
					i.checked = !i.checked;
			}
		}
		for (DRadioButtonGroup i : drbg) {
			i.checkAll();
		}
	}
	
	public void mouseWheel(processing.event.MouseEvent e) {
		scrollY = e.getCount()*20;
		if (scrollY > maxScrollY) scrollY = maxScrollY;
	}
}