package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by derekzhang on 10/15/15.
 */
public class MotorTester extends OpMode {

    /* Accessible variables from super class:

    public Gamepad gamepad1 = new Gamepad();
    public Gamepad gamepad2 = new Gamepad();
    public Telemetry telemetry = new Telemetry();
    public HardwareMap hardwareMap = new HardwareMap();     */

    //default constructor
    public MotorTester() {

    }

    //figure out what to do

    @Override
    public void init() {
        
    }

    @Override
    public void init_loop() {

        super.init_loop();

        //do stuff here

        //example
        hardwareMap.dcMotor.get("motor").setPower(.05);
    }

    @Override
    public void start() {

        super.start();

        //do stuff here
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

        super.stop();

        hardwareMap.dcMotor.get("motor").setPower(0);
    }
}
