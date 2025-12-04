package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.PedroCommands.FollowPathCommand;
import org.firstinspires.ftc.teamcode.PedroCommands.SequentialCommandGroup;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import java.util.function.Supplier;

@Autonomous
public class SequentialTest extends OpMode {
    private Follower follower;
    PathChain first = follower.pathBuilder()
            .addPath(new BezierLine(new Pose(72, 72), new Pose(15, 15)))
            .setConstantHeadingInterpolation(0)
            .build();

    PathChain second = follower.pathBuilder()
            .addPath(new BezierLine(new Pose(15, 15), new Pose(100, 100)))
            .setConstantHeadingInterpolation(0)
            .build();

    PathChain third = follower.pathBuilder()
            .addPath(new BezierLine(new Pose(100, 100), new Pose(72, 72)))
            .setConstantHeadingInterpolation(0)
            .build();

    private SequentialCommandGroup commands;

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        follower.update();

        commands = new SequentialCommandGroup(
                new FollowPathCommand(follower, first),
                new FollowPathCommand(follower, second),
                new FollowPathCommand(follower, third)
        );

        commands.init();
    }

    @Override
    public void loop() {
        if(!commands.isFinished())
        {
            commands.run();
        }
    }
}
