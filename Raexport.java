package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Raexport implements Comparable<Raexport> {
    public Raexport() {
    }

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
        CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
        int db2CustomernumInt;
        ErrorMsg errorMsg = new ErrorMsg();
        String lgacNcs = "ON";
        caCustomerRequest.setEmSqlreq(" INSERT CUSTOMER");
        if (lgacNcs.equals("ON")) {
            try {
                String sql = "INSERT INTO CUSTOMER(CUSTOMERNUMBER, FIRSTNAME, LASTNAME, DATEOFBIRTH, HOUSENAME, HOUSENUMBER, POSTCODE, PHONEMOBILE, PHONEHOME, EMAILADDRESS)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = JdbcConnection.connection.prepareStatement(sql);
                ps.setInt(1, db2CustomernumInt);
                ps.setString(2, caCustomerRequest.getCaFirstName());
                ps.setString(3, caCustomerRequest.getCaLastName());
                ps.setString(4, caCustomerRequest.getCaDob());
                ps.setString(5, caCustomerRequest.getCaHouseName());
                ps.setString(6, caCustomerRequest.getCaHouseNum());
                ps.setString(7, caCustomerRequest.getCaPostcode());
                ps.setString(8, caCustomerRequest.getCaPhoneMobile());
                ps.setString(9, caCustomerRequest.getCaPhoneHome());
                ps.setString(10, caCustomerRequest.getCaEmailAddress());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException exception) {
                caCustomerRequest.setCaReturnCode(Integer.parseInt("90"));
                errorMsg.writeErrorMessage();
                return;
            }
        } else {
            try {
                String sql = "INSERT INTO CUSTOMER(FIRSTNAME, LASTNAME, DATEOFBIRTH, HOUSENAME, HOUSENUMBER, POSTCODE, PHONEMOBILE, PHONEHOME, EMAILADDRESS)values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = JdbcConnection.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, caCustomerRequest.getCaFirstName());
                ps.setString(2, caCustomerRequest.getCaLastName());
                ps.setString(3, caCustomerRequest.getCaDob());
                ps.setString(4, caCustomerRequest.getCaHouseName());
                ps.setString(5, caCustomerRequest.getCaHouseNum());
                ps.setString(6, caCustomerRequest.getCaPostcode());
                ps.setString(7, caCustomerRequest.getCaPhoneMobile());
                ps.setString(8, caCustomerRequest.getCaPhoneHome());
                ps.setString(9, caCustomerRequest.getCaEmailAddress());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                db2CustomernumInt = rs.getInt(1);
                ps.close();
            } catch (SQLException exception) {
                caCustomerRequest.setCaReturnCode(Integer.parseInt("90"));
                errorMsg.writeErrorMessage();
                return;
            }
        }
        caCustomerRequest.setCaCustomerNum(db2CustomernumInt);
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
        return (that instanceof Raexport) && this.equals((Raexport) that);
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
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte) 0x40 /* default EBCDIC space character */);
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
