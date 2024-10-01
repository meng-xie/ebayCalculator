# Flexible Calculator


 
## Assumptions:
1. The `Calculator` supports basic operations (ADD, SUBTRACT, MULTIPLY, DIVIDE).
2. Operations can be chained sequentially.
3. The solution adheres to the Open-Closed Principle, allowing for new operations to be added without modifying the `Calculator` class.
4. Division by zero is handled gracefully by throwing an `ArithmeticException`.

## How to Run
1. Clone the repository.
2. Run the tests using `mvn test` or your preferred testing framework.
3. Use the `Calculator` class to perform basic or chained operations.

## IoC-Compatible

`v2` is a IoC-compatible version of `v1`:

* **Inversion of Control**: The `Calculator` class no longer directly controls which operation to use. Instead, it relies on the IoC container (Spring) to inject the correct `OperationStrategy` implementations at runtime.
* **Loose Coupling**: The calculator can work with any new operations simply by injecting them through the `Map<Operation, OperationStrategy>` without changing the core logic of the `Calculator` class.
* **Testability**: It’s easier to test because you can mock or inject different strategies during unit testing, enabling more flexible testing setups.
