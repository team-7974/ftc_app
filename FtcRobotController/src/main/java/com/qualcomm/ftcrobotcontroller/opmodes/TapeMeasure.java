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

    int nathan;

    @Override
     public void init() {
        leftdrive = hardwareMap.dcMotor.get("leftdrive");
        rightdrive = hardwareMap.dcMotor.get("rightdrive");
        armextend = hardwareMap.dcMotor.get("armextend");
        armrotate = hardwareMap.dcMotor.get("armrotate");

        rightdrive.setDirection(DcMotor.Direction.REVERSE);

        armrotate.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        armrotate.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        nathan = 0;
    }
    @Override
    public void loop() {
        float lefty = gamepad1.left_stick_y;
        float righty = gamepad1.right_stick_y;
        //float ltrigger = gamepad1.left_trigger;aqwertyu8i9oplkmnbvczASDRFTGHYUJKLT
        //float rtrigger = gamepad1.right_trigger;

        leftdrive.setPower(lefty);
        rightdrive.setPower(righty);

        if(gamepad1.left_bumper && !gamepad1.right_bumper) {
            armextend.setPower(1);
        } else if(gamepad1.right_bumper && !gamepad1.left_bumper) {
            armextend.setPower(-1);
        } else {
            armextend.setPower(0);
        }

        if(gamepad1.dpad_left)

        if(gamepad1.dpad_up && !gamepad1.dpad_down && nathan < 4) {
            nathan = 1;
            armrotate.setTargetPosition(140*nathan);
            armrotate.setPower(.5);
        } else if(gamepad1.dpad_down && !gamepad1.dpad_up && nathan > 0) {
            nathan -=1;
            armrotate.setTargetPosition(140*nathan);
            armrotate.setPower(.5);
        }
    }

}


