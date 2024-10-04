# Stream-FlatMap-Refuel-Calculator

---Project Goal:

The goal of this project is to calculate the total amount of fuel (in liters) refueled by each user within a specified date range.

---Input Specification:

The input is a list of maps (or dictionaries), where each map represents a user's fuel bills.

Each map contains:

User ID (String): A unique identifier for the user.

Fuel Bill (Bill): An object representing the details of the fuel transaction. 

This object include:
Liters (Integer): The amount of fuel (in liters) refueled in that transaction.

Date (Date): The date of the transaction to facilitate filtering by the specified date range.

---Output Specification:

The output is a map with the following structure:

User ID (String): The user's identifier.

Total Refueled Liters (Integer): The total number of liters of fuel refueled by that user within the specified date range.
