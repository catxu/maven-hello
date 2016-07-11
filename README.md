# maven-hello

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

依赖传递和 scope 作用域：
compile test runtime provided(在打包发布时不会导入)
作用域为 test 的包不会进行依赖传递
!important:
当依赖级别相同时，pom 文件中谁写在前面就加载谁；
**********不同时，谁的依赖层级少就加载谁：如下，service 应加载 log 中的 commons-logging
service -> user-core -> dbunit -> commons-logging
service -> log -> commons-logging

依赖排除：
<exclusions>
	<exclusion>
		<groupId></groupId>
		<artifactId></artifactId>
	</exclusion>
</exclusions>

聚合
<modules>
	<module>../user-core</module>
	<module>../user-log</module>
</modules>
继承
<parent>
	<groupId>${project.groupId}</groupId>
	<artifactId>user-parent</artifactId>
	<version>${project.version}</version>
	<relativePath>../user-parent/pom.xml</relativePath>
</parent>

maven 隐藏变量：
${project.xxx} 当前 pom 文件中任意节点的内容

1. 创建mock对象 
	UserDao userDao  = Easymock.createMock(UserDao.class);	//泛型 & 动态代理，返回的是 UserDao 对象
 
2. 记录mock对象期望的行为
	Easymock.expect(userDao.getById("1001")).andReturn(expectedUser);
	这里记录了mock对象的行为：getById()方法被调用，调用次数为1(easymock之中如果没有明确指出调用次数，默认为1),参数为"1001"，expectedUser将作为返回值。

3. 进入replay阶段
	Easymock.replay(userDao);

4. 对mock对象执行验证
	Easymock.verify(userDao);


配置本地私有仓库：
<profiles>
<profile>
<id>nexusRepository</id>
<repositories>
	<repository>
		<id>nexus</id>
		<name>Nexus repository</name>
		<url>http://localhost:8081/xxx</url>	<!-- group/hosted/proxy/virtual -->
		<releases>
			<enabled>true</enabled>
		</releases>
		<snapshots>
			<enabled>true</enabled>
		</snapshots>
	</repository>
</repositories>
</profile>
</profiles>
<activeProfiles>
	<activeProfile>nexusRepository</activeProfile>
</activeProfiles>

配置仓库镜像(让所有jar包都从本地url去下载)
<mirrors>
	<mirror>
		<id>nexusMirror</id>
		<mirrorOf>nexus,central</mirrorOf>
		<name>xxx</name>
		<url></url>
	</mirror>
</mirrors>