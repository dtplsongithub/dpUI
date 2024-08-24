package dpUI;

import processing.core.PApplet;

public class DDropdown extends DMenu {
	public boolean extended = false;
	public DDropdownStyle s = DDropdownStyle.LEFT;
	public String summary = "";
	public int w = 0, h = 0, contenth = 100;

	public DDropdown(PApplet p, int x, int y, int w, int h, int maxScrollY, String summary) {
		super(p, x, y, w, h);
		this.summary = summary;
	}
	
	public void renderAll() {
		if (extended) super.renderAll();
	}

}
