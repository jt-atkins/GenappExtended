package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import com.ibm.ibmzpot.common.CobolData;

public class WsResponse implements Comparable<WsResponse> {
    private int wsResponseCode;
    private String wsResponseMessage = "";
    
    public WsResponse() {}
    
    public WsResponse(int wsResponseCode, String wsResponseMessage) {
        this.wsResponseCode = wsResponseCode;
        this.wsResponseMessage = wsResponseMessage;
    }
    
    public WsResponse(WsResponse that) {
        this.wsResponseCode = that.wsResponseCode;
        this.wsResponseMessage = that.wsResponseMessage;
    }
    
    protected WsResponse(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected WsResponse(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static WsResponse fromBytes(byte[] bytes, int offset) {
        return new WsResponse(bytes, offset);
    }
    
    public static WsResponse fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static WsResponse fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getWsResponseCode() {
        return this.wsResponseCode;
    }
    
    public void setWsResponseCode(int wsResponseCode) {
        this.wsResponseCode = wsResponseCode;
    }
    
    public String getWsResponseMessage() {
        return this.wsResponseMessage;
    }
    
    public void setWsResponseMessage(String wsResponseMessage) {
        this.wsResponseMessage = wsResponseMessage;
    }
    public void reset() {
        wsResponseCode = 0;
        wsResponseMessage = "";
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ wsResponseCode=\"");
        s.append(getWsResponseCode());
        s.append("\"");
        s.append(", wsResponseMessage=\"");
        s.append(getWsResponseMessage());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    public boolean equals(WsResponse that) {
        return this.wsResponseCode == that.wsResponseCode &&
            this.wsResponseMessage.equals(that.wsResponseMessage);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof WsResponse) && this.equals((WsResponse)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(wsResponseCode) ^
            Integer.rotateLeft(wsResponseMessage.hashCode(), 1);
    }
    
    @Override
    public int compareTo(WsResponse that) {
        int c = 0;
        c = Integer.compare(this.wsResponseCode, that.wsResponseCode);
        if ( c != 0 ) return c;
        c = this.wsResponseMessage.compareTo(that.wsResponseMessage);
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField WS_RESPONSE_CODE = factory.getExternalDecimalAsIntField(2, true);
    private static final StringField WS_RESPONSE_MESSAGE = factory.getStringField(78);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        WS_RESPONSE_CODE.putInt(wsResponseCode, bytes, offset);
        WS_RESPONSE_MESSAGE.putString(wsResponseMessage, bytes, offset);
        return bytes;
    }
    
    public final byte[] getBytes(byte[] bytes) {
        return getBytes(bytes, 0);
    }
    
    public final byte[] getBytes() {
        return getBytes(new byte[numBytes()]);
    }
    
    public final String toByteString() {
        try {
            return new String(getBytes(), factory.getStringEncoding()).trim();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        wsResponseCode = WS_RESPONSE_CODE.getInt(bytes, offset);
        wsResponseMessage = WS_RESPONSE_MESSAGE.getString(bytes, offset);
    }
    
    
    public final void setBytes(byte[] bytes) {
        setBytes(bytes, 0);
    }
    
    public final void setBytes(String bytes) {
        try {
            setBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int numBytes() {
        return SIZE;
    }

    public void returnWsResponse() {
        CobolData output = new CobolData();
        String fixedReponseCode = String.format("%02d",this.wsResponseCode);
        String fixedReponseMessage = String.format("$-78s",this.wsResponseMessage);
        output.putCobolData(fixedReponseCode + fixedReponseMessage);
    }
    
}
