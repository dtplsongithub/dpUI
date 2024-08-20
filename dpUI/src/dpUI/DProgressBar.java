package dpUI;

import dpUI.util.ShowMessage;
import processing.core.*;

public class DProgressBar {
	public PApplet p;
	public int x, y, w, h, borderColor = 0xFF00FF00, progressColor = 0xFF00FF00, interiorColor = 0xFF003300;
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
		    if (!visible) return;
		    p.background(0);
		    this.interiorW = this.w-this.indentation*2;
		    this.interiorH = this.h-this.indentation*2;
		    byte oldProgress = this.progress;
		    this.progress *= 100/(int)(maxSteps);
		    p.fill(0, 0);
		    p.stroke(this.borderColor);
		    p.strokeWeight(this.borderSize);
		    p.rect(this.x, this.y, this.w, this.h);
		    p.noStroke();
		    p.fill(this.interiorColor);
		    p.rect(this.x+this.indentation, this.y+this.indentation, this.w-this.indentation*2, this.h-this.indentation*2);
		    p.textAlign(PApplet.CENTER, PApplet.CENTER);
		    p.fill(this.progressColor);
		    p.text(this.text + (this.appendProgressToText ? + this.progress + "%" : ""), this.w/2+this.x, this.h/2+this.y);
		    p.loadPixels();
		    try { 
		      for (int y = 0; y < this.interiorH; y++) {
		        for (int x = 0; x < (int)(PApplet.lerp(0, this.interiorW, (float)(this.progress)/100)); x++) {
		          int i = x+this.x+this.indentation+(y+this.y+this.indentation)*p.width;
		          if (p.pixels[i] == this.progressColor) p.pixels[i] = this.interiorColor;
		          else if (p.pixels[i] == this.interiorColor) p.pixels[i] = this.progressColor;
		        }
		      }
		    } catch (ArrayIndexOutOfBoundsException e) {
		      ShowMessage.showError(e+" on rendering progressBar", false);
		    }
		    p.updatePixels();
		    p.textAlign(PApplet.LEFT, PApplet.BOTTOM);
		    this.progress = (byte)(oldProgress+1);
		  }
}
