package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivebase extends SubsystemBase {

    MotorEx frontLeft, frontRight, backLeft, backRight;

    MecanumDrive mecanum;

    //drivebase
    //right motors: [front 3] [back 2]
    //left motors: [front 1] [back 0]
    public  Drivebase (HardwareMap ahwMap){
        frontLeft = new MotorEx(ahwMap, "motor1");
        frontRight = new MotorEx(ahwMap, "motor3");
        backLeft = new MotorEx(ahwMap, "motor0");
        backRight = new MotorEx(ahwMap, "motor2"); //define motors

        frontLeft.setInverted(true);
        frontRight.setInverted(true);
        backLeft.setInverted(true);
        backRight.setInverted(true); //motor directions

        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE); //motor configs

        mecanum = new MecanumDrive(frontLeft, frontRight, backLeft, backRight); //using class to make command work or smt idk
    }

    public void driveRobotCentric(double forwardSpeed, double strafeSpeed, double turnSpeed){
        mecanum.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

    public void driveFieldCentric(double forwardSpeed, double strafeSpeed, double turnSpeed, double angle){
        mecanum.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, angle);
    }

    public void setMotorSpeed(double frontLeft, double frontRight, double backLeft, double backRight) {
        mecanum.driveWithMotorPowers(frontLeft, frontRight, backLeft, backRight);
    }
}
