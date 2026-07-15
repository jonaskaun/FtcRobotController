package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {
    DcMotor intakeMotor;
    public IntakeSubsystem(HardwareMap hardwareMap){
        intakeMotor = hardwareMap.get(DcMotor.class,NamingConfig.intakeName);
    }

    /**
     * sets intake motor speed to an input power
     * @param power // input power of the motor (from 0-1)
     */
    public void setPower(double power){
        intakeMotor.setPower(power);

    }

    /**
     * stops intake movement
     */

    public void stop(){
        intakeMotor.setPower(0);

    }

}
