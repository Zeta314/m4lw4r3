package com.zeta314.exceptions.general;

import com.zeta314.exceptions.base.MessageRuntimeException;

public class SizeException extends MessageRuntimeException {
    public SizeException(String msg) {
        super(msg);
    }
}
