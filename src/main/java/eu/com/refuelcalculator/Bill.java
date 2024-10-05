package eu.com.refuelcalculator;

import java.time.LocalDate;

public class Bill {

    private Integer litersRefueled;
    private LocalDate dateRefueled;
    
    public Integer getLitersRefueled() {
        return litersRefueled;
    }

    public void setLitersRefueled(Integer litersRefueled) {
        this.litersRefueled = litersRefueled;
    }

    public LocalDate getDateRefueled() {
        return dateRefueled;
    }

    public void setDateRefueled(LocalDate dateRefueled) {
        this.dateRefueled = dateRefueled;
    }
   
}