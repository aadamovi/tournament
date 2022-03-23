package com.img.data.consumer.golf.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    private final String connectionString;
    private final String userName;
    private final String password;
    private final String bucketName;

    public CouchbaseConfiguration(@Value("${couchbase.connectionString}") String connectionString,
                                  @Value("${couchbase.userName}") String userName,
                                  @Value("${couchbase.password}") String password,
                                  @Value("${couchbase.bucketName}") String bucketName) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
        this.bucketName = bucketName;
    }

    @Override
    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }
}
