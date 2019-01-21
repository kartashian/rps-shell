package com.wowapp.rps.component;

import com.wowapp.rps.component.layout.Layout;
import com.wowapp.rps.domain.entity.User;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Context {

    THIS;

    private Layout currentLayout;
    private String layoutPath;
    private LinkedList<Layout> layoutHistory;
    private User currentUser;
    private boolean isRunning;

    Context() {
        this.isRunning = true;
        this.layoutHistory = new LinkedList<>();
    }

    public Layout currentLayout() {
        return currentLayout;
    }

    public void nextLayout(Layout currentLayout) {
        this.currentLayout = currentLayout;
        this.layoutHistory.add(currentLayout);
        buildLayoutPath();
        this.currentLayout.init();
    }

    public void previousLayout() {
        if (this.layoutHistory.size() <= 1) {
            return;
        }

        layoutHistory.pollLast();
        this.currentLayout = layoutHistory.getLast();
        buildLayoutPath();
        this.currentLayout.init();
    }

    private void buildLayoutPath() {
        this.layoutPath = layoutHistory.stream()
                .map(Layout::name)
                .collect(Collectors.joining("/"));
    }

    public String layoutPath() {
        return this.layoutPath;
    }

    public User currentUser() {
        return currentUser;
    }

    public String getUserName() {
       return Optional.ofNullable(Context.THIS.currentUser())
                .map(User::getName).orElse("");
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void stopRunning() {
        this.isRunning = false;
    }
}
