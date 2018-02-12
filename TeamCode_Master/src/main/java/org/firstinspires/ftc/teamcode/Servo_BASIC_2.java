package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Servo_BASIC_2", group="Linear Opmode")
@Disabled
public class Servo_BASIC_2 extends LinearOpMode {

    public Servo claw1  = null;
    public CRServo claw2  = null;
    double claw_min = 0.2;
    double claw_max = 0.8;

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        claw1 = hardwareMap.servo.get("claw1");
        claw1.setPosition(0.5);

        claw2 = hardwareMap.crservo.get("claw2");

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if (gamepad1.a){
                claw1.setPosition(claw_max);
                claw2.setDirection(CRServo.Direction.FORWARD);
                claw2.setPower(1.0);
                try {
                    claw2.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                claw2.setPower(0);
            }

            else if (gamepad1.b){
                claw1.setPosition(claw_min);
                claw2.setDirection(CRServo.Direction.REVERSE);
                claw2.setPower(1.0);
                try {
                    claw2.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                claw2.setPower(0);
            }
        }
    }
}
