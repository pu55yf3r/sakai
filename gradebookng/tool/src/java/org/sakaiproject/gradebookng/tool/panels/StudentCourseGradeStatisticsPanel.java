/**
 * Copyright (c) 2003-2018 The Apereo Foundation
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
package org.sakaiproject.gradebookng.tool.panels;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.sakaiproject.gradebookng.tool.chart.CourseGradeChart;
import org.sakaiproject.gradebookng.tool.component.GbAjaxLink;
import org.sakaiproject.core.persistence.grades.entity.CourseGrade;

/**
 * Renders the course grade graph in a modal window
 */
public class StudentCourseGradeStatisticsPanel extends BasePanel {

	private static final long serialVersionUID = 1L;

	private final ModalWindow window;
	private final CourseGrade studentGrade;

	public StudentCourseGradeStatisticsPanel(final String id, final IModel<String> model, final ModalWindow window,
			final CourseGrade courseGrade) {
		super(id, model);
		this.window = window;
		this.studentGrade = courseGrade;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onInitialize() {
		super.onInitialize();

		final String siteId = ((Model<String>) getDefaultModel()).getObject();

		StudentCourseGradeStatisticsPanel.this.window.setTitle(new ResourceModel("label.statistics.title.coursegrade"));

		final CourseGradeChart chart = new CourseGradeChart("chart", siteId, studentGrade);
		add(chart);

		add(new GbAjaxLink<Void>("done") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				StudentCourseGradeStatisticsPanel.this.window.close(target);
			}
		});
	}
}