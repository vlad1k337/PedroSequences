package org.firstinspires.ftc.teamcode.PedroCommands;

import kotlin.NotImplementedError;

abstract public class PedroCommand {
    abstract public void init();
    abstract public void run();

    abstract public boolean isFinished();

    void addCommands(PedroCommand... commands)
    {
        throw new NotImplementedError("Method is not implemented");
    }

    PedroCommand andThen(PedroCommand... commands) {
        SequentialCommandGroup group = new SequentialCommandGroup(this);
        group.addCommands(commands);

        return group;
    }
}
