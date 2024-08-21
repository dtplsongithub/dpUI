package dpUI;

import processing.core.PApplet;
import processing.core.PConstants;

public class DCheckbox {
	public PApplet p;
	public int x, y, s = 16, borderColor = 0xffffffff, backgroundColor = 0xffcccccc, checkColor = 0xff000000,
			inactiveBorderColor = 0xffeeeeee, inactiveBackgroundColor = 0xff777777, inactiveCheckColor = 0xff333333;
	public boolean visible = true, active = true, checked = false, defaultState = false;

	public DCheckbox(PApplet p, int x, int y, int s) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.s = s;
	}

	public boolean checkIfHovered() {
		if (!visible || !active)
			return false;
		return p.mouseX > x && p.mouseX < x + s && p.mouseY > y && p.mouseY < y + s;
	}

	public void render() {
		if (!active)
			checked = defaultState;
		if (!visible)
			return;
		p.pushStyle();
		if (active) {
			p.fill(backgroundColor);
			p.stroke(borderColor);
		} else {
			p.fill(inactiveBackgroundColor);
			p.stroke(inactiveBorderColor);
		}
		p.rect(x, y, s, s);
		p.noFill();
		if (active) 
			p.stroke(checkColor);
		else
			p.stroke(inactiveCheckColor);
		p.strokeWeight(Math.max(s/6, 1));
		p.strokeJoin(PConstants.ROUND);
		p.strokeCap(PConstants.ROUND);
		p.beginShape();
		p.vertex(x, y+s/2);
		p.vertex(x+s/2, y+s);
		p.vertex(x+s, y);
		p.endShape();
		p.popStyle();
	}
}
