package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by eddie on 1/15/16.
 */



public class autoTape extends LinearOpMode {
    DcMotor leftdrive;
    DcMotor rightdrive;
    DcMotor armextend;
    DcMotor armrotate;
    DcMotor backleft;
    DcMotor backright;

    public double magic = 114.591559026;

    public void marshall(int drive_left, int drive_right, double mpow){
        leftdrive.setTargetPosition((int)(drive_left*magic));
        rightdrive.setTargetPosition((int)(drive_right*magic));
        backleft.setTargetPosition((int)(drive_left*magic));
        backright.setTargetPosition((int)(drive_right*magic));
        rightdrive.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        leftdrive.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        leftdrive.setPower(mpow);
        rightdrive.setPower(mpow);
        backleft.setPower(mpow);
        backright.setPower(mpow);

    }


    public void runOpMode() {

        leftdrive = hardwareMap.dcMotor.get("leftdrive");
        rightdrive = hardwareMap.dcMotor.get("rightdrive");
        armextend = hardwareMap.dcMotor.get("armextend");
        armrotate = hardwareMap.dcMotor.get("armrotate");
        backleft = hardwareMap.dcMotor.get("backleft");
        backright = hardwareMap.dcMotor.get("backright");

        rightdrive.setDirection(DcMotor.Direction.REVERSE);
        backright.setDirection(DcMotor.Direction.REVERSE);
        armrotate.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        waitForStart();

        marshall(42, 42, 0.5);

    }

}