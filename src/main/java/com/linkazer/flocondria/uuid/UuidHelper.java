package com.linkazer.flocondria.uuid;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UuidHelper {

    public static byte[] getBytesFromUUID(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return bb.array();
    }

    public static UUID getUUIDFromBytes(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        Long       high       = byteBuffer.getLong();
        Long       low        = byteBuffer.getLong();

        return new UUID(high, low);
    }

    public static UUID getUUIDFromHexString(String hexVarBinary) {
        String uuidStr = getUuidFormateStr(hexVarBinary);
        return UUID.fromString(uuidStr);
    }

    public static String getVarbinUuidFormate(String uuidStringFormated) {
        String[] hexUuid = uuidStringFormated.split("-");
        String   build   = "";
        for (String frag : hexUuid) {
            build += frag;
        }
        return build;
    }

    public static String getUuidFormateStr(String hexUuid) {

        String   build   = "";
        build += hexUuid.substring(0,8);
        build += "-" + hexUuid.substring(8, 12);
        build += "-" + hexUuid.substring(12, 16);
        build += "-" + hexUuid.substring(16, 20);
        build += "-" + hexUuid.substring(20, 32);
        return build;
    }
}
