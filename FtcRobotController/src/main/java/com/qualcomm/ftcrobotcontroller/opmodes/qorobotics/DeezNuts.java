package com.qualcomm.ftcrobotcontroller.opmodes.qorobotics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by derekzhang on 4/11/16.
 */
public class DeezNuts extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        //motors that allow robot to move
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("motor1");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("motor3");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            float leftThrottle = -gamepad1.left_stick_y;
            frontLeftMotor.setPower(leftThrottle);
            leftThrottle = -gamepad1.right_stick_y;
            backLeftMotor.setPower(leftThrottle);


            telemetry.addData("Text", "7519(Red)Teleop");
            telemetry.addData("left throttle", leftThrottle);

            waitOneFullHardwareCycle();
        }
    }
}