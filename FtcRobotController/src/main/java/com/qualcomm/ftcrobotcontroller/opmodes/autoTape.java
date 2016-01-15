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

    public void runOpMode {

        int drive_dist = 1440;

        leftdrive = hardwareMap.dcMotor.get("leftdrive");
        rightdrive = hardwareMap.dcMotor.get("rightdrive");
        armextend = hardwareMap.dcMotor.get("armextend");
        armrotate = hardwareMap.dcMotor.get("armrotate");
        backleft = hardwareMap.dcMotor.get("backleft");
        backright = hardwareMap.dcMotor.get("backright");

        rightdrive.setDirection(DcMotor.Direction.REVERSE);
        backright.setDirection(DcMotor.Direction.REVERSE);
        armrotate.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

        //wait(5);

        leftdrive.setTargetPosition(drive_dist);
        rightdrive.setTargetPosition(drive_dist);
        backleft.setTargetPosition(drive_dist);
        backright.setTargetPosition(drive_dist);
        rightdrive.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        leftdrive.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        backleft.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        backright.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        leftdrive.setPower(0.5);
        rightdrive.setPower(0.5);
        backleft.setPower(0.5);
        backright.setPower(0.5);
        
    }

}