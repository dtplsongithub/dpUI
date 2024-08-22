package dpUI;

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

	public void render(PGraphics g) {
		if (!visible)
			return;
		g.pushStyle();
		g.textAlign(alignX, alignY);
		g.fill(textColor);
		g.text(text, x, y);
		g.popStyle();
	}
}
