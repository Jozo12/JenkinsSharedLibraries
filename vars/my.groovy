def call(String mavenGoal){
	if ("${mavenGoal}" == "Clean")
	{
	sh "mvn clean"
	}
	else if ("${mavenGoal}" == "Package")
	{
	sh "mvn package"
	}
	else if ("${mavenGoal}" == "Test")
	{
	sh "mvn sonar:sonar"
	}
	else if ("${mavenGoal}" == "Backup")
	{
	sh "mvn deploy"
	}
	else if ("${mavenGoal}" == "deploytotomcat")
	{
    deploy adapters: [tomcat9(credentialsId: 'tomcat-cred2', path: '', url: 'http://35.88.83.206:8080/')], contextPath: null, war: 'target/*.war'
	}
}
