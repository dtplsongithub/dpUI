package dpUI;

import processing.core.PApplet;
import processing.core.PConstants;

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

	public void render(boolean checked) {
		if (!visible) return;
		p.pushStyle();
		if (active) {
			p.fill(backgroundColor);
			p.stroke(borderColor);
		} else {
			p.fill(inactiveBackgroundColor);
			p.stroke(inactiveBorderColor);
		}
		p.ellipseMode(PConstants.CORNER);
		p.ellipse(x, y, s, s);
		if (active)
			p.fill(checkColor);
		else 
			p.fill(inactiveCheckColor);
		p.noStroke();
		p.ellipse(x+s/4, y+s/4, s/2, s/2);
		if (active)
			p.fill(textColor);
		else
			p.fill(inactiveTextColor);
		p.textAlign(PConstants.LEFT, PConstants.CENTER);
		p.text(text, x+s*1.5f, y+s/2);
		p.popStyle();
	}

	public boolean checkIfHovered() {
		if (!visible || !active)
			return false;
		return p.mouseX > x && p.mouseX < x + s && p.mouseY > y && p.mouseY < y + s;
	}
}
