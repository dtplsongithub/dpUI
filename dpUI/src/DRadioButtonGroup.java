

import java.util.ArrayList;
import java.util.List;

import processing.core.PGraphics;

public class DRadioButtonGroup {
	public List<DRadioButton> drb = new ArrayList<>(0);
	public boolean visible = true;
	public int currentActive = -1;

	public DRadioButtonGroup() {
	}

	public void add(DRadioButton i) {
		drb.add(i);
	}

	public void renderAll(PGraphics c) {
		int n = 0;
		for (DRadioButton i : drb) {
			n++;
			i.render(c, n == currentActive);
		}
	}

	public void checkAll(int scrollY, int px, int py) {
		int n = 0;
		for (DRadioButton i : drb) {
			n++;
			if (i.checkIfHovered(scrollY, px, py)) {
				currentActive = n;
				break;
			}
		}
	}
}
