package dpUI;

import java.util.ArrayList;
import java.util.List;

public class DMenu {
	public List<DButton> dbuttons = new ArrayList<>(0);

	public DMenu() {
	}

	public void add(DButton dbutton) {
		dbuttons.add(dbutton);
	}

	public void renderAll() {
		for (DButton i : dbuttons) {
			if (i.active) {
				i.render();
			}
		}
	}

	public void checkAll() {
		for (DButton i : dbuttons) {
			if (i.active && i.checkIfHovered()) {
				i.event.run();
			}
		}
	}
}