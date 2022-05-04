User-Account-System

Hello ！This is a simple backend project for an Account Management System based on Springboot 

In this project, APIs for user-lookup,user-registration and user-login are created. I am going to first create an account by calling user-registration API and then write two test cases in which both correct credentials and incorrect credentials are utilized to call user-login API respectively to show you that correct credentials work for login API and incorrect credentials do not


Technology stack: Springboot Web Framework，Mybatis，MySQL，Postman，IntelliJ

dependencies:
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.5.13</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.1.0</version>
		</dependency>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.5</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.2.62</version>
		</dependency>


Project Structure:


![1651668035(1)](https://user-images.githubusercontent.com/24584111/166683013-74d4e2ce-d44d-4e40-8927-41cf73ffff6b.png)


Steps:

1.create a springboot-based project 

![1651669528(1)](https://user-images.githubusercontent.com/24584111/166687272-c9266405-98ac-4240-a967-b1231e105106.png)

2.once the project is created,import dependencies mentioned above to pom.xml

![1651669793(1)](https://user-images.githubusercontent.com/24584111/166687920-c24d4c58-833e-43f5-8c2d-9f0ea8d7d0ec.png)

3.create database and table to store users' data

![1651675383(1)](https://user-images.githubusercontent.com/24584111/166706126-be62c88c-c4a9-498c-a243-0c1d07422149.png)

4.write functional codes and run project

![1651675624(1)](https://user-images.githubusercontent.com/24584111/166707028-cd230eaa-2f6c-42f3-bc08-94407b28b064.png)

5.call register API to create an account using Postman and check if it is sucessfully persisted into database

![1651675734(1)](https://user-images.githubusercontent.com/24584111/166707586-bacf206a-2051-4fbf-aa2f-122a12ff3f03.png)

![1651675822(1)](https://user-images.githubusercontent.com/24584111/166707747-aa393dfa-4f77-41be-b2dd-1a8c17659ecf.png)

6.call login API using created account and invalid account to verify that login API works as expected(returning 32-bit token for the created account and error for invalid account)

result for valid account

![1651676054(1)](https://user-images.githubusercontent.com/24584111/166708735-e99f6fdb-7c8e-4c7d-bcfc-1dc7368ad801.png)

result for invalid account

![1651676158(1)](https://user-images.githubusercontent.com/24584111/166709115-358e7a3a-36c4-4b1e-8521-43f07b81cab4.png)


7.write test cases using TestNG for login API

logic of login API：

![1651676281(1)](https://user-images.githubusercontent.com/24584111/166709401-659e2ff0-ab19-4504-b8a4-a93bb475a213.png)


test cases：

![1651676394(1)](https://user-images.githubusercontent.com/24584111/166709719-9d4ba61c-67e7-40e8-a5d3-24701ab88b13.png)




