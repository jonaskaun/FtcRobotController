package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "jonasFun")
public class tankDrive extends OpMode {
DcMotor intakeName;
DcMotor fr;
DcMotor br;
DcMotor fl;
DcMotor bl;

Servo hood;
double servoPosition = 0.0;
double timer = 0.0;

    @Override
    public void init() {
        intakeName = hardwareMap.get(DcMotor.class,"intake");
        fr = hardwareMap.get(DcMotor.class,"frontRight");
        br = hardwareMap.get(DcMotor.class,"backRight");
        fl = hardwareMap.get(DcMotor.class,"frontLeft");
        bl = hardwareMap.get(DcMotor.class,"backLeft");
        hood = hardwareMap.get(Servo.class,"leftHood");
        //reversing the left side to compensate for different direction
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        telemetry.speak("hello, i am robot.  I will now attack SABER.    Come here lil bro");


    }

    @Override
    public void loop() {
        if((gamepad1.left_bumper)){
            telemetry.addData("left bumper is pressed","67");
        }

        if(gamepad1.right_bumper){
            telemetry.addData("pressing right bumper","76");
        }
        if(gamepad1.x){
            telemetry.speak("I am the sigma");
        }
        telemetry.addData("left", gamepad1.left_stick_y);
        telemetry.addData("right", gamepad1.right_stick_y);
        telemetry.addData("servo number",servoPosition);

        double foreward = -gamepad1.right_stick_y;
        double rotation = gamepad1.left_stick_x;
        double strafe = gamepad1.right_stick_x;
        foreward *= 0.4;
        rotation *= 0.4;
        strafe *= 0.4;


        fr.setPower(foreward-strafe-rotation);
        br.setPower(foreward+strafe-rotation);
        fl.setPower(foreward+strafe+rotation);
        bl.setPower(foreward-strafe-rotation);

        if((gamepad1.left_stick_y !=0 ||gamepad1.left_stick_x!=0||gamepad1.right_stick_x!=0||gamepad1.right_stick_y!=0)){
            telemetry.speak("six seven");
        }
        hood.setPosition(servoPosition);
        if(servoPosition>=0 && servoPosition<1) {
            if(gamepad1.dpadUpWasReleased()){
                servoPosition += 0.01;

            }
            if(gamepad1.dpadDownWasReleased()){
                servoPosition-= 0.01;
            }

            telemetry.speak("mewing activate");
        }
        //if(gamepad1.dpadDownWasReleased()){
        //    servoPosition -= 0.1;
        //}

        timer+=0.1;

        if(timer== 400){
            telemetry.speak("kill");
            timer = 0;
        }






       telemetry.update();

    }
}
