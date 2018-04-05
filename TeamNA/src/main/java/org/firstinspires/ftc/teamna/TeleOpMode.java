package org.firstinspires.ftc.teamna;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp", group="Linear Opmode")
public class TeleOpMode extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();


    /**
     * Runs ingenious teleop code that scores on average #{Game.MAX_TELEOP_POINTS} points
     * @precondion  Robot Works
     * @postcondion Win Competition
     */
    @Override
    public void runOpMode() {
        DcMotor left, right  ,
                arm , endgame;
        Servo   auto, claw   ;

        left    = hardwareMap.get(DcMotor.class, "fl"  );
        right   = hardwareMap.get(DcMotor.class, "fr"  );
        arm     = hardwareMap.get(DcMotor.class, "arm" );
        endgame = hardwareMap.get(DcMotor.class, "end" );
        auto    = hardwareMap.get(Servo  .class, "auto");
        claw    = hardwareMap.get(Servo  .class, "claw");

        left    .setDirection(DcMotor.Direction.FORWARD);
        right   .setDirection(DcMotor.Direction.REVERSE);

        waitForStart  ();
        runtime .reset();

        while (opModeIsActive()) {
            left   .setPower   (-gamepad1. left_stick_y);
            right  .setPower   (-gamepad1.right_stick_y);
            arm    .setPower   (-gamepad2.right_stick_y);
            endgame.setPower   (-gamepad2. left_stick_y);
            auto   .setPosition( gamepad2. a ? 1  :  0 );
            claw   .setPosition( gamepad2. b ? 1  :  0 );
        }
    }
}
