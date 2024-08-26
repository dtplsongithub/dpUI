import processing.core.PApplet;
import processing.core.PConstants;

public class DDropdown extends DMenu {
	public boolean extended = false;
	public DDropdownStyle s = DDropdownStyle.LEFT;
	public String summary = "";
	public int dx = 0, dy = -20, dh = 20, summaryBackgroundColor = 0xff111111, summaryTextColor = 0xffffffff;

	public DDropdown(PApplet p, int dx, int y, int w, int dh, int contentH, String summary) {
		super(p, dx, y, w, contentH);
		this.dx = dx;
		this.dy = y-dh;
		this.dh = dh;
		this.summary = summary;
	}
	
	public void renderAll() {
		p.pushStyle();
		p.noStroke();
		p.fill(summaryBackgroundColor);
		p.rect(dx, dy, w, dh);
		p.fill(summaryTextColor);
		p.textAlign(PConstants.CENTER, PConstants.CENTER);
		p.strokeWeight(5);
		p.strokeJoin(PConstants.MITER);
		p.strokeCap(PConstants.ROUND);
		int sxo = dx + (s==DDropdownStyle.RIGHT?w-16:0), syo = dy + dh/2-8;
		if (s == DDropdownStyle.LEFT) p.text(summary, dx + w / 2 + 8, dy + dh / 2);
		if (s == DDropdownStyle.RIGHT) p.text(summary, dx + w / 2 - 8 , dy + dh / 2);
		if (s == DDropdownStyle.INVIZ) p.text(summary, dx + w / 2, dy + dh / 2);
		p.stroke(summaryTextColor);
		if (s == DDropdownStyle.INVIZ) p.noStroke();
		p.noFill();
		p.beginShape();
		p.vertex(sxo, syo+8);
		p.vertex(sxo+8, syo+(extended?0:16));
		p.vertex(sxo+16, syo+8);
		p.endShape();
		p.popStyle();
		if (extended)
			super.renderAll();
	}

	public boolean checkIfHovered() {
		if (!visible)
			return false;
		return p.mouseX > dx && p.mouseX < dx + w && p.mouseY > dy && p.mouseY < dy + dh;
	}
	
	public void checkClick() {
		if (checkIfHovered()) extended = !extended;
		super.checkClick();
	}

}
