package dpUI;

import java.util.ArrayList;
import java.util.List;

// please ignore any DButton cannot be resolved to a type errors.

public class DMenu {
	public List<DButton> db = new ArrayList<DButton>(0);
	public List<DProgressBar> dpb = new ArrayList<DProgressBar>(0);
	public boolean visible = true;

	public DMenu() {
	}

	public void add(DButton i) {
		db.add(i);
	}
	
	public void add(DProgressBar i) {
		dpb.add(i);
	}

	public void renderAll() {
		if (!visible) return;
		for (DButton i : db) {
			i.render();
		}
		for (DProgressBar i : dpb) {
			i.render();
		}
	}

	public void checkAll() {
		if (!visible) return;
		for (DButton i : db) {
			if (i.checkIfHovered()) {
				i.event.run();
			}
		}
	}
}