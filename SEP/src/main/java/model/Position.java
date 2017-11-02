package model;

public enum Position {
    CustomerService("Customer Service"),
    SeniorCustomerService("Senior Customer Service"),
    FinancialManager("Financial Manager"),
    AdministrationManager("Administration Manager"),
    ServiceManager("Service Manager"),
    HR("HR"),
    ProductionManager("Production Manager"),
    ServiceProductionStaff("Service & production staff"),
    AudioSpecialist("Production department audio specialist"),
    Photographer("Production department photographer"),
    Chef("Service department chef"),
    Waitress("Service department Waitress");


    private final String string;



    private Position(final String string){
        this.string = string;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
