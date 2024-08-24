package dpUI;

import processing.core.PApplet;
import processing.core.PConstants;

public class DProgressBar {
	public int x, y, w, h, borderColor = 0xFF00FF00, progressColor = 0xFF00FF00, interiorColor = 0xFF003300,
			textColor = 0xFFFFFFFF;
	public boolean visible = true, appendProgressToText = true;
	public byte progress = 0, indentation = 2, borderSize = 1, maxSteps = 100;
	public String text = "";
	private int interiorW, interiorH;

	public DProgressBar(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void render(PApplet p) {
		if (!visible) {
			return;
		}
		interiorW = w - indentation * 2;
		interiorH = h - indentation * 2;
		byte oldProgress = progress;
		progress *= 100 / (maxSteps);
		p.pushStyle();
		p.fill(0, 0);
		p.stroke(borderColor);
		p.strokeWeight(borderSize);
		p.rect(x, y, w, h);
		p.noStroke();
		p.fill(interiorColor);
		p.rect(x + indentation, y + indentation, w - indentation * 2, h - indentation * 2);
		p.textAlign(PConstants.CENTER, PConstants.CENTER);
		p.fill(textColor);
		p.text(text + (appendProgressToText ? + progress + "%" : ""), w / 2 + x, h / 2 + y);
		p.fill(progressColor);
		p.rect(x + indentation, y + indentation, PApplet.lerp(0, interiorW, (float) (progress) / 100), interiorH);
		p.popStyle();
		progress = oldProgress;
	}
}
