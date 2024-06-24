/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.quarkiverse.slack.it;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import io.quarkiverse.slack.runtime.SlackConfig;

@Path("/slack")
@ApplicationScoped
public class SlackResource {
    // add some rest methods here

    @Inject
    SlackConfig config;

    @Inject
    Slack slack;

    @GET
    public String hello() throws Exception {
        System.out.println(slack.status().current().getActiveIncidents());
        MethodsClient methods = slack.methods(config.token());
        // Build a request object
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("D0443KRRQTG") // Use a channel ID `C1234567` is preferable
                .text(":wave: Hi from a bot written in Java!")
                .build();
        // Get a response as a Java object
        ChatPostMessageResponse response = methods.chatPostMessage(request);
        System.out.println(response.isOk());
        return "Hello slack";
    }
}
