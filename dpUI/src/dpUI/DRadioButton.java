package dpUI;

import processing.core.PApplet;

public class DRadioButton {
	PApplet p;
	public boolean visible, active;
	public int x, y, s = 16;
	public String text;
	
	public DRadioButton(PApplet p, int x, int y, int s, String text) {

	}

	public void render(boolean checked) {

	}
	
	public boolean checkIfHovered() {
		if (!visible || !active)
			return false;
		return p.mouseX > x && p.mouseX < x + s && p.mouseY > y && p.mouseY < y + s;
	}
}
