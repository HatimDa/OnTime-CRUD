# CRUD Operations for the Time Scheduler App

---

#### Setup and Requirements:

1. IDE : Inteliji
2. 👇🏽 JDK Version Used on the Project (v8) , it's a must to use this version otherwise you will receive problem with mysql connector 

(https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

3. 👇🏽 Hibernate Library + MySQL Connector 

(https://drive.google.com/drive/folders/1mak3fOojSJhwfHLNnfRCnFtx_nUON9Ky?usp=sharing)

---

#### Architecture:

- The decision behind using Hibernate Framework because it will save us a lot of time and lines of code for mapping our DB to the Java Code it will minimise the amount of sql code we should write to insert or retrieve an object from the db.

![Hibernate - Java Architecture](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ecae2524-ee22-446a-b8dd-49fbd67eb63c/DB_App_Architecture.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210201T012146Z&X-Amz-Expires=86400&X-Amz-Signature=75cadad93e6870f3b45bc5ce9929050228607993dba023bcb49fb273f6cd73eb&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22DB_App_Architecture.png%22)


- Hibernate provides the Object-to-Relational Mapping (ORM)
We tell hibernate how our Java Class or Object maps to the Data inside the Database, we gonna map our Class into a given Database Table. We can setup this mapping via a config file like XML or Java Annotations but i used the java annotation for the mapping

![DB Mapping](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c9305398-77ba-443d-a261-17a7a9342235/DB-Mapping.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210201T015507Z&X-Amz-Expires=86400&X-Amz-Signature=a4519b3dbe7d878de9941ba29b4564392ae95a40d06376a7d2a0aca4ea6d2850&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22DB-Mapping.png%22) 


- All Tables should be mapped to the Database to perform the CRUD Functionalities - (EER Diagram)

![EER Diagram for the Time Scheduler](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/326f92d0-3326-4b71-9241-c163bf537c61/Screenshot_2021-02-01_at_02.37.51.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210201T020026Z&X-Amz-Expires=86400&X-Amz-Signature=86f68128d053bdf90678a490d0846c6d3faf2f3d727240a8b5e7831b8f9d6226&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_2021-02-01_at_02.37.51.png%22)

---

- All the CRUD functionalities are on the package "com.ontime.crudoperations"
- The Mapping on the other hand is on "com.ontime.dbmapping" only for the User table the others are on the way.

![Mapping](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d42f56af-ab3d-4f5d-b4ce-d44f2e5bfc1e/Screenshot_2021-02-01_at_03.17.11.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210201T021740Z&X-Amz-Expires=86400&X-Amz-Signature=281db690f5795c5bcc51c3af6dca7c34b9530230bcbdbdde9436e48b51f18fc7&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_2021-02-01_at_03.17.11.png%22)

## PS: 👋🏻 The code is not finished yet but I will be working on it today and tomorrow.
