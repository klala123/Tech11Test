FROM quay.io/wildfly/wildfly:26.1.2.Final
COPY target/tech11Test.war /opt/jboss/wildfly/standalone/deployments/