package com.wowapp.rps.component;

import com.wowapp.rps.component.layout.Layout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.wowapp.rps.component.util.CommandLineUtil.print;
import static com.wowapp.rps.component.util.CommandLineUtil.shell;

@Component
public class ApplicationManagerImpl implements ApplicationManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationManagerImpl.class);

    private final Scanner input;
    private final Context context;

    @Autowired
    public ApplicationManagerImpl(@Qualifier("loginLayout") Layout loginLayout) {
        this.input = new Scanner(System.in);
        this.context = Context.THIS;
        this.context.nextLayout(loginLayout);
    }

    @Override
    public void run() {
        LOGGER.info("Run application");
        while (context.isRunning()) {
            try {
                shell();
                String inputText = input.nextLine();
                context.currentLayout().execute(inputText);
            } catch (Exception e) {
               print("Internal error: " + e.toString());
            }
        }
    }
}
