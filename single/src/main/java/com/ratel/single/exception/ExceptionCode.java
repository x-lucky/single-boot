package com.ratel.single.exception;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
    prefix = "ratel"
)
public class ExceptionCode {
    public static final int EXCEL_IMPORT_FAILED = 11213;
    public static final int ERROR_INPUT_DATA = 10005;
    public static final int BATCH_TASK_TIMEOUT = 10006;
    /**
     * 异常池
     */
    public static Map<String, String> EX_MAP;
    private Map<String, String> exception;

    public ExceptionCode() {
    }

    public void setException(Map<String, String> exception) {
        EX_MAP = exception;
        this.exception = exception;
    }

    public Map<String, String> getException() {
        return this.exception;
    }
}