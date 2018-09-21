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
package strings

// IsWildcardMatch matches the given input string against the provided pattern. The
// pattern might contain '?' and '*' wildcards.
// Original code: https://discuss.leetcode.com/topic/9350/python-dp-solution/5
func IsWildcardMatch(s string, p string) bool {
	dp := make([][]bool, len(p)+1)
	for i := range dp {
		dp[i] = make([]bool, len(s)+1)
		for j := range dp[i] {
			dp[i][j] = false
		}
	}
	dp[0][0] = true
	for j := 1; j <= len(p); j++ {
		pattern := p[j-1]
		dp[j][0] = dp[j-1][0] && pattern == '*'
		for i := 1; i <= len(s); i++ {
			letter := s[i-1]
			if pattern != '*' {
				dp[j][i] = dp[j-1][i-1] && (pattern == '?' || pattern == letter)
			} else {
				dp[j][i] = dp[j][i-1] || dp[j-1][i]
			}
		}
	}
	return dp[len(p)][len(s)]
}
