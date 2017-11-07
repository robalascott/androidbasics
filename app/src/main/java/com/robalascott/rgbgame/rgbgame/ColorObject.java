package com.robalascott.rgbgame.rgbgame;

import android.graphics.Color;

/**
 * Created by robscott on 2017-11-06.
 */

public class ColorObject {
    private int red,green,blue;
    private float alpha;
    public ColorObject(int red, int green ,int blue){
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.alpha = 1;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public boolean compare(ColorObject color){
        if(this.red == color.getRed() && this.green == color.getGreen() && this.blue == color.getBlue()){
            //here can you reset alpha
            return true;
        }else{
            return false;
        }
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public int getRGB(){
        int tempAlpha =(int)(this.alpha * 255.0f);
        return Color.argb(tempAlpha,this.red,this.green,this.blue);
    }
}
