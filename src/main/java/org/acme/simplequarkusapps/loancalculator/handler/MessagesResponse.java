package org.acme.simplequarkusapps.loancalculator.handler;

public enum MessagesResponse {
    SUCCCESS("Success!"),
    SAVED("Saved successfully!"),
    UPDATED("Updated successfully!"),
    DELETED("Deleted successfully!"),
    REMOVED("Removed successfully!"),
    ADDED("Added successfully!"),
    APPROVED("Approved successfully!"),
    DECLINED("Declined successfully!"),
    COMPLETED("Declined successfully!"),
    DISBURSED("Disbursed successfully!"),
    ACTIVATED("Activated successfully!"),
    FETCHED("Fetched successfully!"),
    REJECTED("Rejected successfully!"),
    DEACTIVATED("Deactivated successfully!"),
    CLOSED("Closed successfully!"),
    ACCESS_DENIED("Access denied!");

    public final String label;

    private MessagesResponse(String label) {
        this.label = label;
    }
}
