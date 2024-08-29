import processing.core.PApplet;
import processing.core.PConstants;

public class DDropdown {
	protected PApplet c;
	public boolean visible, active, extended;
	public DDropdownStyle style = DDropdownStyle.LEFT;
	public int x = 0, y = 0, w = 0, h = 0, contentW = 100, contentH = 100, summaryBackgroundColor = 0xff222222, summaryTextColor;
}
