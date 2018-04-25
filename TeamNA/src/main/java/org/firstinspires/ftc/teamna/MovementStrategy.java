package org.firstinspires.ftc.teamna;

public interface MovementStrategy {

    /**
     * moves the robot backward
     * @param amount the inches to move the robot forward
     */
    void forward(float amount);

    /**
     * moves the robot forward
     * @param amount the inches to move the robot backward
     */
    void backward(float amount);

    /**
     * turns the robot left
     * @param amount the amount of degrees to turn the robot left
     */
    void pivotLeft(float amount);

    /**
     * turns the robot right
     * @param amount the amount of degrees to turn the robot right
     */
    void pivotRight(float amount);

    /**
     * Sets to power the robot uses to move
     * @param power the value of power with which to move the robot
     */
    void setPower(float power);
}
