package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

// SF
import com.ibm.cics.server.invocation.CICSProgram;

public class Lgapcv01 implements Comparable<Lgapcv01> {
    public Lgapcv01() {}
    
    public Lgapcv01(Lgapcv01 that) {
    }
    
    protected Lgapcv01(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Lgapcv01(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Lgapcv01 fromBytes(byte[] bytes, int offset) {
        return new Lgapcv01(bytes, offset);
    }
    
    public static Lgapcv01 fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Lgapcv01 fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    //SF: make this Method available as a CICS program
    @CICSProgram("LGACJV02")
    public static void checkFirstCobol() {
    CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
    WsResponse wsResponse = new WsResponse();
    wsResponse.setWsResponseCode(0);
    wsResponse.setWsResponseMessage("");
    if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("GB")) {
        // TODO: Empty block may need to be addressed
    } else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("US")) {
        // TODO: Empty block may need to be addressed
    } else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("UK")) {
        // TODO: Empty block may need to be addressed
    } else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("DN")) {
        // TODO: Empty block may need to be addressed
    } else {
        wsResponse.setWsResponseCode(Integer.parseInt("82"));
        wsResponse.setWsResponseMessage("Invalid postcode: " + caCustomerRequest.getCaPostcode());
    }
    // SF: Return response to caller
    wsResponse.returnWsResponse();
}

    
    public static void main(String[] args) {
        checkFirstCobol();
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("}");
        return s.toString();
    }
    
    public boolean equals(Lgapcv01 that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Lgapcv01) && this.equals((Lgapcv01)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(Lgapcv01 that) {
        int c = 0;
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
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
            return new String(getBytes(), factory.getStringEncoding());
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
    
}
