package com.img.data.consumer.golf.config;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.couchbase.BucketDefinition;
import org.testcontainers.couchbase.CouchbaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

import java.util.stream.Stream;

@Testcontainers
public class AbstractTestContainer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestContainer.class);
    private static final DockerImageName COUCHBASE_IMAGE = DockerImageName.parse("couchbase/server:6.5.1");

    @Container
    private static final CouchbaseContainer COUCHBASE = new CouchbaseContainer(COUCHBASE_IMAGE)
        .withCredentials("Administator", "password")
        .withBucket(new BucketDefinition("tournament").withFlushEnabled(true).withQuota(100));

    @BeforeClass
    public static void beforeClass() {
        LOGGER.debug("Starting containers");
        Startables.deepStart(Stream.of(COUCHBASE));
    }

    @AfterClass
    public static void afterClass() {
        LOGGER.debug("Stopping containers");
        COUCHBASE.stop();
    }
}
