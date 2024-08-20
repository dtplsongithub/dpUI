package dpUI;

import processing.core.PApplet;
import processing.core.PFont;

public class DButton {
	public PApplet p;
	public int x, y, w, h;
	public String id, text;
	private float anim = 0;
	public boolean toggle = false, toggler = false, enableAnimations = true, active = true;
	public int foregroundColor = 0xffffffff, foregroundSelectColor = 0xff80c0ff, backgroundColor = 0x40c4c4c4,
			textColor = 0xff000000, borderColor = 0xff000000, borderSize = 1, textXOffset = 10, textYOffset = 20;
	public PFont font;
	public Runnable event = new Runnable() {
		@Override
		public void run() {
		}
	};

	public DButton(PApplet p, String id, int x, int y, int w, int h, String text) {
		this.p = p;
		this.id = id;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
	}

	public boolean checkIfHovered() {
		return p.mouseX > x && p.mouseX < x + w + anim && p.mouseY > y - anim && p.mouseY < y + h;
	}

	public void render() {
		float animTarget = 0;
		p.pushStyle();
		p.fill(backgroundColor);
		p.strokeWeight(borderSize);
		p.stroke(borderColor);
		p.textFont(font);
		if (active) {
			p.rect(x, y, w, h);
		}
		p.fill(foregroundColor);
		if (checkIfHovered()) {
			if (enableAnimations) {
				animTarget = 8;
			}
			p.fill(foregroundSelectColor);
		}
		if (active) {
			p.rect(x + anim, y - anim, w, h);
			p.fill(textColor);
			p.text(text, x + textXOffset + anim, y + textYOffset - anim);
		}
		anim += (animTarget - anim) / 5;
		if (Math.abs(animTarget - anim) < 0.5f || !enableAnimations) {
			anim = animTarget;
		}
		p.popStyle();
	}
}
