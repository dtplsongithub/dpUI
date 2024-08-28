

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class DCheckbox {
	protected PApplet c;
	public int x, y, s = 16, borderColor = 0xffffffff, backgroundColor = 0xffcccccc, checkColor = 0xff000000,
			textColor = 0xffffffff, inactiveBorderColor = 0xffeeeeee, inactiveBackgroundColor = 0xff777777,
			inactiveCheckColor = 0xff333333, inactiveTextColor = 0xff777777;
	public boolean visible = true, active = true, checked = false, defaultState = false;
	public String text;

	public DCheckbox(PApplet c, int x, int y, int s, String text) {
		this.c = c;
		this.x = x;
		this.y = y;
		this.s = s;
		this.text = text;
	}

	public boolean checkIfHovered(int scrollY, int px, int py) {
		if (!visible || !active)
			return false;
		return c.mouseX > x+px && c.mouseX < x + s+px && c.mouseY-scrollY > y+py && c.mouseY-scrollY < y + s+py;
	}

	public void render(PGraphics p) {
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
		p.strokeWeight(Math.max(s / 5, 1));
		p.strokeJoin(PConstants.MITER);
		p.strokeCap(PConstants.ROUND);
		if (!checked)
			p.noStroke();
		p.beginShape();
		p.vertex(x + s / 5, y + s / 1.8f);
		p.vertex(x + s / 2.4f, y + s - s / 5);
		p.vertex(x + s - s / 5, y + s / 5);
		p.endShape();
		if (active)
			p.fill(textColor);
		else
			p.fill(inactiveTextColor);
		p.textAlign(PConstants.LEFT, PConstants.CENTER);
		if (text.length() > 0) p.text(text, x+s*1.5f, y+s/2);
		p.popStyle();
	}
}
