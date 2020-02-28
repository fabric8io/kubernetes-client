/**
 * Copyright (C) 2015 Fabric8 Authors.
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
/**
 * Package leaderelection implements leader election of a set of endpoints.
 *
 * <p> It uses an annotation in the endpoints object to store the record of the
 * election state. This implementation does not guarantee that only one
 * client is acting as a leader (a.k.a. fencing).
 *
 * <p> A client only acts on timestamps captured locally to infer the state of the
 * leader election. The client does not consider timestamps in the leader
 * election record to be accurate because these timestamps may not have been
 * produced by a local clock. The implementation does not depend on their
 * accuracy and only uses their change to indicate that another client has
 * renewed the leader lease. Thus the implementation is tolerant to arbitrary
 * clock skew, but is not tolerant to arbitrary clock skew rate.
 *
 * <p> However the level of tolerance to skew rate can be configured by setting
 * RenewDeadline and LeaseDuration appropriately. The tolerance expressed as a
 * maximum tolerated ratio of time passed on the fastest node to time passed on
 * the slowest node can be approximately achieved with a configuration that sets
 * the same ratio of LeaseDuration to RenewDeadline. For example if a user wanted
 * to tolerate some nodes progressing forward in time twice as fast as other nodes,
 * the user could set LeaseDuration to 60 seconds and RenewDeadline to 30 seconds.
 *
 * <p> While not required, some method of clock synchronization between nodes in the
 * cluster is highly recommended. It's important to keep in mind when configuring
 * this client that the tolerance to skew rate varies inversely to master
 * availability.
 *
 * <p> Larger clusters often have a more lenient SLA for API latency. This should be
 * taken into account when configuring the client. The rate of leader transitions
 * should be monitored and RetryPeriod and LeaseDuration should be increased
 * until the rate is stable and acceptably low. It's important to keep in mind
 * when configuring this client that the tolerance to API latency varies inversely
 * to master availability.
 *
 * <p><strong>DISCLAIMER:</strong> This is a port of leaderelection package in client-go:
 * <a href="https://github.com/kubernetes/client-go/blob/1aa326d7304eba6aedc8c89daad615cc7499d1f7/tools/leaderelection/leaderelection.go">github.com/kubernetes/client-go</a>
 *
 * @since 4.7.1
 */
package io.fabric8.kubernetes.client.extended.leaderelection;
