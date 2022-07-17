package pl.scoreboard.worldcup.person;

import java.util.Date;
import java.util.Objects;

public class Staff extends Person {

    private double salary;
    private Date contractStartDate;
    private Date contractEndDate;
    private StaffRole staffRole;

    public Staff(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public void setStaffRole(StaffRole staffRole) {
        this.staffRole = staffRole;
    }

    public double getSalary() {
        return salary;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public StaffRole getStaffRole() {
        return staffRole;
    }

        @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Staff other = (Staff) o;
        boolean salaryCodeEquals = Double.compare(salary, other.getSalary()) == 0;
        boolean contractStartCodeEquals = (this.contractStartDate == null && other.getContractStartDate() == null) || (this.contractStartDate != null && this.contractStartDate.equals(other.contractStartDate));
        boolean contractEndCodeEquals = (this.contractEndDate == null && other.getContractEndDate()== null) || (this.contractEndDate != null && this.contractEndDate.equals(other.getContractEndDate()));
        boolean roleCodeEquals = (this.staffRole == null && other.getStaffRole() == null) || (this.staffRole != null && this.staffRole.equals(other.getStaffRole()));
        return salaryCodeEquals && contractStartCodeEquals && contractEndCodeEquals && roleCodeEquals && super.equals(o);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        if (Objects.nonNull(contractEndDate)) {
            result = prime * result + contractEndDate.hashCode();
        }
        if (Objects.nonNull(contractStartDate)) {
            result = prime * result + contractStartDate.hashCode();
        }
        if (Objects.nonNull(staffRole)) {
            result = prime * result + staffRole.hashCode();
        }
        return result;
    }
}
