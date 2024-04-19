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
	"fmt"
	"log"
	"reflect"
	"strconv"
	"strings"
)

type EnumDescriptor struct {
	Type   string
	Values []EnumValueDescriptor
}

type EnumValueDescriptor struct {
	Name  string
	Value interface{}
}

type ProvidedType struct {
	GoType    reflect.Type
	JavaClass string
}

type PackageInformation struct {
	ApiGroup    string
	ApiVersion  string
	JavaPackage string
}

// Name strategy mapping for auto discovered classes
type JavaNameStrategyMapping struct {
	// Sometimes the json field name is set in this way:
	// GoField *GoType `protobuf:"...,json=goField,proto3" json:"go_field,omitempty"`
	// By default, we will still use the one from `json`, if this flag is true,
	// it will then use the one from the protobuf.
	ResolveFieldNameFromProtobufFirst bool
	// Skip fields that don't have any tags
	SkipFieldWithEmptyTag bool
	// To provide a custom generic rule that applies to all java, interface, enum
	CustomJavaNameRule func(packageName *string, javaName *string)
	// To manually map a golang class to a Java class
	NameMapping map[reflect.Type]string
}

type schemaGenerator struct {
	crdLists             map[reflect.Type]CrdScope
	types                map[reflect.Type]*JSONObjectDescriptor
	providedPackages     map[string]string
	manualTypeMap        map[reflect.Type]string
	packageMapping       map[string]PackageInformation
	mappingSchema        map[string]string
	providedTypes        []ProvidedType
	constraints          map[reflect.Type]map[string]*Constraint // type -> field name -> constraint
	interfacesMapping    map[string][]reflect.Type               // interface -> list of implementations
	javaNameStrategy     JavaNameStrategyMapping                 // java name strategy by extension
	enumTypes            map[reflect.Type]EnumDescriptor         // enum -> json descriptor
	generatedTypesPrefix string
}

type Constraint struct {
	MaxLength int
	Pattern   string
}

type CrdScope int32

const (
	Namespaced  CrdScope = 0
	Cluster     CrdScope = 1
	BasePackage string   = "io.fabric8.kubernetes.api.model"
)

func GenerateSchema(schemaId string, crdLists map[reflect.Type]CrdScope, providedPackages map[string]string, manualTypeMap map[reflect.Type]string, packageMapping map[string]PackageInformation, mappingSchema map[string]string, providedTypes []ProvidedType, constraints map[reflect.Type]map[string]*Constraint, generatedTypesPrefix string) string {
	return GenerateSchemaWithAllOptions(schemaId, crdLists, make(map[reflect.Type]*JSONObjectDescriptor), providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, make(map[string][]reflect.Type), JavaNameStrategyMapping{}, make(map[reflect.Type]EnumDescriptor), generatedTypesPrefix)
}

func GenerateSchemaWithAllOptions(schemaId string, crdLists map[reflect.Type]CrdScope, typesDescriptors map[reflect.Type]*JSONObjectDescriptor, providedPackages map[string]string, manualTypeMap map[reflect.Type]string, packageMapping map[string]PackageInformation, mappingSchema map[string]string, providedTypes []ProvidedType, constraints map[reflect.Type]map[string]*Constraint, interfacesMapping map[string][]reflect.Type, javaNameStrategy JavaNameStrategyMapping, enumTypes map[reflect.Type]EnumDescriptor, generatedTypesPrefix string) string {
	g := &schemaGenerator{
		crdLists:             crdLists,
		types:                typesDescriptors,
		providedPackages:     providedPackages,
		manualTypeMap:        manualTypeMap,
		packageMapping:       packageMapping,
		mappingSchema:        mappingSchema,
		providedTypes:        providedTypes,
		constraints:          constraints,
		generatedTypesPrefix: generatedTypesPrefix,
		interfacesMapping:    interfacesMapping,
		javaNameStrategy:     javaNameStrategy,
		enumTypes:            enumTypes,
	}
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

func (g *schemaGenerator) jsonFieldName(f reflect.StructField) string {
	if g.javaNameStrategy.ResolveFieldNameFromProtobufFirst {
		protobufTag := f.Tag.Get("protobuf")
		if len(protobufTag) > 0 && strings.Contains(protobufTag, "json=") {
			fieldName := protobufTag[strings.LastIndex(protobufTag, "json=")+5:]
			return fieldName[:strings.Index(fieldName, ",")]
		}
		if len(protobufTag) > 0 && strings.Contains(protobufTag, "name=") {
			fieldName := protobufTag[strings.LastIndex(protobufTag, "name=")+5:]
			if strings.Contains(fieldName, ",") {
				return fieldName[:strings.Index(fieldName, ",")]
			}
			return fieldName
		}
	}

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

func (g *schemaGenerator) qualifiedNameForString(className string) string {
	return strings.NewReplacer(".", "_", "/", "_").Replace(className)
}

func (g *schemaGenerator) generateReference(t reflect.Type) string {
	return g.generateReferenceForString(g.qualifiedName(t))
}

func (g *schemaGenerator) generateReferenceForString(str string) string {
	return "#/definitions/" + str
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
	case reflect.Float32, reflect.Float64:
		return &JSONDescriptor{Type: "number"}
	case reflect.Int, reflect.Uint8, reflect.Int16, reflect.Int32, reflect.Int64, reflect.Uint32, reflect.Uint64, reflect.Uint16:
		return &JSONDescriptor{Type: "integer"}
	case reflect.Bool:
		return &JSONDescriptor{Type: "boolean"}
	case reflect.String:
		return &JSONDescriptor{Type: "string"}
	case reflect.Interface:
		// When having something like: Tag interface{}, it should be mapped into "Tag Object".
		return &JSONDescriptor{Type: "object"}
	}

	panic("Nothing for " + t.Name() + " " + t.PkgPath() + " kind " + t.Kind().String())
}

func (g *schemaGenerator) existingJavaTypeDescriptor(t reflect.Type) *ExistingJavaTypeDescriptor {

	// no type information required for simple java types
	// if provided, this breaks default value for fields ?! wtf?
	if isSimpleJavaType(t) && !hasDifferentSimpleJavaTypeMapping(t) {
		return nil
	}
	return &ExistingJavaTypeDescriptor{
		ExistingJavaType: g.javaType(t),
	}
}

func (g *schemaGenerator) javaType(t reflect.Type) string {

	// follow pointer
	t = g.resolvePointer(t)

	if g.javaNameStrategy.NameMapping != nil {
		found, ok := g.javaNameStrategy.NameMapping[t]
		if ok {
			return found
		}
	}

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
		case reflect.Int, reflect.Uint8, reflect.Int16, reflect.Int32, reflect.Uint16:
			return "Integer"
		case reflect.String:
			return "String"
		case reflect.Int64, reflect.Uint32, reflect.Uint64:
			return "Long"
		case reflect.Float32:
			return "Float"
		case reflect.Float64:
			return "Double"
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

	// When having something like: Tag interface{}, it should be mapped into "Tag Object".
	if t.Kind() == reflect.Interface {
		return "Object"
	}

	panic("No type mapping for " + t.PkgPath() + "." + t.Name() + " " + t.Kind().String())
}

func (g *schemaGenerator) javaInterfaces(t reflect.Type) []string {

	if g.isCRD(t) {

		scope := g.crdScope(t)

		if scope == Namespaced {
			return []string{BasePackage + ".HasMetadata", "io.fabric8.kubernetes.api.model.Namespaced"}
		}

		return []string{BasePackage + ".HasMetadata"}
	}

	if g.isCRDList(t) {
		return []string{BasePackage + ".KubernetesResource", g.resourceListInterface(t)}
	}

	return []string{BasePackage + ".KubernetesResource"}
}

func (g *schemaGenerator) generateJavaType(t reflect.Type) bool {
	_, ok := g.providedPackages[t.PkgPath()]
	if !ok {
		return false
	}
	// In case some types shouldn't be generated, Improve package Metadata (PackageInformation) to include a generate(true/false) flag
	return true
}

func (g *schemaGenerator) resourceListInterface(listType reflect.Type) string {
	itemsField, _ := listType.FieldByName("Items")
	itemType := itemsField.Type.Elem()
	return BasePackage + ".KubernetesResourceList<" + g.javaType(itemType) + ">"
}

func (g *schemaGenerator) generate(schemaId string, crdLists map[reflect.Type]CrdScope) (*JSONSchema, error) {

	s := JSONSchema{
		ID:     schemaId,
		Schema: "http://json-schema.org/draft-07/schema#",
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

	for interfaceName, implementations := range g.interfacesMapping {
		// register interface
		interfaceJavaClass := g.resolveFqnJavaTypeUsingMappingSchema(interfaceName)
		interfaceKey := g.qualifiedNameForString(interfaceName)
		interfaceImplementations := make([]string, 0)

		// register implementations
		for _, implementation := range implementations {
			implementationName := g.qualifiedName(implementation)
			implementationJavaName := g.javaType(implementation)
			interfaceImplementations = append(interfaceImplementations, implementationJavaName)

			s.Definitions[implementationName] = JSONPropertyDescriptor{
				JSONDescriptor: &JSONDescriptor{
					Type: "object",
				},
				JSONObjectDescriptor: &JSONObjectDescriptor{
					Properties: g.getStructProperties(implementation),
				},
				JavaTypeDescriptor: &JavaTypeDescriptor{
					JavaType: implementationJavaName,
				},
				JavaInterfacesDescriptor: &JavaInterfacesDescriptor{
					JavaInterfaces: []string{g.adaptJavaClassName(interfaceJavaClass)},
				},
			}
			s.Properties[implementationName] = JSONPropertyDescriptor{
				JSONReferenceDescriptor: &JSONReferenceDescriptor{
					Reference: g.generateReference(implementation),
				},
				JavaTypeDescriptor: &JavaTypeDescriptor{
					JavaType: implementationJavaName,
				},
			}
		}

		// register interface
		s.Definitions[interfaceKey] = JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type: "object",
			},
			JavaInterfaceDescriptor: &JavaInterfaceDescriptor{
				InterfaceType:   g.adaptJavaClassName(interfaceJavaClass),
				Implementations: interfaceImplementations,
			},
		}
		s.Properties[interfaceKey] = JSONPropertyDescriptor{
			JSONReferenceDescriptor: &JSONReferenceDescriptor{
				Reference: g.generateReferenceForString(interfaceKey),
			},
			JavaInterfaceDescriptor: &JavaInterfaceDescriptor{
				InterfaceType: g.adaptJavaClassName(interfaceJavaClass),
			},
		}

	}

	for k, v := range g.types {

		name := g.qualifiedName(k)
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
		if strings.HasPrefix(javaType, g.generatedTypesPrefix) {
			value.JavaTypeDescriptor = &JavaTypeDescriptor{
				JavaType: javaType,
			}
		} else {
			value.ExistingJavaTypeDescriptor = &ExistingJavaTypeDescriptor{
				ExistingJavaType: javaType,
			}
		}
		s.Definitions[name] = value

		s.Properties[name] = JSONPropertyDescriptor{
			JSONReferenceDescriptor: &JSONReferenceDescriptor{
				Reference: g.generateReference(k),
			},
			ExistingJavaTypeDescriptor: &ExistingJavaTypeDescriptor{
				ExistingJavaType: g.javaType(k),
			},
		}

	}

	for enumType, enumDescriptor := range g.enumTypes {
		enumTypeName := g.qualifiedName(enumType)

		enumValues := make([]interface{}, 0)
		javaEnums := make([]JSONJavaEnumDescriptor, 0)

		for _, enumValue := range enumDescriptor.Values {
			enumValues = append(enumValues, enumValue.Value)
			javaEnums = append(javaEnums, JSONJavaEnumDescriptor{
				Name: enumValue.Name,
			})
		}

		s.Definitions[enumTypeName] = JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:      enumDescriptor.Type,
				Enum:      enumValues,
				JavaEnums: javaEnums,
			},
			JavaTypeDescriptor: &JavaTypeDescriptor{
				JavaType: g.resolveJavaClassUsingMappingSchema(enumType),
			},
		}

		s.Properties[enumTypeName] = JSONPropertyDescriptor{
			JSONReferenceDescriptor: &JSONReferenceDescriptor{
				Reference: g.generateReference(enumType),
			},
			JavaTypeDescriptor: &JavaTypeDescriptor{
				JavaType: g.resolveJavaClassUsingMappingSchema(enumType),
			},
		}
	}

	return &s, nil
}

type FieldType string

const (
	EMBEDDED  FieldType = "E"
	OBJECT    FieldType = "O"
	MAP       FieldType = "M"
	INTERFACE FieldType = "I"
	SIMPLE    FieldType = "S"
	LIST      FieldType = "L"
	ENUM      FieldType = "N"
)

func (g *schemaGenerator) getFields(t reflect.Type) []reflect.StructField {

	var fields = make([]reflect.StructField, 0)

	//Not all types are Structs (e.g. `type RawMessage byte[]`) will cause this function to fail.
	//So, we need to add a guard for this case. It's expected that this will handled using external/provided mappings.
	if t.Kind() != reflect.Struct {
		return fields
	}

	for i := 0; i < t.NumField(); i++ {
		field := t.Field(i)
		if g.javaNameStrategy.SkipFieldWithEmptyTag && field.Tag == "" {
			continue
		}
		fieldType := g.fieldCategory(field)

		if fieldType == EMBEDDED {
			// flatten embedded fields
			etype := g.resolvePointer(field.Type)
			embeddedFields := g.getFields(etype)
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
		if jsonName == "-" {
			continue
		}
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

func (g *schemaGenerator) getEnumDescriptor(t reflect.Type) EnumDescriptor {
	instance := reflect.New(t).Elem()
	enumValues := make([]EnumValueDescriptor, 0)

	// Note that at the moment, this only supports "string" types, for others, it must be
	// defined in the extensions using the "enumTypes"
	var index int64 = 0
	end := false
	// We stop trying to find enum values when end is true (last index was not found) AND when at least 50 indexes have been checked.
	for !end || index < 50 {
		instance.SetInt(index)
		enumJavaName := fmt.Sprintf("%v", instance.Interface())
		if enumJavaName == strconv.FormatInt(index, 10) {
			end = true
		} else {
			enumValues = append(enumValues, EnumValueDescriptor{
				Name:  enumJavaName,
				Value: index,
			})
		}

		index++
	}

	return EnumDescriptor{
		Type:   "integer",
		Values: enumValues,
	}
}

func (g *schemaGenerator) propertyDescriptor(field reflect.StructField, parentType reflect.Type) JSONPropertyDescriptor {

	// type might have manual overwrite
	if g.isManualType(field.Type) {
		return JSONPropertyDescriptor{
			JSONReferenceDescriptor:    g.referenceDescriptor(field.Type),
			ExistingJavaTypeDescriptor: g.existingJavaTypeDescriptor(field.Type),
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

	if fieldCategory == INTERFACE {
		return g.propertyDescriptorForInterface(field)
	}

	if fieldCategory == ENUM {
		return g.propertyDescriptorForEnum(field)
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
	protobufTag := field.Tag.Get("protobuf")

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

	// enum examples:
	// - Mode    PeerAuthenticationMode `protobuf:"varint,1,opt,name=mode,proto3,enum=package.to.type.PeerAuthenticationMode" json:"mode,omitempty"`

	if strings.Contains(protobufTag, "enum") {
		return ENUM
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
	case reflect.Interface:
		// Special case when "interface {}" is a Interface kind, but meant to be mapped to Objects
		if fieldType.String() == "interface {}" {
			return SIMPLE
		}

		return INTERFACE

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
	case reflect.Int, reflect.Uint8, reflect.Int16, reflect.Int32, reflect.Uint16:
		return true
	case reflect.String:
		return true
	case reflect.Int64, reflect.Uint32, reflect.Uint64:
		return true
	case reflect.Float32, reflect.Float64:
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
			return g.adaptJavaClassName(pt.JavaClass)
		}
	}
	panic("Failed to resolve java class for provided type")
}

func (g *schemaGenerator) isPartOfOwnPackage(t reflect.Type) bool {
	_, ok := g.packageMapping[t.PkgPath()]
	return ok
}

func (g *schemaGenerator) resolveJavaClassUsingOwnPackages(t reflect.Type) string {
	return g.adaptJavaClassName(g.packageMapping[t.PkgPath()].JavaPackage + "." + t.Name())
}

func (g *schemaGenerator) adaptJavaClassName(className string) string {
	lastDot := strings.LastIndex(className, ".")
	packageName := className[:lastDot]
	className = className[lastDot+1:]

	// If the java name starts with a lowercase character, change it to uppercase
	className = strings.Title(className)

	// apply custom rules
	if g.javaNameStrategy.CustomJavaNameRule != nil {
		g.javaNameStrategy.CustomJavaNameRule(&packageName, &className)
	}

	return packageName + "." + className
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
			return g.adaptJavaClassName(modifiedTypeName)
		}
	}
	panic("Failed to resolve Java Class using mapping schema definition")
}

func (g *schemaGenerator) resolveFqnJavaTypeUsingMappingSchema(typeName string) string {

	for key, value := range g.mappingSchema {
		if strings.HasPrefix(typeName, key) {
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
	description := g.fieldDescription(field)
	if len(description) > 0 {
		propertyDescriptor.Description = description
	}

	return propertyDescriptor
}

func (g *schemaGenerator) propertyDescriptorForSimple(t reflect.Type) JSONPropertyDescriptor {
	return JSONPropertyDescriptor{
		JSONDescriptor:             g.jsonDescriptor(t),
		ExistingJavaTypeDescriptor: g.existingJavaTypeDescriptor(t),
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
				JSONReferenceDescriptor:    g.referenceDescriptor(mapValueType),
				ExistingJavaTypeDescriptor: g.existingJavaTypeDescriptor(fieldType),
			},
		},
		ExistingJavaTypeDescriptor: g.existingJavaTypeDescriptor(fieldType),
	}
}

func (g *schemaGenerator) propertyDescriptorForObject(field reflect.StructField) JSONPropertyDescriptor {
	fieldType := g.resolvePointer(field.Type)

	// "type discovery"
	g.handleType(fieldType)

	return JSONPropertyDescriptor{
		JSONReferenceDescriptor:    g.referenceDescriptor(fieldType),
		ExistingJavaTypeDescriptor: g.existingJavaTypeDescriptor(fieldType),
	}
}

func (g *schemaGenerator) propertyDescriptorForList(field reflect.StructField) JSONPropertyDescriptor {

	listValueType := g.resolvePointer(field.Type.Elem())

	if g.isManualType(listValueType) {
		return JSONPropertyDescriptor{
			JSONDescriptor: &JSONDescriptor{
				Type:          "array",
				JavaOmitEmpty: g.isOmitEmpty(field),
			},
			JSONArrayDescriptor: &JSONArrayDescriptor{
				Items: JSONPropertyDescriptor{
					JSONReferenceDescriptor:    g.referenceDescriptor(listValueType),
					ExistingJavaTypeDescriptor: g.existingJavaTypeDescriptor(listValueType),
				},
			},
		}
	}

	// "type discovery"
	g.handleType(listValueType)

	omitIfEmpty := g.isOmitEmpty(field)

	if isSimpleJavaType(listValueType) {
		if listValueType.Kind() == reflect.Uint8 { // Handle case for byte[]
			return JSONPropertyDescriptor{
				JSONDescriptor: &JSONDescriptor{
					Type:          "string",
					JavaOmitEmpty: omitIfEmpty,
				},
			}
		}
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
					JSONReferenceDescriptor:    g.referenceDescriptor(listValueType),
					ExistingJavaTypeDescriptor: g.existingJavaTypeDescriptor(listValueType),
				},
			},
		}
	}

}

func (g *schemaGenerator) propertyDescriptorForInterface(field reflect.StructField) JSONPropertyDescriptor {
	fieldType := g.resolvePointer(field.Type)

	return JSONPropertyDescriptor{
		JSONReferenceDescriptor: g.referenceDescriptor(fieldType),
		JavaInterfaceDescriptor: &JavaInterfaceDescriptor{
			InterfaceType: g.javaType(fieldType),
		},
	}
}

func (g *schemaGenerator) propertyDescriptorForEnum(field reflect.StructField) JSONPropertyDescriptor {
	fieldType := g.resolvePointer(field.Type)

	// Check whether it was already defined
	_, ok := g.enumTypes[fieldType]
	if !ok {
		g.enumTypes[fieldType] = g.getEnumDescriptor(fieldType)
	}

	return JSONPropertyDescriptor{
		JSONReferenceDescriptor: g.referenceDescriptor(fieldType),
		JavaTypeDescriptor: &JavaTypeDescriptor{
			JavaType: g.resolveJavaClassUsingMappingSchema(fieldType),
		},
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
