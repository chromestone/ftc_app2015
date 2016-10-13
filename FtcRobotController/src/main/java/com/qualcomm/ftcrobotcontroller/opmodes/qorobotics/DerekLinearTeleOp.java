package com.qualcomm.ftcrobotcontroller.opmodes.qorobotics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by derekzhang on 11/24/15.
 */
public class DerekLinearTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor motor = hardwareMap.dcMotor.get("motor");
        float throttle, direction;

        waitForStart();

        while (opModeIsActive()) {

            // throttle:  left_stick_y ranges from -1 to 1, where -1 is full up,  and 1 is full down
            // direction: left_stick_x ranges from -1 to 1, where -1 is full left and 1 is full right
            //assuming right stick is the same
            throttle = - (gamepad1.right_stick_y);
            direction = gamepad1.right_stick_x;

            motor.setDirection(DcMotor.Direction.FORWARD);

            //turn the robot
            if (Math.abs(direction) > .5) {

                motor.setDirection(DcMotor.Direction.REVERSE);
            }

            motor.setPower(throttle);

            waitOneFullHardwareCycle();
        }
    }
}
