plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.tradesoft"
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
}

dependencies {
	implementation("org.jetbrains:annotations:24.0.0")
    compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	implementation("org.springframework.boot:spring-boot-starter-validation:3.2.0")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.0.4")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.2.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring30x:4.11.0")
	testImplementation("org.wiremock:wiremock:3.2.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
