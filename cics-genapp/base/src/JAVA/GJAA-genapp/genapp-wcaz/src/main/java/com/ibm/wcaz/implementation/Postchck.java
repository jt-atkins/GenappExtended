package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import com.ibm.cics.server.invocation.CICSProgram;

public class Postcode implements Comparable<Postcode> {
    public Postcode() {}
    
    public Postcode(Postcode that) {
    }
    
    protected Postcode(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Postcode(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Postcode fromBytes(byte[] bytes, int offset) {
        return new Postcode(bytes, offset);
    }
    
    public static Postcode fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Postcode fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    @CICSProgram("LGACUS01")
    public static void checkFirstCobol() {
        CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
        WsResponse wsResponse = new WsResponse();

        wsResponse.setWsResponseCode(0);
        wsResponse.setWsResponseMessage("");
        if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("GB")) {
        }
        else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("US")) {
        }
        else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("UK")) {
        }
        else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("DN")) {
        }
        else {
            wsResponse.setWsResponseCode(82);
            String jdeclVar1 = "Invalid postcode: " + caCustomerRequest.getCaPostcode();
            wsResponse.setWsResponseMessage(jdeclVar1);
        }

        // SF: Return response to caller
        wsResponse.returnWsResponse();
    }
    
    @CICSProgram("LGACUS01")
    public static void checkFirstJava() {
        CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
        WsResponse wsResponse = new WsResponse();

        wsResponse.setWsResponseCode(0);
        wsResponse.setWsResponseMessage("");
        if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("GB")) {
        }
        else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("US")) {
        }
        else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("UK")) {
        }
        else if (caCustomerRequest.getCaPostcode().substring(0, 2).equals("DN")) {
        }
        else {
            wsResponse.setWsResponseCode(82);
            String jdeclVar1 = "Invalid postcode: " + caCustomerRequest.getCaPostcode();
            wsResponse.setWsResponseMessage(jdeclVar1);
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
    
    public boolean equals(Postcode that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Postcode) && this.equals((Postcode)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(Postcode that) {
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
            return new String(getBytes(), factory.getStringEncoding()).stripTrailing();
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
