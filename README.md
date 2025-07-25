# Fidelity Platform KA

A Java SpringBoot backend ideal for small to medium Stores meant to:

- Retain the current customers
- Increase income
- Gain new Customers
- Instantly deploy and manage multiple Stores and E-commerces

A front end for the services is available at [Back Office Front End](https://github.com/zusby/FidelityPlatformFE) and [Front Office Front End](https://github.com/zusby/FidelityPlatformFEClient), both of them are reactive minimalistic and lightweight, see their rispective README for more info.
 
## Prerequisites

To initialize the FireStore Database and the FireStore Authentication service it is necessary to modify accordingly the followings classes:

- FireStoreInitializer.java
- AuthenticationController.java
- insert your own FireBase SDK Admin API json file in the main folder of the project
- add `stripe-api-key` to your application.properties
- Setup Stripe's webhook trough [Stripe CLI](https://stripe.com/docs/stripe-cli/overview?locale=it-IT)

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
           
```

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

## Authors

- [@Kacper Henryk Osicki](https://github.com/zusby)
- [@Anthony Eleuteri](https://github.com/AnthonyEleuteri)
