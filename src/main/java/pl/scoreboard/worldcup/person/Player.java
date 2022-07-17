package pl.scoreboard.worldcup.person;

import java.util.Date;
import java.util.Objects;

public class Player extends Person {

    private double salary;
    private Date contractStartDate;
    private Date contractEndDate;
    private PlayerRole playerRole;
    private int number;

    public Player(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public double getSalary() {
        return salary;
    }

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }


    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =  super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        if (Objects.nonNull(contractEndDate)) {
            result = prime * result + contractEndDate.hashCode();
        }
        if (Objects.nonNull(contractStartDate)) {
            result = prime * result + contractStartDate.hashCode();
        }
        if (Objects.nonNull(playerRole)) {
            result = prime * result + playerRole.hashCode();
        }
        result = prime * result + number;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Player other = (Player) obj;
        boolean salaryCodeEquals = Double.compare(salary, other.getSalary()) == 0;
        boolean contractStartCodeEquals = (this.contractStartDate == null && other.getContractStartDate() == null) || (this.contractStartDate != null && this.contractStartDate.equals(other.contractStartDate));
        boolean contractEndCodeEquals = (this.contractEndDate == null && other.getContractEndDate()== null) || (this.contractEndDate != null && this.contractEndDate.equals(other.getContractEndDate()));
        boolean roleCodeEquals = (this.playerRole == null && other.getPlayerRole() == null) || (this.playerRole != null && this.playerRole.equals(other.playerRole));
        boolean numberCodeEquals = this.number == other.getNumber();
        return salaryCodeEquals && contractStartCodeEquals && contractEndCodeEquals && roleCodeEquals && numberCodeEquals;
    }


}
