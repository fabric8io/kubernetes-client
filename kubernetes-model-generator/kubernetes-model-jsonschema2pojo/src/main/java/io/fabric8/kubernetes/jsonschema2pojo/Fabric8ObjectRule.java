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
package io.fabric8.kubernetes.jsonschema2pojo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.sun.codemodel.JAnnotationArrayMember;
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder;
import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.rules.ObjectRule;
import org.jsonschema2pojo.rules.RuleFactory;
import org.jsonschema2pojo.util.ParcelableHelper;
import org.jsonschema2pojo.util.ReflectionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that extend the object rule to add support of interfaces.
 */
public class Fabric8ObjectRule extends ObjectRule {
  private static final String INTERFACE_TYPE_PROPERTY = "interfaceType";
  private static final String INTERFACE_IMPLEMENTATIONS_TYPE_PROPERTY = "interfaceImpls";
  private static final String VALUE_PROPERTY = "value";

  private final RuleFactory ruleFactory;

  protected Fabric8ObjectRule(RuleFactory ruleFactory, ParcelableHelper parcelableHelper, ReflectionHelper reflectionHelper) {
    super(ruleFactory, parcelableHelper, reflectionHelper);

    this.ruleFactory = ruleFactory;
  }

  @Override
  public JType apply(String nodeName, JsonNode node, JsonNode parent, JPackage _package, Schema schema) {
    if (node.has(INTERFACE_TYPE_PROPERTY)) {
      // interface
      return createInterface(node, _package);
    }

    // rest of types
    return super.apply(nodeName, node, parent, _package, schema);
  }

  private JType createInterface(JsonNode node, JPackage _package) {
    String fqn = node.path(INTERFACE_TYPE_PROPERTY).asText();
    int index = fqn.lastIndexOf(".") + 1;

    JDefinedClass newType;
    try {
      newType = _package._interface(fqn.substring(index));
    } catch (JClassAlreadyExistsException ex) {
      return ex.getExistingClass();
    }

    this.ruleFactory.getAnnotator().typeInfo(newType, node);
    this.ruleFactory.getAnnotator().propertyInclusion(newType, node);

    // Allow to deserialize the interface from implementations:
    if (node.has(INTERFACE_IMPLEMENTATIONS_TYPE_PROPERTY)) {
      newType.annotate(JsonTypeResolver.class).param(VALUE_PROPERTY, UnwrappedTypeResolverBuilder.class);
      JAnnotationArrayMember subTypes = newType.annotate(JsonSubTypes.class).paramArray(VALUE_PROPERTY);
      JsonNode implementationsNode = node.get(INTERFACE_IMPLEMENTATIONS_TYPE_PROPERTY);
      List<String> implementations = new ArrayList<>();
      for (JsonNode implementationNode : implementationsNode) {
        String implementation = implementationNode.textValue();
        implementations.add(implementation);
        subTypes.annotate(JsonSubTypes.Type.class).param(VALUE_PROPERTY, new JCodeModel().ref(implementation));
      }

      JAnnotationUse jsonTypeAnnotation = newType.annotate(JsonTypeInfo.class).param("use", JsonTypeInfo.Id.DEDUCTION);
      if (implementations.size() == 1) {
        jsonTypeAnnotation.param("defaultImpl", new JCodeModel().ref(implementations.get(0)));
      }
    }

    return newType;
  }
}
