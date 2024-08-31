import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class DInteractive extends DComponent {
	protected PApplet c;
	public boolean active = true;
	
	public abstract void render(PGraphics p, int scrollY, int px, int py);

	public boolean checkIfHovered(int scrollY, int px, int py) {
		if (!visible || !active) return false;
		return c.mouseX > x+px && c.mouseX < x + w + px && c.mouseY-scrollY > y+py && c.mouseY-scrollY-py < y + h;
	}
}
