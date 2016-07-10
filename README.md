# add a new branch 'user-core' for maven-hello

mvn compile
mvn clean test
mvn package
mvn install

mvn repository: ~\.m2\repository

<localRepository>/path/to/local/repo</localRepository>

mvn archetype:generate <-DgroupId=[]><-DartifactId=[]><-Dversion=[]>
mvn help:describe -Dplugin=<plugin_name> -Dgoal=<goal> -Ddetail=true

eclipse\STS initial maven jar fail solution:
$IDE_HOME$/plugins/org.eclipse.m2e.maven.runtime_1.7.0.20160603-1931/jars/maven-settings-builder-3.3.9.jar