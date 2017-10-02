#!/usr/bin/env groovy

pipeline {
	agent any
	
	stages {
		def mvnHome = tool 'apache-maven-3.5.0'
	   //def mvnHome = tool 'M3'
	   stage('Checkout') { // for display purposes
	      git 'https://github.com/bennetelli/mule-demo.git'
	      // Get the Maven tool.
	      // ** NOTE: This 'M3' Maven tool must be configured
	      // **       in the global configuration.           
	      //mvnHome = tool 'M3'
	   }
	   stage('Build') {
	       sh "'${mvnHome}/bin/mvn' package -DskipTests=true"
	   }
	   stage('Unit Test (Transformers)') {
	       //${mvnHome}/bin/mvn test
	       // sh "'${mvnHome}/bin/mvn' test"
	       sh "'${mvnHome}/bin/mvn' cobertura:cobertura"
	   }
	   stage('Analyze') {
	
	   }
	   stage('Archive') {
	       
	   }
	   stage('Integration Test (Mule flows)') {
	       
	   }
	   stage('Deploy to Test') {
	       //sh "'${mvnHome}/bin/mvn' deploy"
	       sh "'${mvnHome}/bin/mvn' pre-integration-test -DskipTests=true"
	       //echo "ausgabe:"
	       //echo "tail -${MULE_HOME}/logs/mule.log"
	       //sleep(36000)
	        // Run the maven build
	      //if (isUnix()) {
	      //   sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
	      //} else {
	      //   bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
	      //}       
	   }
	    stage('Undeploy from Test') {
	       //sh "'${mvnHome}/bin/mvn' undeploy"
	       sh "'${mvnHome}/bin/mvn' post-integration-test -DskipTests=true"
	   }
	   stage('Check Code Quality') {
	       
	   }
	   stage('Results') {
	      //sh "'${mvnHome}/bin/mvn' cobertura:cobertura"
	      step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
	      junit '**/target/surefire-reports/TEST-*.xml'
	      archive 'target/*.zip'
	   }
	}
}