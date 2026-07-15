package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class wheel {
    DcMotor wheel;

    public wheel(HardwareMap hardwareMap) {
        wheel = hardwareMap.get(DcMotor.class, NamingConfig.flywheel);
    }

    public void setTargetPostion(int ticks) {
        wheel.setTargetPosition(ticks);
        wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public int getTargetPosition() {
        return wheel.getCurrentPosition();

    }

    public void setPower(double power) {
        wheel.setPower(power);
    }

    // get curr pos, and dc motor, get curr pos, set target pso, set mode( run to postion)
}
