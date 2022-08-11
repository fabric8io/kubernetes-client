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

import com.sun.codemodel.JClassContainer;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.Rule;
import org.jsonschema2pojo.rules.RuleFactory;
import org.jsonschema2pojo.util.NameHelper;
import org.jsonschema2pojo.util.ParcelableHelper;

public class Fabric8RuleFactory extends RuleFactory {

  private final Fabric8NameHelper nameHelper;

  public Fabric8RuleFactory() {
    super(new DefaultGenerationConfig(), new Jackson2Annotator(new DefaultGenerationConfig()), new SchemaStore());
    this.nameHelper = new Fabric8NameHelper(getGenerationConfig());
  }

  @Override
  public NameHelper getNameHelper() {
    return nameHelper;
  }

  @Override
  public Rule<JPackage, JType> getObjectRule() {
    return new Fabric8ObjectRule(this, new ParcelableHelper(), getReflectionHelper());
  }

  @Override
  public Rule<JFieldVar, JFieldVar> getDefaultRule() {
    return new Fabric8DefaultRule(this);
  }

  @Override
  public Rule<JClassContainer, JType> getEnumRule() {
    return new Fabric8EnumRule(this);
  }
}
