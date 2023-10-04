plugins {
	java
	id("org.springframework.boot") version "3.2.0-M3"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.springusers.rest.webservices"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	// SpringBoot
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	// Swagger and openApi
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	runtimeOnly("com.h2database:h2")
	// Lombok helper dep
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	// Hateoas
	implementation("org.springframework.hateoas:spring-hateoas")
	// SpringBoot test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
