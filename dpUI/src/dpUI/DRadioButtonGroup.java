package dpUI;

import java.util.ArrayList;
import java.util.List;

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
		int i = 0;
		for (DRadioButton o : drb) {
			i++;
			o.render(i == currentActive);
		}
	}

	public void checkAll() {
		for (DRadioButton i : drb) {
			i.checkIfHovered();
		}
	}
}
