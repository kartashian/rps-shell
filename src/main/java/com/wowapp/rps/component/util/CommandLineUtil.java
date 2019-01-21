package com.wowapp.rps.component.util;

import com.wowapp.rps.component.Context;
import com.wowapp.rps.domain.CommandName;
import com.wowapp.rps.domain.GameResult;
import com.wowapp.rps.domain.entity.Statistic;
import org.springframework.data.domain.Page;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hibernate.internal.util.StringHelper.repeat;

/**
 * Util class
 * Contains common command line utils
 */
public final class CommandLineUtil {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

    public static void print(String message) {
        System.out.println(message + "\n");
    }

    public static void emptyLine() {
        System.out.print("");
    }

    public static void shell() {
        System.out.print(Context.THIS.getUserName() + " ~" + Context.THIS.layoutPath() + "> ");
    }

    public static void printCommands(String startMessage, Collection<CommandName> commands) {
        StringBuilder message = new StringBuilder(startMessage);
        for (CommandName commandName : commands) {
            message.append("\n")
                    .append(commandName.getDescription())
                    .append(" - ")
                    .append(commandName.getName());
        }
        print(message.toString());
    }

    public static void printStatistic(List<Statistic> statistic) {
        System.out.println();
        printStatisticHeader();
        for (int i = 0; i < statistic.size(); i++) {
            printStatisticRow(statistic.get(i), i + 1);
        }

        Map<GameResult, Long> totals = statistic.stream()
                .collect(Collectors.groupingBy(Statistic::getResult, Collectors.counting()));
        String resultTotals = totals.entrySet().stream()
                .map(e -> e.getKey().name() + ": " + e.getValue())
                .collect(Collectors.joining(" "));
        String message = "TOTAL: " + statistic.size() + " " + resultTotals;
        System.out.println();
        print(message);
    }

    public static void printStatisticPage(Page<Statistic> page) {
        System.out.println();
        printStatisticHeader();
        List<Statistic> statistic = page.getContent();
        long offset = page.getTotalElements() > page.getSize()
                ? page.getTotalElements() - page.getSize() : 0;
        for (int i = 0; i < statistic.size(); i++) {
            printStatisticRow(statistic.get(i), i + 1 + offset);
        }
    }

    private static void printStatisticHeader() {
        System.out.println(String.format("|%4s|%22s|%15s|%15s|%10s|",
                "№", "Date", Context.THIS.getUserName() + " Move", "Robert Move", "Result"));
        System.out.println(String.format("%s", repeat("-", 72)));
    }

    private static void printStatisticRow(Statistic statistic, long index) {
        System.out.println(String.format("|%4s|%22s|%15s|%15s|%10s|",
                index, statistic.getDate().format(DATE_FORMATTER),
                statistic.getUserMove(), statistic.getBotMove(), statistic.getResult()));
    }

    private CommandLineUtil() {
    }
}
