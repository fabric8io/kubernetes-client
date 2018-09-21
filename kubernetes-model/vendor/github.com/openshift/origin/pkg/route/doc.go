/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
Package route provides support for managing and watching routes.
It defines a Route resource type, along with associated storage.

A Route object allows the user to specify a DNS / alias for a Kubernetes service.
It stores the ID of the Service (ServiceName) and the DNS/alias (Name).
The Route can be used to specify just the DNS/alias or it could also include
port and/or the path.

The Route model includes the following attributes to specify the frontend URL:
 - Host: Alias/DNS that points to the service. Can be host or host:port
 - Path: Path allows the router to perform fine-grained routing

The Route resources can be used by routers and load balancers to route external inbound
traffic. The proxy is expected to have frontend mappings for the Route.Name in its
configuration. For its endpoints, a proxy could either forward the traffic to the
Kubernetes Service port and let it do the load balancing and routing. Alternately,
a more meaningful implementation of a router could take the endpoints for the service
and route/load balance the incoming requests to the corresponding service endpoints.
*/
package route
