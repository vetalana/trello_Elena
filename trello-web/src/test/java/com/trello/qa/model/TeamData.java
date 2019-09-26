package com.trello.qa.model;

public class TeamData {
  private  String teamName;
  private  String description;

  public TeamData withTeamName(String teamName) {
    this.teamName = teamName;
    return this;
  }

  public TeamData withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getTeamName() {
    return teamName;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "TeamData{" +
            "teamName='" + teamName + '\'' +
            '}';
  }
}
