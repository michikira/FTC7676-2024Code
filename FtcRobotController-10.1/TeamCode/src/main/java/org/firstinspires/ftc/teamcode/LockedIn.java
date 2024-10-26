package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

@TeleOp(name = "Locked IN (pushbot (not anymore) teleop)")

public class LockedIn extends OpMode {

    private LockedInHardware robot = new LockedInHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot.init(hardwareMap);
    }

    @Override
    public void loop(){

        robot.simpleDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);

        telemetry.addData("LockedInStatus", "Run Time: " + runtime.toString());

        //move arm up
        if (gamepad2.a) {
            robot.liftArm(0.5);
        }else if (!gamepad1.a){
            robot.thrustMaster.setPower(0);
        }

        //move the arm down
        if (gamepad2.b){
            robot.lowerArm(-0.5);
        }else if (!gamepad1.b){
        robot.thrustMaster.setPower(0);
    }

        //move second level up
        if (gamepad2.right_trigger){
            robot.secondLevelArm(0.5);
        }else //move second level down
            if (!gamepad1.right_trigger) {
                robot.secondLevelArm(0.5);
            }


    @Override
    public void stop() {
    }




}
