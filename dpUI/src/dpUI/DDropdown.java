package dpUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class DDropdown extends DMenu {
	public boolean extended = false;
	public DDropdownStyle s = DDropdownStyle.LEFT;
	public String summary = "";
	public int x = 0, y = 0, w = 0, h = 0, summaryBackgroundColor = 0xff111111, summaryTextColor = 0xffffffff;

	public DDropdown(PApplet p, int x, int y, int w, int h, int contentH, String summary) {
		super(p, x, y, w, contentH);
		this.summary = summary;
	}

	public void render(PGraphics p) {
		p.pushStyle();
		p.noStroke();
		p.fill(summaryBackgroundColor);
		p.rect(x, y, w, h);
		p.fill(summaryTextColor);
		p.textAlign(PConstants.CENTER, PConstants.CENTER);
		p.strokeWeight(5);
		p.strokeJoin(PConstants.MITER);
		p.strokeCap(PConstants.ROUND);
		int sxo = x + (s==DDropdownStyle.RIGHT?w-16:0), syo = y + h/2-8;
		if (s == DDropdownStyle.LEFT) p.text(summary, x + w / 2 + 8, y + h / 2);
		if (s == DDropdownStyle.RIGHT) p.text(summary, x + w / 2 - 8 , y + h / 2);
		if (s == DDropdownStyle.INVIZ) p.text(summary, x + w / 2, y + h / 2);
		p.stroke(summaryTextColor);
		if (s == DDropdownStyle.INVIZ) p.noStroke();
		p.beginShape();
		p.vertex(sxo, syo+8);
		p.vertex(sxo+8, syo+(extended?0:16));
		p.vertex(sxo+16, syo+8);
		p.endShape();
		p.popStyle();
		if (extended)
			super.renderAll();
	}

}
