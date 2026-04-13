/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.port.ClientProjectPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Infrastructure adapter that fetches client project data from an external REST API.
 * Encapsulates all HTTP and JSON parsing concerns away from the domain layer.
 */
@Component
public class ClientProjectAdapter implements ClientProjectPort {

    private static final Logger LOG = LoggerFactory.getLogger(ClientProjectAdapter.class);

    private static final int MAX_RETRIES = 3;
    private static final String URI = "http://localhost:8080/client-system/client/{clientId}/projects";

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Set<Project> fetchProjectsForClient(int clientId) {
        ResponseEntity<String> response = makeRequest(clientId);

        int retryCount = 0;
        while (response.getStatusCode() != HttpStatus.OK) {
            if (retryCount >= MAX_RETRIES) {
                LOG.warn("Failed to fetch projects for client {} after {} retries", clientId, MAX_RETRIES);
                return Collections.emptySet();
            }
            response = makeRequest(clientId);
            retryCount++;
        }

        return parseResponse(response.getBody());
    }

    private Set<Project> parseResponse(String body) {
        try {
            JsonNode root = objectMapper.readTree(body);
            JsonNode projectNode = root.path("project");
            Set<Project> projects = new HashSet<>();
            // TODO: properly map JSON fields to Project domain model
            projects.add(new Project());
            return projects;
        } catch (IOException e) {
            LOG.error("Failed to parse client project response: {}", e.getMessage(), e);
            return Collections.emptySet();
        }
    }

    private ResponseEntity<String> makeRequest(int clientId) {
        return restTemplate.getForEntity(URI, String.class, clientId);
    }
}
