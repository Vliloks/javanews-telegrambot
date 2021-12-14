package com.github.vliloks.jntb.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    NO("nocommand"),
    HELP("/help"),
    ADMIN_HELP("/ahelp"),
    STAT("/stat"),
    ADD_GROUP_SUB("/addgroupsub"),
    LIST_GROUP_SUB("/listgroupsub"),
    DELETE_GROUP_SUB("/deletegroupsub");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
