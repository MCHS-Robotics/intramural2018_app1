package org.firstinspires.ftc.teamna;

public interface MovementStrategy {

    /**
     * moves the robot forward
     * @param amount the inches to move the robot forward
     */
    public void forward   (float amount);

    /**
     * moves the robot backward
     * @param amount the inches to move the robot backward
     */
    public void backward  (float amount);

    /**
     * turns the robot left
     * @param amount the amount of degrees to turn the robot left
     */
    public void pivotLeft (float amount);

    /**
     * turns the robot right
     * @param amount the amount of degrees to turn the robot right
     */
    public void pivotRight(float amount);

    /**
     * Sets to power the robot uses to move
     * @param power the value of power with which to move the robot
     */
    public void setPower  (float power );
}
