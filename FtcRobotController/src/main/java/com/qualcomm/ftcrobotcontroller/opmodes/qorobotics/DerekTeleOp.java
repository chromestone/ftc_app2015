package com.qualcomm.ftcrobotcontroller.opmodes.qorobotics;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by derekzhang on 10/15/15.
 */
public class DerekTeleOp extends OpMode {

    /* Accessible variables from super class:

    public Gamepad gamepad1 = new Gamepad();
    public Gamepad gamepad2 = new Gamepad();
    public Telemetry telemetry = new Telemetry();
    public HardwareMap hardwareMap = new HardwareMap();

    */

    private int phase;

    //default constructor
    public DerekTeleOp() {

        phase = 0;
    }

    //figure out what to do

    @Override
    public void init() {

    }

    @Override
    public void init_loop() {

        super.init_loop();
    }

    @Override
    public void start() {

        super.start();

        hardwareMap.servo.get("servo").setPosition(Servo.MIN_POSITION);
    }

    @Override
    public void loop() {

        if (getRuntime() > 3) {

            if (phase == 0) {

                hardwareMap.servo.get("servo").setPosition(Servo.MAX_POSITION);
                phase++;
            }
            else {

                hardwareMap.servo.get("servo").setPosition(Servo.MIN_POSITION);
                phase = 0;
            }

            resetStartTime();
        }
    }

    @Override
    public void stop() {

        super.stop();
    }
}
