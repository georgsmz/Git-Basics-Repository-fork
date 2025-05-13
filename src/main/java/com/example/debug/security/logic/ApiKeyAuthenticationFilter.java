/*
 * Copyright (c) 2023 Volkswagen AG
 * Copyright (c) 2025 Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e.V.
 * (represented by Fraunhofer ISST)
 * Copyright (c) 2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.example.debug.security.logic;

import com.example.debug.security.domain.ApiKeyAuthentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Authentication filter that checks if X-API-KEY header is given and set to value from config
 */
@Component
@AllArgsConstructor
@Slf4j
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

    public final String API_KEY_HEADER = "X-API-KEY";
    private final ApiKeyAuthenticationProvider apiKeyAuthenticationProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerKey = request.getHeader(API_KEY_HEADER);

        if (headerKey == null){
            log.info("Header {} not set in request for endpoint {}", API_KEY_HEADER, request.getRequestURL());
        }

        if (headerKey != null){
            log.info("Header {} not set in request for endpoint {}", API_KEY_HEADER, request.getRequestURL());
            ApiKeyAuthentication apiKeyAuthentication = new ApiKeyAuthentication(headerKey, false);
            Authentication authenticatedObject = apiKeyAuthenticationProvider.authenticate(apiKeyAuthentication);
            SecurityContextHolder.getContext().setAuthentication(authenticatedObject);
        }

        filterChain.doFilter(request,response);
    }
}
