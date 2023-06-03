package org.acme.simplequarkusapps.loancalculator.models;

import static java.time.temporal.ChronoUnit.WEEKS;

public class LoanMine {
    //fields
    private double principal;
    private double ratePerMonth;
    private int loanTimeIntervals;//the loan will be in weeks or months or days or years
    private int loanTime;//how many are the loanTimeIntervals ie 2 weeks or 2 days etc
    private int interval;//payment schedules how much you are paying every week or month or day or year
    private double totalInterestOverLoanSpan;//total interest accumulated and to be paid all together at the end of the loan span
    private double totalAmountToBePaidOverLoanSpan;//this indicates the total amount ie principal plus interest over the whole period
    private double payPerShedule;//if you have to pay per week or per month or per day or years
    private String manInterval;

    //constructors
    public LoanMine() {
    }

    public LoanMine(double principal, double ratePerMonth, int loanTimeIntervals, int loanTime, int interval, double totalInterestOverLoanSpan, double payPerShedule, double totalAmountToBePaidOverLoanSpan, double manInterval) {
        this.principal = principal;
        this.ratePerMonth = ratePerMonth;
        this.loanTimeIntervals = loanTimeIntervals;
        this.loanTime = loanTime;
        this.interval = interval;
        this.totalInterestOverLoanSpan = totalInterestOverLoanSpan;
        this.payPerShedule = payPerShedule;
        this.totalAmountToBePaidOverLoanSpan = totalAmountToBePaidOverLoanSpan;
        this.manInterval = String.valueOf(manInterval);
    }

    //getters and setters

    public void setManInterval(String manInterval){
        this.manInterval = manInterval;
    }
    public String getManInterval(){
        return manInterval;
    }

    public void setPayPerShedule(double payPerShedule) {
        this.payPerShedule = payPerShedule;
    }

    public double getPayPerShedule() {
        return payPerShedule;
    }

    public void setTotalAmountToBePaidOverLoanSpan(double totalAmountToBePaidOverLoanSpan) {
        this.totalAmountToBePaidOverLoanSpan = totalAmountToBePaidOverLoanSpan;
    }

    public double getTotalAmountToBePaidOverLoanSpan() {
        return totalAmountToBePaidOverLoanSpan;
    }

    public void setTotalInterestOverLoanSpan(double totalInterestOverLoanSpan) {
        this.totalInterestOverLoanSpan = totalInterestOverLoanSpan;
    }

    public double getTotalInterestOverLoanSpan() {
        return totalInterestOverLoanSpan;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setRatePerMonth(double ratePerMonth) {
        this.ratePerMonth = ratePerMonth;
    }

    public double getRatePerMonth() {
        return ratePerMonth;
    }

    public void setLoanTimeIntervals(int loanTimeIntervals) {
        this.loanTimeIntervals = loanTimeIntervals;
    }

    public int getLoanTimeIntervals() {
        return loanTimeIntervals;
    }

    public void setLoanTime(int loanTime) {
        this.loanTime = loanTime;
    }

    public int getLoanTime() {
        return loanTime;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }

    //calculations begin


    public void calculateTotalInterestOverLoanSpan() {
        if (loanTimeIntervals == 1) {
            this.totalInterestOverLoanSpan = this.principal * (this.ratePerMonth / 100) * (this.loanTime / (4.345 * 7));
            this.totalAmountToBePaidOverLoanSpan = this.principal + this.totalInterestOverLoanSpan;
            if (interval == 1 ) {
                this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime);
            } else if (interval == 2) {
                if (loanTime >= 7) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime / 7);
                }else{}
            } else if (interval == 3) {
                if (loanTime >= 30) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime / 30);
                }
            } else if (interval == 4) {
                if (loanTime >= 365) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime / 365);

                }

            }

        } else if (loanTimeIntervals == 2) {
            this.totalInterestOverLoanSpan = this.principal * (this.ratePerMonth / 100) * (this.loanTime / 4.345);
            this.totalAmountToBePaidOverLoanSpan = this.principal + this.totalInterestOverLoanSpan;
            if (interval == 1 ) {
                if (loanTime >= 1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime * 7);
                }
                } else if (interval == 2) {
                if (loanTime >= 1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime);
                }
            } else if (interval == 3) {
                if (loanTime > 4) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime / 4.345);
                }
            } else if (interval == 4) {
                if (loanTime > 52) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime / 52);

                }

            }
        } else if (loanTimeIntervals == 3) {
            this.totalInterestOverLoanSpan = this.principal * (this.ratePerMonth / 100) * this.loanTime;
            this.totalAmountToBePaidOverLoanSpan = this.principal + this.totalInterestOverLoanSpan;
            if (interval == 1 ) {
                if (loanTime >= 1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime * 30);
                }
            } else if (interval == 2) {
                if (loanTime >= 1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime*4.345);
                }
            } else if (interval == 3) {
                if (loanTime >=1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime);
                }
            } else if (interval == 4) {
                if (loanTime >= 12) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime / 12);

                }

            }
        } else if (loanTimeIntervals == 4) {
            this.totalInterestOverLoanSpan = this.principal * (this.ratePerMonth / 100) * (this.loanTime * 12);
            this.totalAmountToBePaidOverLoanSpan = this.principal + this.totalInterestOverLoanSpan;
            if (interval == 1 ) {
                if (loanTime >= 1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime * 365);
                }
            } else if (interval == 2) {
                if (loanTime >= 1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime*52);
                }
            } else if (interval == 3) {
                if (loanTime >=1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime*12);
                }
            } else if (interval == 4) {
                if (loanTime >= 1) {
                    this.payPerShedule = this.totalAmountToBePaidOverLoanSpan / (this.loanTime);

                }

            }
        }


    }
}
