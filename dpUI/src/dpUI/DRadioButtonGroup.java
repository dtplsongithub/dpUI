package dpUI;

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

	public void renderAll() {
		int n = 0;
		for (DRadioButton i : drb) {
			n++;
			i.render(n == currentActive);
		}
	}

	public void checkAll() {
		int n = 0;
		for (DRadioButton i : drb) {
			n++;
			if (i.checkIfHovered()) {
				currentActive = n;
				break;
			}
		}
	}
}
