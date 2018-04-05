package org.firstinspires.ftc.teamna;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Auto_Blue", group="Linear Opmode")
public class BlueSideAutonomous extends SideIndependentAuto {
    protected void dropNoodle(int red, int blue) {
        boolean detectsRed = red >= blue;
        if (detectsRed) {
            move.backward(6);
            move.pivotRight(90);
            move.forward(10);
            move.pivotLeft(90);
            move.forward(6);
        }
        auto.setPosition(1f);
        sleep(1000);
        auto.setPosition(1f);
    }

    protected void knockOffNoodles() {
        move.pivotLeft(90f);
    }

}
