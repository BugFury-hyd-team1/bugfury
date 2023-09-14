package com.project.bean;

import java.util.Date;

public class Bug {
    private int bugId;
    private String description;
    private BugStatus status;
    private BugSeverity severity;
    private BugPriority priority;
    private User reportedBy;
    private User assignedTo;
    private Date createdDate;
    private Date lastUpdatedDate;
    private Date dueDate;
    private String comments;

    // Constructor
    public Bug(int bugId, String description, BugStatus status, BugSeverity severity, BugPriority priority,
               User reportedBy, User assignedTo, Date createdDate, Date lastUpdatedDate, Date dueDate, String comments) {
        this.bugId = bugId;
        this.description = description;
        this.status = status;
        this.severity = severity;
        this.priority = priority;
        this.reportedBy = reportedBy;
        this.assignedTo = assignedTo;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.dueDate = dueDate;
        this.comments = comments;
    }

    // Getters and setters
    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }

    public BugSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(BugSeverity severity) {
        this.severity = severity;
    }

    public BugPriority getPriority() {
        return priority;
    }

    public void setPriority(BugPriority priority) {
        this.priority = priority;
    }

    public User getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(User reportedBy) {
        this.reportedBy = reportedBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // Enum to represent bug status (Open, In Progress, Resolved, Closed)
    public enum BugStatus {
        OPEN, IN_PROGRESS, RESOLVED, CLOSED
    }

    // Enum to represent bug severity (Low, Medium, High, Critical)
    public enum BugSeverity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    // Enum to represent bug priority (Low, Medium, High, Critical)
    public enum BugPriority {
        LOW, MEDIUM, HIGH, CRITICAL
    }
}
