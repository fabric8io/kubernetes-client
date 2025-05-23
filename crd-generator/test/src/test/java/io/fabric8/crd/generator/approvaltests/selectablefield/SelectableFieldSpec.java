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
package io.fabric8.crd.generator.approvaltests.selectablefield;

import io.fabric8.crd.generator.annotation.SelectableField;
import lombok.Data;

@Data
public class SelectableFieldSpec {

  @SelectableField
  private String id;

  private DeepLevel1 deepLevel1;

  @Data
  static class DeepLevel1 {
    // targeted from @AdditionalSelectableField
    private String name;

    @SelectableField
    private Integer fromLevel1;

    private DeepLevel2 deepLevel2;
  }

  @Data
  static class DeepLevel2 {
    @SelectableField
    private Boolean fromLevel2;
  }

}
