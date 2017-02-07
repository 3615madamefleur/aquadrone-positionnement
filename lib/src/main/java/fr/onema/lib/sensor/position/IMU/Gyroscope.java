package fr.onema.lib.sensor.position.IMU;

/**
 * Created by strock on 06/02/2017.
 */
public class Gyroscope {

    private final int xRotation;
    private final int yRotation;
    private final int zRotation;

    /**
     *
     * @param xRotation coordonnée rotation x
     * @param yRotation coordonnée rotation y
     * @param zRotation coordonnée rotation z
     */
    public Gyroscope(int xRotation, int yRotation, int zRotation) {
        this.xRotation = xRotation;
        this.yRotation = yRotation;
        this.zRotation = zRotation;
    }

    public int getxRotation() {
        return xRotation;
    }

    public int getyRotation() {
        return yRotation;
    }

    public int getzRotation() {
        return zRotation;
    }
}