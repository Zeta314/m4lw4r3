package com.zeta314.util;

import org.apache.commons.lang3.ArrayUtils;

public class IntegerUtils {
    public static byte[] toByteArray(int value, Endianess endianess) {
        byte[] data = new byte[]{
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) value
        };

        if (endianess == Endianess.LITTLE_ENDIAN) {
            ArrayUtils.reverse(data);
        }

        return data;
    }

    public static byte[] toByteArray(int value) {
        return toByteArray(value, Endianess.BIG_ENDIAN);
    }

    public static int fromByteArray(byte[] bytes, Endianess endianess) {
        if (endianess == Endianess.BIG_ENDIAN) {
            return ((bytes[3] & 0xFF) << 24) | ((bytes[2] & 0xFF) << 16) | ((bytes[1] & 0xFF) << 8) | (bytes[0] & 0xFF);
        }

        return ((bytes[0] & 0xFF) << 24) | ((bytes[1] & 0xFF) << 16) | ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
    }

    public static int fromByteArray(byte[] bytes) {
        return fromByteArray(bytes, Endianess.BIG_ENDIAN);
    }
}
