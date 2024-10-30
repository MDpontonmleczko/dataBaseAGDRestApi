DataBase AGD REST API Documentation
===================================

Project Description
-------------------

The `DataBase AGD REST API` is a system designed to manage a database of home appliances. It allows users to create, read, update, and delete information about various appliances. The API provides access to these resources, facilitating integration with external applications or systems.

Running the Application
-----------------------

1.  **Dependencies Installation**: The application requires a Java environment and the Spring Boot framework.

2.  **Starting the Application**:

    `mvn spring-boot:run`

3.  **Environment Variable**: Optional settings can be configured in `application.properties`.

API Structure
-------------

### Model `Appliance`

The `Appliance` model represents a home appliance and contains the following fields:

-   `id` (int): Unique identifier for the appliance.
-   `item` (String): Name of the appliance.
-   `description` (String): Description of the appliance.
-   `item_value` (double): Value of the appliance.

### Endpoints

#### 1\. Retrieve Appliance by ID

-   **URL**: `/appliances/{id}`
-   **Method**: `GET`
-   **Parameters**:
    -   `id` (int): Identifier of the appliance.
-   **Description**: Returns the appliance with the specified ID.
-   **Responses**:
    -   `200 OK`: Appliance found, returns the `Appliance` object.
    -   `404 Not Found`: Appliance with the given ID does not exist.

#### 2\. Retrieve List of All Appliances

-   **URL**: `/appliances`
-   **Method**: `GET`
-   **Description**: Returns a list of all home appliances.
-   **Responses**:
    -   `200 OK`: Returns a list of `Appliance` objects.
    -   `404 Not Found`: No appliances found in the database.

#### 3\. Add a New Appliance

-   **URL**: `/addAppliance`
-   **Method**: `POST`
-   **Body** (JSON):

    `{
    "item": "string",
    "description": "string",
    "item_value": "double"
    }`

-   **Description**: Adds a new appliance to the database.

-   **Responses**:

    -   `200 OK`: Returns the added `Appliance` object.

#### 4\. Delete Appliance by ID

-   **URL**: `/delete/{id}`
-   **Method**: `DELETE`
-   **Parameters**:
    -   `id` (int): Identifier of the appliance.
-   **Description**: Deletes the appliance with the specified ID.
-   **Responses**:
    -   `200 OK`: Appliance deleted successfully.
    -   `404 Not Found`: Appliance with the given ID does not exist.

#### 5\. Update Appliance by ID

-   **URL**: `/update/{id}`
-   **Method**: `PATCH`
-   **Parameters**:
    -   `id` (int): Identifier of the appliance.
-   **Body** (JSON):

    `{
    "item": "string",
    "description": "string",
    "item_value": "double"
    }`

-   **Description**: Updates the data of the appliance with the specified ID.
-   **Responses**:

    -   `200 OK`: Returns the updated `Appliance` object.
    -   `404 Not Found`: Appliance with the given ID does not exist.
