package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Steve Cline on 10/21/2017.
 * This code may be utilized to start programming an OpMode for a robot which includes DC Motors and Servos.
 */

@TeleOp(name = "Insert_Your_OpMode_Name", group = "linear OpMode")              // Register your Opmode. On the RC the Opmode will show up as the name string.
@Disabled

public class StartUp_Code extends LinearOpMode {

    // Declare OpMode members.
    private DcMotor LF, RF, LR, RR;
    private double speed, position;

    @Override
    public void runOpMode () {

        //Declare all variables here.

        waitForStart();                                                         // Wait for the game to start (driver presses PLAY).

        while (opModeIsActive()) {                                              // Run until the end of the match (driver presses STOP).

        }

        // This is where your instructions go.  This loop runs continuously until STOP is pressed by the driver.
    }
}
