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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListUtils {
  private ListUtils() {
  }

  public static <T> List<T> longestCommonSubsequence(final List<T> list1, final List<T> list2) {
    Objects.requireNonNull(list1, "listA");
    Objects.requireNonNull(list2, "listB");
    int[][] dp = new int[list1.size() + 1][list2.size() + 1];

    for (int list1Index = 1; list1Index <= list1.size(); list1Index++) {
      for (int list2Index = 1; list2Index <= list2.size(); list2Index++) {
        if (list1.get(list1Index - 1).equals(list2.get(list2Index - 1))) {
          dp[list1Index][list2Index] = dp[list1Index - 1][list2Index - 1] + 1;
        } else {
          dp[list1Index][list2Index] = Math.max(dp[list1Index - 1][list2Index], dp[list1Index][list2Index - 1]);
        }
      }
    }

    List<T> lcs = new ArrayList<>();
    int list1Index = list1.size();
    int list2Index = list2.size();
    while (list1Index > 0 && list2Index > 0) {
      if (list1.get(list1Index - 1).equals(list2.get(list2Index - 1))) {
        lcs.add(list1.get(list1Index - 1));
        list1Index--;
        list2Index--;
      } else if (dp[list1Index - 1][list2Index] >= dp[list1Index][list2Index - 1]) {
        list1Index--;
      } else {
        list2Index--;
      }
    }

    java.util.Collections.reverse(lcs);
    return lcs;
  }
}
