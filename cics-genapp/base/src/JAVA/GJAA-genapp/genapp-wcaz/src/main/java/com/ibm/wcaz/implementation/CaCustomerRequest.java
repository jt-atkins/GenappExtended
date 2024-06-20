package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import com.ibmzpot.common.CobolData

public class CaCustomerRequest extends Dfhcommarea1 {
    private String caFirstName = "";
    private String caLastName = "";
    private String caDob = "";
    private String caHouseName = "";
    private String caHouseNum = "";
    private String caPostcode = "";
    private int caNumPolicies;
    private String caPhoneMobile = "";
    private String caPhoneHome = "";
    private String caEmailAddress = "";
    private String caPolicyData = "";
    
    public CaCustomerRequest() {}
    
    public CaCustomerRequest(String caRequestId, int caReturnCode, long caCustomerNum, String caFirstName, String caLastName, String caDob, String caHouseName, String caHouseNum, String caPostcode, int caNumPolicies, String caPhoneMobile, String caPhoneHome, String caEmailAddress, String caPolicyData) {
        super(caRequestId, caReturnCode, caCustomerNum);
        this.caFirstName = caFirstName;
        this.caLastName = caLastName;
        this.caDob = caDob;
        this.caHouseName = caHouseName;
        this.caHouseNum = caHouseNum;
        this.caPostcode = caPostcode;
        this.caNumPolicies = caNumPolicies;
        this.caPhoneMobile = caPhoneMobile;
        this.caPhoneHome = caPhoneHome;
        this.caEmailAddress = caEmailAddress;
        this.caPolicyData = caPolicyData;
    }
    
    public CaCustomerRequest(CaCustomerRequest that) {
        super(that);
        this.caFirstName = that.caFirstName;
        this.caLastName = that.caLastName;
        this.caDob = that.caDob;
        this.caHouseName = that.caHouseName;
        this.caHouseNum = that.caHouseNum;
        this.caPostcode = that.caPostcode;
        this.caNumPolicies = that.caNumPolicies;
        this.caPhoneMobile = that.caPhoneMobile;
        this.caPhoneHome = that.caPhoneHome;
        this.caEmailAddress = that.caEmailAddress;
        this.caPolicyData = that.caPolicyData;
    }
    
    protected CaCustomerRequest(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CaCustomerRequest(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CaCustomerRequest fromBytes(byte[] bytes, int offset) {
        return new CaCustomerRequest(bytes, offset);
    }
    
    public static CaCustomerRequest fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CaCustomerRequest fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCaFirstName() {
        return this.caFirstName;
    }
    
    public void setCaFirstName(String caFirstName) {
        this.caFirstName = caFirstName;
    }
    
    public String getCaLastName() {
        return this.caLastName;
    }
    
    public void setCaLastName(String caLastName) {
        this.caLastName = caLastName;
    }
    
    public String getCaDob() {
        return this.caDob;
    }
    
    public void setCaDob(String caDob) {
        this.caDob = caDob;
    }
    
    public String getCaHouseName() {
        return this.caHouseName;
    }
    
    public void setCaHouseName(String caHouseName) {
        this.caHouseName = caHouseName;
    }
    
    public String getCaHouseNum() {
        return this.caHouseNum;
    }
    
    public void setCaHouseNum(String caHouseNum) {
        this.caHouseNum = caHouseNum;
    }
    
    public String getCaPostcode() {
        return this.caPostcode;
    }
    
    public void setCaPostcode(String caPostcode) {
        this.caPostcode = caPostcode;
    }
    
    public int getCaNumPolicies() {
        return this.caNumPolicies;
    }
    
    public void setCaNumPolicies(int caNumPolicies) {
        this.caNumPolicies = caNumPolicies;
    }
    
    public String getCaPhoneMobile() {
        return this.caPhoneMobile;
    }
    
    public void setCaPhoneMobile(String caPhoneMobile) {
        this.caPhoneMobile = caPhoneMobile;
    }
    
    public String getCaPhoneHome() {
        return this.caPhoneHome;
    }
    
    public void setCaPhoneHome(String caPhoneHome) {
        this.caPhoneHome = caPhoneHome;
    }
    
    public String getCaEmailAddress() {
        return this.caEmailAddress;
    }
    
    public void setCaEmailAddress(String caEmailAddress) {
        this.caEmailAddress = caEmailAddress;
    }
    
    public String getCaPolicyData() {
        return this.caPolicyData;
    }
    
    public void setCaPolicyData(String caPolicyData) {
        this.caPolicyData = caPolicyData;
    }
    public void reset() {
        super.reset();
        caFirstName = "";
        caLastName = "";
        caDob = "";
        caHouseName = "";
        caHouseNum = "";
        caPostcode = "";
        caNumPolicies = 0;
        caPhoneMobile = "";
        caPhoneHome = "";
        caEmailAddress = "";
        caPolicyData = "";
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("{ caFirstName=\"");
        s.append(getCaFirstName());
        s.append("\"");
        s.append(", caLastName=\"");
        s.append(getCaLastName());
        s.append("\"");
        s.append(", caDob=\"");
        s.append(getCaDob());
        s.append("\"");
        s.append(", caHouseName=\"");
        s.append(getCaHouseName());
        s.append("\"");
        s.append(", caHouseNum=\"");
        s.append(getCaHouseNum());
        s.append("\"");
        s.append(", caPostcode=\"");
        s.append(getCaPostcode());
        s.append("\"");
        s.append(", caNumPolicies=\"");
        s.append(getCaNumPolicies());
        s.append("\"");
        s.append(", caPhoneMobile=\"");
        s.append(getCaPhoneMobile());
        s.append("\"");
        s.append(", caPhoneHome=\"");
        s.append(getCaPhoneHome());
        s.append("\"");
        s.append(", caEmailAddress=\"");
        s.append(getCaEmailAddress());
        s.append("\"");
        s.append(", caPolicyData=\"");
        s.append(getCaPolicyData());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    public boolean equals(CaCustomerRequest that) {
        return super.equals(that) &&
            this.caFirstName.equals(that.caFirstName) &&
            this.caLastName.equals(that.caLastName) &&
            this.caDob.equals(that.caDob) &&
            this.caHouseName.equals(that.caHouseName) &&
            this.caHouseNum.equals(that.caHouseNum) &&
            this.caPostcode.equals(that.caPostcode) &&
            this.caNumPolicies == that.caNumPolicies &&
            this.caPhoneMobile.equals(that.caPhoneMobile) &&
            this.caPhoneHome.equals(that.caPhoneHome) &&
            this.caEmailAddress.equals(that.caEmailAddress) &&
            this.caPolicyData.equals(that.caPolicyData);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CaCustomerRequest) && this.equals((CaCustomerRequest)that);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^
            Integer.rotateLeft(caFirstName.hashCode(), 3) ^
            Integer.rotateLeft(caLastName.hashCode(), 4) ^
            Integer.rotateLeft(caDob.hashCode(), 5) ^
            Integer.rotateLeft(caHouseName.hashCode(), 6) ^
            Integer.rotateLeft(caHouseNum.hashCode(), 7) ^
            Integer.rotateLeft(caPostcode.hashCode(), 8) ^
            Integer.rotateLeft(Integer.hashCode(caNumPolicies), 9) ^
            Integer.rotateLeft(caPhoneMobile.hashCode(), 10) ^
            Integer.rotateLeft(caPhoneHome.hashCode(), 11) ^
            Integer.rotateLeft(caEmailAddress.hashCode(), 12) ^
            Integer.rotateLeft(caPolicyData.hashCode(), 13);
    }
    
    public int compareTo(CaCustomerRequest that) {
        int c = 0;
        c = super.compareTo(that);
        if ( c != 0 ) return c;
        c = this.caFirstName.compareTo(that.caFirstName);
        if ( c != 0 ) return c;
        c = this.caLastName.compareTo(that.caLastName);
        if ( c != 0 ) return c;
        c = this.caDob.compareTo(that.caDob);
        if ( c != 0 ) return c;
        c = this.caHouseName.compareTo(that.caHouseName);
        if ( c != 0 ) return c;
        c = this.caHouseNum.compareTo(that.caHouseNum);
        if ( c != 0 ) return c;
        c = this.caPostcode.compareTo(that.caPostcode);
        if ( c != 0 ) return c;
        c = Integer.compare(this.caNumPolicies, that.caNumPolicies);
        if ( c != 0 ) return c;
        c = this.caPhoneMobile.compareTo(that.caPhoneMobile);
        if ( c != 0 ) return c;
        c = this.caPhoneHome.compareTo(that.caPhoneHome);
        if ( c != 0 ) return c;
        c = this.caEmailAddress.compareTo(that.caEmailAddress);
        if ( c != 0 ) return c;
        c = this.caPolicyData.compareTo(that.caPolicyData);
        return c;
    }
    
    @Override
    public int compareTo(Dfhcommarea1 that) {
        if (that instanceof CaCustomerRequest) {
            return this.compareTo((CaCustomerRequest)that);
        } else {
            int c = super.compareTo(that);
            // for compatibility with equals(), unequal objects shouldn't compare equal
            if ( c == 0 ) {
                return this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
            } else {
                return c;
            }
        }
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
        factory.incrementOffset(Dfhcommarea1.SIZE);
    }
    
    private static final StringField CA_FIRST_NAME = factory.getStringField(10);
    private static final StringField CA_LAST_NAME = factory.getStringField(20);
    private static final StringField CA_DOB = factory.getStringField(10);
    private static final StringField CA_HOUSE_NAME = factory.getStringField(20);
    private static final StringField CA_HOUSE_NUM = factory.getStringField(4);
    private static final StringField CA_POSTCODE = factory.getStringField(8);
    private static final ExternalDecimalAsIntField CA_NUM_POLICIES = factory.getExternalDecimalAsIntField(3, true);
    private static final StringField CA_PHONE_MOBILE = factory.getStringField(20);
    private static final StringField CA_PHONE_HOME = factory.getStringField(20);
    private static final StringField CA_EMAIL_ADDRESS = factory.getStringField(100);
    private static final StringField CA_POLICY_DATA = factory.getStringField(32267);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        super.getBytes(bytes, offset);
        CA_FIRST_NAME.putString(caFirstName, bytes, offset);
        CA_LAST_NAME.putString(caLastName, bytes, offset);
        CA_DOB.putString(caDob, bytes, offset);
        CA_HOUSE_NAME.putString(caHouseName, bytes, offset);
        CA_HOUSE_NUM.putString(caHouseNum, bytes, offset);
        CA_POSTCODE.putString(caPostcode, bytes, offset);
        CA_NUM_POLICIES.putInt(caNumPolicies, bytes, offset);
        CA_PHONE_MOBILE.putString(caPhoneMobile, bytes, offset);
        CA_PHONE_HOME.putString(caPhoneHome, bytes, offset);
        CA_EMAIL_ADDRESS.putString(caEmailAddress, bytes, offset);
        CA_POLICY_DATA.putString(caPolicyData, bytes, offset);
        return bytes;
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        super.setBytes(bytes, offset);
        caFirstName = CA_FIRST_NAME.getString(bytes, offset);
        caLastName = CA_LAST_NAME.getString(bytes, offset);
        caDob = CA_DOB.getString(bytes, offset);
        caHouseName = CA_HOUSE_NAME.getString(bytes, offset);
        caHouseNum = CA_HOUSE_NUM.getString(bytes, offset);
        caPostcode = CA_POSTCODE.getString(bytes, offset);
        caNumPolicies = CA_NUM_POLICIES.getInt(bytes, offset);
        caPhoneMobile = CA_PHONE_MOBILE.getString(bytes, offset);
        caPhoneHome = CA_PHONE_HOME.getString(bytes, offset);
        caEmailAddress = CA_EMAIL_ADDRESS.getString(bytes, offset);
        caPolicyData = CA_POLICY_DATA.getString(bytes, offset);
    }
    
    public int numBytes() {
        return SIZE;
    }
    
}
