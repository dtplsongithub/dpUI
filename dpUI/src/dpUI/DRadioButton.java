package dpUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class DRadioButton {
	protected PApplet p;
	public boolean visible, active;
	public int x, y, s = 16, borderColor = 0xffffffff, backgroundColor = 0xffcccccc, checkColor = 0xff000000,
			textColor = 0xffffffff, inactiveBorderColor = 0xffeeeeee, inactiveBackgroundColor = 0xff777777,
			inactiveCheckColor = 0xff333333, inactiveTextColor = 0xff777777;
	public String text;

	public DRadioButton(PApplet p, int x, int y, int s, String text) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.s = s;
		this.text = text;
	}

	public void render(PGraphics g, boolean checked) {
		if (!visible) return;
		g.pushStyle();
		if (active) {
			g.fill(backgroundColor);
			g.stroke(borderColor);
		} else {
			g.fill(inactiveBackgroundColor);
			g.stroke(inactiveBorderColor);
		}
		g.ellipseMode(PConstants.CORNER);
		g.ellipse(x, y, s, s);
		if (active)
			g.fill(checkColor);
		else
			g.fill(inactiveCheckColor);
		g.noStroke();
		g.ellipse(x+s/4, y+s/4, s/2, s/2);
		if (active)
			g.fill(textColor);
		else
			g.fill(inactiveTextColor);
		g.textAlign(PConstants.LEFT, PConstants.CENTER);
		g.text(text, x+s*1.5f, y+s/2);
		g.popStyle();
	}

	public boolean checkIfHovered() {
		if (!visible || !active)
			return false;
		return p.mouseX > x && p.mouseX < x + s && p.mouseY > y && p.mouseY < y + s;
	}
}
