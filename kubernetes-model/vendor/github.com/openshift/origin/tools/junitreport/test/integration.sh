#!/bin/bash
#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


# This file runs the integration tests for the `junitreport` binary to ensure that correct jUnit XML is produced.

set -o errexit
set -o nounset
set -o pipefail

JUNITREPORT_ROOT=$(dirname "${BASH_SOURCE}")/..
pushd "${JUNITREPORT_ROOT}" > /dev/null

diff_args='-ydb --suppress-common-lines'

TMPDIR="/tmp/junitreport/test/integration"
mkdir -p "${TMPDIR}"

for suite in test/*/; do
	suite_name=$( basename ${suite} )
	echo "[INFO] Testing suite ${suite_name}..."

	WORKINGDIR="${TMPDIR}/${suite_name}"
	mkdir -p "${WORKINGDIR}"

	# test every case with flat and nested suites
	for test in ${suite}/testdata/*.txt; do
		test_name=$( basename ${test} '.txt' )

		cat "${test}" | junitreport -type "${suite_name}" -suites flat > "${WORKINGDIR}/${test_name}_flat.xml"
		if ! diff ${diff_args} "${suite}/reports/${test_name}_flat.xml" "${WORKINGDIR}/${test_name}_flat.xml"; then
			echo "[FAIL] Test '${test_name}' in suite '${suite_name}' failed for flat suite builder."
			exit 1
		fi

		cat "${WORKINGDIR}/${test_name}_flat.xml" | junitreport summarize > "${WORKINGDIR}/${test_name}_summary.txt"
		if ! diff ${diff_args} "${suite}/summaries/${test_name}_summary.txt" "${WORKINGDIR}/${test_name}_summary.txt"; then
			echo "[FAIL] Test '${test_name}' in suite '${suite_name}' failed to summarize flat XML."
		fi
	done

	echo "[PASS] Test output type passed: ${suite_name}"
done

echo "[PASS] junitreport testing successful"
popd > /dev/null
