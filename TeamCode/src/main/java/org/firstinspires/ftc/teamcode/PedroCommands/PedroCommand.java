package org.firstinspires.ftc.teamcode.PedroCommands;

import kotlin.NotImplementedError;

abstract public class PedroCommand {
    abstract public void init();
    abstract public void run();

    abstract public boolean isFinished();

    public PedroCommand andThen(PedroCommand... commands) {
        SequentialCommandGroup group = new SequentialCommandGroup(this);
        group.addCommands(commands);

        return group;
    }

    public PedroCommand alongWith(PedroCommand... commands)
    {
        ParallelCommandGroup group = new ParallelCommandGroup(this);
        group.addCommands(commands);

        return group;
    }
}
