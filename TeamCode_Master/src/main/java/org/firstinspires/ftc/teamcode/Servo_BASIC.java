package org.firstinspires.ftc.teamcode;

/* This OpMode is designed to test a servo with a gamepad
 */

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Servo_BASIC", group="Linear Opmode")
@Disabled
public class Servo_BASIC extends LinearOpMode {

    public Servo claw    = null;
    double claw_min = 0.2;
    double claw_max = 0.8;

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        claw = hardwareMap.servo.get("test_servo");
        claw.setPosition(0.5);

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if (gamepad1.a){
                claw.setPosition(claw_max);
            }

            else if (gamepad1.b){
                claw.setPosition(claw_min);
            }
        }
    }
}
