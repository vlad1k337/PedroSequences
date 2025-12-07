package org.firstinspires.ftc.teamcode.PedroCommands;

import java.util.Collections;
import java.util.Set;

public class ParallelCommandGroup extends PedroCommand {
    private final Set<PedroCommand> commandList = Collections.emptySet();

    public ParallelCommandGroup(PedroCommand... commands)
    {
        Collections.addAll(commandList, commands);
    }

    @Override
    public void init() {
        for(PedroCommand command : commandList)
        {
            command.init();
        }
    }

    // Has to be called ONCE!
    @Override
    public void run() {
        for(PedroCommand command : commandList)
        {
            if(command.isFinished())
            {
                continue;
            }

            command.run();
        }
    }

    @Override
    public boolean isFinished() {
        boolean finished = true;

        for(PedroCommand command : commandList)
        {
            finished = finished && command.isFinished();
        }

        return finished;
    }

    public void addCommands(PedroCommand... commands)
    {
        Collections.addAll(commandList, commands);
    }
}
