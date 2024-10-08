

import processing.core.PApplet;
import processing.core.PGraphics;

public class DButton extends DInteractive {
	public String text;
	private float anim = 0;
	public boolean toggle = false, toggler = false, enableAnimations = true;
	public int foregroundColor = 0xffffffff, foregroundSelectColor = 0xff80c0ff, backgroundColor = 0x40c4c4c4,
			textColor = 0xff000000, borderColor = 0xff000000, borderSize = 1, textXOffset = 10, textYOffset = 20,
			inactiveColor = 0xffbbbbbb, inactiveTextColor;
	public Runnable event = new Runnable() {
		@Override
		public void run() {
		}
	};

	public DButton(PApplet c, int x, int y, int w, int h, String text) {
		this.c = c;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
	}

	public void render(PGraphics p, int scrollY, int px, int py) {
		float animTarget = 0;
		p.pushStyle();
		p.fill(backgroundColor);
		p.strokeWeight(borderSize);
		p.stroke(borderColor);
		if (visible) {
			p.rect(x, y, w, h);
		}
		p.fill(foregroundColor);
		if (checkIfHovered(scrollY, px, py)) {
			if (enableAnimations) {
				animTarget = 8;
			}
			p.fill(foregroundSelectColor);
		}
		if (!active)
			p.fill(inactiveColor);
		if (visible) {
			p.rect(x + anim, y - anim, w, h);
			if (active)
				p.fill(textColor);
			else
				p.fill(inactiveTextColor);
			p.text(text, x + textXOffset + anim, y + textYOffset - anim);
		}
		anim += (animTarget - anim) / 5;
		if (Math.abs(animTarget - anim) < 0.5f || !enableAnimations) {
			anim = animTarget;
		}
		p.popStyle();
	}
}
