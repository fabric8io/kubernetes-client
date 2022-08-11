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

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JForEach;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import org.jsonschema2pojo.model.EnumDefinition;
import org.jsonschema2pojo.rules.EnumRule;
import org.jsonschema2pojo.rules.RuleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Adds default map handling
 */
public class Fabric8EnumRule extends EnumRule {

  private static final String TO_LOWERCASE_METHOD = "toLowerCase";

  private final RuleFactory ruleFactory;

  protected Fabric8EnumRule(RuleFactory ruleFactory) {
    super(ruleFactory);

    this.ruleFactory = ruleFactory;
  }

  @Override
  protected void addFieldAccessors(JDefinedClass _enum, JFieldVar valueField) {
    // do nothing
  }

  protected void addFactoryMethod(EnumDefinition enumDefinition, JDefinedClass _enum) {

    JClass stringType = _enum.owner().ref(String.class);

    JMethod fromValue = _enum.method(JMod.PUBLIC | JMod.STATIC, _enum, "fromValue");
    JVar valueParam = fromValue.param(_enum.owner().ref(Object.class), "value");

    JBlock body = fromValue.body();
    JFieldVar backingTypeLookupMap = addValueLookupMap(enumDefinition, _enum);
    JFieldVar addNameLookupMap = addNameLookupMap(_enum);

    // if param instanceof String
    JConditional _ifString = body._if(valueParam._instanceof(stringType));
    getEnumFromNameConstants(_ifString._then().block(), valueParam, addNameLookupMap, enumDefinition, _enum);
    getEnumFromValueConstants(body, valueParam, backingTypeLookupMap, enumDefinition, _enum);

    ruleFactory.getAnnotator().enumCreatorMethod(_enum, fromValue);
  }

  protected void getEnumFromValueConstants(JBlock body, JVar valueParam, JFieldVar quickLookupMap,
      EnumDefinition enumDefinition, JDefinedClass _enum) {
    JType backingType = enumDefinition.getBackingType();

    JVar constant = body.decl(_enum, "constant").init(quickLookupMap.invoke("get").arg(valueParam));

    JConditional _if = body._if(constant.eq(JExpr._null()));
    _if._then()._throw(illegalArgumentException(valueParam, _enum, backingType));
    _if._else()._return(constant);
  }

  protected void getEnumFromNameConstants(JBlock body, JVar valueParam, JFieldVar quickLookupMap, EnumDefinition enumDefinition,
      JDefinedClass _enum) {
    JType backingType = enumDefinition.getBackingType();
    JClass stringType = _enum.owner().ref(String.class);

    JVar constant = body.decl(_enum, "constant").init(quickLookupMap.invoke("get")
        .arg(JExpr.invoke(JExpr.cast(stringType, valueParam), TO_LOWERCASE_METHOD)));

    JConditional _if = body._if(constant.eq(JExpr._null()));
    _if._then()._throw(illegalArgumentException(valueParam, _enum, backingType));
    _if._else()._return(constant);
  }

  private JInvocation illegalArgumentException(JVar valueParam, JDefinedClass _enum, JType backingType) {
    JInvocation illegalArgumentException = JExpr._new(_enum.owner().ref(IllegalArgumentException.class));
    JExpression expr = valueParam;

    // if string no need to add ""
    if (!isString(backingType)) {
      expr = expr.plus(JExpr.lit(""));
    }

    illegalArgumentException.arg(expr);
    return illegalArgumentException;
  }

  protected JFieldVar addValueLookupMap(EnumDefinition enumDefinition, JDefinedClass _enum) {
    JType backingType = enumDefinition.getBackingType();

    JClass lookupType = _enum.owner().ref(Map.class).narrow(backingType.boxify(), _enum);
    JFieldVar backingTypeLookupMap = _enum.field(JMod.PRIVATE | JMod.STATIC | JMod.FINAL, lookupType, "CONSTANTS");

    JClass lookupImplType = _enum.owner().ref(HashMap.class).narrow(backingType.boxify(), _enum);
    backingTypeLookupMap.init(JExpr._new(lookupImplType));

    JForEach forEach = _enum.init().forEach(_enum, "c", JExpr.invoke("values"));
    JInvocation put = forEach.body().invoke(backingTypeLookupMap, "put");
    if (isString(backingType)) {
      put.arg(forEach.var().ref("value").invoke(TO_LOWERCASE_METHOD));
    } else {
      put.arg(forEach.var().ref("value"));
    }

    put.arg(forEach.var());

    return backingTypeLookupMap;
  }

  protected JFieldVar addNameLookupMap(JDefinedClass _enum) {
    JClass stringType = _enum.owner().ref(String.class);

    JClass nameLookupType = _enum.owner().ref(Map.class).narrow(stringType, _enum);
    JFieldVar nameLookupMap = _enum.field(JMod.PRIVATE | JMod.STATIC | JMod.FINAL, nameLookupType, "NAME_CONSTANTS");

    JClass lookupImplType = _enum.owner().ref(HashMap.class).narrow(stringType, _enum);
    nameLookupMap.init(JExpr._new(lookupImplType));

    JForEach forEach = _enum.init().forEach(_enum, "c", JExpr.invoke("values"));

    JInvocation namePut = forEach.body().invoke(nameLookupMap, "put");
    namePut.arg(forEach.var().invoke("name").invoke(TO_LOWERCASE_METHOD));
    namePut.arg(forEach.var());

    return nameLookupMap;
  }
}
