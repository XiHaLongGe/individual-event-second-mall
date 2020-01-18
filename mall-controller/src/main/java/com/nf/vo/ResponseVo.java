package com.nf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname ResponseVo
 * @Date: 2020-01-15 15:13
 * @Description: 响应前台的vo类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {
    /**
     * code： 响应状态码
     */
    private Integer code;
    /**
     * message：响应消息
     */
    private String message;
    /**
     * data： 响应数据
     */
    private Object data;

    private ResponseVo(Builder builder) {
        code = builder.code;
        message = builder.message;
        data = builder.data;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ResponseVo copy) {
        Builder builder = new Builder();
        builder.code = copy.getCode();
        builder.message = copy.getMessage();
        builder.data = copy.getData();
        return builder;
    }


    public static final class Builder {
        private Integer code;
        private String message;
        private Object data;

        private Builder() {
        }

        public Builder code(Integer val) {
            code = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder data(Object val) {
            data = val;
            return this;
        }


        public ResponseVo build() {
            return new ResponseVo(this);
        }
    }
}
