package com.example.M2ChallengeMercierSydney.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class CustomErrorResponse {
    // Wrote this on October 5th, 2022 with the class

    String errorMsg;
    int status;
    String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime timestamp;

    public CustomErrorResponse(HttpStatus status, String message) {
        this.errorMsg = message;
        this.status = status.value();
        this.errorCode = status.toString();
        this.timestamp = LocalDateTime.now();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomErrorResponse that = (CustomErrorResponse) o;
        return getStatus() == that.getStatus() && Objects.equals(getErrorMsg(), that.getErrorMsg()) && Objects.equals(getErrorCode(), that.getErrorCode()) && Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getErrorMsg(), getStatus(), getErrorCode(), getTimestamp());
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
                "errorMsg='" + errorMsg + '\'' +
                ", status=" + status +
                ", errorCode='" + errorCode + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
