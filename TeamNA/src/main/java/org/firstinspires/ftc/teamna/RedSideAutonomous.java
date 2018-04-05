package org.firstinspires.ftc.teamna;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Auto_Red", group="Linear Opmode")
public class RedSideAutonomous extends SideIndependentAuto {
    protected void dropNoodle(int red, int blue) {
        boolean detectsRed = red >= blue;
        if (!detectsRed) {
            move.backward(6);
            move.pivotLeft(90);
            move.forward(10);
            move.pivotRight(90);
            move.forward(6);
        }
        auto.setPosition(1f);
        sleep(1000);
        auto.setPosition(1f);
    }

    protected void knockOffNoodles() {
        move.pivotRight(90f);
    }

}
