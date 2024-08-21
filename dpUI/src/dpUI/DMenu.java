package dpUI;

import java.util.ArrayList;
import java.util.List;

import dpUI.util.ShowMessage;

// please ignore any "DSomething cannot be resolved to a type" errors.
// eclipse just hates that class for some reason.

public class DMenu {
	public List<DButton> db = new ArrayList<>(0);
	public List<DProgressBar> dpb = new ArrayList<>(0);
	public List<DCheckbox> dc = new ArrayList<>(0);
	public List<DRadioButtonGroup> drbg = new ArrayList<>(0);
	public boolean visible = true;

	public DMenu() {
	}

	public void add(DButton i) {
		db.add(i);
	}

	public void add(DProgressBar i) {
		dpb.add(i);
	}

	public void add(DCheckbox i) {
		dc.add(i);
	}

	public void add(DRadioButtonGroup i) {
		drbg.add(i);
	}

	public void renderAll() {
		if (!visible) {
			return;
		}
		try {
			if (db.size() > 0) for (DButton i: db) i.render();
			if (dpb.size() > 0) for (DProgressBar i: dpb) i.render();
			if (dc.size() > 0) for (DCheckbox i: dc) i.render();
			// if (drbg.size() > 0) for (DRadioButtonGroup i: drbg) i.renderAll();
		} catch (NullPointerException e) {
			ShowMessage.showError(e.toString(), true);
		}
	}

	public void checkClick() {
		if (!visible) {
			return;
		}
		for (DButton i : db) {
			if (i.checkIfHovered()) {
				i.event.run();
			}
		}
		for (DCheckbox i : dc) {
			if (i.checkIfHovered()) {
				if (i.visible && i.active)
					i.checked = !i.checked;
			}
		}
		for (DRadioButtonGroup i : drbg) {
			i.checkAll();
		}
	}
}