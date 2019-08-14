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
package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"github.com/fabric8io/kubernetes-client/extensions/knative/generator/pkg/schemagen"
	eventingv1alpha1 "github.com/knative/eventing/pkg/apis/eventing/v1alpha1"
	messagingv1alpha1 "github.com/knative/eventing/pkg/apis/messaging/v1alpha1"
	"github.com/knative/serving/pkg/apis/serving/v1beta1"
	"log"
	"os"
	"reflect"
	"strings"
	"time"
)

//A Schema with the core types of the Service Catalog
type Schema struct {
	//Serving
	Service           v1beta1.Service
	ServiceList       v1beta1.ServiceList
	Route             v1beta1.Route
	RouteList         v1beta1.RouteList
	Revision          v1beta1.Revision
	RevisionList      v1beta1.RevisionList
	Configuration     v1beta1.Configuration
	ConfigurationList v1beta1.ConfigurationList

	//Eventing
	Broker                        eventingv1alpha1.Broker
	BrokerList                    eventingv1alpha1.BrokerList
	Trigger                       eventingv1alpha1.Trigger
	TriggerList                   eventingv1alpha1.TriggerList
	Channel                       eventingv1alpha1.Channel
	ChannelList                   eventingv1alpha1.ChannelList
	ClusterChannelProvisioner     eventingv1alpha1.ClusterChannelProvisioner
	ClusterChannelProvisionerList eventingv1alpha1.ClusterChannelProvisionerList
	Subscription                  eventingv1alpha1.Subscription
	SubscriptionList              eventingv1alpha1.SubscriptionList
	EventType                     eventingv1alpha1.EventType
	EventTypeList                 eventingv1alpha1.EventTypeList

	//Eventing - Messaging
	Sequence            messagingv1alpha1.Sequence
	SequenceList        messagingv1alpha1.SequenceList
	InMemoryChannel     messagingv1alpha1.InMemoryChannel
	InMemoryChannelList messagingv1alpha1.InMemoryChannelList
}

func main() {
	packages := []schemagen.PackageDescriptor{
		{"k8s.io/api/core/v1", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_"},
		{"k8s.io/apimachinery/pkg/apis/meta/v1", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_meta_"},
		{"k8s.io/apimachinery/pkg/util", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_uti_"},
		{"github.com/knative/pkg/apis", "v1", "io.fabric8.knative.v1", "knative_"},
		{"github.com/knative/pkg/apis/duck/v1beta1", "duck", "io.fabric8.knative.duck.v1beta1", "knative_duck_v1beta1_"},
		{"github.com/knative/pkg/apis/duck/v1alpha1", "duck", "io.fabric8.knative.duck.v1alpha1", "knative_duck_v1alpha1_"},
		{"github.com/knative/serving/pkg/apis/serving/v1beta1", "serving", "io.fabric8.knative.serving.v1beta1", "knative_serving_v1beta1_"},
		{"github.com/knative/eventing/pkg/apis/eventing/v1alpha1", "eventing", "io.fabric8.knative.eventing.v1alpha1", "knative_eventing_v1alpha1_"},
		{"github.com/knative/eventing/pkg/apis/messaging/v1alpha1", "messaging", "io.fabric8.knative.messaging.v1alpha1", "knative_messaging_v1alpha1_"},
		{"github.com/knative/eventing/pkg/apis/duck/v1alpha1", "duck", "io.fabric8.knative.duck.v1alpha1", "knative_duck_v1alpha1_"},
	}

	typeMap := map[reflect.Type]reflect.Type{
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}
	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap)
	if err != nil {
		log.Fatal(err)
	}

	args := os.Args[1:]
	if len(args) < 1 || args[0] != "validation" {
		schema.Resources = nil
	}

	b, err := json.Marshal(&schema)
	if err != nil {
		log.Fatal(err)
	}
	result := string(b)
	result = strings.Replace(result, "\"additionalProperty\":", "\"additionalProperties\":", -1)
	var out bytes.Buffer
	err = json.Indent(&out, []byte(result), "", "  ")
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println(out.String())
}
