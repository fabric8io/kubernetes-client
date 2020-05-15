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
	"bytes"
	"encoding/json"
	"log"
	"reflect"
	"strings"
)

type ProvidedType struct {
	GoType    reflect.Type
	JavaClass string
}

type PackageInformation struct {
	ApiGroup    string
	ApiVersion  string
	JavaPackage string
}

type schemaGenerator struct {
	crdLists         map[reflect.Type]CrdScope
	types            map[reflect.Type]*JSONObjectDescriptor
	providedPackages map[string]string
	manualTypeMap    map[reflect.Type]string
	packageMapping   map[string]PackageInformation
	mappingSchema    map[string]string
	providedTypes    []ProvidedType
	constraints      map[reflect.Type]map[string]*Constraint // type -> field name -> constraint
}

type Constraint struct {
	MaxLength int
	Pattern   string
}

type CrdScope int32

const (
	Namespaced CrdScope = 0
	Cluster    CrdScope = 1
)

func GenerateSchema(schemaId string, crdLists map[reflect.Type]CrdScope, providedPackages map[string]string, manualTypeMap map[reflect.Type]string, packageMapping map[string]PackageInformation, mappingSchema map[string]string, providedTypes []ProvidedType, constraints map[reflect.Type]map[string]*Constraint) string {
	g := newSchemaGenerator(crdLists, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints)
	schema, err := g.generate(schemaId, crdLists)

	if err != nil {
		log.Fatal(err)
	}

	b, err := json.Marshal(&schema)
	if err != nil {
		log.Fatal(err)
	}
	result := string(b)
	var out bytes.Buffer
	err = json.Indent(&out, []byte(result), "", "  ")
	if err != nil {
		log.Fatal(err)
	}

	return out.String()
}

func newSchemaGenerator(crdLists map[reflect.Type]CrdScope, providedPackages map[string]string, manualTypeMap map[reflect.Type]string, packageMapping map[string]PackageInformation, mappingSchema map[string]string, providedTypes []ProvidedType, constraints map[reflect.Type]map[string]*Constraint) *schemaGenerator {
	g := schemaGenerator{
		crdLists:         crdLists,
		types:            make(map[reflect.Type]*JSONObjectDescriptor),
		providedPackages: providedPackages,
		manualTypeMap:    manualTypeMap,
		packageMapping:   packageMapping,
		mappingSchema:    mappingSchema,
		providedTypes:    providedTypes,
		constraints:      constraints,
	}
	return &g
}

func (g *schemaGenerator) jsonFieldName(f reflect.StructField) string {
	json := f.Tag.Get("json")
	if len(json) > 0 {
		parts := strings.Split(json, ",")
		return parts[0]
	}
	return f.Name
}

func (g *schemaGenerator) fieldDescription(f reflect.StructField) string {
	json := f.Tag.Get("description")
	if len(json) > 0 {
		parts := strings.Split(json, ",")
		return parts[0]
	}
	return ""
}

func (g *schemaGenerator) isOmitEmpty(f reflect.StructField) bool {
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

func (g *schemaGenerator) qualifiedName(t reflect.Type) string {
	path := t.PkgPath()
	name := t.Name()
	return strings.NewReplacer(".", "_", "/", "_").Replace(path) + "_" + name
}

func (g *schemaGenerator) generateReference(t reflect.Type) string {
	return "#/definitions/" + g.qualifiedName(t)
}

func (g *schemaGenerator) resolvePointer(t reflect.Type) reflect.Type {
	if t.Kind() == reflect.Ptr {
		t = t.Elem()
	}
	return t
}

func (g *schemaGenerator) jsonDescriptor(t reflect.Type) *JSONDescriptor {
	t = g.resolvePointer(t)

	switch t.Kind() {
	case reflect.Int, reflect.Int32, reflect.Int64:
		return &JSONDescriptor{Type: "integer"}
	case reflect.Bool:
		return &JSONDescriptor{Type: "boolean"}
	case reflect.String:
		return &JSONDescriptor{Type: "string"}
	}

	panic("Nothing for " + t.Name())
}

func (g *schemaGenerator) javaTypeDescriptor(t reflect.Type) *JavaTypeDescriptor {

	// no type information required for simple java types
	// if provided, this breaks default value for fields ?! wtf?
	if isSimpleJavaType(t) && !hasDifferentSimpleJavaTypeMapping(t) {
		return nil
	}
	return &JavaTypeDescriptor{
		JavaType: g.javaType(t),
	}
}

func (g *schemaGenerator) javaType(t reflect.Type) string {

	// follow pointer
	t = g.resolvePointer(t)

	manualType, ok := g.manualTypeMap[t]
	if ok {
		return manualType
	}

	if g.isProvidedType(t) {
		return g.resolveJavaClassForProvidedType(t)
	}

	if isSimpleJavaType(t) {
		switch t.Kind() {
		case reflect.Bool:
			return "Boolean"
		case reflect.Int, reflect.Int32:
			return "Integer"
		case reflect.String:
			return "String"
		case reflect.Int64:
			return "Long"
		}
	}

	if t.Kind() == reflect.Map {
		return "java.util.Map<" + g.javaType(t.Key()) + "," + g.javaType(t.Elem()) + ">"
	}

	if t.Kind() == reflect.Slice {
		return "java.util.List<" + g.javaType(t.Elem()) + ">"
	}

	// part of provided packages?
	if g.isPartOfProvidedPackage(t) {
		return g.resolveJavaClassUsingProvidedPackages(t)
	}

	// part of own packages?
	if g.isPartOfOwnPackage(t) {
		return g.resolveJavaClassUsingOwnPackages(t)
	}

	if g.isPartOfMappingSchema(t) {
		return g.resolveJavaClassUsingMappingSchema(t)
	}

	panic("No type mapping for " + t.PkgPath() + "." + t.Name())
}

func (g *schemaGenerator) javaInterfaces(t reflect.Type) []string {

	if g.isCRD(t) {

		scope := g.crdScope(t)

		if scope == Namespaced {
			return []string{"io.fabric8.kubernetes.api.model.HasMetadata", "io.fabric8.kubernetes.api.model.Namespaced"}
		}

		return []string{"io.fabric8.kubernetes.api.model.HasMetadata"}
	}

	if g.isCRDList(t) {
		return []string{"io.fabric8.kubernetes.api.model.KubernetesResource", g.resourceListInterface(t)}
	}

	return []string{"io.fabric8.kubernetes.api.model.KubernetesResource"}
}

func (g *schemaGenerator) resourceListInterface(listType reflect.Type) string {
	itemsField, _ := listType.FieldByName("Items")
	itemType := itemsField.Type.Elem()
	return "io.fabric8.kubernetes.api.model.KubernetesResourceList<" + g.javaType(itemType) + ">"
}

func (g *schemaGenerator) generate(schemaId string, crdLists map[reflect.Type]CrdScope) (*JSONSchema, error) {

	s := JSONSchema{
		ID:     schemaId,
		Schema: "http://json-schema.org/schema#",
		JSONDescriptor: JSONDescriptor{
			Type: "object",
		},
		Definitions: make(map[string]JSONPropertyDescriptor),
		JSONObjectDescriptor: &JSONObjectDescriptor{
			Properties:           make(map[string]JSONPropertyDescriptor),
			AdditionalProperties: false,
		},
	}

	for crd, _ := range crdLists {
		g.handleType(crd)
	}

	for k, v := range g.types {

		name := g.qualifiedName(k)
		value := JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type: "object",
			},
			JSONObjectDescriptor: v,
			JavaTypeDescriptor: &JavaTypeDescriptor{
				JavaType: g.javaType(k),
			},
			JavaInterfacesDescriptor: &JavaInterfacesDescriptor{
				JavaInterfaces: g.javaInterfaces(k),
			},
		}
		s.Definitions[name] = value

		s.Properties[name] = JSONPropertyDescriptor{
			JSONReferenceDescriptor: &JSONReferenceDescriptor{
				Reference: g.generateReference(k),
			},
			JavaTypeDescriptor: &JavaTypeDescriptor{
				JavaType: g.javaType(k),
			},
		}

	}

	return &s, nil
}

type FieldType string

const (
	EMBEDDED FieldType = "E"
	OBJECT   FieldType = "O"
	MAP      FieldType = "M"
	SIMPLE   FieldType = "S"
	LIST     FieldType = "L"
)

func (g *schemaGenerator) getFields(t reflect.Type) []reflect.StructField {

	var fields = make([]reflect.StructField, 0)

	for i := 0; i < t.NumField(); i++ {
		field := t.Field(i)

		fieldType := g.fieldCategory(field)

		if fieldType == EMBEDDED {
			// flatten embedded fields
			embeddedFields := g.getFields(field.Type)
			for _, ef := range embeddedFields {
				fields = append(fields, ef)
			}
		} else {
			fields = append(fields, field)
		}

	}

	return fields
}

func (g *schemaGenerator) getStructProperties(t reflect.Type) map[string]JSONPropertyDescriptor {

	// follow pointer
	t = g.resolvePointer(t)

	result := map[string]JSONPropertyDescriptor{}

	fieldList := g.getFields(t)
	for _, field := range fieldList {
		jsonName := g.jsonFieldName(field)
		result[jsonName] = g.propertyDescriptor(field, t)
	}

	// setting api version default values
	if g.isCRD(t) || g.isCRDList(t) {
		apiVersionPropertyDescriptor, _ := result["apiVersion"]
		g.setApiVersion(apiVersionPropertyDescriptor, t)

		kindPropertyDescriptor, _ := result["kind"]
		kindPropertyDescriptor.Default = t.Name()
		kindPropertyDescriptor.Required = true
	}

	return result
}

func (g *schemaGenerator) propertyDescriptor(field reflect.StructField, parentType reflect.Type) JSONPropertyDescriptor {

	// type might have manual overwrite
	if g.isManualType(field.Type) {
		return JSONPropertyDescriptor{
			JSONReferenceDescriptor: g.referenceDescriptor(field.Type),
			JavaTypeDescriptor:      g.javaTypeDescriptor(field.Type),
		}
	}

	fieldCategory := g.fieldCategory(field)

	if fieldCategory == SIMPLE {
		return g.propertyDescriptorForSimpleField(field, parentType)
	}

	if fieldCategory == MAP {
		return g.propertyDescriptorForMap(field)
	}

	if fieldCategory == OBJECT {
		return g.propertyDescriptorForObject(field)
	}

	if fieldCategory == LIST {
		return g.propertyDescriptorForList(field)
	}

	panic("Failed to get property descriptor for field")
}

func (g *schemaGenerator) referenceDescriptor(valueType reflect.Type) *JSONReferenceDescriptor {

	if g.isManualType(valueType) {

		return nil
	}

	if g.isPartOfGeneratedClasses(valueType) {
		return &JSONReferenceDescriptor{
			Reference: g.generateReference(valueType),
		}
	}
	return nil
}

func (g *schemaGenerator) setApiVersion(apiVersionPropertyDescriptor JSONPropertyDescriptor, t reflect.Type) {
	versionInfo, ok := g.packageMapping[t.PkgPath()]
	if !ok {
		panic("Not able to set api version for " + t.PkgPath() + "/" + t.Name())
	}
	apiVersionPropertyDescriptor.Default = versionInfo.ApiGroup + "/" + versionInfo.ApiVersion
	apiVersionPropertyDescriptor.Required = true
}

func (g *schemaGenerator) fieldCategory(field reflect.StructField) FieldType {

	// follow pointer
	fieldType := g.resolvePointer(field.Type)

	jsonTag := field.Tag.Get("json")

	jsonFieldName := g.jsonFieldName(field)

	// embedded examples:
	// - metav1.TypeMeta `json:",inline"` => anonymous = True
	// - PipelineResourceBinding => anonymous = True
	// - v1beta1.Addressable `json:",omitempty"`
	// NOT embedded
	// - metav1.ObjectMeta `json:"metadata,omitempty"`  => anonymous = True (!)

	if field.Anonymous && (jsonTag == "" || strings.Contains(jsonTag, "inline") || jsonFieldName == "") {
		return EMBEDDED
	}

	switch fieldType.Kind() {
	case reflect.Array:
		return LIST
	case reflect.Slice:
		return LIST
	case reflect.Struct:
		return OBJECT
	case reflect.Map:
		return MAP

	default:
		return SIMPLE
	}
}

func hasDifferentSimpleJavaTypeMapping(t reflect.Type) bool {
	switch t.Kind() {

	// -> mapped to Long instead
	case reflect.Int64:
		return true
	}
	return false
}

func isSimpleJavaType(fieldType reflect.Type) bool {

	// simple = primitive + String

	switch fieldType.Kind() {
	case reflect.Bool:
		return true
	case reflect.Int, reflect.Int32:
		return true
	case reflect.String:
		return true
	case reflect.Int64:
		return true
	}

	return false
}

func (g *schemaGenerator) handleType(t reflect.Type) {

	t = g.resolvePointer(t)

	// no need to include simple types or excluded types
	if !g.isPartOfGeneratedClasses(t) || isSimpleJavaType(t) || g.isManualType(t) {
		return
	}

	// type discovery for Map (key & value)
	if t.Kind() == reflect.Map {
		keyType := g.resolvePointer(t.Key())
		g.handleType(keyType)
		valueType := g.resolvePointer(t.Elem())
		g.handleType(valueType)
	}

	// type discovery for Lists (value)
	if t.Kind() == reflect.Slice {
		valueType := g.resolvePointer(t.Elem())
		g.handleType(valueType)
	}

	// skip type registration if not required
	// e.g. something like ExtraValue does not require registration -> it directly maps to List<String>
	if t.Kind() != reflect.Struct {
		return
	}

	definedType, ok := g.types[t]
	if !ok {
		g.types[t] = &JSONObjectDescriptor{} // avoid recursion issue

		nestedProperties := g.getStructProperties(t)

		definedType = &JSONObjectDescriptor{
			Properties:           nestedProperties,
			AdditionalProperties: true,
		}
		g.types[t] = definedType
	}
}

func (g *schemaGenerator) isPartOfProvidedPackage(t reflect.Type) bool {
	_, ok := g.providedPackages[t.PkgPath()]
	return ok
}

func (g *schemaGenerator) isManualType(t reflect.Type) bool {
	_, ok := g.manualTypeMap[t]
	return ok
}

func (g *schemaGenerator) isProvidedType(t reflect.Type) bool {
	for _, pt := range g.providedTypes {
		if pt.GoType == t {
			return true
		}
	}
	return false
}

func (g *schemaGenerator) resolveJavaClassForProvidedType(t reflect.Type) string {
	for _, pt := range g.providedTypes {
		if pt.GoType == t {
			return pt.JavaClass
		}
	}
	panic("Failed to resolve java class for provided type")
}

func (g *schemaGenerator) isPartOfOwnPackage(t reflect.Type) bool {
	_, ok := g.packageMapping[t.PkgPath()]
	return ok
}

func (g *schemaGenerator) resolveJavaClassUsingOwnPackages(t reflect.Type) string {
	return g.packageMapping[t.PkgPath()].JavaPackage + "." + t.Name()
}

func (g *schemaGenerator) isPartOfMappingSchema(t reflect.Type) bool {
	for key, _ := range g.mappingSchema {
		if strings.HasPrefix(t.PkgPath(), key) {
			return true
		}
	}
	return false
}

func (g *schemaGenerator) resolveJavaClassUsingMappingSchema(t reflect.Type) string {

	for key, value := range g.mappingSchema {
		if strings.HasPrefix(t.PkgPath(), key) {
			typeName := t.PkgPath() + "." + t.Name()
			modifiedTypeName := strings.NewReplacer(key, value, "/", ".").Replace(typeName)
			return modifiedTypeName
		}
	}
	panic("Failed to resolve Java Class using mapping schema definition")
}

func (g *schemaGenerator) resolveJavaClassUsingProvidedPackages(t reflect.Type) string {
	return g.providedPackages[t.PkgPath()] + "." + t.Name()
}

func (g *schemaGenerator) isPartOfGeneratedClasses(t reflect.Type) bool {
	if g.isPartOfProvidedPackage(t) {
		return false
	}

	if g.isProvidedType(t) {
		return false
	}

	return true
}

func (g *schemaGenerator) propertyDescriptorForSimpleField(field reflect.StructField, parentType reflect.Type) JSONPropertyDescriptor {
	propertyDescriptor := g.propertyDescriptorForSimple(field.Type)

	// check if there are constraint defined
	typeConstraints := g.constraints[parentType]
	if typeConstraints != nil {
		constraint := typeConstraints[field.Name]
		if constraint != nil {
			propertyDescriptor.MaxLength = constraint.MaxLength
			propertyDescriptor.Pattern = constraint.Pattern
		}
	}

	// add description
	propertyDescriptor.Description = g.fieldDescription(field)

	return propertyDescriptor
}

func (g *schemaGenerator) propertyDescriptorForSimple(t reflect.Type) JSONPropertyDescriptor {
	return JSONPropertyDescriptor{
		JSONDescriptor:     g.jsonDescriptor(t),
		JavaTypeDescriptor: g.javaTypeDescriptor(t),
	}
}

func (g *schemaGenerator) propertyDescriptorForMap(f reflect.StructField) JSONPropertyDescriptor {
	fieldType := g.resolvePointer(f.Type)
	mapValueType := g.resolvePointer(f.Type.Elem())

	// auto discovery
	g.handleType(mapValueType)

	return JSONPropertyDescriptor{
		JSONDescriptor: &JSONDescriptor{
			Type: "object",
		},
		JSONMapDescriptor: &JSONMapDescriptor{
			MapValueType: JSONPropertyDescriptor{
				JSONReferenceDescriptor: g.referenceDescriptor(mapValueType),
				JavaTypeDescriptor:      g.javaTypeDescriptor(fieldType),
			},
		},
		JavaTypeDescriptor: g.javaTypeDescriptor(fieldType),
	}
}

func (g *schemaGenerator) propertyDescriptorForObject(field reflect.StructField) JSONPropertyDescriptor {
	fieldType := g.resolvePointer(field.Type)

	// "type discovery"
	g.handleType(fieldType)

	return JSONPropertyDescriptor{
		JSONReferenceDescriptor: g.referenceDescriptor(fieldType),
		JavaTypeDescriptor:      g.javaTypeDescriptor(fieldType),
	}
}

func (g *schemaGenerator) propertyDescriptorForList(field reflect.StructField) JSONPropertyDescriptor {

	listValueType := g.resolvePointer(field.Type.Elem())

	// "type discovery"
	g.handleType(listValueType)

	omitIfEmpty := g.isOmitEmpty(field)

	if isSimpleJavaType(listValueType) {
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:          "array",
				JavaOmitEmpty: omitIfEmpty,
			},
			JSONArrayDescriptor: &JSONArrayDescriptor{
				Items: g.propertyDescriptorForSimple(listValueType),
			},
		}

	} else {
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:          "array",
				JavaOmitEmpty: omitIfEmpty,
			},
			JSONArrayDescriptor: &JSONArrayDescriptor{
				Items: JSONPropertyDescriptor{
					JSONReferenceDescriptor: g.referenceDescriptor(listValueType),
					JavaTypeDescriptor:      g.javaTypeDescriptor(listValueType),
				},
			},
		}
	}

}

func (g *schemaGenerator) isCRD(t reflect.Type) bool {

	typeName := t.PkgPath() + "." + t.Name() + "List"

	for crd, _ := range g.crdLists {
		// provided are CRDList as an entry point
		crdListName := crd.PkgPath() + "." + crd.Name()

		if typeName == crdListName {
			return true
		}

	}

	return false
}

func (g *schemaGenerator) crdScope(t reflect.Type) CrdScope {

	typeName := t.PkgPath() + "." + t.Name() + "List"

	for crd, scope := range g.crdLists {
		// provided are CRDList as an entry point
		crdListName := crd.PkgPath() + "." + crd.Name()

		if typeName == crdListName {
			return scope
		}

	}

	panic("No CRD scope information for " + t.Name())

}

func (g *schemaGenerator) isCRDList(t reflect.Type) bool {

	typeName := t.PkgPath() + "." + t.Name()

	for crd, _ := range g.crdLists {
		// provided are CRDList as an entry point
		crdListName := crd.PkgPath() + "." + crd.Name()

		if typeName == crdListName {
			return true
		}

	}

	return false
}
