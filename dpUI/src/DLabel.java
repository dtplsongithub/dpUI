

import processing.core.PConstants;
import processing.core.PGraphics;

public class DLabel {
	public boolean visible = true;
	public int x, y, alignX = PConstants.LEFT, alignY = PConstants.BASELINE, textColor = 0xffffffff;
	public String text;

	public DLabel(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
	}

	public void textAlign(int alignX) {
		this.alignX = alignX;
	}

	public void textAlign(int alignX, int alignY) {
		this.alignX = alignX;
		this.alignY = alignY;
	}

	public void render(PGraphics p) {
		if (!visible)
			return;
		p.pushStyle();
		p.textAlign(alignX, alignY);
		p.fill(textColor);
		p.text(text, x, y);
		p.popStyle();
	}
}
