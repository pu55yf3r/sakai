/**
 * Copyright (c) 2006-2019 The Apereo Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://opensource.org/licenses/ecl2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sakaiproject.sitestats.api.event.detailed.assignments;

/**
 * Data for an assignment
 * @author plukasew
 */
public class AssignmentData implements AssignmentsData
{
	public final String title;
	public final boolean anonymous;
	public final boolean deleted;

	/**
	 * Constructor
	 * @param title the title of the assignment
	 * @param anonymous whether the assignment is anonymous
	 * @param deleted whether the assignment has been deleted
	 */
	public AssignmentData(String title, boolean anonymous, boolean deleted)
	{
		this.title = title;
		this.anonymous = anonymous;
		this.deleted = deleted;
	}
}
