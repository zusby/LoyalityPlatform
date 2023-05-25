
# Fidelity Platform KA
A Java SpringBoot backend meant to:
- Retain the current customers
- Increase income
- Gain new Customers   


## Prerequisites

To initialize the FireStore Database and the FireStore Authentication service it is necessary to modify accordingly the followings classes: 
- FireStoreInitializer.java 
- AuthenticationController.java
- 
-insert your own FireBase SDK Admin API credencials.
## API Reference

All the api references are available @Swagger_UI and or trough the java docs.

```
📦         └─ resources
            |  ├─ application.properties
            |  └─ google-services.json
            └───it.unicam.cs.ids
            │              ├─ Admin
            │              │  ├─ Admin.java
            │              │  ├─ AdminController.java
            │              │  └─ AdminService.java
            │              ├─ Coupon
            │              │  ├─ Coupon.java
            │              │  ├─ CouponController.java
            │              │  └─ CouponService.java
            │              ├─ Customer
            │              │  ├─ Customer.java
            │              │  ├─ CustomerController.java
            │              │  └─ CustomerService.java
            │              ├─ Database
            │              │  ├─ AuthenticationController.java
            │              │  ├─ DBManager.java
            │              │  └─ FireBaseInitializer.java
            │              ├─ DemoApplication.java
            │              ├─ Employee
            │              │  ├─ Employee.java
            │              │  ├─ EmployeeController.java
            │              │  └─ EmployeeService.java
            │              ├─ FidelityCard
            │              │  ├─ FidelityCard.java
            │              │  ├─ FidelityCardController.java
            │              │  └─ FidelityCardService.java
            │              ├─ Model
            │              │  ├─ Address.java
            │              │  ├─ AuthenticatedUser.java
            │              │  ├─ FidelityProgram.java
            │              │  ├─ Item.java
            │              │  ├─ Level.java
            │              │  ├─ PrizeAwards.java
            │              │  ├─ Purchase.java
            │              │  ├─ Role.java
            │              │  ├─ RuleApplier.java
            │              │  ├─ Rules
            │              │  │  ├─ CashBackRule.java
            │              │  │  ├─ CouponRule.java
            │              │  │  ├─ LevelsRule.java
            │              │  │  └─ PointsRule.java
            │              │  └─ User.java
            │              ├─ Shop
            │              │  ├─ Shop.java
            │              │  ├─ ShopController.java
            │              │  └─ ShopService.java
            │              └─ ShopOwner
            │                 ├─ ShopOwner.java
            │                 ├─ ShopOwnerController.java
            │                 └─ ShopOwnerService.java
           





[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

## Authors

- [@Kacper Henryk Osicki](https://github.com/zusby)
- [@Anthony Eleuteri](https://github.com/AnthonyEleuteri)

