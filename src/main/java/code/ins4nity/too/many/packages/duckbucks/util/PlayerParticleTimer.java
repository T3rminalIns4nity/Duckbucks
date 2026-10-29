package code.ins4nity.too.many.packages.duckbucks.util;

public class PlayerParticleTimer {
    private int ticksLeft = 0;

    public int getTicksLeft() {
        return this.ticksLeft;
    }

    public void setTicksLeft(int value) {
        this.ticksLeft = value;
    }

    public void decrement() {
        if (this.ticksLeft > 0) {
            this.ticksLeft--;
        }
    }
}
