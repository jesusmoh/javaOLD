package core.common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;

@JsonPropertyOrder({
    "success",
    "message",
    "timestamp",
    "codeResult",
    "data"
})
public class ApiResponse {

    private final boolean success;
    private final int codeResult;
    private final String message;
    private final Object data;

    public ApiResponse(boolean success, String message, Object data, int code) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.codeResult = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }

    public Object getData() {
        return data;
    }

    public int getCodeResult() {
        return codeResult;
    }

}
