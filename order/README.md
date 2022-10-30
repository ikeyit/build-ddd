#  DDD-oriented microservice 
DDD (Domain-Driven Design) is a powerful approach to tackle business complexity, but how to apply it in real world is
not so obvious! Maybe you can find some clues in the project, which shows how a layered design is implemented for order 
microservice.
## Tech stack
Spring Boot + gradle
### subprojects
- order-domain：Domain model layer, where to define entity, aggregate root, value object, domain service and implement 
business logic.
- order-application: Application layer orchestrates domain layer as a facade.
- order-infrastructure：Implement data persistence, publish message to mq and communicate with other microservice. The layer
transfers domain data to the downstream system/infrastructure.
- order-interfaces: Implement the interfaces to interact with the upstream system. e.g. rest api, grpc, mq consumer, and 
task scheduler.
- order-sdk: The sdk to facilitate other microservice calling order microservice