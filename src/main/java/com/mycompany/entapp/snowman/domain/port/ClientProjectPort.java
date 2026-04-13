/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.port;

import com.mycompany.entapp.snowman.domain.model.Project;

import java.util.Set;

/**
 * Port for fetching client projects from an external system.
 * Infrastructure adapters provide the actual HTTP/messaging implementation.
 */
public interface ClientProjectPort {

    /**
     * Fetches projects associated with a given client from the external client system.
     *
     * @param clientId the client identifier
     * @return set of projects, or empty set if none found
     */
    Set<Project> fetchProjectsForClient(int clientId);
}
