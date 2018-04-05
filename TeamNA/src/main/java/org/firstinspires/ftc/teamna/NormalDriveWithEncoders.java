package org.firstinspires.ftc.teamna;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class NormalDriveWithEncoders implements MovementStrategy {

    final private int   encoder    = 1120 ;
    final private float turnRadius = 16.9f;

    private DcMotor   left     ,
                      right    ;
    private Telemetry telemetry;
    float power;

    /**
     * Constructor
     * @param telemetry Telemetry object to debug with
     * @param left      Left  DcMotor
     * @param right     Right DcMotor
     * @param power     Power value with which to move (0, 1]
     */
    public NormalDriveWithEncoders(Telemetry telemetry, DcMotor left, DcMotor right, float power) {
        this.left      = left     ;
        this.right     = right    ;
        this.telemetry = telemetry;
        this.power     = power    ;
        this.left      . setMode  (DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.right     . setMode  (DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    /**
     *
     * @param in
     */
    public void forward(float in) {

        int pos = (int)((encoder * in)/(4 * Math.PI));

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setTargetPosition(pos);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setTargetPosition(pos);
        right.setPower(power);
        left.setPower(power);
        while(left.isBusy() &&right.isBusy())
        {
            telemetry.addData("Motor Encoder", "Left Pos: " + left.getCurrentPosition());
            telemetry.addLine();
            telemetry.addData("Motor Encoder", "Right Pos: " + right.getCurrentPosition());
            telemetry.addLine();
            telemetry.addData("Power","Left Pow: " + left.getPower());
            telemetry.addLine();
            telemetry.addData("Power","Right Pow: " + right.getPower());
            telemetry.addLine();
            telemetry.addData("Target","Left Tar: " + left.getTargetPosition());
            telemetry.update();
        }
        left.setPower(0);
        right.setPower(0);
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void backward(float in)
    {
        forward(-in);
    }
    public void pivotLeft(float degrees)

    {
        double arc = Math.PI * turnRadius * degrees / 360f;
        int pos = (int)((encoder * arc)/(4 * Math.PI));

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setTargetPosition(pos);
        right.setTargetPosition(-pos);
        left.setPower(power);
        right.setPower(power);
        while(left.isBusy() && right.isBusy())
        {
            telemetry.addData("Motor Encoder", "Left Pos: " + left.getCurrentPosition());
            telemetry.addLine();
            telemetry.addData("Motor Encoder", "Right Pos: " + right.getCurrentPosition());
            telemetry.addLine();
            telemetry.addData("Power","Left Pow: " + left.getPower());
            telemetry.addLine();
            telemetry.addData("Power","Right Pow: " + right.getPower());
            telemetry.addLine();
            telemetry.addData("Target","Left Tar: " + left.getTargetPosition());
            telemetry.update();
            //telemetry.addData("Target","Right Tar: " + right.getTargetPosition());
            //telemetry.update();
        }
        left.setPower(0);
        right.setPower(0);
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void pivotRight(float degrees)
    {
       pivotLeft(-degrees);
    }
    public void setPower(float a) {power = a;}
}
