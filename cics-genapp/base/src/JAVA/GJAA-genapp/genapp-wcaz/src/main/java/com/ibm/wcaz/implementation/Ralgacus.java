package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import com.ibm.cics.server.invocation.CICSProgram;

public class Ralgacus implements Comparable<Ralgacus> {
    public Ralgacus() {}
    
    public Ralgacus(Ralgacus that) {
    }
    
    protected Ralgacus(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Ralgacus(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Ralgacus fromBytes(byte[] bytes, int offset) {
        return new Ralgacus(bytes, offset);
    }
    
    public static Ralgacus fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Ralgacus fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    


    //SF: make this Method available as a CICS program
    @CICSProgram("LGACJV02")
    public static void checkFirstCobol() {
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
    
    public boolean equals(Ralgacus that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Ralgacus) && this.equals((Ralgacus)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(Ralgacus that) {
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
