package dpUI;

import java.util.ArrayList;
import java.util.List;

public class DRadioButtonGroup {
	public List<DRadioButton> drbg = new ArrayList<>(0);

	public DRadioButtonGroup() {
	}

	public void add(DRadioButton i) {
		drbg.add(i);
	}

	public void renderAll() {
		for (DRadioButton i : drbg) {
			i.render();
		}
	}

}
