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

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * @author Michael Minella
 */
public class SysOutItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("SysOutItemWriter.write()");
		System.out.println("The size of this chunk was: " + items.size());

		for (String item : items) {
			System.out.println(">> " + item);
		}
	}
}
