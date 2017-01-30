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

package io.fabric8.kubernetes.client.dsl;

import java.util.List;

import io.fabric8.kubernetes.api.builder.Visitable;
import io.fabric8.kubernetes.client.FromServerGettable;
import io.fabric8.kubernetes.client.GracePeriodConfigurable;

public interface ListVisitFromServerGetDeleteRecreateWaitApplicable<T, B> extends Visitable<ListVisitFromServerGetDeleteRecreateWaitApplicable<T, B>>,
                                                                          FromServerGettable<List<T>>, RecreateApplicable<List<T>>,
                                                                          CascadingDeletable<B>,
                                                                          Waitable<List<T>>,
                                                                          GracePeriodConfigurable<CascadingDeletable<B>> {
}
