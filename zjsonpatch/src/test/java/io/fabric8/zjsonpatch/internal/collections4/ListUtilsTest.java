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
package io.fabric8.zjsonpatch.internal.collections4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ListUtilsTest {
  @Test
  void longestCommonSubsequence() {
    assertThatNullPointerException()
        .isThrownBy(() -> ListUtils.longestCommonSubsequence((List<?>) null, null))
        .withMessageContaining("listA");
    assertThatNullPointerException()
        .isThrownBy(() -> ListUtils.longestCommonSubsequence(Collections.singletonList('A'), null))
        .withMessageContaining("listB");
    assertThatNullPointerException()
        .isThrownBy(() -> ListUtils.longestCommonSubsequence(null, Collections.singletonList('A')))
        .withMessageContaining("listA");

    assertThat(ListUtils.longestCommonSubsequence(Collections.emptyList(), Collections.emptyList())).isEmpty();

    final List<Character> list1 = Arrays.asList('B', 'A', 'N', 'A', 'N', 'A');
    final List<Character> list2 = Arrays.asList('A', 'N', 'A', 'N', 'A', 'S');
    assertThat(ListUtils.longestCommonSubsequence(list1, list2))
        .containsExactly('A', 'N', 'A', 'N', 'A');

    final List<Character> list3 = Arrays.asList('A', 'T', 'A', 'N', 'A');
    assertThat(ListUtils.longestCommonSubsequence(list1, list3))
        .containsExactly('A', 'A', 'N', 'A');

    assertThat(ListUtils.longestCommonSubsequence(list1, Arrays.asList('Z', 'O', 'R', 'R', 'O'))).isEmpty();
  }
}
