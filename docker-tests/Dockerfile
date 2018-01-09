FROM cwds/javajdk
RUN mkdir /opt/case-management-api-tests
ADD case-management-api-tests.jar /opt/case-management-api-tests/case-management-api-tests.jar
ADD resources /opt/case-management-api-tests/resources
ADD config /opt/case-management-api-tests/config
ADD entrypoint.sh /opt/case-management-api-tests/
RUN chmod +x /opt/case-management-api-tests/entrypoint.sh
WORKDIR /opt/case-management-api-tests
CMD ["/opt/case-management-api-tests/entrypoint.sh"]
