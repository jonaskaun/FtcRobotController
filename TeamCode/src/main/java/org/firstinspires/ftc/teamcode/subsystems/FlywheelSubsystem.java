package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlywheelSubsystem {
    DcMotorEx flywheel;
    public FlywheelSubsystem(HardwareMap hardwareMap){
        flywheel = hardwareMap.get(DcMotorEx.class,"leftFlywheel");
    }

    /**
     * converts rpm to tps, and sets velocity for flywheel
     * @param rpm input in rpm,
     */
    public void setRpm(double rpm){
        flywheel.setVelocity((rpm/60)*28);
    }

    /**
     * returns the current RPM of the flywheel
     * @return
     */
    public double getSpeedRPM(){
        return ((flywheel.getVelocity())/28)*60;
    }

    /**
     * converts a value in Ticks pers second, to rotations per minute
     * @param TPS a varible in Ticks per second
     * @return  the conversion in RPM
     */
    public double convertToRPM(double TPS){
        return TPS/60*28;
    }

    /**
     * converts a value in RPM to TPS
     * @param RPM a value in RPM
     * @return  the conversion in TPS
     */
    public double convertToTPS(double RPM){
        return RPM*60/28;
    }



}
