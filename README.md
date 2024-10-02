# My Calculator
 
 
## Business Request 
 
1. The `Calculator` supports fundamental operations (addition, subtraction, multiplication, and division).
2. Operations can be performed in sequence.
3. The design follows the Open-Closed Principle, enabling the addition of new operations without altering the `Calculator` class.
4. Division by zero is managed gracefully by raising an `ArithmeticException`.

 
## Requisites
- Java 17
- Spring boot test 3.x
- Spring context 6.x
- JUnit
- Mockito


## How to Run
1. Clone the repository.
2. install Java and Apache Maven or use IDE to run.
3. Run the tests using `mvn test` or your preferred testing framework.
4. Use the `Calculator` class to perform basic or chained operations.

## Version iteration

folder `better` is a better version of folder `original` :
 
* **Inversion of Control**: The `Calculator` class no longer dictates which operation to use. Instead, it leverages an IoC container (like Spring) to inject the appropriate `OperationStrategy` implementations at runtime.
* **Loose Coupling**: The calculator can seamlessly integrate new operations by injecting them through a `Map<Operation, OperationStrategy>`, without modify the core logic of the `Calculator` class.
* **Testability**: Testing is simplified as different strategies can be mocked or injected during unit testing, allowing for more flexible and comprehensive testing setups.
  
 
## Future Improvements
- **Expanded Operator and Numeric Type Support**: Introduce additional operators and support for various numeric types, enhancing the calculator's versatility and functionality.
- **Monitoring and Logging**: Implement comprehensive monitoring and logging capabilities to print detailed logs, facilitating easier debugging and performance tracking.
- **Edge Case Bug Fixes**: Address and resolve bugs related to edge cases, ensuring the calculator operates reliably under all conditions.
- **Resiliency Enhancements**: Improve the system's resiliency by incorporating rate limiting, implementing retry mechanisms, and enabling multithreading to handle concurrent operations more efficiently.
