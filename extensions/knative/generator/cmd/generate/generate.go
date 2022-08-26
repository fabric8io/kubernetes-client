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
	"fmt"
	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
	"k8s.io/apimachinery/pkg/runtime"
	awssqs_source "knative.dev/eventing-awssqs/pkg/apis/sources/v1alpha1"
	couchdb_source "knative.dev/eventing-couchdb/source/pkg/apis/sources/v1alpha1"
	github_binding "knative.dev/eventing-github/pkg/apis/bindings/v1alpha1"
	github_source "knative.dev/eventing-github/pkg/apis/sources/v1alpha1"
	gitlab_binding "knative.dev/eventing-gitlab/pkg/apis/bindings/v1alpha1"
	gitlab_source "knative.dev/eventing-gitlab/pkg/apis/sources/v1alpha1"
	kafka_binding "knative.dev/eventing-kafka/pkg/apis/bindings/v1beta1"
	kafka_channel "knative.dev/eventing-kafka/pkg/apis/messaging/v1beta1"
	kafka_source "knative.dev/eventing-kafka/pkg/apis/sources/v1beta1"
	prometheus_source "knative.dev/eventing-prometheus/pkg/apis/sources/v1alpha1"
	eventing_v1 "knative.dev/eventing/pkg/apis/eventing/v1"
	eventing_v1beta1 "knative.dev/eventing/pkg/apis/eventing/v1beta1"
	flows_v1 "knative.dev/eventing/pkg/apis/flows/v1"
	messaging_v1 "knative.dev/eventing/pkg/apis/messaging/v1"
	source_v1 "knative.dev/eventing/pkg/apis/sources/v1"
	"knative.dev/pkg/apis"
	serving_v1 "knative.dev/serving/pkg/apis/serving/v1"
	serving_v1beta1 "knative.dev/serving/pkg/apis/serving/v1beta1"
	"reflect"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		// serving v1
		reflect.TypeOf(serving_v1.ServiceList{}):            schemagen.Namespaced,
		reflect.TypeOf(serving_v1.RouteList{}):              schemagen.Namespaced,
		reflect.TypeOf(serving_v1.RevisionList{}):           schemagen.Namespaced,
		reflect.TypeOf(serving_v1.ConfigurationList{}):      schemagen.Namespaced,
		reflect.TypeOf(serving_v1beta1.DomainMappingList{}): schemagen.Namespaced,

		// eventing v1
		reflect.TypeOf(eventing_v1.BrokerList{}):  schemagen.Namespaced,
		reflect.TypeOf(eventing_v1.TriggerList{}): schemagen.Namespaced,

		// eventing v1beta1
		reflect.TypeOf(eventing_v1beta1.EventTypeList{}): schemagen.Namespaced,

		// eventing source v1
		reflect.TypeOf(source_v1.PingSourceList{}):      schemagen.Namespaced,
		reflect.TypeOf(source_v1.SinkBindingList{}):     schemagen.Namespaced,
		reflect.TypeOf(source_v1.ContainerSourceList{}): schemagen.Namespaced,
		reflect.TypeOf(source_v1.ApiServerSourceList{}): schemagen.Namespaced,

		// eventing contrib v1alpha1
		reflect.TypeOf(kafka_channel.KafkaChannelList{}):         schemagen.Namespaced,
		reflect.TypeOf(kafka_source.KafkaSourceList{}):           schemagen.Namespaced,
		reflect.TypeOf(kafka_binding.KafkaBindingList{}):         schemagen.Namespaced,
		reflect.TypeOf(awssqs_source.AwsSqsSourceList{}):         schemagen.Namespaced,
		reflect.TypeOf(couchdb_source.CouchDbSourceList{}):       schemagen.Namespaced,
		reflect.TypeOf(github_source.GitHubSourceList{}):         schemagen.Namespaced,
		reflect.TypeOf(github_binding.GitHubBindingList{}):       schemagen.Namespaced,
		reflect.TypeOf(gitlab_source.GitLabSourceList{}):         schemagen.Namespaced,
		reflect.TypeOf(gitlab_binding.GitLabBindingList{}):       schemagen.Namespaced,
		reflect.TypeOf(prometheus_source.PrometheusSourceList{}): schemagen.Namespaced,

		// messaging v1
		reflect.TypeOf(messaging_v1.ChannelList{}):         schemagen.Namespaced,
		reflect.TypeOf(messaging_v1.SubscriptionList{}):    schemagen.Namespaced,
		reflect.TypeOf(messaging_v1.InMemoryChannelList{}): schemagen.Namespaced,

		// flows v1
		reflect.TypeOf(flows_v1.SequenceList{}): schemagen.Namespaced,
		reflect.TypeOf(flows_v1.ParallelList{}): schemagen.Namespaced,
	}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		// external
		"k8s.io/api/core/v1":                   "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/apis/meta/v1": "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/api/resource": "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/runtime":      "io.fabric8.kubernetes.api.model.runtime",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"knative.dev/serving/pkg/apis/serving/v1":                       {JavaPackage: "io.fabric8.knative.serving.v1", ApiGroup: "serving.knative.dev", ApiVersion: "v1"},
		"knative.dev/serving/pkg/apis/serving/v1beta1":                  {JavaPackage: "io.fabric8.knative.serving.v1beta1", ApiGroup: "serving.knative.dev", ApiVersion: "v1beta1"},
		"knative.dev/eventing/pkg/apis/eventing/v1":                     {JavaPackage: "io.fabric8.knative.eventing.v1", ApiGroup: "eventing.knative.dev", ApiVersion: "v1"},
		"knative.dev/eventing/pkg/apis/eventing/v1beta1":                {JavaPackage: "io.fabric8.knative.eventing.v1beta1", ApiGroup: "eventing.knative.dev", ApiVersion: "v1beta1"},
		"knative.dev/eventing/pkg/apis/messaging/v1":                    {JavaPackage: "io.fabric8.knative.messaging.v1", ApiGroup: "messaging.knative.dev", ApiVersion: "v1"},
		"knative.dev/eventing/pkg/apis/flows/v1":                        {JavaPackage: "io.fabric8.knative.flows.v1", ApiGroup: "flows.knative.dev", ApiVersion: "v1"},
		"knative.dev/eventing/pkg/apis/sources/v1":                      {JavaPackage: "io.fabric8.knative.sources.v1", ApiGroup: "sources.knative.dev", ApiVersion: "v1"},
		"knative.dev/eventing-kafka/pkg/apis/messaging/v1beta1":         {JavaPackage: "io.fabric8.knative.eventing.contrib.kafka.v1beta1", ApiGroup: "messaging.knative.dev", ApiVersion: "v1beta1"},
		"knative.dev/eventing-kafka/pkg/apis/sources/v1beta1":           {JavaPackage: "io.fabric8.knative.eventing.contrib.kafka.v1beta1", ApiGroup: "sources.knative.dev", ApiVersion: "v1beta1"},
		"knative.dev/eventing-kafka/pkg/apis/bindings/v1beta1":          {JavaPackage: "io.fabric8.knative.eventing.contrib.kafka.v1beta1", ApiGroup: "bindings.knative.dev", ApiVersion: "v1beta1"},
		"knative.dev/eventing-awssqs/pkg/apis/sources/v1alpha1":         {JavaPackage: "io.fabric8.knative.eventing.contrib.awssqs.v1alpha1", ApiGroup: "sources.knative.dev", ApiVersion: "v1alpha1"},
		"knative.dev/eventing-couchdb/source/pkg/apis/sources/v1alpha1": {JavaPackage: "io.fabric8.knative.eventing.contrib.couchdb.v1alpha1", ApiGroup: "sources.knative.dev", ApiVersion: "v1alpha1"},
		"knative.dev/eventing-github/pkg/apis/sources/v1alpha1":         {JavaPackage: "io.fabric8.knative.eventing.contrib.github.v1alpha1", ApiGroup: "sources.knative.dev", ApiVersion: "v1alpha1"},
		"knative.dev/eventing-github/pkg/apis/bindings/v1alpha1":        {JavaPackage: "io.fabric8.knative.eventing.contrib.github.v1alpha1", ApiGroup: "bindings.knative.dev", ApiVersion: "v1alpha1"},
		"knative.dev/eventing-gitlab/pkg/apis/sources/v1alpha1":         {JavaPackage: "io.fabric8.knative.eventing.contrib.gitlab.v1alpha1", ApiGroup: "sources.knative.dev", ApiVersion: "v1alpha1"},
		"knative.dev/eventing-gitlab/pkg/apis/bindings/v1alpha1":        {JavaPackage: "io.fabric8.knative.eventing.contrib.gitlab.v1alpha1", ApiGroup: "bindings.knative.dev", ApiVersion: "v1alpha1"},
		"knative.dev/eventing-prometheus/pkg/apis/sources/v1alpha1":     {JavaPackage: "io.fabric8.knative.eventing.contrib.prometheus.v1alpha1", ApiGroup: "sources.knative.dev", ApiVersion: "v1alpha1"},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	// e.g. knative.dev/eventing/pkg/apis/messaging/v1beta1/ChannelTemplateSpec is mapped to "io.fabric8.knative.internal.eventing.pkg.apis.messaging.v1beta1.ChannelTemplateSpec"
	mappingSchema := map[string]string{
		"knative.dev": "io.fabric8.knative.internal",
	}

	// overwriting some times
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(apis.URL{}):             "java.lang.String",
		reflect.TypeOf(apis.VolatileTime{}):    "java.lang.String",
		reflect.TypeOf(runtime.RawExtension{}): "java.util.Map<String, Object>",
	}

	json := schemagen.GenerateSchema("http://fabric8.io/knative/KnativeSchema#", crdLists, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, "io.fabric8")

	fmt.Println(json)
}
