## Installation

1. Make shure you have eclipse neon and jdk 1.8 
2. Make sure you have tomcat 8.5.11
3. Import in eclipse projects from git > clone uri > import as general Project
4. Right Click on project and configure to Maven Project
5. Right click on properties of project go to java build path Make sure your build path is configured to include JDK 1.8
  * In build Path Remove all Sources and SRC as your source
6. In the properties > Project Facets Make sure All the following are checked: 
  * dymanic web module version 2.5
  * Java 1.8 
  * javaServer faces 2.2
7. In the properties> Deployment Assembly Make sure to add maven Dependency Simply :
   * ADD > Java Build Path Entries > Maven Dependencies

## Deployment
After Configuring Just Right Click run As > run on server. Choose the server you installed and ther program will run
   
