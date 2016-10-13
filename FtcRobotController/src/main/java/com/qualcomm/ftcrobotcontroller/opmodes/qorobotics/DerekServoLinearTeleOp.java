package com.qualcomm.ftcrobotcontroller.opmodes.qorobotics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by derekzhang on 12/16/15.
 */
public class DerekServoLinearTeleOp extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        Servo servo = hardwareMap.servo.get("servo");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.dpad_up) {

                servo.setPosition(1);
            }
            else if (gamepad1.dpad_down) {

                servo.setPosition(0);
            }
            else {

                servo.setPosition(.5);
            }

            waitOneFullHardwareCycle();
        }
    }
}
