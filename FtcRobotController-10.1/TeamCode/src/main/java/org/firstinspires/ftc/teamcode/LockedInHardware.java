package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

// this class names the motors.
public class LockedInHardware {

    //drivebase
    public DcMotor backLeft = null;
    public DcMotor frontLeft = null;
    public DcMotor backRight = null;
    public DcMotor frontRight = null;
    public DcMotor thrustMaster = null;
    public DcMotor jorkinator5000 = null;
    public DcMotor peanitzOverdrive= null;



    public void init(HardwareMap ahwMap) {

        //drivebase
        //right motors: [front 3] [back 2]
        //left motors: [front 1] [back 0]

        backLeft = ahwMap.get(DcMotor.class, "motor0");
        frontLeft = ahwMap.get(DcMotor.class, "motor1");
        backRight = ahwMap.get(DcMotor.class, "motor2");
        frontRight = ahwMap.get(DcMotor.class, "motor3");

        //set direction of the drivebase motors
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);


        //handle encoders of drivebase motors
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);




        //REV UltraPlanetary Hex Motor, the lowest and biggest one on the arm
        thrustMaster = ahwMap.get(DcMotor.class, "thrustMaster");
        //REV Core Hex Motor, second motor on arm
        jorkinator5000 = ahwMap.get(DcMotor.class, "jorkinator5000");
        //REV Core Hex Motor #2, claw motor
        peanitzOverdrive = ahwMap.get(DcMotor.class, "peanitzOverdrive");

    }


    //chatgpt!!
    public void simpleDrive(double joystick1X, double joystick1Y, double joystick2X) {
        double y = joystick1Y;
        double x = -joystick1X * 1.1; // Adjust this factor as needed
        double rx = -joystick2X;

        // Calculate power for each wheel
        double frontLeftPower = y + x + rx;
        double backLeftPower = y - x + rx;
        double frontRightPower = y - x - rx;
        double backRightPower = y + x - rx;

        // Normalize the wheel powers if necessary
        double maxPower = Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(backLeftPower),
                Math.max(Math.abs(frontRightPower), Math.abs(backRightPower))));

        if (maxPower > 1) {
            frontLeftPower /= maxPower;
            backLeftPower /= maxPower;
            frontRightPower /= maxPower;
            backRightPower /= maxPower;
        }

        // Set power to motors
        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
    }



    public void liftArm (double power){
        thrustMaster.setPower(power);
    }

    public void lowerArm (double power){
        thrustMaster.setPower(power);
    }

    public void secondLevelArm (double power) {
        //at the stripped club, straight up jorkin it, and by it, i mean, my peanits
        jorkinator5000.setPower(power);
    }

}

