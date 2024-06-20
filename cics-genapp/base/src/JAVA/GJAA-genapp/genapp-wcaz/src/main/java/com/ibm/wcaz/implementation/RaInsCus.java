package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class RaInsCus implements Comparable<RaInsCus> {
    public RaInsCus() {}
    
    public RaInsCus(RaInsCus that) {
    }
    
    protected RaInsCus(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected RaInsCus(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static RaInsCus fromBytes(byte[] bytes, int offset) {
        return new RaInsCus(bytes, offset);
    }
    
    public static RaInsCus fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static RaInsCus fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static void insertCustomer() {
    Dfhcommarea1 dfhcommarea1 = new Dfhcommarea1();
    String wsStatus = "";
    if (wsStatus.equals("valid")) {
        Task jdeclTask = Task.getTask();
        Channel jdeclChannelObj = jdeclTask.getCurrentChannel();
        Container jdeclContainerObj = jdeclChannelObj.getContainer(dfhcommarea1.getLgapdb01());
        byte[] jdeclCommareaByteArray = jdeclContainerObj.get();
        Charset jdeclCharSet = Charset.forName(System.getProperty("com.ibm.cics.jvmserver.local.ccsid"));
        String jdeclLocalCcsid = System.getProperty("com.ibm.cics.jvmserver.local.ccsid");
        byte[] jdeclTempOutputData = jdeclCommareaByteArray;
        dfhcommarea1.setBytes(new String(jdeclTempOutputData, jdeclCharSet));
    } else if (wsStatus.equals("error")) {
        Task.getTask().abend("CUSE");
    }
}

    
    public static void main(String[] args) {
        insertCustomer();
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("}");
        return s.toString();
    }
    
    public boolean equals(RaInsCus that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof RaInsCus) && this.equals((RaInsCus)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(RaInsCus that) {
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
