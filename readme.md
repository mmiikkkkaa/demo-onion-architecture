# Architecture demo - Healthy Pizza

## Basic information

This project shows how an architecture with Onion Architecture (but also other clean architecture types) could look like.

The main focus is on
- what is implemented in which layer
- different types of validation

### Scenario

The used scenario is a simple one: a healthy pizza delivery service, which offers pizza for persons suffering from food allergy. For each pizza different allergens can be mentions and the ingredients (base and toppings) are checked for not containing that allergens.

### Use cases
There are several use cases, but the most clear is ordering a pizza.

## Implementations

### Architecture
As stated an Onion Architecture style is used, but it can also be applied to other clean architectures, like Hexagonal/Ports&Adapters.

These are the layers/rings:
The innermost layer is the domain model. The model already contains a lot of domain logic, by defining what a valid model looks like.


The domain model is surrounded by domain services, which realize domain logic, which covers the interaction of several objects of the domain model. The domain layers/rings doesn't contain any infrastructure information.

Within Domain layers/rings not primitive data types should be used, every value should live in a wrapper class, which encapsulates the value, so

Around the domain services are the application services, which realize the use cases and orchestrate the application logic: what actually happens within the application. Also, retrieval of values from other sources is done here and are provided to domain services - no domain service should care about where values are taken from. Any permissions handling takes place here, too.

Around the application services are different infrastructure integrations, e.g. rest controllers and database handling.

## Validations
Different types of validation take place at different layers.

The most important validation is within the domain model ring. The model should guarantee, that is valid **all the time**. There should be no way of creating an invalid domain model object, which e.g. contains conflicting values.

Also, the application services ring contains validation, but this is more like checking whether certain conditions are matched, like whether used resources exist or whether permissions are granted.

And also the infrastructure rings do validation, but only the slightest one: do incoming requests have the correct format, are mandatory values provided and are provided values within sensible borders.