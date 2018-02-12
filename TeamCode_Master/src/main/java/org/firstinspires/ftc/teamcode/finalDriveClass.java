package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import static java.lang.Math.abs;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Owner on 1/9/18.
 * Mecanum code adapted from this FTC Forum post: https://ftcforum.usfirst.org/forum/ftc-technology/android-studio/6361-mecanum-wheels-drive-code-example
 */
@TeleOp(name="finalDriveClass", group="Linear Opmode")
@Disabled
public class finalDriveClass extends LinearOpMode {

    static final double pace = .01;
    static final int milisec = 50;
    static final double maxPos = 1.0;
    static final double minPos = 0.0;
    double position = minPos;
    double liftPower = 0;
    double flipPower = 0;

    //Define Class
    //Servo greenSticker;
    //Servo brownSticker;
    private DcMotor flip;
    private DcMotor lift;

    //ColorSensor color_sensor;
    //Servo fadedSticker;

    private DcMotor leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor;

    @Override
    public void runOpMode() { //declaring variable
        //greenSticker = hardwareMap.get(Servo.class, "greenSticker");
        //brownSticker = hardwareMap.get(Servo.class, "brownSticker");
        flip = hardwareMap.get(DcMotor.class, "flip");
        lift = hardwareMap.get(DcMotor.class, "lift");

        //fadedSticker = hardwareMap.get(Servo.class, "fadedSticker");
        //color_sensor = hardwareMap.colorSensor.get("color");

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
            double strafe = -gamepad1.right_stick_x;

            telemetry.addData("speed : ", speed);

            //Left Front = +speed + turn - strafe      Right Front = +speed - turn + strafe
            //Left Rear = +speed + turn + strafe       Right Rear = +speed - turn - strafe

            /*double magnitude = abs(speed) + abs(turn) + abs(strafe);
            magnitude = (magnitude > 1) ? magnitude : 1; //Sets scaling to keep -1, +1 range*/

            leftFrontMotor.setPower(-speed + -turn - -strafe); //Left motors reversed
            leftRearMotor.setPower(-speed + -turn + -strafe); //Left motors reversed
            rightFrontMotor.setPower(speed - turn + strafe);
            rightRearMotor.setPower(speed - turn - strafe);

            if (gamepad1.dpad_down) { //Moving Lift up and down
                liftPower = -.1;
            }
            if (gamepad1.dpad_up) {
                liftPower = .1;
            } else {
                liftPower = 0;
            }
            lift.setPower(liftPower);

            if (gamepad1.left_bumper) { //Flipping up and down
                flipPower = -.1;
            }
            if (gamepad1.right_bumper) {
                flipPower = .1;
            } else {
                flipPower = 0;
            }
            flip.setPower(flipPower);

            if (gamepad1.dpad_left) { //Moves Forklift Servos
                position = minPos;
                //greenSticker.setPosition(position);
                //brownSticker.setPosition(position);
                //Use this website as help for servos: https://github.com/ftctechnh/ftc_app/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/ConceptScanServo.java#L28
            } else if (gamepad1.dpad_right) {
                position = maxPos;
                //greenSticker.setPosition(position);
                //brownSticker.setPosition(position);
            } else {
                sleep(milisec);
                idle();
            }
        }
    }
}