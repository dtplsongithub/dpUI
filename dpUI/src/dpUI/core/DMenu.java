package dpUI.core;

import java.util.List;
import dpUI.DButton;

public class DMenu {
	List<DButton> dbuttons;

	public DMenu() {
	}

	public void add(DButton dbutton) {
		dbuttons.add(dbutton);
	}

	public void renderAll() {
		for (DButton i : dbuttons) {
			if (i.active)
				i.render();
		}
	}

	public void checkAll() {
		for (DButton i : dbuttons) {
			if (i.active && i.checkIfHovered())
				i.event.run();
		}
	}
}
