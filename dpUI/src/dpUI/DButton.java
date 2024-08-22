package dpUI;

import processing.core.PApplet;
import processing.core.PGraphics;

public class DButton {
	protected PApplet p;
	public int x, y, w, h;
	public String text;
	private float anim = 0;
	public boolean toggle = false, toggler = false, enableAnimations = true, active = true, visible = true;
	public int foregroundColor = 0xffffffff, foregroundSelectColor = 0xff80c0ff, backgroundColor = 0x40c4c4c4,
			textColor = 0xff000000, borderColor = 0xff000000, borderSize = 1, textXOffset = 10, textYOffset = 20,
			inactiveColor = 0xffbbbbbb, inactiveTextColor;
	public Runnable event = new Runnable() {
		@Override
		public void run() {
		}
	};

	public DButton(PApplet p, int x, int y, int w, int h, String text) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
	}

	public boolean checkIfHovered() {
		if (!visible || !active) return false;
		return p.mouseX > x && p.mouseX < x + w + anim && p.mouseY > y - anim && p.mouseY < y + h;
	}

	public void render(PGraphics g) {
		float animTarget = 0;
		g.pushStyle();
		g.fill(backgroundColor);
		g.strokeWeight(borderSize);
		g.stroke(borderColor);
		if (visible) {
			g.rect(x, y, w, h);
		}
		g.fill(foregroundColor);
		if (checkIfHovered()) {
			if (enableAnimations) {
				animTarget = 8;
			}
			g.fill(foregroundSelectColor);
		}
		if (!active)
			g.fill(inactiveColor);
		if (visible) {
			g.rect(x + anim, y - anim, w, h);
			if (active)
				g.fill(textColor);
			else
				g.fill(inactiveTextColor);
			g.text(text, x + textXOffset + anim, y + textYOffset - anim);
		}
		anim += (animTarget - anim) / 5;
		if (Math.abs(animTarget - anim) < 0.5f || !enableAnimations) {
			anim = animTarget;
		}
		g.popStyle();
	}
}
