package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by eddie on 12/18/15.
 */
public class TapeMeasure extends OpMode {
    DcMotor leftdrive;
    DcMotor rightdrive;
    DcMotor armextend;
    DcMotor armrotate;

    @Override
     public void init() {
        leftdrive = hardwareMap.dcMotor.get("leftdrive");
        rightdrive = hardwareMap.dcMotor.get("rightdrive");
        armextend = hardwareMap.dcMotor.get("armextend");
        armrotate = hardwareMap.dcMotor.get("armrotate");

        rightdrive.setDirection(DcMotor.Direction.REVERSE);
        armrotate.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }
    @Override
    public void loop() {
        float lefty = gamepad1.left_stick_y;
        float righty = gamepad1.right_stick_y;

        leftdrive.setPower(lefty);
        rightdrive.setPower(righty);


        if(gamepad2.left_bumper && !gamepad2.right_bumper) {
            armextend.setPower(1);
        } else if(gamepad2.right_bumper && !gamepad2.left_bumper) {
            armextend.setPower(-1);
        } else {
            armextend.setPower(0);
        }

        if(gamepad2.a && !gamepad2.b) {
            armrotate.setTargetPosition(150);
            armrotate.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
            armrotate.setPower(0.05);
        } else if(gamepad2.b && !gamepad2.a) {
            armrotate.setTargetPosition(10);
            armrotate.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
            armrotate.setPower(0.05);
        } else if(gamepad2.x) {
            armrotate.setTargetPosition(117);
            armrotate.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
            armrotate.setPower(0.05);
        }

        if(gamepad1.x) {
            leftdrive.setPowerFloat();
            rightdrive.setPowerFloat();
        }
        if(gamepad1.y) {
            leftdrive.setPower(-0.5);
            rightdrive.setPower(-0.5);
        }
    }

}


