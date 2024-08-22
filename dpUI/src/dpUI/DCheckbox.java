package dpUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class DCheckbox {
	protected PApplet p;
	public int x, y, s = 16, borderColor = 0xffffffff, backgroundColor = 0xffcccccc, checkColor = 0xff000000,
			textColor = 0xffffffff, inactiveBorderColor = 0xffeeeeee, inactiveBackgroundColor = 0xff777777,
			inactiveCheckColor = 0xff333333, inactiveTextColor = 0xff777777;
	public boolean visible = true, active = true, checked = false, defaultState = false;
	public String text;

	public DCheckbox(PApplet p, int x, int y, int s, String text) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.s = s;
		this.text = text;
	}

	public boolean checkIfHovered() {
		if (!visible || !active)
			return false;
		return p.mouseX > x && p.mouseX < x + s && p.mouseY > y && p.mouseY < y + s;
	}

	public void render(PGraphics g) {
		if (!active)
			checked = defaultState;
		if (!visible)
			return;
		g.pushStyle();
		if (active) {
			g.fill(backgroundColor);
			g.stroke(borderColor);
		} else {
			g.fill(inactiveBackgroundColor);
			g.stroke(inactiveBorderColor);
		}
		g.rect(x, y, s, s);
		g.noFill();
		if (active)
			g.stroke(checkColor);
		else
			g.stroke(inactiveCheckColor);
		g.strokeWeight(Math.max(s / 5, 1));
		g.strokeJoin(PConstants.MITER);
		g.strokeCap(PConstants.ROUND);
		if (!checked)
			g.noStroke();
		g.beginShape();
		g.vertex(x + s / 5, y + s / 1.8f);
		g.vertex(x + s / 2.4f, y + s - s / 5);
		g.vertex(x + s - s / 5, y + s / 5);
		g.endShape();
		if (active)
			g.fill(textColor);
		else
			g.fill(inactiveTextColor);
		g.textAlign(PConstants.LEFT, PConstants.CENTER);
		g.text(text, x+s*1.5f, y+s/2);
		g.popStyle();
	}
}
