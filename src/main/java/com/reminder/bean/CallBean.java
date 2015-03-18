package com.reminder.bean;
import com.bandwidth.sdk.model.Recording;

import java.util.Date;
import java.util.List;

public class CallBean {

    private String id;
    private String state;
    private String direction;
    private String to;
    private String from;
    private Date startTime;
    private Date activeTime;
    private Date endTime;
    private Long chargeableDuration;
    private String callbackUrl;
    private String transcriptionEnabled;
    private String transcriptions;
    private String recordingEnabled;
    private List<Recording> recordings;
    private String events;


    public CallBean getBean(){
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getChargeableDuration() {
        return chargeableDuration;
    }

    public void setChargeableDuration(Long chargeableDuration) {
        this.chargeableDuration = chargeableDuration;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getTranscriptionEnabled() {
        return transcriptionEnabled;
    }

    public void setTranscriptionEnabled(String transcriptionEnabled) {
        this.transcriptionEnabled = transcriptionEnabled;
    }

    public String getTranscriptions() {
        return transcriptions;
    }

    public void setTranscriptions(String transcriptions) {
        this.transcriptions = transcriptions;
    }

    public String getRecordingEnabled() {
        return recordingEnabled;
    }

    public void setRecordingEnabled(String recordingEnabled) {
        this.recordingEnabled = recordingEnabled;
    }

    public List<Recording> getRecordings() {
        return recordings;
    }

    public void setRecordings(List<Recording> recordings) {
        this.recordings = recordings;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }
}
