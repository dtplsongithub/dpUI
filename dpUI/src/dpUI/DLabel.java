package dpUI;

import processing.core.PApplet;

public class DLabel {
	protected PApplet p;
	public int x, y, alignX, alignY, textColor = 0xffffffff;
	public String text;
	
	public DLabel(PApplet p, int x, int y, String text) {
		
	}

	public void textAlign(int alignX) {
		this.alignX = alignX;
	}

	public void textAlign(int alignX, int alignY) {
		this.alignX = alignY;
	}
	
	public void render() {
		p.pushStyle();
	}
}
