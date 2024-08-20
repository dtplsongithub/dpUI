package dpUI;

import dpUI.util.ShowMessage;
import processing.core.*;

public class DProgressBar {
	public PApplet p;
	public int x, y, w, h, borderColor = 0xFF00FF00, progressColor = 0xFF00FF00, interiorColor = 0xFF003300,
			textColor = 0xFFFFFFFF;
	public boolean visible = true, appendProgressToText = true;
	public byte progress = 0, indentation = 2, borderSize = 1, maxSteps = 100;
	public String text = "";
	private int interiorW, interiorH;

	public DProgressBar(PApplet p, int x, int y, int w, int h) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void render() {
		if (!visible) {
			return;
		}
		p.background(0);
		interiorW = w - indentation * 2;
		interiorH = h - indentation * 2;
		progress *= 100 / (maxSteps);
		p.fill(0, 0);
		p.stroke(borderColor);
		p.strokeWeight(borderSize);
		p.rect(x, y, w, h);
		p.noStroke();
		p.fill(interiorColor);
		p.rect(x + indentation, y + indentation, w - indentation * 2, h - indentation * 2);
		p.textAlign(PConstants.CENTER, PConstants.CENTER);
		p.fill(textColor);
		p.text(text + (appendProgressToText ? +progress + "%" : ""), w / 2 + x, h / 2 + y);
		p.rect(x + indentation, y + indentation, PApplet.lerp(0, interiorW, (float) (progress) / 100), interiorH);
		p.textAlign(PConstants.LEFT, PConstants.BOTTOM);
	}
}
