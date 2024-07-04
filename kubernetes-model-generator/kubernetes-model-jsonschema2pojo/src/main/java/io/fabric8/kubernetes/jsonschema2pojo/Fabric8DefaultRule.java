/*
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

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JType;
import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.rules.DefaultRule;
import org.jsonschema2pojo.rules.RuleFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    super.apply(nodeName, node, parent, field, currentSchema);
    final JType fieldType = field.type();
    final String fieldTypeName = field.type().fullName();
    if (ruleFactory.getGenerationConfig().isInitializeCollections()) {
      // add a default for maps if missing, rejected upstream https://github.com/joelittlejohn/jsonschema2pojo/issues/955
      if (fieldTypeName.startsWith(Map.class.getName()) && (node == null || node.asText() == null || node.asText().isEmpty())) {
        final JClass mapImplClass = fieldType.owner().ref(LinkedHashMap.class).narrow(Collections.emptyList());
        field.init(JExpr._new(mapImplClass));
      } else if (fieldTypeName.startsWith(List.class.getName())) {
        final JClass listImplClass = fieldType.owner().ref(ArrayList.class).narrow(Collections.emptyList());
        field.init(JExpr._new(listImplClass));
      } else if (fieldTypeName.startsWith(Set.class.getName())) {
        final JClass setImplClass = fieldType.owner().ref(HashSet.class).narrow(Collections.emptyList());
        field.init(JExpr._new(setImplClass));
      }
    }
    return field;
  }

}
