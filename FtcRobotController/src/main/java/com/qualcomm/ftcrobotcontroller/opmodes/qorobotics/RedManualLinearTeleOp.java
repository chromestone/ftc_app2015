package com.qualcomm.ftcrobotcontroller.opmodes.qorobotics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by derekzhang on 10/28/15.
 */
public class RedManualLinearTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        //motors that allow robot to move
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("motor1");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("motor2");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("motor3");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("motor4");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        //motors that extend and retract the arm
        DcMotor armMotor = hardwareMap.dcMotor.get("a-motor");

        //motors that pivots the arm
        DcMotor pivotMotor = hardwareMap.dcMotor.get("p-motor");

        waitForStart();

        while (opModeIsActive()) {

            float leftThrottle = -gamepad1.left_stick_y;
            frontLeftMotor.setPower(leftThrottle);
            backLeftMotor.setPower(leftThrottle);

            float rightThrottle = -gamepad1.right_stick_y;
            frontRightMotor.setPower(rightThrottle);
            backRightMotor.setPower(rightThrottle);

            if (gamepad1.left_bumper && gamepad1.right_bumper) {

                backLeftMotor.setPower(.01f);
                backRightMotor.setPower(.01f);
            }



            float armThrottle = -gamepad2.left_stick_y;
            armThrottle = adjustForSafety(armThrottle, -.1f, gamepad2.left_trigger);
            armMotor.setPower(armThrottle);

            float pivotThrottle = -gamepad2.right_stick_y;
            pivotThrottle = adjustForSafety(pivotThrottle, -.1f, gamepad2.right_trigger);
            pivotMotor.setPower(pivotThrottle);



            telemetry.addData("Text", "7519(Red)Teleop");
            telemetry.addData("left throttle", leftThrottle);
            telemetry.addData("right throttle", rightThrottle);
            telemetry.addData("arm throttle", armThrottle);
            telemetry.addData("pivot throttle", pivotThrottle);

            waitOneFullHardwareCycle();
        }
    }

    private float adjustForSafety(float throttle, float safeThrottle, float safetyTrigger) {

        boolean safetyOff = safetyTrigger > 0;
        if (safetyOff) {

            throttle = -safetyTrigger;
        }
        else if (throttle < 0) {

            throttle = safeThrottle;
        }

        return throttle;
    }
}

/*
        //DcMotor rightPivotMotor = hardwareMap.dcMotor.get("right_pivot_motor");
        //rightPivotMotor.setDirection(DcMotor.Direction.REVERSE);
------
*/

/*
            // throttle:  left_stick_y ranges from -1 to 1, where -1 is full up,  and 1 is full down
            // direction: left_stick_x ranges from -1 to 1, where -1 is full left and 1 is full right

            float throttle = gamepad1.right_stick_y;
            float direction = gamepad1.left_stick_x;

            frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
            backRightMotor.setDirection(DcMotor.Direction.REVERSE);

            //turn the robot
            if (direction < -.1) {

                frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
                backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            }
            else if (direction > .1) {

                frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
                backRightMotor.setDirection(DcMotor.Direction.FORWARD);
            }

            frontLeftMotor.setPower(throttle);
            frontRightMotor.setPower(throttle);
            backLeftMotor.setPower(throttle);
            backRightMotor.setPower(throttle);

            float pivotThrottle = -gamepad2.right_stick_y;

            if (pivotThrottle >= 0) {

                pivotMotor.setPower(pivotThrottle);
                //rightPivotMotor.setPower(pivotThrottle);
            }
            else {

                if (gamepad2.left_bumper) {

                    pivotMotor.setPower(Math.min(pivotThrottle, -.75));
                    //rightPivotMotor.setPower(Math.min(pivotThrottle, -.75));
                }
                else {

                    pivotMotor.setPower(-.1);
                    //rightPivotMotor.setPower(-.1);
                }
            }

            armMotor.setPower(-gamepad2.left_stick_y);

 */