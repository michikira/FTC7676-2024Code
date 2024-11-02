package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LowerArm extends SubsystemBase {

    public DcMotor jorkinator5000 = null;

    public LowerArm(HardwareMap ahwMap){

        //REV UltraPlanetary Hex Motor, the lowest and biggest one on the arm
        jorkinator5000 = ahwMap.get(DcMotor.class, "jorkinator5000");




    }

    public void setPower (double power){
        jorkinator5000.setPower(power);
    }
}
