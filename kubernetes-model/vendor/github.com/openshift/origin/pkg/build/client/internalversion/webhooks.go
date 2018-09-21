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
package internalversion

import (
	"errors"
	"net/url"

	"k8s.io/client-go/rest"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

var ErrTriggerIsNotAWebHook = errors.New("the specified trigger is not a webhook")

type WebHookURLInterface interface {
	WebHookURL(name string, trigger *buildapi.BuildTriggerPolicy) (*url.URL, error)
}

func NewWebhookURLClient(c rest.Interface, ns string) WebHookURLInterface {
	return &webhooks{client: c, ns: ns}
}

type webhooks struct {
	client rest.Interface
	ns     string
}

func (c *webhooks) WebHookURL(name string, trigger *buildapi.BuildTriggerPolicy) (*url.URL, error) {
	hooks := c.client.Get().Namespace(c.ns).Resource("buildConfigs").Name(name).SubResource("webhooks")
	switch {
	case trigger.GenericWebHook != nil:
		return hooks.Suffix("<secret>", "generic").URL(), nil
	case trigger.GitHubWebHook != nil:
		return hooks.Suffix("<secret>", "github").URL(), nil
	case trigger.GitLabWebHook != nil:
		return hooks.Suffix("<secret>", "gitlab").URL(), nil
	case trigger.BitbucketWebHook != nil:
		return hooks.Suffix("<secret>", "bitbucket").URL(), nil
	default:
		return nil, ErrTriggerIsNotAWebHook
	}
}
