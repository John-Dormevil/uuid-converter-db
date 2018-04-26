package com.linkazer.flocondria.uuid;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class UuidHelperTest {

    @Test
    public void testGetVarbinStringUuid() {
        String varString = UuidHelper.getVarbinUuidFormate("ee4fd61b-1e0f-424a-b194-ff62d94f1b00");
        Assert.assertEquals("ee4fd61b1e0f424ab194ff62d94f1b0", varString);
    }

    @Test
    public void testGetStringUuidVarbin() {
        String uuidString = UuidHelper.getUuidFormateStr("ee4fd61b1e0f424ab194ff62d94f1b00");
        Assert.assertEquals("ee4fd61b-1e0f-424a-b194-ff62d94f1b00", uuidString);
    }

    @Test
    public void getUUIDFromHexString() {
        UUID uuid       = UUID.fromString("ee4fd61b-1e0f-424a-b194-ff62d94f1b00");
        UUID uuidHelper = UuidHelper.getUUIDFromHexString("ee4fd61b1e0f424ab194ff62d94f1b00");
        Assert.assertEquals(uuid, uuidHelper);
    }

    @Test
    public void should_Get_16_Bytes_From_a_UUID() {
        UUID uuid = UUID.randomUUID();

        byte[] result = UuidHelper.getBytesFromUUID(uuid);

        Assert.assertEquals("Expected result to be a byte array w/16 elements.", 16, result.length);
    }

    @Test
    public void should_Reconstruct_Same_UUID_From_Byte_Array() {
        UUID uuid = UUID.randomUUID();

        byte[] bytes = UuidHelper.getBytesFromUUID(uuid);
        UUID reconstructedUuid = UuidHelper.getUUIDFromBytes(bytes);

        Assert.assertEquals(uuid, reconstructedUuid);
    }

    @Test
    public void should_Not_Generate_the_Same_UUID_From_Bytes() {
        UUID uuid = UUID.fromString("9f881758-0b4a-4eaa-b59f-b6dea0934223");

        byte[] result = UuidHelper.getBytesFromUUID(uuid);
        UUID newUuid = UUID.nameUUIDFromBytes(result);

        Assert.assertFalse(uuid.equals(newUuid));
    }
}
