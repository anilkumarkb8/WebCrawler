# WebCrawler
Application created to demonstrate the web crawler behavior.

This webCrawler application is written using Jsoup library. When user supplies the input url for crawling, application does deep crawling in the supplied domain to retrieve all the URLs used in all the pages. The links which leads to external domain will not be crawled by this application.

The URL provided by user is considered as the base domain for validating the fetched links for crawling.

In this application we have also implemented validation of URL supplied by user using the regular expression. And also crawling is not performed on the links which are for javascrpt, image and css files. This is done by validating the results fetched by crawling of the url and if the result is of any of the above types, then no further crawling will be done on them.

Future enhancements:
	** At present only basic html page is written for input and output pages. This will be enhanced to rich html pages with better look and feel.
	** Adding the database to the account to store the crawling results fetched for supplied URL. With this if we have already crawled through any of the URL, then it will be displaying the results from the database itself.
	** Automating the build by configuring the project on Jenkins, which will deploy the application war file on remote server directly when war is built successfully.
	** Specifying the limit for crawling, which will limit the number of deep crawling done on the supplied URL.
	** Moving the current regular expression based url validation to validate it by connecting to the server to see if it is the right URL
	** Allowing users to specify type of data(image, javascript, etc..) to be fetched from crawling.
	
#System Prerequisites for setting up the project

	* Java -- 1.8 Release
	* Maven -- 3.3.9 Release   
	* STS -- 3.8.1 Release (you can use any IDE of your choice)
	* Git -- To clone the appication into your local system.
			In the IDE, Maven plugin needs to be installed for ease of working and also tomcat needs to be installed inorder to deploy and run the application.
	
	P.S: If you need any help with above setups, please refer the installation documentation available online on their official websites.
	
#To Build 
	Once the application is cloned into the local, you can either import it into your IDE by selecting the File -> Import.. -> Maven -> Existing Maven Projects. And then navigate the project folder and the project will be imported.
	
	Further editing or customization can be done once it is imported into the IDE.
	
	If you just need to build the war file to deploy it on tomcat directly and run, then maven can be used to perform that. Navigate to the project folder where pom.xml file will be present, and run any of the following commands on to build the war file.
	
	mvn clean install (to clean and build and project)

	mvn clean install -Dmaven.test.skip=true (to build project with skipping test class)

	mvn -Dtest=CrawlerServiceTest.java test  (to run independant test class)
	
	
