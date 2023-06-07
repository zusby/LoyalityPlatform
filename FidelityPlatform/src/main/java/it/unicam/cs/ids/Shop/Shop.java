package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.Model.*;
import it.unicam.cs.ids.Model.Rules.CashBackRule;
import it.unicam.cs.ids.Model.Rules.CouponRule;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import it.unicam.cs.ids.Model.Rules.PointsRule;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Shop {

    private String id;
    private String vatNumber;
    private String name;
    private List<String> shopOwners;
    //private List<FidelityProgram> fidelityPrograms = new ArrayList<>();

    private CashBackRule cashBackRule;
    private CouponRule couponRule;
    private LevelsRule levelsRule;
    private PointsRule pointsRule;

    private PrizeAwards prizes;
    private FidelitySpace space;
    private Catalogue catalogue;
    private List<String> employees = new ArrayList<>();

    public Shop(String id, Address shopAddress, String vatNumber, String name, String shopTelephoneNumber, List<String> shopOwnerIDs) {
        this.id = id;
        this.vatNumber = vatNumber;
        this.name = name;
        this.shopOwners = shopOwnerIDs;
        this.space= new FidelitySpace();
        space.setShopAddress( shopAddress);
        space.setShopTelephoneNumber(shopTelephoneNumber);
    }

    public Shop(){
    }


    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    public PrizeAwards getPrizes() {
        return prizes;
    }
    public void setPrizes(PrizeAwards prizes) {
        this.prizes = prizes;
    }
    public FidelitySpace getSpace() {
        return space;
    }
    public void setSpace(FidelitySpace space) {
        this.space = space;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<String> getShopOwners() {
        return this.shopOwners;
    }
    public void setShopOwners(List<String> owners) {
        this.shopOwners = owners;
    }
    public String getVatNumber() {
        return vatNumber;
    }
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Catalogue getCatalogue() {
        return catalogue;
    }
    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public void addEmployee(String employee){
        this.employees.add(employee);
    }
    public void removeEmployee(String employee){
        this.employees.remove(employee);
    }
    public CashBackRule getCashBackRule() {
        return cashBackRule;
    }

    public void setCashBackRule(CashBackRule cashBackRule) {
        this.cashBackRule = cashBackRule;
    }

    public CouponRule getCouponRule() {
        return couponRule;
    }

    public void setCouponRule(CouponRule couponRule) {
        this.couponRule = couponRule;
    }

    public LevelsRule getLevelsRule() {
        return levelsRule;
    }

    public void setLevelsRule(LevelsRule levelsRule) {
        this.levelsRule = levelsRule;
    }

    public PointsRule getPointsRule() {
        return pointsRule;
    }

    public void setPointsRule(PointsRule pointsRule) {
        this.pointsRule = pointsRule;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "cashBackRule=" + cashBackRule +
                ", catalogue=" + catalogue +
                ", couponRule=" + couponRule +
                ", employees=" + employees +
                ", id='" + id + '\'' +
                ", levelsRule=" + levelsRule +
                ", name='" + name + '\'' +
                ", pointsRule=" + pointsRule +
                ", prizes=" + prizes +
                ", shopOwners=" + shopOwners +
                ", space=" + space +
                ", vatNumber='" + vatNumber + '\'' +
                '}';
    }
}
