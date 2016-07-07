package com.maven.catxu;

public class HelloMaven {
	public String sayHello(String name) {
		return "Hello " + name;
	}
}

// Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project maven-hello: Execution default-compile of goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile failed: Plugin org.apache.maven.plugins:maven-compiler-plugin:3.1 or one of its dependencies could not be resolved: Could not transfer artifact log4j:log4j:jar:1.2.12 from/to central (https://repo.maven.apache.org/maven2): GET request of: log4j/log4j/1.2.12/log4j-1.2.12.jar from central failed: Connection reset -> [Help 1]

// %JAVA_HOME%\bin