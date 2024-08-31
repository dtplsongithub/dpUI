import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class DCheckbox extends DInteractive{
	public int borderColor = 0xffffffff, backgroundColor = 0xffcccccc, checkColor = 0xff000000,
			textColor = 0xffffffff, inactiveBorderColor = 0xffeeeeee, inactiveBackgroundColor = 0xff777777,
			inactiveCheckColor = 0xff333333, inactiveTextColor = 0xff777777;
	public boolean checked = false, defaultState = false;
	public String text;

	public DCheckbox(PApplet c, int x, int y, int s, String text) {
		this.c = c;
		this.x = x;
		this.y = y;
		this.w = s;
		this.h = s;
		this.text = text;
	}

	public void render(PGraphics p, int scrollY, int px, int py) {
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
		p.rect(x, y, w, h);
		p.noFill();
		if (active)
			p.stroke(checkColor);
		else
			p.stroke(inactiveCheckColor);
		p.strokeWeight(Math.max(w / 5, 1));
		p.strokeJoin(PConstants.MITER);
		p.strokeCap(PConstants.ROUND);
		if (!checked)
			p.noStroke();
		p.beginShape();
		p.vertex(x + w / 5, y + w / 1.8f);
		p.vertex(x + w / 2.4f, y + w - w / 5);
		p.vertex(x + w - w / 5, y + w / 5);
		p.endShape();
		if (active)
			p.fill(textColor);
		else
			p.fill(inactiveTextColor);
		p.textAlign(PConstants.LEFT, PConstants.CENTER);
		if (text.length() > 0) p.text(text, x+w*1.5f, y+w/2);
		p.popStyle();
	}
}
