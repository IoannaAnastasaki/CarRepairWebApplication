package com.example.CarRepair.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class NewRepairForm {


    private static final String TAX_PATTERN = "\\d\\d\\d\\d\\d\\d\\d\\d\\d";
    private static final int TAXNO_SIZE = 9;

    private static final String PLATE_PATTERN = "[A-Z][A-Z][A-Z]\\-[1-9][0-9][0-9][0-9]";
    private static final int PLATE_SIZE = 8;

    private static final String MONEY_PATTERN = "[0-9]+([.][0-9]{1,2})?";

    //some field like tax number email and password must not be null by our database
    //size gives us the max and min size so we check the size of our input
    @NotNull(message = "{newRepair.taxno.null}")
    @Pattern(regexp = TAX_PATTERN, message = "{newRepair.taxno.invalid}")
    @Size(min=TAXNO_SIZE, max=TAXNO_SIZE, message = "{newRepair.taxno.size}")
    private String taxNumber;

    @Pattern(regexp = PLATE_PATTERN, message = "{newRepair.plate.invalid}")
    @Size(min=PLATE_SIZE, max=PLATE_SIZE, message = "{newRepair.plate.size}")
    private String plateNumber;

    private String description;

    /*String string = "2011-03-22";
     * Date date = new SimpleDateFormat("yyyy-MM-dd").parse(string);
     */
    private String repairDate;

    private String repairStatus;

    private String repairType;

    @Pattern(regexp = MONEY_PATTERN, message = "{newRepair.plate.invalid}")
    private String cost;

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
