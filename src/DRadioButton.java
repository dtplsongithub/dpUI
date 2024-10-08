

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class DRadioButton {
	protected PApplet c;
	public boolean visible = true, active = true;
	public int x, y, s = 16, borderColor = 0xffffffff, backgroundColor = 0xffcccccc, checkColor = 0xff000000,
			textColor = 0xffffffff, inactiveBorderColor = 0xffeeeeee, inactiveBackgroundColor = 0xff777777,
			inactiveCheckColor = 0xff333333, inactiveTextColor = 0xff777777;
	public String text;

	public DRadioButton(PApplet c, int x, int y, int s, String text) {
		this.c = c;
		this.x = x;
		this.y = y;
		this.s = s;
		this.text = text;
	}

	public void render(PGraphics p, boolean checked) {
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
		if (checked) p.ellipse(x+s/4, y+s/4, s/2, s/2);
		if (active)
			p.fill(textColor);
		else
			p.fill(inactiveTextColor);
		p.textAlign(PConstants.LEFT, PConstants.CENTER);
		p.text(text, x+s*1.5f, y+s/2);
		p.popStyle();
	}

	public boolean checkIfHovered(int scrollY, int px, int py) {
		if (!visible || !active)
			return false;
		return c.mouseX > x+px && c.mouseX < x + s+px && c.mouseY-scrollY > y+py && c.mouseY-scrollY < y + s+py;
	}
}
