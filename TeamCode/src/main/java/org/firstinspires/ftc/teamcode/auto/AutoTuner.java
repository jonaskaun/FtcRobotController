package org.firstinspires.ftc.teamcode.auto;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.util.OdoPods;
@Configurable
@TeleOp(name = "fun")
public class AutoTuner extends OpMode {
    OdoPods pods;
    MecanumDrivetrain drive;
    public static double nextX = 0;
    public static double nextY = 0;
    public static double nextHeading = 0;
    public static double nextSpeed = 0;
    @Override
    public void init() {
        drive = new MecanumDrivetrain(1.0, hardwareMap);
        pods = new OdoPods(hardwareMap, drive);
        pods.setPosition(0,0,0);
    }

    @Override
    public void loop() {
        pods.holdPosition(nextX,nextY,nextHeading,nextSpeed);
        pods.update();
        telemetry.addData("x", pods.getX());
        telemetry.addData("y", pods.getY());
        telemetry.addData("heading",pods.getHeading());
        telemetry.update();


    }
}
