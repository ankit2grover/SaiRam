
package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.kohls.mcommerce.opal.framework.vo.ErrorVO;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.io.Serializable;
import java.util.List;

public class ValidateOrderVO implements IValueObject, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2229481314151548002L;

    private List<ErrorVO> errors;

    private Payload payload;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload {
        private List<address> addresses;

        public List<address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<address> addresses) {
            this.addresses = addresses;
        }

    }

    public static class address {
        private String ID;

        private List<Fault> faults;

        public String getID() {
            return ID;
        }

        public void setID(String iD) {
            ID = iD;
        }

        public List<Fault> getFaults() {
            return faults;
        }

        public void setFaults(List<Fault> faults) {
            this.faults = faults;
        }
    }

    public static class Fault implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = -8061383731468723532L;

        private String message;

        private List<FaultItem> possibleValues ;

        public List<FaultItem> getPossibleValues() {
            return possibleValues;
        }

        public void setPossibleValues(List<FaultItem> possibleValues) {
            this.possibleValues = possibleValues;
        }

        private String code;

        private String invalidElementName;

        private String invalidValue;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }



        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getInvalidElementName() {
            return invalidElementName;
        }

        public void setInvalidElementName(String invalidElementName) {
            this.invalidElementName = invalidElementName;
        }

        public String getInvalidValue() {
            return invalidValue;
        }

        public void setInvalidValue(String invalidValue) {
            this.invalidValue = invalidValue;
        }

    }
    public class FaultItem implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = 4652648209326074027L;
        private String ID;
        private String name ;
        private String address ;
        public String getID() {
            return ID;
        }
        public void setID(String iD) {
            ID = iD;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
    }
}
