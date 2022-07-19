# :wave: Welcome to hexagonal arch (ports & adapters)!

Hi Folks ! **Exploring** the hexagonal architecture with this project. a vanilla bank account management 
application.
Focused on the hexagonal architecture period.

# What is hexagonal architecture
Hexagonal architecture is a model of **designing software applications around domain logic** to isolate it from external factors.

The domain logic is specified in a business core, which we'll call the inside part, the rest being outside parts. Access to domain logic from the outside is available through ports and adapters. [from](https://www.baeldung.com/hexagonal-architecture-ddd-spring)

In other words  it's basically encapsulating the business logic in the core package, entities, use case implementation and provide **ports** (interfaces) that will be used to apply a certain use case.

for interaction with providers like persistence we should  also declare a persistence port.

than in application layer **adapters** we will provide the implementations like entity, services and repo calls;
please check what we did with [persistence port](https://github.com/aminjellali/account/blob/master/src/main/java/com/bank/account/core/ports/persistence/AccountPersistancePort.java) and it's [implementation](https://github.com/aminjellali/account/blob/master/src/main/java/com/bank/account/persistance_adapter/AccountPersistancePortImpl.java) 

Thanks to such implementation we can easily add for example an interaction command line layer just like http_controllers.

Due to the simplicity of the project we did not implement POJOs or DTOs for each layer, but one of the down sides of this architecture besides having many classes are Dtos and mappers for simplicity we actually implemented a [util mapping class](https://github.com/aminjellali/account/blob/master/src/main/java/com/bank/account/dto_utils/MapperUtilClass.java)
But on a bigger scale it's recommended to use multiple Pojos Dtos for each layer. (Working 10h a day and on week ends not an option :stuck_out_tongue_winking_eye:).
But hey spaghetti code :sob: is history :heart_eyes:

While learning how this architecture is implemented I projected back on many projects I worked on where this logic is a perfect option to insure maintainability, test-ability and ease to migrate, upgrade dependencies etc.. as we decoupled not only the b-logic but also the frameworks and dependencies :heartbeat:.

A candidate for my trading bot project don't hesitate to contact me if you wanna contribute [Amin JELLALI](mailto:a.j.aminjellali@gmail.com)
 
# Project requirements
- mvn 3.6.3
- mysql db (password not secured change app properties.)
- java 11
- spring 2.7.1