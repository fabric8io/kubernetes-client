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
package schemagen

import (
	"fmt"
	"path/filepath"
	"reflect"
	"strings"
)

type PackageDescriptor struct {
	GoPackage   string
	ApiGroup    string
	JavaPackage string
	Prefix      string
	Generate    bool
}

type schemaGenerator struct {
	types         map[reflect.Type]*JSONObjectDescriptor
	typeNames     map[reflect.Type]string
	manualTypeMap map[reflect.Type]string
	packages      map[string]PackageDescriptor
	typeMap       map[reflect.Type]reflect.Type
}

type CrdScope int32

const (
	Namespaced  CrdScope = iota
	Cluster     CrdScope = iota
	BasePackage string   = "io.fabric8.kubernetes.api.model"
)

func GenerateSchema(t reflect.Type, packages []PackageDescriptor, typeMap map[reflect.Type]reflect.Type, manualTypeMapping map[reflect.Type]string, moduleName string) (*JSONSchema, error) {
	g := newSchemaGenerator(packages, typeMap, manualTypeMapping)
	return g.generate(t, moduleName)
}

func newSchemaGenerator(packages []PackageDescriptor, typeMap map[reflect.Type]reflect.Type, manualTypeMap map[reflect.Type]string) *schemaGenerator {
	pkgMap := make(map[string]PackageDescriptor)
	for _, p := range packages {
		pkgMap[p.GoPackage] = p
	}
	g := schemaGenerator{
		types:         make(map[reflect.Type]*JSONObjectDescriptor),
		typeNames:     make(map[reflect.Type]string),
		manualTypeMap: manualTypeMap,
		packages:      pkgMap,
		typeMap:       typeMap,
	}
	return &g
}

func getFieldName(f reflect.StructField) string {
	json := f.Tag.Get("json")
	if len(json) > 0 {
		parts := strings.Split(json, ",")
		return parts[0]
	}
	return f.Name
}

func isOmitEmpty(f reflect.StructField) bool {
	json := f.Tag.Get("json")
	if len(json) > 0 {
		parts := strings.Split(json, ",")
		for _, part := range parts {
			if part == "omitempty" {
				return true
			}
		}
	}
	return false
}

func getFieldDescription(f reflect.StructField) string {
	json := f.Tag.Get("description")
	if len(json) > 0 {
		parts := strings.Split(json, ",")
		return parts[0]
	}
	return ""
}

func (g *schemaGenerator) generateJavaType(t reflect.Type) bool {
	pkgDesc, ok := g.packages[pkgPath(t)]
	if !ok {
		return false
	}
	return pkgDesc.Generate
}

func (g *schemaGenerator) qualifiedName(t reflect.Type) string {
	pkgDesc, ok := g.packages[pkgPath(t)]
	if !ok {
		prefix := strings.Replace(pkgPath(t), "/", "_", -1)
		prefix = strings.Replace(prefix, ".", "_", -1)
		prefix = strings.Replace(prefix, "-", "_", -1)
		return prefix + "_" + t.Name()
	}
	return pkgDesc.Prefix + t.Name()
}

func (g *schemaGenerator) resourceDetails(t reflect.Type) string {
	var name = strings.ToLower(t.Name())
	return name
}

func (g *schemaGenerator) generateReference(t reflect.Type) string {
	return "#/definitions/" + g.qualifiedName(t)
}

func (g *schemaGenerator) javaTypeArrayList(t reflect.Type) string {
	typeName := g.javaTypeWrapPrimitive(t)
	switch typeName {
	case "Byte":
		return "String"
	default:
		return "java.util.ArrayList<" + typeName + ">"
	}
}

func (g *schemaGenerator) javaTypeWrapPrimitive(t reflect.Type) string {
	typeName := g.javaType(t)
	switch typeName {
	case "bool":
		return "Boolean"
	case "char":
		return "Character"
	case "short":
		return "Short"
	case "int":
		return "Integer"
	case "long":
		return "Long"
	case "float":
		return "Float"
	case "double":
		return "Double"
	default:
		return typeName
	}
}

func (g *schemaGenerator) javaType(t reflect.Type) string {
	if t.Kind() == reflect.Ptr {
		t = t.Elem()
	}
	pkgDesc, ok := g.packages[pkgPath(t)]

	manualType, isFound := g.manualTypeMap[t]
	if isFound {
		return manualType
	}

	//Added a special case for RunAsUserStrategyOptions
	//If i don't add a prefix it get conflict with
	//openShift RunAsUserStrategyOptions and project give compilation error
	//because both classes are different

	if t.Kind() == reflect.Struct && ok {
		switch t.Name() {
		case "Time":
			return "String"
		case "RawExtension":
			return "io.fabric8.kubernetes.api.model.KubernetesResource"			
		case "List":
			return pkgDesc.JavaPackage + ".KubernetesList"
		default:
			return pkgDesc.JavaPackage + "." + t.Name()
		}
		typeName, ok := g.typeNames[t]
		if ok {
			return pkgDesc.JavaPackage + "." + typeName
		}
		return pkgDesc.JavaPackage + "." + t.Name()
	}
	switch t.Kind() {
	case reflect.Bool:
		return "bool"
	case reflect.Uint8:
	  return "Byte"
	case reflect.Int, reflect.Int8, reflect.Int16,
		reflect.Int32, reflect.Uint,
		reflect.Uint16, reflect.Uint32:
		return "int"
	case reflect.Int64, reflect.Uint64:
		return "Long"
	case reflect.Float32, reflect.Float64, reflect.Complex64,
		reflect.Complex128:
		return "double"
	case reflect.String:
		return "String"
	case reflect.Array, reflect.Slice:
		return g.javaTypeArrayList(t.Elem())
	case reflect.Map:
		return "java.util.Map<String," + g.javaTypeWrapPrimitive(t.Elem()) + ">"
	default:
	    if t.Name() == "RawExtension" {
	        return "io.fabric8.kubernetes.api.model.KubernetesResource"
	    }
	    if t.Name() == "Time" {
			return "String"
		}
		if len(t.Name()) == 0 && t.NumField() == 0 {
			return "Object"
		}
		return t.Name()
	}
}

func (g *schemaGenerator) resourceListWithGeneric(t reflect.Type) string {
	return BasePackage + ".KubernetesResourceList<" + g.javaType(t.Elem()) + ">"
}

func (g *schemaGenerator) javaInterfaces(t reflect.Type) []string {
	_, hasMeta := t.FieldByName("ObjectMeta")

	if t.Name() != "JobTemplateSpec" && t.Name() != "PodTemplateSpec" && t.Name() != "PersistentVolumeClaimTemplate" && t.Name() != "MachineSpec" && t.Name() != "MachineTemplateSpec" && hasMeta {
		scope := g.crdScope(t)

		if scope == Namespaced {
			return []string{BasePackage + ".HasMetadata", BasePackage + ".Namespaced"}
		}
		return []string{BasePackage + ".HasMetadata"}
	}

	itemsField, hasItems := t.FieldByName("Items")
	_, hasListMeta := t.FieldByName("ListMeta")
	if hasItems && hasListMeta {
		return []string{BasePackage + ".KubernetesResource", g.resourceListWithGeneric(itemsField.Type)}
	}

	if !hasMeta && g.isNamespaceScopedResource(t) {
		return []string{BasePackage + ".KubernetesResource", BasePackage + ".Namespaced"}
	}

	return []string{BasePackage + ".KubernetesResource"}
}

func (g *schemaGenerator) initializeTypeNames(t reflect.Type) {
	for it := 0; it < t.NumField(); it++ {
		field := t.Field(it)
		g.typeNames[field.Type] = field.Name
	}
}

func (g *schemaGenerator) generate(t reflect.Type, moduleName string) (*JSONSchema, error) {
	if t.Kind() != reflect.Struct {
		return nil, fmt.Errorf("Only struct types can be converted.")
	}
	g.initializeTypeNames(t)

	s := JSONSchema{
		ID:     "http://fabric8.io/fabric8/v2/" + t.Name() + "#",
		Schema: "http://json-schema.org/draft-05/schema#",
		Module: moduleName,
		JSONDescriptor: JSONDescriptor{
			Type: "object",
		},
	}
	s.JSONObjectDescriptor = g.generateObjectDescriptor(t)
	if len(g.types) > 0 {
		s.Definitions = make(map[string]JSONPropertyDescriptor)
		s.Resources = make(map[string]*JSONObjectDescriptor)

		for k, v := range g.types {
			name := g.qualifiedName(k)
			resource := g.resourceDetails(k)
			value := JSONPropertyDescriptor{
				JSONDescriptor: &JSONDescriptor{
					Type: "object",
				},
				JSONObjectDescriptor: v,
				JavaInterfacesDescriptor: &JavaInterfacesDescriptor{
					JavaInterfaces: g.javaInterfaces(k),
				},
			}
			javaType := g.javaType(k)
			if g.generateJavaType(k) && strings.HasPrefix(javaType, "io.fabric8.") {
				value.JavaTypeDescriptor = &JavaTypeDescriptor{
					JavaType: javaType,
				}
			} else {
				value.ExistingJavaTypeDescriptor = &ExistingJavaTypeDescriptor{
					ExistingJavaType: javaType,
				}
			}
			
			s.Definitions[name] = value
			s.Resources[resource] = v
		}
	}

	return &s, nil
}

func (g *schemaGenerator) getPropertyDescriptor(t reflect.Type, desc string, omitEmpty bool) JSONPropertyDescriptor {
	if t.Kind() == reflect.Ptr {
		t = t.Elem()
	}
	tt, ok := g.typeMap[t]
	if ok {
		t = tt
	}
	switch t.Kind() {
	case reflect.Bool:
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:        "boolean",
				Description: desc,
			},
		}
	case reflect.Int, reflect.Int8, reflect.Int16,
		reflect.Int32, reflect.Uint,
		reflect.Uint8, reflect.Uint16, reflect.Uint32:
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:        "integer",
				Description: desc,
			},
		}
	case reflect.Int64, reflect.Uint64:
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:        "integer",
				Description: desc,
			},
			ExistingJavaTypeDescriptor: &ExistingJavaTypeDescriptor{
				ExistingJavaType: "Long",
			},
		}
	case reflect.Float32, reflect.Float64, reflect.Complex64,
		reflect.Complex128:
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:        "number",
				Description: desc,
			},
		}
	case reflect.String:
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:        "string",
				Description: desc,
			},
		}
	case reflect.Array:
	case reflect.Slice:
		if g.javaTypeArrayList(t.Elem()) == "String" {
			return JSONPropertyDescriptor{
				JSONDescriptor: &JSONDescriptor{
					Type:        "string",
					Description: desc,
				},
			}
		}
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:          "array",
				Description:   desc,
				JavaOmitEmpty: omitEmpty,
			},
			JSONArrayDescriptor: &JSONArrayDescriptor{
				Items: g.getPropertyDescriptor(t.Elem(), desc, false),
			},
		}
	case reflect.Map:
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:        "object",
				Description: desc,
			},
			JSONMapDescriptor: &JSONMapDescriptor{
				MapValueType: g.getPropertyDescriptor(t.Elem(), desc, false),
			},
			ExistingJavaTypeDescriptor: &ExistingJavaTypeDescriptor{
				ExistingJavaType: "java.util.Map<String, " + g.javaTypeWrapPrimitive(t.Elem()) + ">",
			},
		}
	case reflect.Struct:
		definedType, ok := g.types[t]
		if !ok {
			g.types[t] = &JSONObjectDescriptor{}
			definedType = g.generateObjectDescriptor(t)
			g.types[t] = definedType
		}
		return JSONPropertyDescriptor{
			JSONReferenceDescriptor: &JSONReferenceDescriptor{
				Reference: g.generateReference(t),
			},
			ExistingJavaTypeDescriptor: &ExistingJavaTypeDescriptor{
				ExistingJavaType: g.javaType(t),
			},
		}
	}

	return JSONPropertyDescriptor{}
}

func (g *schemaGenerator) getStructProperties(t reflect.Type) map[string]JSONPropertyDescriptor {
	props := map[string]JSONPropertyDescriptor{}
	for i := 0; i < t.NumField(); i++ {
		field := t.Field(i)
		if len(field.PkgPath) > 0 { // Skip private fields
			continue
		}
		name := getFieldName(field)
		// Skip unserialized fields
		if name == "-" {
			continue
		}
		path := pkgPath(t)
		desc := getFieldDescription(field)
		omitEmpty := isOmitEmpty(field)
		prop := g.getPropertyDescriptor(field.Type, desc, omitEmpty)
		if field.Anonymous && field.Type.Kind() == reflect.Struct && len(name) == 0 {
			var newProps map[string]JSONPropertyDescriptor
			if prop.JSONReferenceDescriptor != nil {
				pType := field.Type
				if pType.Kind() == reflect.Ptr {
					pType = pType.Elem()
				}
				newProps = g.types[pType].Properties
			} else {
				newProps = prop.Properties
			}
			for k, v := range newProps {
				switch k {
				case "kind":
					v = JSONPropertyDescriptor{
						JSONDescriptor: &JSONDescriptor{
							Type:     "string",
							Default:  t.Name(),
							Required: true,
						},
					}
				case "apiVersion":
					apiVersion := filepath.Base(path)
					apiGroup := filepath.Base(strings.TrimSuffix(path, apiVersion))

					pkgDesc, ok := g.packages[path]
					if ok && pkgDesc.ApiGroup != "" {
						apiGroup = pkgDesc.ApiGroup
					}
					/*
					 * ApiGroup for apiextensions is apiextensions.k8s.io
					 */
					if apiGroup == "apiextensions" {
						apiGroup = "apiextensions.k8s.io"
					}

					/*
					 * Skip appending apiGroup in apiVersion for case of core and meta resources since
					 * they have been moved to core/v1 and meta/v1 packages respectively but their apiVersion
					 * is still v1.
					 */
					if !(apiGroup == "core" || apiGroup == "meta") {
						groupPostfix := ""
						if strings.HasPrefix(path, "github.com/openshift/") {
							groupPostfix = ".openshift.io"
						}
						apiVersion = apiGroup + groupPostfix + "/" + apiVersion
					}

					v = JSONPropertyDescriptor{
						JSONDescriptor: &JSONDescriptor{
							Type: "string",
						},
					}
					if apiVersion != "unversioned" {
						v.Required = true
						v.Default = apiVersion
					}
				default:
					g.addConstraints(t.Name(), k, &v)
				}
				props[k] = v
			}
		} else {
			g.addConstraints(t.Name(), name, &prop)
			props[name] = prop
		}
	}
	return props
}

func (g *schemaGenerator) generateObjectDescriptor(t reflect.Type) *JSONObjectDescriptor {
	// Added special case for JSONSchemaProps because it has
	// already a field by name additionalProperty
	additionalProperties := t.Name() != "JSONSchemaProps"
	desc := JSONObjectDescriptor{AdditionalProperties: additionalProperties}
	desc.Properties = g.getStructProperties(t)
	return &desc
}

func (g *schemaGenerator) addConstraints(objectName string, propName string, prop *JSONPropertyDescriptor) {
	switch objectName {
	case "ObjectMeta":
		switch propName {
		case "namespace":
			prop.Pattern = `^[a-z0-9]([-a-z0-9]*[a-z0-9])?(\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*$`
			prop.MaxLength = 253
		}
	case "EnvVar":
		switch propName {
		case "name":
			prop.Pattern = `^[A-Za-z_][A-Za-z0-9_]*$`
		}
	case "Container", "Volume", "ContainerPort", "ContainerStatus", "ServicePort", "EndpointPort":
		switch propName {
		case "name":
			prop.Pattern = `^[a-z0-9]([-a-z0-9]*[a-z0-9])?$`
			prop.MaxLength = 63
		}
	}
}

func pkgPath(t reflect.Type) string {
	return strings.TrimPrefix(t.PkgPath(), "github.com/fabric8io/kubernetes-client/kubernetes-model/vendor/")
}

func (g *schemaGenerator) crdScope(t reflect.Type) CrdScope {
	if g.isClusterScopedResource(t) {
		return Cluster
	}
	return Namespaced
}

func (g *schemaGenerator) isNamespaceScopedResource(t reflect.Type) bool {
	namespaceScopedResourcesList := []string{
		"github.com/openshift/api/authorization/v1/LocalResourceAccessReview",
		"github.com/openshift/api/authorization/v1/LocalSubjectAccessReview",
		"github.com/openshift/api/authorization/v1/SelfSubjectRulesReview",
		"github.com/openshift/api/authorization/v1/SubjectRulesReview",
		"github.com/openshift/api/security/v1/PodSecurityPolicyReview",
		"github.com/openshift/api/security/v1/PodSecurityPolicySelfSubjectReview",
		"github.com/openshift/api/security/v1/PodSecurityPolicySubjectReview",
	}

	return Contains(namespaceScopedResourcesList, t.PkgPath()+"/"+t.Name())
}

func (g *schemaGenerator) isClusterScopedResource(t reflect.Type) bool {
	clusterScopedResourcesList := []string{
		"k8s.io/api/core/v1/Namespace",
		"k8s.io/api/core/v1/Node",
		"k8s.io/api/core/v1/ComponentStatus",
		"k8s.io/kube-aggregator/pkg/apis/apiregistration/v1/APIService",
		"k8s.io/api/core/v1/PersistentVolume",
		"k8s.io/api/authentication/v1/TokenReview",
		"k8s.io/api/admissionregistration/v1beta1/MutatingWebhookConfiguration",
		"k8s.io/api/authorization/v1/SelfSubjectRulesReview",
		"k8s.io/api/authorization/v1beta1/SubjectAccessReview",
		"k8s.io/api/admissionregistration/v1beta1/ValidatingWebhookConfiguration",
		"k8s.io/api/authorization/v1/SubjectAccessReview",
		"k8s.io/api/authorization/v1beta1/SelfSubjectRulesReview",
		"k8s.io/api/admissionregistration/v1/MutatingWebhookConfiguration",
		"k8s.io/api/admissionregistration/v1/ValidatingWebhookConfiguration",
		"k8s.io/api/authorization/v1/SelfSubjectAccessReview",
		"k8s.io/api/authorization/v1beta1/SelfSubjectAccessReview",
		"k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1/CustomResourceDefinition",
		"k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1/CustomResourceDefinition",
		"k8s.io/api/policy/v1beta1/PodSecurityPolicy",
		"k8s.io/api/rbac/v1/ClusterRole",
		"k8s.io/api/rbac/v1/ClusterRoleBinding",
		"k8s.io/api/scheduling/v1/PriorityClass",
		"k8s.io/api/scheduling/v1beta1/PriorityClass",
		"k8s.io/api/certificates/v1beta1/CertificateSigningRequest",
		"k8s.io/api/certificates/v1/CertificateSigningRequest",
		"k8s.io/api/storage/v1beta1/CSIDriver",
		"k8s.io/api/storage/v1beta1/CSINode",
		"k8s.io/api/storage/v1/CSIDriver",
		"k8s.io/api/storage/v1/CSINode",
		"k8s.io/api/storage/v1/VolumeAttachment",
		"k8s.io/metrics/pkg/apis/metrics/v1beta1/NodeMetrics",
		"k8s.io/api/node/v1beta1/RuntimeClass",
		"k8s.io/api/node/v1/RuntimeClass",
		"k8s.io/api/node/v1alpha1/RuntimeClass",
		"k8s.io/api/networking/v1beta1/IngressClass",
		"k8s.io/api/networking/v1/IngressClass",
		"k8s.io/api/storage/v1/StorageClass",
		"k8s.io/api/storage/v1beta1/StorageClass",
		"k8s.io/api/flowcontrol/v1beta1/FlowSchema",
		"k8s.io/api/flowcontrol/v1beta1/PriorityLevelConfiguration",
		"k8s.io/api/flowcontrol/v1beta2/FlowSchema",
		"k8s.io/api/flowcontrol/v1beta2/PriorityLevelConfiguration",
		"github.com/openshift/api/authorization/v1/ClusterRole",
		"github.com/openshift/api/authorization/v1/ClusterRoleBinding",
		"github.com/openshift/api/authorization/v1/ResourceAccessReview",
		"github.com/openshift/api/authorization/v1/SubjectAccessReview",
		"github.com/openshift/api/oauth/v1/UserOAuthAccessToken",
		"github.com/openshift/api/oauth/v1/OAuthClientAuthorization",
		"github.com/openshift/api/config/v1/Authentication",
		"github.com/openshift/api/config/v1/Build",
		"github.com/openshift/api/config/v1/Console",
		"github.com/openshift/api/config/v1/DNS",
		"github.com/openshift/api/config/v1/Network",
		"github.com/openshift/api/config/v1/Infrastructure",
		"github.com/openshift/api/config/v1/Image",
		"github.com/openshift/api/config/v1/ImageContentPolicy",
		"github.com/openshift/api/config/v1/FeatureGate",
		"github.com/openshift/api/config/v1/OperatorHub",
		"github.com/openshift/api/config/v1/APIServer",
		"github.com/openshift/api/config/v1/OAuth",
		"github.com/openshift/api/config/v1/ClusterVersion",
		"github.com/openshift/api/config/v1/Scheduler",
		"github.com/openshift/api/network/v1/ClusterNetwork",
		"github.com/openshift/api/quota/v1/ClusterResourceQuota",
		"github.com/openshift/api/config/v1/ClusterOperator",
		"github.com/openshift/api/network/v1/NetNamespace",
		"github.com/openshift/api/config/v1/Proxy",
		"github.com/openshift/api/config/v1/Project",
		"github.com/openshift/api/security/v1/RangeAllocation",
		"github.com/openshift/api/image/v1/Image",
		"github.com/openshift/api/image/v1/ImageSignature",
		"github.com/openshift/api/operator/v1/CSISnapshotController",
		"github.com/openshift/api/operator/v1/ClusterCSIDriver",
		"github.com/openshift/api/operator/v1/Config",
		"github.com/openshift/api/operator/v1/CloudCredential",
		"github.com/openshift/api/operator/v1/Etcd",
		"github.com/openshift/api/operator/v1/ServiceCatalogControllerManager",
		"github.com/openshift/api/operator/v1/Storage",
		"github.com/openshift/api/operator/v1/KubeStorageVersionMigrator",
		"github.com/openshift/api/operator/v1/Console",
		"github.com/openshift/api/operator/v1/KubeAPIServer",
		"github.com/openshift/api/operator/v1/OpenShiftAPIServer",
		"github.com/openshift/api/operator/v1/OpenShiftControllerManager",
		"github.com/openshift/api/operator/v1alpha1/ImageContentSourcePolicy",
		"github.com/openshift/api/operator/v1/DNS",
		"github.com/openshift/api/operator/v1/ServiceCA",
		"github.com/openshift/api/operator/v1/ServiceCatalogAPIServer",
		"github.com/openshift/api/operator/v1/KubeControllerManager",
		"github.com/openshift/api/operator/v1/Network",
		"github.com/openshift/api/operator/v1/KubeScheduler",
		"github.com/openshift/api/operator/v1/Authentication",
		"github.com/operator-framework/api/pkg/operators/v1/Operator",
		"github.com/openshift/api/imageregistry/v1/ImagePruner",
		"github.com/openshift/api/imageregistry/v1/Config",
		"github.com/openshift/api/console/v1/ConsoleLink",
		"github.com/openshift/api/console/v1/ConsoleCLIDownload",
		"github.com/openshift/api/console/v1/ConsoleNotification",
		"github.com/openshift/api/console/v1/ConsoleYAMLSample",
		"github.com/openshift/api/console/v1/ConsoleExternalLogLink",
		"github.com/openshift/api/console/v1/ConsoleQuickStart",
		"github.com/openshift/api/console/v1alpha1/ConsolePlugin",
		"github.com/openshift/api/config/v1/Ingress",
		"github.com/openshift/api/template/v1/BrokerTemplateInstance",
		"github.com/openshift/api/helm/v1beta1/HelmChartRepository",
		"github.com/openshift/api/network/v1/HostSubnet",
		"github.com/openshift/api/user/v1/UserIdentityMapping",
		"github.com/openshift/api/user/v1/Identity",
		"github.com/openshift/api/apiserver/v1/APIRequestCount",
		"github.com/openshift/api/project/v1/Project",
		"github.com/openshift/api/project/v1/ProjectRequest",
		"github.com/openshift/api/user/v1/Group",
		"github.com/openshift/api/user/v1/User",
		"github.com/openshift/api/oauth/v1/OAuthAccessToken",
		"github.com/openshift/api/oauth/v1/OAuthAuthorizeToken",
		"github.com/openshift/api/oauth/v1/OAuthClient",
		"github.com/openshift/api/security/v1/SecurityContextConstraints",
		"github.com/openshift/machine-config-operator/pkg/apis/machineconfiguration.openshift.io/v1/ContainerRuntimeConfig",
		"github.com/openshift/machine-config-operator/pkg/apis/machineconfiguration.openshift.io/v1/ControllerConfig",
		"github.com/openshift/machine-config-operator/pkg/apis/machineconfiguration.openshift.io/v1/KubeletConfig",
		"github.com/openshift/machine-config-operator/pkg/apis/machineconfiguration.openshift.io/v1/MachineConfigPool",
		"github.com/openshift/machine-config-operator/pkg/apis/machineconfiguration.openshift.io/v1/MachineConfig",
		"github.com/openshift/cluster-autoscaler-operator/pkg/apis/autoscaling/v1/ClusterAutoscaler",
                "github.com/openshift/hive/apis/hive/v1/ClusterImageSet",
                "github.com/openshift/hive/apis/hive/v1/SelectorSyncIdentityProvider",
                "github.com/openshift/hive/apis/hive/v1/SelectorSyncSet",
                "github.com/openshift/hive/apis/hive/v1/HiveConfig",
		"sigs.k8s.io/kube-storage-version-migrator/pkg/apis/migration/v1alpha1/StorageState",
		"sigs.k8s.io/kube-storage-version-migrator/pkg/apis/migration/v1alpha1/StorageVersionMigration",
                "sigs.k8s.io/gateway-api/apis/v1alpha2/GatewayClass",
                "sigs.k8s.io/gateway-api/apis/v1beta1/GatewayClass",
	}

	return Contains(clusterScopedResourcesList, t.PkgPath()+"/"+t.Name())
}

func Contains(a []string, x string) bool {
	for _, n := range a {
		if x == n {
			return true
		}
	}
	return false
}
