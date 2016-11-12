/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.patel.pradeep.chap5.itemwriter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Michael Minella
 */
@Configuration
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public ListItemReader<String> itemReader() {
		System.out.println("JobConfiguration.itemReader() 111");
		List<String> items = new ArrayList<>(100);

		for(int i = 1; i <= 100; i++) {
			items.add(String.valueOf(i));
		}
		System.out.println("JobConfiguration.itemReader() 222");
		return new ListItemReader<>(items);
	}

	@Bean
	public SysOutItemWriter itemWriter() {
		System.out.println("JobConfiguration.itemWriter()");
		return new SysOutItemWriter();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step")
				.<String, String>chunk(10)
				.reader(itemReader())
				.writer(itemWriter())
				.build();
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("itemwriter")
				.start(step())
				.build();
	}
}
