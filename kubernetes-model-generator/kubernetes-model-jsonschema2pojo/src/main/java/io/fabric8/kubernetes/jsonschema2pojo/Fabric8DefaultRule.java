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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JType;
import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.rules.DefaultRule;
import org.jsonschema2pojo.rules.RuleFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Adds default map handling
 */
public class Fabric8DefaultRule extends DefaultRule {

  private final RuleFactory ruleFactory;

  public Fabric8DefaultRule(RuleFactory ruleFactory) {
    super(ruleFactory);
    this.ruleFactory = ruleFactory;
  }

  @Override
  public JFieldVar apply(String nodeName, JsonNode node, JsonNode parent, JFieldVar field, Schema currentSchema) {
    JType fieldType = field.type();
    String fieldTypeName = fieldType.fullName();

    if (ruleFactory.getGenerationConfig().isInitializeCollections()) {
      // add a default for maps if missing, rejected upstream https://github.com/joelittlejohn/jsonschema2pojo/issues/955
      if (fieldTypeName.startsWith(Map.class.getName()) && (node == null || node.asText() == null || node.asText().isEmpty())) {
        JClass keyGenericType = ((JClass) fieldType).getTypeParameters().get(0);
        JClass valueGenericType = ((JClass) fieldType).getTypeParameters().get(1);

        JClass mapImplClass = fieldType.owner().ref(LinkedHashMap.class);
        mapImplClass = mapImplClass.narrow(keyGenericType, valueGenericType);
        field.init(JExpr._new(mapImplClass));
      }

      // maps and some lists are not marked as omitJavaEmpty - it's simplest to just add the annotation here, rather than updating the generator
      JClass jsonInclude = fieldType.owner().ref(JsonInclude.class);
      if ((fieldTypeName.startsWith(Map.class.getName()) || fieldTypeName.startsWith(List.class.getName()))
          && field.annotations().stream()
              .noneMatch(annotation -> annotation.getAnnotationClass().isAssignableFrom(jsonInclude))) {
        field.annotate(jsonInclude).param(KubernetesCoreTypeAnnotator.ANNOTATION_VALUE, JsonInclude.Include.NON_EMPTY);
      }
    }

    return super.apply(nodeName, node, parent, field, currentSchema);
  }

}
