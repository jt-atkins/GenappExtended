package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class WsJavaVariables implements Comparable<WsJavaVariables> {
    private String java = "JAVA";
    private String lgacjv02 = "LGACJV02";
    
    public WsJavaVariables() {}
    
    public WsJavaVariables(String java, String lgacjv02) {
        this.java = java;
        this.lgacjv02 = lgacjv02;
    }
    
    public WsJavaVariables(WsJavaVariables that) {
        this.java = that.java;
        this.lgacjv02 = that.lgacjv02;
    }
    
    protected WsJavaVariables(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected WsJavaVariables(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static WsJavaVariables fromBytes(byte[] bytes, int offset) {
        return new WsJavaVariables(bytes, offset);
    }
    
    public static WsJavaVariables fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static WsJavaVariables fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getJava() {
        return this.java;
    }
    
    public void setJava(String java) {
        this.java = java;
    }
    
    public String getLgacjv02() {
        return this.lgacjv02;
    }
    
    public void setLgacjv02(String lgacjv02) {
        this.lgacjv02 = lgacjv02;
    }
    public void reset() {
        java = "";
        lgacjv02 = "";
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ java=\"");
        s.append(getJava());
        s.append("\"");
        s.append(", lgacjv02=\"");
        s.append(getLgacjv02());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    public boolean equals(WsJavaVariables that) {
        return this.java.equals(that.java) &&
            this.lgacjv02.equals(that.lgacjv02);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof WsJavaVariables) && this.equals((WsJavaVariables)that);
    }
    
    @Override
    public int hashCode() {
        return java.hashCode() ^
            Integer.rotateLeft(lgacjv02.hashCode(), 1);
    }
    
    @Override
    public int compareTo(WsJavaVariables that) {
        int c = 0;
        c = this.java.compareTo(that.java);
        if ( c != 0 ) return c;
        c = this.lgacjv02.compareTo(that.lgacjv02);
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField JAVA = factory.getStringField(8);
    private static final StringField LGACJV_02 = factory.getStringField(8);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        JAVA.putString(java, bytes, offset);
        LGACJV_02.putString(lgacjv02, bytes, offset);
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
        java = JAVA.getString(bytes, offset);
        lgacjv02 = LGACJV_02.getString(bytes, offset);
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
