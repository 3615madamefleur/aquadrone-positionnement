package fr.onema.lib.sensor.position.IMU;

/**
 * Created by strock on 06/02/2017.
 */
public class Compass {

    private final int xMagnetic;
    private final int yMagnetic;
    private final int zMagnetic;

    /**
     *
     * @param xMagnetic coordonnée magnétisme x
     * @param yMagnetic coordonnée magnétisme y
     * @param zMagnetic coordonnée magnétisme z
     */
    public Compass(int xMagnetic, int yMagnetic, int zMagnetic) {
        this.xMagnetic = xMagnetic;
        this.yMagnetic = yMagnetic;
        this.zMagnetic = zMagnetic;
    }

    public int getxMagnetic() {
        return xMagnetic;
    }

    public int getyMagnetic() {
        return yMagnetic;
    }

    public int getzMagnetic() {
        return zMagnetic;
    }
}