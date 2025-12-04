package org.firstinspires.ftc.teamcode.PedroCommands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialCommandGroup extends PedroCommand {
    private final List<PedroCommand> commandList = new ArrayList<PedroCommand>();
    private int currentCommandIndex = -1;

    public SequentialCommandGroup(PedroCommand... commands)
    {
        Collections.addAll(commandList, commands);
    }

    @Override
    public void init()
    {
        currentCommandIndex = 0;

        if(commandList.isEmpty())
        {
            throw new IllegalStateException(
                    "Can't create an empty command group!");
        }
    }

    @Override
    public void run()
    {
        if(commandList.isEmpty())
        {
            return;
        }

        PedroCommand currentCommand = commandList.get(currentCommandIndex);
        currentCommand.init();

        currentCommand.run();

        if(currentCommand.isFinished())
        {
            currentCommandIndex += 1;
        }
    }

    @Override
    public boolean isFinished()
    {
        return currentCommandIndex == commandList.size();
    }

    @Override
    public void addCommands(PedroCommand... commands)
    {
        Collections.addAll(commandList, commands);
    }
}
