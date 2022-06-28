def call(String StageName){
	if ("${StageName}" == "Clean")
	{
	sh "mvn clean"
	}
	else if ("${StageName}" == "Package")
	{
	sh "mvn package"
	}
	else if ("${StageName}" == "Test")
	{
	sh "mvn sonar:sonar"
	}
	else if ("${StageName}" == "Backup")
	{
	sh "mvn deploy"
	}
	else if ("${StageName}" == "Deploy-to-Tomcat")
	{
	deploy adapters: [tomcat9(credentialsId: 'tomcat-cred2', path: '', url: 'http://35.88.83.206:8080/')], contextPath: null, war: 'target/*.war'
	}
}
