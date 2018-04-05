package org.firstinspires.ftc.teamna;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class SideIndependentAuto extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    /**
     * Runs ingenious autonomous code that scores on average #{Game.MAX_AUTONOMOUS_POINTS} points
     * @precondion  Robot Works
     * @postcondion Win Competition
     */

    protected MovementStrategy
                          move         ;

    protected DcMotor     left, right  ,
                          arm , endgame;
    protected Servo       auto, claw   ;
    protected ColorSensor cs           ;

    @Override
    public void runOpMode() {
        left    = hardwareMap.get(DcMotor    .class, "fl"  );
        right   = hardwareMap.get(DcMotor    .class, "fr"  );
        arm     = hardwareMap.get(DcMotor    .class, "arm" );
        endgame = hardwareMap.get(DcMotor    .class, "end" );
        auto    = hardwareMap.get(Servo      .class, "auto");
        claw    = hardwareMap.get(Servo      .class, "claw");
        cs      = hardwareMap.get(ColorSensor.class, "cs"  );

        left    .setDirection(DcMotor.Direction.FORWARD);
        right   .setDirection(DcMotor.Direction.REVERSE);

        move = new NormalDriveWithEncoders(telemetry, left, right, 0.3f);

        waitForStart();

        move.forward(60);
        dropNoodle(cs.red(), cs.blue());
        move.backward(30);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setTargetPosition(135 / 360 * 1120);
        arm.setPower(0.5f);
        knockOffNoodles();
    }

    protected abstract void dropNoodle(int red, int blue);
    protected abstract void knockOffNoodles();
}
