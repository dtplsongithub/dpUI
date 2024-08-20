package dpUI;

import processing.core.PApplet;

public class DCheckbox {
	public PApplet p;
	public int x, y, s = 16, borderColor = 0xffffffff, backgroundColor = 0xffcccccc;
	public boolean visible = true, active = true, checked = false;

	public DCheckbox(PApplet p, int x, int y, int s) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.s = s;
	}

	public boolean checkIfHovered() {
		if (!visible || !active) return false;
		return p.mouseX > x && p.mouseX < x + s && p.mouseY > y  && p.mouseY < y + s;
	}
	
	public void render() {
		p.text("checkbox render coming soon", x, y);
	}
}
