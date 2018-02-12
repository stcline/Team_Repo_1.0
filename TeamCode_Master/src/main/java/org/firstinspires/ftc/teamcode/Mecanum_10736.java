package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import static java.lang.Math.abs;

/**
 * Adapted from this FTC Forum post: https://ftcforum.usfirst.org/forum/ftc-technology/android-studio/6361-mecanum-wheels-drive-code-example
 * by Steve Cline on 16 October 2017.
 */

@TeleOp(name="Mercanum_10736", group="Linear Opmode")
//@Disabled
public class Mecanum_10736 extends LinearOpMode {

    private DcMotor leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor;

    @Override
    public void runOpMode() { //declaring variable

        double MAX_SPEED = 1.0;
        double scale = 1.0;
        double scaleInput = 1.0;

        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFront");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFront");
        leftRearMotor = hardwareMap.get(DcMotor.class, "leftRear");
        rightRearMotor = hardwareMap.get(DcMotor.class, "rightRear");

        waitForStart();

        while (opModeIsActive()) {

            double speed = -gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            double strafe = gamepad1.right_stick_x;

            telemetry.addData("speed : ", speed);

            //Left Front = +speed + turn - strafe      Right Front = +speed - turn + strafe
            //Left Rear = +speed + turn + strafe       Right Rear = +speed - turn - strafe

            /*double magnitude = abs(speed) + abs(turn) + abs(strafe);
            magnitude = (magnitude > 1) ? magnitude : 1; //Sets scaling to keep -1, +1 range*/

            leftFrontMotor.setPower(speed + turn - strafe);
            leftRearMotor.setPower(speed + turn + strafe);
            rightFrontMotor.setPower(speed - turn + strafe);
            rightRearMotor.setPower(speed - turn - strafe);
            }

        }

    }
