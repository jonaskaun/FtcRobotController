package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.subsystems.FlywheelSubsystem;
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
    // 500, 1000, 1500
    public enum flywheelActions{
        OFF,
        LOW,
        MED,
        HIGH
    }
    public intakeActions spindexerState = intakeActions.START;
    public flywheelActions flywheelState = flywheelActions.OFF;
    public IntakeSubsystem intakeSub;
    public FlywheelSubsystem flywheelSub;

    double stateChangeTime = 5.0;


    @Override
    public void init(){
        timer = new ElapsedTime();
        //sensyBoi = hardwareMap.get(RevColorSensorV3.class,"RevColorSensorV3");
        intakeSub = new IntakeSubsystem(hardwareMap);
        flywheelSub = new FlywheelSubsystem(hardwareMap);


    }
    @Override
    public void loop(){
      telemetry.update();
       /* switch(spindexerState){
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
                telemetry.addData("toong toong toong sahoor", "");

                telemetry.update();

                break;
            case COLOR :
                if(sensyBoi.getDistance(DistanceUnit.MM)<5){

                }
                break;

        }*/
        switch (flywheelState){
            case OFF:
                flywheelState = flywheelActions.LOW;
                flywheelSub.setRPM(500);
                break;
            case LOW:
                if (timer.seconds()>=stateChangeTime){
                    flywheelState = flywheelActions.MED;
                    flywheelSub.setRPM(1000);
                    timer.reset();
                    telemetry.speak("low and slow");
                }

                break;
            case MED:
                if(timer.seconds()>=stateChangeTime){
                    flywheelState = flywheelActions.HIGH;
                    flywheelSub.setRPM(1500);
                    timer.reset();
                    telemetry.speak("medium........ toong toong toong sahoor");
                }


                break;
            case HIGH:
                if(timer.seconds()>=stateChangeTime){
                    flywheelState = flywheelActions.OFF;
                    flywheelSub.stop();
                    telemetry.speak("fast and furious");
                }

                break;

        }





    }
}
