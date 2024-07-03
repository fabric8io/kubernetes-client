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
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;
import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.rules.AdditionalPropertiesRule;
import org.jsonschema2pojo.rules.RuleFactory;

public class Fabric8AdditionalPropertiesRule extends AdditionalPropertiesRule {

  public Fabric8AdditionalPropertiesRule(RuleFactory ruleFactory) {
    super(ruleFactory);
  }

  @Override
  public JDefinedClass apply(String nodeName, JsonNode node, JsonNode parent, JDefinedClass jclass, Schema schema) {
    super.apply(nodeName, node, parent, jclass, schema);
    final JFieldVar additionalPropertiesField = jclass.fields().get("additionalProperties");
    if (additionalPropertiesField == null || !additionalPropertiesField.type().name().equals("Map<String,Object>")) {
      return jclass;
    }
    // Add setter for additionalProperties (#3570 | #3576 | #6100)
    final JMethod setter = jclass.method(JMod.PUBLIC, void.class, "setAdditionalProperties");
    final JVar param = setter.param(additionalPropertiesField.type(), additionalPropertiesField.name());
    final JBlock body = setter.body();
    body.assign(JExpr._this().ref(additionalPropertiesField), param);
    return jclass;
  }
}
