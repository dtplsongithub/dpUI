package dpUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

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

	public void render(PGraphics g) {
		if (!visible) {
			return;
		}
		interiorW = w - indentation * 2;
		interiorH = h - indentation * 2;
		byte oldProgress = progress;
		progress *= 100 / (maxSteps);
		g.pushStyle();
		g.fill(0, 0);
		g.stroke(borderColor);
		g.strokeWeight(borderSize);
		g.rect(x, y, w, h);
		g.noStroke();
		g.fill(interiorColor);
		g.rect(x + indentation, y + indentation, w - indentation * 2, h - indentation * 2);
		g.textAlign(PConstants.CENTER, PConstants.CENTER);
		g.fill(textColor);
		g.text(text + (appendProgressToText ? + progress + "%" : ""), w / 2 + x, h / 2 + y);
		g.fill(progressColor);
		g.rect(x + indentation, y + indentation, PApplet.lerp(0, interiorW, (float) (progress) / 100), interiorH);
		g.popStyle();
		progress = oldProgress;
	}
}
