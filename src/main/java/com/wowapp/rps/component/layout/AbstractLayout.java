package com.wowapp.rps.component.layout;

import com.wowapp.rps.component.command.BackCommand;
import com.wowapp.rps.component.command.QuitCommand;
import com.wowapp.rps.component.command.CommandListener;
import com.wowapp.rps.domain.CommandName;
import org.springframework.util.StringUtils;

import java.util.EnumMap;
import java.util.Map;

import static com.wowapp.rps.component.util.CommandLineUtil.emptyLine;
import static com.wowapp.rps.component.util.CommandLineUtil.print;

public abstract class AbstractLayout implements Layout {

    private Map<CommandName, CommandListener> commandsMap;

    public AbstractLayout() {
        this.commandsMap = new EnumMap<>(CommandName.class);
        this.commandsMap.put(CommandName.BACK, BackCommand::new);
        this.commandsMap.put(CommandName.QUIT, QuitCommand::new);
    }

    Map<CommandName, CommandListener> commands() {
        return this.commandsMap;
    }

    @Override
    public void execute(String input) {
        if (StringUtils.isEmpty(input)) {
            emptyLine();
            return;
        }

        CommandName command = CommandName.findCommand(input.trim().toLowerCase());
        CommandListener listener = commands().get(command);
        if (listener != null) {
            listener.action();
        } else {
            print("Command not found");
        }
    }
}
