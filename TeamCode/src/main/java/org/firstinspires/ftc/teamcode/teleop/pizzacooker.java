package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

@TeleOp (name = "goofy silly")


public class pizzacooker extends OpMode {

    ElapsedTime timer;
    RevColorSensorV3 sensyBoi;
    public enum intakeActions {
        START,
        SPINNING,
        STOP,
        DIALOGUE,
        COLOR



    }
    public intakeActions spindexerState = intakeActions.START;
    public IntakeSubsystem intakeSub;


    @Override
    public void init(){
        timer = new ElapsedTime();
        sensyBoi = hardwareMap.get(RevColorSensorV3.class,"RevColorSensorV3");
        intakeSub = new IntakeSubsystem(hardwareMap);


    }
    @Override
    public void loop(){

        switch(spindexerState){
            case START:
                intakeSub.setPower(0.5);
                spindexerState = intakeActions.SPINNING;
                break;

            case SPINNING:
                if(timer.seconds()>= 5){
                    spindexerState = intakeActions.STOP;
                }
                break;

            case STOP :
                intakeSub.setPower(0);
                spindexerState = intakeActions.DIALOGUE;
                break;

            case DIALOGUE:
                telemetry.speak("tung tung tung tung tung tung sahur");
                break;
            case COLOR :
                if(sensyBoi.getDistance(DistanceUnit.MM)<5){

                }
                break;





        }





    }
}
