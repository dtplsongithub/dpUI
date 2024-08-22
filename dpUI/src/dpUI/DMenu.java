package dpUI;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PGraphics;

// please ignore any "DSomething cannot be resolved to a type" errors.
// eclipse just hates that class for some reason.

public class DMenu {
	protected PApplet p;
	public PGraphics g;
	public List<DButton> db = new ArrayList<>(0);
	public List<DProgressBar> dpb = new ArrayList<>(0);
	public List<DCheckbox> dc = new ArrayList<>(0);
	public List<DRadioButtonGroup> drbg = new ArrayList<>(0);
	public List<DLabel> dl = new ArrayList<>(0);
	public boolean visible = true;

	public DMenu() {
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
		for (DButton i : db) i.render(g);
		for (DProgressBar i : dpb) i.render(g);
		for (DCheckbox i : dc) i.render(g);
		for (DRadioButtonGroup i : drbg) i.renderAll(g);
		for (DLabel i : dl) i.render(g);
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
}