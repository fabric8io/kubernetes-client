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
package util

import (
	"fmt"
	"time"

	authorizationapiv1 "k8s.io/api/authorization/v1"
	"k8s.io/apimachinery/pkg/util/wait"
	kclientset "k8s.io/client-go/kubernetes"
	e2e "k8s.io/kubernetes/test/e2e/framework"
)

func WaitForSelfSAR(interval, timeout time.Duration, c kclientset.Interface, selfSAR authorizationapiv1.SelfSubjectAccessReviewSpec) error {
	err := wait.PollImmediate(interval, timeout, func() (bool, error) {
		res, err := c.AuthorizationV1().SelfSubjectAccessReviews().Create(
			&authorizationapiv1.SelfSubjectAccessReview{
				Spec: selfSAR,
			},
		)
		if err != nil {
			return false, err
		}

		if !res.Status.Allowed {
			e2e.Logf("Waiting for SelfSAR (ResourceAttributes: %#v, NonResourceAttributes: %#v) to be allowed, current Status: %#v", selfSAR.ResourceAttributes, selfSAR.NonResourceAttributes, res.Status)
			return false, nil
		}

		return true, nil
	})
	if err != nil {
		return fmt.Errorf("failed to wait for SelfSAR (ResourceAttributes: %#v, NonResourceAttributes: %#v), err: %v", selfSAR.ResourceAttributes, selfSAR.NonResourceAttributes, err)
	}

	return nil
}
