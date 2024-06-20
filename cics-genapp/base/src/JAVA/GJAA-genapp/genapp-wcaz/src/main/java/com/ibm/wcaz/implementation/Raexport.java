package com.ibm.wcaz.implementation;

import com.ibm.cics.server.Channel;
import com.ibm.cics.server.Container;
import com.ibm.cics.server.Task;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class Raexport implements Comparable<Raexport> {
    public Raexport() {}
    
    public Raexport(Raexport that) {
    }
    
    protected Raexport(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Raexport(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Raexport fromBytes(byte[] bytes, int offset) {
        return new Raexport(bytes, offset);
    }
    
    public static Raexport fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Raexport fromBytes(String bytes) {
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
    
    public boolean equals(Raexport that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Raexport) && this.equals((Raexport)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(Raexport that) {
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
