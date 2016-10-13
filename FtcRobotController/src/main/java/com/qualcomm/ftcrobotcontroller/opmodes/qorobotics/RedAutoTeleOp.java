package com.qualcomm.ftcrobotcontroller.opmodes.qorobotics;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class RedAutoTeleOp extends OpMode {

    //motors that allow robot to move
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;

    //motors that extend and retract the arm
    DcMotor armMotor ;

    //motors that pivots the arm
    DcMotor pivotMotor;

    //seconds to wait
    private double waitSeconds;
    private int step;

    @Override
    public void init() {

        frontLeftMotor = hardwareMap.dcMotor.get("motor1");
        frontRightMotor = hardwareMap.dcMotor.get("motor2");
        backLeftMotor = hardwareMap.dcMotor.get("motor3");
        backRightMotor = hardwareMap.dcMotor.get("motor4");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        armMotor = hardwareMap.dcMotor.get("a-motor");

        pivotMotor = hardwareMap.dcMotor.get("p-motor");

        //default values
        waitSeconds = 0;
        step = 0;

//        telemetry.addData("Text", "7519(Red)Autonomous");
//        telemetry.addData("Waiting", waitSeconds + " seconds");
//        telemetry.addData("Next step", step);
    }

    @Override
    public void loop() {

        //run if seconds to wait is positive and when time passed is greater than or equal to seconds to wait
        if (waitSeconds >= 0 && getRuntime() >= waitSeconds) {

            if (step == 0) {

                frontLeftMotor.setPower(.25);
                frontRightMotor.setPower(.25);
                backLeftMotor.setPower(.25);
                backRightMotor.setPower(.25);

                armMotor.setPower(.10);

                waitSeconds = 2;
                step++;

            } else if (step == 1) {

                frontRightMotor.setPower(-.25);
                backRightMotor.setPower(-.25);

                armMotor.setPower(0);

                //pivotMotor.setPower(.25);

                waitSeconds = .75;
                step++;
            }
            else if (step == 2) {

                //pivotMotor.setPower(0);

                waitSeconds = 10;
                step++;
            }
            else {

                frontLeftMotor.setPower(0);
                frontRightMotor.setPower(0);
                backLeftMotor.setPower(0);
                backRightMotor.setPower(0);
                armMotor.setPower(0);
                pivotMotor.setPower(0);

                waitSeconds = -1;
            }

            resetStartTime();//sets time to "0"

            /*
            if (step == 0) {//step "1" (turn right 3 seconds at full speed)

                frontLeftMotor.setPower(1);
                backLeftMotor.setPower(1);

                frontRightMotor.setPower(-1);
                backRightMotor.setPower(-1);

                waitSeconds = 3;
                step++;
            }
            else if (step == 1) {//step "2" (move foward 5 seconds at full speed)

                frontLeftMotor.setPower(1);
                frontRightMotor.setPower(1);
                backLeftMotor.setPower(1);
                backRightMotor.setPower(1);

                waitSeconds = 5;
                step++;
            }
            else if (step == 2) {//step 3 stop

                frontLeftMotor.setPower(0);
                frontRightMotor.setPower(0);
                backLeftMotor.setPower(0);
                backRightMotor.setPower(0);

                waitSeconds = -1;
            }*/

//            telemetry.addData("Text", "7519(Red)Autonomous");
//            telemetry.addData("Waiting", waitSeconds + " seconds");
//            telemetry.addData("Next step", (waitSeconds >= 0) ? Float.toString(step) : "?");
        }
    }
}
