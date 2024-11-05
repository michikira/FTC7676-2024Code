package org.firstinspires.ftc.teamcode.Opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Drivebase;

public class TeleOp extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        // run the scheduler
        while (!isStopRequested() && opModeIsActive()) {
            CommandScheduler.getInstance().run();
        }
        CommandScheduler.getInstance().reset();
    }

    @com.qualcomm.robotcore.eventloop.opmode.TeleOp
    public class TeleOP extends CommandOpMode {

        private GamepadEx driverOP;
        private GamepadEx buttonOP;
        private Drivebase drivebase;

        @Override
        public void initialize() {
            driverOP = new GamepadEx(gamepad1);
            buttonOP = new GamepadEx(gamepad2);

            drivebase = new Drivebase(hardwareMap);
            GamepadButton armUp = new GamepadButton(buttonOP, GamepadKeys.Button.X);
            GamepadButton armDown = new GamepadButton(buttonOP, GamepadKeys.Button.Y);
            GamepadButton gripUp = new GamepadButton(buttonOP, GamepadKeys.Button.B);
            GamepadButton gripDown = new GamepadButton(buttonOP, GamepadKeys.Button.A);


            drivebase.setDefaultCommand(new RunCommand(() -> drivebase.driveRobotCentric(driverOP.getLeftY(), driverOP.getLeftX(), driverOP.getRightX()), drivebase));


        }

    }


}
