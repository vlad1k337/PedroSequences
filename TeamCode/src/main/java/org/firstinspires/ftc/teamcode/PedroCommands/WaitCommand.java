package org.firstinspires.ftc.teamcode.PedroCommands;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

public class WaitCommand extends PedroCommand {
    ElapsedTime timer;
    int waitTime = 0;
    public WaitCommand(int milliseconds) {
        waitTime = milliseconds;
        timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    }

    @Override
    public void init() {
        // Intentionally empty..
    }

    @Override
    public void run() {
        timer.reset();
    }

    @Override
    public boolean isFinished()
    {
        return waitTime >= timer.milliseconds();
    }
}
